package com.atguigu.gulimall.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * className: AttrRespVo
 * description:
 * date: 2024/3/19 0019-22:51
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo {
    /**
     * 分类名
     */
    private String catalogName;

    /**
     * 分组名
     */
    private String groupName;

    /**
     * 分类完整路径
     */
    private Long[] catalogPath;
}
