package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * className: OrderItemVo
 * description:
 * date: 2024/5/16-16:30
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.ware.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class OrderItemVo {

    private Long skuId;
    private Boolean check = true;
    private String title;
    private String image;
    private List<String> skuAttr;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    private BigDecimal weight;
}
