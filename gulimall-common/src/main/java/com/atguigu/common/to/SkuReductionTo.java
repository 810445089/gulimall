package com.atguigu.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * className: SkuReductionTo
 * description:
 * date: 2024/3/21 0021-14:00
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SkuReductionTo {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 折扣->满多少件
     */
    private Integer fullCount;

    /**
     * 折扣->打几折
     */
    private BigDecimal discount;

    /**
     * 是否可叠加优惠
     */
    private Integer countStatus;

    /**
     * 满减->满多少价->打几折
     */
    private BigDecimal fullPrice;

    /**
     * 满减->满多少价->优惠多少钱
     */
    private BigDecimal reducePrice;

    /**
     * 是否可叠加优惠
     */
    private Integer priceStatus;

    /**
     * 会员价格
     */
    List<MemberPrice> memberPrice;
}
