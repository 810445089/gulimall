package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * className: Sku
 * description: Sku 信息
 * date: 2024/3/20 0020-22:35
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class Sku {

    /**
     * Sku 属性
     */
    private List<Attr> attrs;

    /**
     * Sku 名称
     */
    private String skuName;

    /**
     * Sku 价格
     */
    private BigDecimal price;

    /**
     * Sku 标题
     */
    private String skuTitle;

    /**
     * Sku 副标题
     */
    private String skuSubTitle;

    /**
     * Sku 图片
     */
    private List<Image> images;

    /**
     * Sku 销售属性的笛卡尔集
     */
    private List<String> descar;

    /**
     * 满减-满多少件
     */
    private Integer fullCount;

    /**
     * 满减-打多少折
     */
    private BigDecimal discount;

    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    private Integer countStatus;

    /**
     * 满减-满多少金额
     */
    private BigDecimal fullPrice;

    /**
     * 满减-减多少金额
     */
    private BigDecimal reducePrice;

    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    private Integer priceStatus;

    /**
     * 会员价格列表
     */
    private List<MemberPrice> memberPrice;
}
