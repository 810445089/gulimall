package com.atguigu.common.to.es;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * className: SkuEsModel
 * description:
 * date: 2024/4/10 Wednesday-15:29
 * <p>
 * project: gulimall
 * package: com.atguigu.common.to.es
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class SkuEsModel {
    /**
     * "skuId": {
     * "type": "long"
     * }
     */
    private Long skuId;

    /**
     * "spuId": {
     * "type": "keyword"
     * },
     */
    private Long spuId;

    /**
     * "skuTitle": {
     * "type": "text",
     * "analyzer": "ik_smart"
     * },
     */
    private String skuTitle;

    /**
     * "skuPrice": {
     * "type": "keyword",
     * },
     */
    private BigDecimal skuPrice;

    /**
     * "skuImg": {
     * "type": "keyword"
     * }
     */
    private String skuImg;

    /**
     * "saleCount": {
     * "type": "long"
     * }
     */
    private Long saleCount;

    /**
     * "hasStock": {
     * "type": "boolean"
     * }
     */
    private Boolean hasStock;

    /**
     * "hotScore": {
     * "type": "long"
     * }
     */
    private Long hotScore;

    /**
     * "brandId": {
     * "type": "long"
     * }
     */
    private Long brandId;

    /**
     * "catalogId": {
     * "type": "long"
     * }
     */
    private Long catalogId;

    /**
     * "brandName": {
     * "type": "keyword"
     * }
     */
    private String brandName;

    /**
     * "brandImg": {
     * "type": "keyword"
     * }
     */
    private String brandImg;

    /**
     * "catalogName": {
     * "type": "keyword"
     * }
     */
    private String catalogName;

    private List<Attrs> attrs;

    /**
     * "properties": {
     * "attrs": {
     * "type": "nested",
     * "properties": {
     * "attrId": {
     * "type": "long"
     * },
     * "attrName": {
     * "type": "keyword"
     * },
     * "attrValue": {
     * "type": "keyword",
     * }
     * }
     * }
     */
    @Data
    public static class Attrs {
        private Long attrId;
        private String attrName;
        private String attrValue;
    }
}
