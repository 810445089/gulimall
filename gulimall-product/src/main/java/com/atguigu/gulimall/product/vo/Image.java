package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * className: Image
 * description: Sku 图片
 * date: 2024/3/20 0020-22:40
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.product.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class Image {

    /**
     * 图片url
     */
    private String imgUrl;

    /**
     * 是否默认图
     */
    private Integer defaultImg;
}
