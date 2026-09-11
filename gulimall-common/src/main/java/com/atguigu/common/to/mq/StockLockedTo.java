package com.atguigu.common.to.mq;

import lombok.Data;

import java.util.List;

/**
 * className: StockLockedTo
 * description:
 * date: 2024/5/24-20:33
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to.mq
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class StockLockedTo {

    /**
     * 库存工作单 id
     */
    private Long id;

    /**
     * 工作单详情的所有id
     */
    private StockDetailTo detail;
}
