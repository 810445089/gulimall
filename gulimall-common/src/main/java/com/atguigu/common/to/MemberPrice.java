package com.atguigu.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * className: MemberPrice
 * description: 会员价
 * date: 2024/3/20 0020-22:42
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class MemberPrice {

    /**
     * 会员等级 id
     */
    private Long id;

    /**
     * 会员等级名
     */
    private String name;

    /**
     * 会员价格
     */
    private BigDecimal price;

}
