package com.atguigu.gulimall.ware.vo;

import lombok.Data;

/**
 * className: PurchaseItemDoneVo
 * description:
 * date: 2024/3/23 0023-21:32
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class PurchaseItemDoneVo {

    /**
     * 采购项id
     */
    private Long itemId;

    /**
     * 采购项状态
     */
    private Integer status;

    /**
     * 失败原因
     */
    private String reason;
}
