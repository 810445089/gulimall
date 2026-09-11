package com.atguigu.gulimall.ware.vo;

import lombok.Data;

/**
 * className: LockStockResult
 * description:
 * date: 2024/5/17-21:00
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class LockStockResult {

    private Long skuId;
    private Integer num;
    private Boolean locked;
}
