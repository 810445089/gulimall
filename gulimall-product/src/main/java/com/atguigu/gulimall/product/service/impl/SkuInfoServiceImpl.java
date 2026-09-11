package com.atguigu.gulimall.product.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.atguigu.gulimall.product.entity.ProductAttrValueEntity;
import com.atguigu.gulimall.product.service.AttrService;
import com.atguigu.gulimall.product.service.ProductAttrValueService;
import com.atguigu.gulimall.product.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.SkuInfoDao;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.service.SkuInfoService;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Autowired
    private SkuInfoService skuInfoService;
//
//    @Autowired
//    private SpuInfoService spuInfoService;
//
//    @Autowired
//    private ProductAttrValueService productAttrValueService;

//    @Autowired
//    private AttrService attrService;

//    public SkuInfoServiceImpl(SkuInfoService skuInfoService) {
//        this.skuInfoService = skuInfoService;
//    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {

        QueryWrapper<SkuInfoEntity> wrapper = new QueryWrapper<>();
//        key=&catalogId=0&brandId=0&min=0&max=0
        String key = (String) params.get("key");
        if (StringUtils.isNotBlank(key)) {
            wrapper.and(v -> v.eq("sku_id", key).or().like("sku_name", key));
        }

        Object catalogId = params.get("catalogId");
        if (StringUtils.isNotEmpty((String)catalogId)) {
            wrapper.eq("catalog_id", catalogId);
        }

        Object brandId = params.get("brandId");
        if (StringUtils.isNotEmpty((String)brandId)) {
            wrapper.eq("brand_id", brandId);
        }

        Object min = params.get("min");
        if (StringUtils.isNotEmpty((String)min)) {
            wrapper.ge("price", min);
        }

        String max = (String)params.get("max");
        if (StringUtils.isNotEmpty(max)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(max);
                if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                    wrapper.le("price", max);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        IPage<SkuInfoEntity> page = this.page(new Query<SkuInfoEntity>().getPage(params), wrapper);

        return new PageUtils(page);
    }

    @Override
    public List<SkuInfoEntity> getSkusInfoBySpuId(Long spuId) {
        List<SkuInfoEntity> list = this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id", spuId));
        return list;
    }
}