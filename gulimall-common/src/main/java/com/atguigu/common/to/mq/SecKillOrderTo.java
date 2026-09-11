package com.atguigu.common.to.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * className: SecKillOrderTo
 * description:
 * date: 2024/5/31-21:35
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to.mq
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SecKillOrderTo {

    private String orderSn;

    private Long promotionSessionId;

    private Long skuId;

    private BigDecimal seckillPrice;

    private Integer num;

    private Long memberId;

}
