package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * className: WareSkuLockVo
 * description:
 * date: 2024/5/17-20:52
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class WareSkuLockVo {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 需要锁住的所有库存信息
     */
    private List<OrderItemVo> locks;
}
