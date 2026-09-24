package com.atguigu.gulimall.product.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import com.atguigu.gulimall.product.vo.Catalog2Vo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private RedissonClient redissonClient;

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);

        return entities.stream().filter(item -> item.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getChildren(menu, entities)))
                .sorted(Comparator.comparingInt(menu -> menu.getSort() == null ? 0 : menu.getSort()))
                .collect(Collectors.toList());
    }
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter(item -> Objects.equals(item.getParentCid(), root.getCatId()))
                .peek(categoryEntity -> categoryEntity.setChildren(getChildren(categoryEntity, all)))
                .sorted(Comparator.comparingInt(menu -> menu.getSort() == null ? 0 : menu.getSort()))
                .collect(Collectors.toList());
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> list = new ArrayList<>();

        List<Long> parentPath = findParentPath(catelogId, list);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[0]);
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {

        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        return paths;
    }

    @Cacheable(value = {"category"}, key="'level1Categorys'")
    @Override
    public List<CategoryEntity> getLevel1Categorys() {

        List<CategoryEntity> entities = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
        return entities;
    }

    @Override
    public Map<String, List<Catalog2Vo>> getCatalogJson() {
        List<CategoryEntity> selectList = this.list();

        List<CategoryEntity> level1Categories = getParentCid(selectList, 0L);

        return level1Categories.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            List<CategoryEntity> categoryEntities = getParentCid(selectList, v.getCatId());
            List<Catalog2Vo> catalog2Vos = Collections.emptyList();

            if (categoryEntities != null) {
                catalog2Vos = categoryEntities.stream().map(l2 -> {
                    Catalog2Vo catalog2Vo = new Catalog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryEntity> level3Catalog = getParentCid(selectList, l2.getCatId());
                    if (level3Catalog != null) {
                        catalog2Vo.setCatalog3List(level3Catalog.stream().map(l3 -> {
                            return new Catalog2Vo.Catalog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                        }).collect(Collectors.toList()));
                    }

                    return catalog2Vo;
                }).collect(Collectors.toList());
            }
            return catalog2Vos;
        }));
    }

    private List<CategoryEntity> getParentCid(List<CategoryEntity> selectList, long l) {
        return selectList.stream().filter(item -> item.getParentCid() == l).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Catalog2Vo>> getCatalogJson2() {
        String catalogJson = stringRedisTemplate.opsForValue().get("catalogJson");

        if (StringUtils.isEmpty(catalogJson)) {
            return getCatalogJsonFromDbWithRedissonLock();
        }

        return JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catalog2Vo>>>(){});
    }

//    @CacheEvict(value = {"category"}, key = "'level1Categorys'") // 失效模式，方法执行完删除缓存
//    @CachePut(value = "category", key = "'level1Categorys'") // 双写模式，方法执行完更新缓存

    @Caching(evict = {
            @CacheEvict(value = "category", key = "'level1Categorys'"),
            @CacheEvict(value = "category", key = "'catalogJson'")
    })
    @Transient
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);

        if (StringUtils.isNotEmpty(category.getName())) {
            categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
        }
    }

    private Map<String, List<Catalog2Vo>> getCatalogJsonFromDbWithRedissonLock() {
        RLock lock = redissonClient.getLock("catalogJson-lock");
        lock.lock(30, TimeUnit.SECONDS);

        Map<String, List<Catalog2Vo>> listMap = null;
        try {
            listMap = getCatalogJsonFromDbWithRedis();
        } finally {
            lock.unlock();
        }

        return listMap;
    }

    public Map<String, List<Catalog2Vo>> getCatalogJsonFromDbWithRedisLock() {

        String uuid = UUID.randomUUID().toString();

//        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid);
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid, 300, TimeUnit.SECONDS);
        if (lock) {
            System.out.println("获取分布式锁成功");
//            方式1：设置过期时间,必须和枷锁是同步的，原子的
//            stringRedisTemplate.expire("lock", 30, TimeUnit.SECONDS);
            Map<String, List<Catalog2Vo>> listMap = getCatalogJsonFromDbWithRedis();

//            Object lockValue = stringRedisTemplate.opsForValue().get("lock");
//            if (uuid.equals(lockValue)) {
//                stringRedisTemplate.delete(uuid);
//            }

//            方式2：
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            stringRedisTemplate.execute(new DefaultRedisScript<>(script, Long.class), Collections.singletonList("lock"), uuid);
            return listMap;
        } else {
            System.out.println("获取分布式锁失败！等待重试...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getCatalogJson2();
        }
    }

    public  Map<String, List<Catalog2Vo>> getCatalogJsonFromDbWithRedis() {
        String catalogJson = stringRedisTemplate.opsForValue().get("catalogJson");

        if (StringUtils.isNotEmpty(catalogJson)) {
            return JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catalog2Vo>>>(){});
        }

        Map<String, List<Catalog2Vo>> listMap = getFromDb();
        String s = JSON.toJSONString(listMap);

//            stringRedisTemplate.opsForValue().set("catalogJson", s);

        stringRedisTemplate.opsForValue().set("catalogJson", s, 1, TimeUnit.DAYS); // 加锁，解决击穿问题

        return listMap;
    }

    public Map<String, List<Catalog2Vo>> getCatalogJsonFromDbWithLocalLock() {
        synchronized (this) {
            return getCatalogJsonFromDbWithRedis();
        }
    }

    public Map<String, List<Catalog2Vo>> getCatalogJsonFromDbRedis() {
        String catalogJson = stringRedisTemplate.opsForValue().get("catalogJson");

        if (StringUtils.isNotEmpty(catalogJson)) {
            return JSON.parseObject(catalogJson, new TypeReference<Map<String, List<Catalog2Vo>>>(){});
        }

        Map<String, List<Catalog2Vo>> listMap = getFromDb();
        String s = JSON.toJSONString(listMap);

//        stringRedisTemplate.opsForValue().set("catalogJson", s);

        /**
         * 1、空结果缓存：解决缓存穿透
         * 2、设置过期时间（加随机值）：解决缓存雪崩
         * 3、加锁：解决缓存击穿
         */
        stringRedisTemplate.opsForValue().set("catalogJson", s, 1, TimeUnit.DAYS);

        return listMap;
    }

    private Map<String, List<Catalog2Vo>> getFromDb() {

        List<CategoryEntity> selectList = this.list();
        System.out.println("查询数据库");
        List<CategoryEntity> level1Categories = getParentCid(selectList, 0L);

        Map<String, List<Catalog2Vo>> listMap = level1Categories.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            List<CategoryEntity> categoryEntities = getParentCid(selectList, v.getCatId());
            List<Catalog2Vo> catalog2Vos = Collections.emptyList();

            if (categoryEntities != null) {
                catalog2Vos = categoryEntities.stream().map(l2 -> {
                    Catalog2Vo catalog2Vo = new Catalog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());

                    List<CategoryEntity> level3Catalog = getParentCid(selectList, l2.getCatId());
                    if (level3Catalog != null) {
                        catalog2Vo.setCatalog3List(level3Catalog.stream().map(l3 -> {
                            return new Catalog2Vo.Catalog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                        }).collect(Collectors.toList()));
                    }

                    return catalog2Vo;
                }).collect(Collectors.toList());
            }
            return catalog2Vos;
        }));

        return listMap;
    }
}