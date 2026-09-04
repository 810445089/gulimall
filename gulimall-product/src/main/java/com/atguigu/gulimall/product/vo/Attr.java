package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * className: Attr
 * description: Sku 销售属性
 * date: 2024/3/20 0020-22:06
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class Attr {

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性名
     */
    private String attrName;

    /**
     * 属性值
     */
    private String attrValue;
}
