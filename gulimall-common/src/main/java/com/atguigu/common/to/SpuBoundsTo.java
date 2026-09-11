package com.atguigu.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * className: SpuBoundsTo
 * description:
 * date: 2024/3/21 0021-13:43
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SpuBoundsTo {

    /**
     * spuId
     */
    private Long spuId;

    /**
     * 成长积分
     */
    private BigDecimal growBounds;

    /**
     * 购物积分
     */
    private BigDecimal buyBounds;

}
