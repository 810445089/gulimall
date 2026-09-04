package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * className: BaseAttr
 * description: 基本属性
 * date: 2024/3/20 0020-22:22
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class BaseAttr {

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性值
     */
    private String attrValues;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    private Integer showDesc;
}
