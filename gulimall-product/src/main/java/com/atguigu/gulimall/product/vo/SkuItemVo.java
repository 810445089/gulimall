package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.SkuImagesEntity;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;

import java.util.List;

/**
 * className: SkuItemVo
 * description:
 * date: 2024/4/23-16:14
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SkuItemVo {
    /**
     * 1. sku基本信息 pms_sku_info
     */
    private SkuInfoEntity info;

    /**
     * 有货：无货
     */
    private boolean hasStock = true;

    /**
     * 2. sku图片信息 pms_sku_images
     */
    private List<SkuImagesEntity> images;

    /**
     * 3. spu销售属性组合
     */
    private List<SkuItemSaleAttrVo> saleAttrs;

    /**
     * 4. spu介绍 pms_spu_info_desc
     */
    private SpuInfoDescEntity desc;

    /**
     * 5. sku规格参数信息
     */
    private List<SpuItemAttrGroupVo> groupAttrs;

    /**
     * 秒杀商品的优惠信息
     */
    private SeckillInfoVo seckillInfo;

}
