package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * className: SpuSaveVo
 * description: Spu 提交信息
 * date: 2024/3/20 0020-22:11
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SpuSaveVo {

    /**
     * spu名称
     */
    private String spuName;

    /**
     * spu描述
     */
    private String spuDescription;

    /**
     * 分类id
     */
    private Long catalogId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 发布状态 0-下线，1-上线
     */
    private Integer publishStatus;

    /**
     * Spu 商品描述图
     */
    private List<String> descript;

    /**
     * Spu 图片集
     */
    private List<String> images;

    /**
     * 积分信息
     */
    private Bounds bounds;

    /**
     * 基础属性
     */
    private List<BaseAttr> baseAttrs;

    /**
     * Sku 组合信息
     */
    private List<Sku> skus;
}
