package com.atguigu.gulimall.search.vo;

import lombok.Data;

import java.util.List;

/**
 * className: SearchParam
 * description: 封装页面的所有请求参数
 * catalog3Id=225&keyword=小米&sort=saleCount_asc&hasStock=0/1&brandId=1&brandId=2
 * date: 2024/4/21-1:17
 * <p>
 * project: gulimall
 * package: com.atguigu.gulimall.search.vo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SearchParam {

    /**
     * 全文检索关键字
     */
    private String keyword;

    /**
     * 三级分类id
     */
    private String catalog3Id;

    /**
     * 排序条件
     * sort=saleCount_asc/desc
     * sort=skuPrice_asc/desc
     * sort=hotScore_asc/desc
     */
    private String sort;

    /**
     * 好多的过滤条件
     * hasStock(是否有货)、skuPrice区间、brandId、catalog3Id、attrs
     * hasStock=0/1
     * skuPrice=1_500/_500/500_
     * brandId=1/2/3
     * attrs=1_5寸:6寸
     *
     * <p>
     * 是否有货
     */
    private Integer hasStock;

    /**
     * 价格区间
     */
    private String skuPrice;

    /**
     * 品牌id
     */
    private List<Long> brandId;

    /**
     * 属性
     */
    private List<String> attrs;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 原始查询条件
     */
    private String _queryString;

}
