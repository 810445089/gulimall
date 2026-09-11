package com.atguigu.gulimall.product.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson2.TypeReference;
import com.atguigu.common.constant.ProductConstant;
import com.atguigu.common.to.SkuHasStockTo;
import com.atguigu.common.to.es.SkuEsModel;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.entity.ProductAttrValueEntity;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.feign.WareFeignService;
import com.atguigu.gulimall.product.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.SpuInfoDao;
import com.atguigu.gulimall.product.entity.SpuInfoEntity;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private WareFeignService wareFeignService;

    @Autowired
    private BrandService brandService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {

        QueryWrapper<SpuInfoEntity> wrapper = new QueryWrapper<>();

        String categoryId = (String) params.get("categoryId");
        if (StringUtils.isNotEmpty(categoryId)) {
            wrapper.eq("category_id", categoryId);
        }

        String brandId = (String) params.get("brandId");
        if (StringUtils.isNotEmpty(brandId)) {
            wrapper.eq("brand_id", brandId);
        }

        String status = (String) params.get("status");
        if (StringUtils.isNotEmpty(status)) {
            wrapper.eq("publish_status", status);
        }

        String key = (String) params.get("key");
        if (StringUtils.isNotEmpty(key)) {
            wrapper.and(w -> {
                w.eq("id", key).or().like("spu_name", key);
            });
        }

        IPage<SpuInfoEntity> page = this.page(new Query<SpuInfoEntity>().getPage(params), wrapper);
        return new PageUtils(page);
    }

    @Override
    public void up(Long spuId) {
//        this.update(new QueryWrapper<SkuInfoEntity>().eq("sku_id", spuId));
        // 1.查询当前spuId对应的所有sku信息，品牌的名字，图片，价格，标题，库存
        List<SkuInfoEntity> skuInfoEntities = skuInfoService.getSkusInfoBySpuId(spuId);
        List<Long> skuIdList = skuInfoEntities.stream().map(SkuInfoEntity::getSkuId).collect(Collectors.toList());

        // 4.查询当前 sku 的所有可以用来搜索的规格属性
        List<ProductAttrValueEntity> productAttrValueEntities = productAttrValueService.baseAttrListForSpu(spuId);
        List<Long> attrIds = productAttrValueEntities.stream().map(ProductAttrValueEntity::getAttrId).collect(Collectors.toList());

        List<Long> searchAttrIds = attrService.selectSearchAttrIds(attrIds);
        HashSet<Long> searchAttrIdSet = new HashSet<>(searchAttrIds);
        List<SkuEsModel.Attrs> attrsList = productAttrValueEntities.stream().filter(item -> searchAttrIdSet.contains(item.getAttrId())).map(item -> {
            SkuEsModel.Attrs attrs = new SkuEsModel.Attrs();
            BeanUtils.copyProperties(item, attrs);
            return attrs;
        }).collect(Collectors.toList());

        // 1. 远程查询sku的库存，是否有库存
//        Map<Long, Boolean> stockMap = null;
//        try {
//            R skuHasStock = wareFeignService.getSkuHasStock(skuIdList);
//            stockMap = skuHasStock.getData(new TypeReference<List<SkuHasStockTo>>() {}).stream()
//                    .collect(Collectors.toMap(SkuHasStockTo::getSkuId, SkuHasStockTo::getHasStock));
//        } catch(Exception e) {
//            log.error("远程查询库存信息失败:{}", e);
//        }

        System.out.println("11111111111111");
        // 2.封装每个sku的信息
//        Map<Long, Boolean> finalStockMap = stockMap;
//        skuInfoEntities.stream().map(sku -> {
//            SkuEsModel skuEsModel = new SkuEsModel();
//            BeanUtils.copyProperties(sku, skuEsModel);
//            // 设置库存信息
//            if (finalStockMap == null) {
//                skuEsModel.setHasStock(true);
//            } else {
//                skuEsModel.setHasStock(finalStockMap.get(sku.getSkuId()));
//            }
//            // 2. 热度分值
//            skuEsModel.setHotScore(0L);
//
//            BrandEntity brandEntity = brandService.getById(sku.getBrandId());
//            skuEsModel.setBrandId(brandEntity.getBrandId());
//            skuEsModel.setBrandName(brandEntity.getName());
//
//            return skuEsModel;
//        }).collect(Collectors.toList());

        baseMapper.updateSpuStatus(spuId, ProductConstant.StatusEnum.SPU_UP.getCode());
    }

}