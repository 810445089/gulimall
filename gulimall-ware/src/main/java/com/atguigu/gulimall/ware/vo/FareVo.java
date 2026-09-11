package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * className: FareVo
 * description:
 * date: 2024/5/17-14:23
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
