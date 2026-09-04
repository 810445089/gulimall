package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.util.List;

/**
 * className: SkuItemSaleAttrVo
 * description:
 * date: 2024/4/23-17:02
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SkuItemSaleAttrVo {
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuIdVo> attrValues;
}
