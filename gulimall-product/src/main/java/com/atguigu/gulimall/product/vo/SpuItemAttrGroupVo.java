package com.atguigu.gulimall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * className: SpuItemAttrGroupVo
 * description:
 * date: 2024/4/23-17:03
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@ToString
@Data
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrs;
}
