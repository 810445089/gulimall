package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * className: MergeVo
 * description:
 * date: 2024/3/23 0023-12:56
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class MergeVo {

    /**
     * 采购单Id
     */
    private Long purchaseId;

    /**
     * 合并项集
     */
    private List<Long> items;
}
