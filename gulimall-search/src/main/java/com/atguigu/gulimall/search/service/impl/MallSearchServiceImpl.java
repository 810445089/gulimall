package com.atguigu.gulimall.search.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.atguigu.common.to.es.SkuEsModel;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.search.config.GulimallElasticSearchConfig;
import com.atguigu.gulimall.search.constant.EsConstant;
import com.atguigu.gulimall.search.feign.ProductFeignService;
import com.atguigu.gulimall.search.service.MallSearchService;
import com.atguigu.gulimall.search.vo.AttrResponseVo;
import com.atguigu.gulimall.search.vo.BrandVo;
import com.atguigu.gulimall.search.vo.SearchParam;
import com.atguigu.gulimall.search.vo.SearchResult;
import io.seata.common.util.CollectionUtils;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MallSearchServiceImpl implements MallSearchService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ProductFeignService productFeignService;

    @Override
    public SearchResult search(SearchParam searchParam) {

        SearchResult result;

        SearchRequest request = buildSearchRequest(searchParam);

        try {
            SearchResponse searchResponse = restHighLevelClient.search(request, GulimallElasticSearchConfig.COMMON_OPTIONS);
            result = buildSearchResult(searchResponse, searchParam);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private SearchResult buildSearchResult(SearchResponse searchResponse, SearchParam searchParam) {
        SearchResult result = new SearchResult();

        SearchHits searchHits = searchResponse.getHits();

        List<SkuEsModel> skuEsModels = new ArrayList<>();

        if (searchHits.getHits() != null && searchHits.getHits().length > 0) {
            for (SearchHit hit : searchHits.getHits()) {
                String sourceAsString = hit.getSourceAsString();
                SkuEsModel esModel = JSON.parseObject(sourceAsString, SkuEsModel.class);
                if (StringUtils.isNotEmpty(searchParam.getKeyword())) {
                    HighlightField highlightField = hit.getHighlightFields().get("skuTitle");
                    if (highlightField != null) {
                        esModel.setSkuTitle(highlightField.getFragments()[0].string());
                    }
                }
                skuEsModels.add(esModel);
            }
        }

        result.setProducts(skuEsModels);

        List<SearchResult.AttrVo> attrVos = new ArrayList<>();
        ParsedNested attrAgg = searchResponse.getAggregations().get("attr_agg");
        ParsedLongTerms attrIdAgg = attrAgg.getAggregations().get("attr_id_agg");
        for(Terms.Bucket bucket : attrIdAgg.getBuckets()) {
            SearchResult.AttrVo attrVo = new SearchResult.AttrVo();
            attrVo.setAttrId(bucket.getKeyAsNumber().longValue());
            attrVo.setAttrName(((ParsedStringTerms) bucket.getAggregations().get("attr_name_agg")).getBuckets().get(0).getKeyAsString());
            ParsedStringTerms attrValueAgg = bucket.getAggregations().get("attr_value_agg");
            attrVo.setAttrValues(attrValueAgg.getBuckets().stream().map(MultiBucketsAggregation.Bucket::getKeyAsString).collect(Collectors.toList()));
            attrVos.add(attrVo);
        }
        result.setAttrs(attrVos);

        List<SearchResult.BrandVo> brandVos = new ArrayList<>();
        ParsedLongTerms brandAgg = searchResponse.getAggregations().get("brand_agg");
        if (brandAgg != null) {
            for(Terms.Bucket bucket : brandAgg.getBuckets()) {
                SearchResult.BrandVo brandVo = new SearchResult.BrandVo();
                brandVo.setBrandId(bucket.getKeyAsNumber().longValue());
                brandVo.setBrandName(((ParsedStringTerms) bucket.getAggregations().get("brand_name_agg")).getBuckets().get(0).getKeyAsString());
                brandVo.setBrandImg(((ParsedStringTerms) bucket.getAggregations().get("brand_img_agg")).getBuckets().get(0).getKeyAsString());
                brandVos.add(brandVo);
            }
        }
        result.setBrands(brandVos);

        String catalogName = null;
        List<SearchResult.CatalogVo> catalogs = new ArrayList<>();
        ParsedLongTerms catalogAgg = searchResponse.getAggregations().get("catalog_agg");
        if (catalogAgg != null) {
            for (Terms.Bucket bucket : catalogAgg.getBuckets()) {
                SearchResult.CatalogVo catalogVo = new SearchResult.CatalogVo();
                catalogVo.setCatalogId(bucket.getKeyAsNumber().longValue());
                catalogVo.setCatalogName(((ParsedStringTerms) bucket.getAggregations().get("catalog_name_agg")).getBuckets().get(0).getKeyAsString());
                catalogs.add(catalogVo);
                if (catalogVo.getCatalogId().equals(searchParam.getCatalog3Id())) {
                    catalogName = catalogVo.getCatalogName();
                }
            }
        }
        result.setCatalogs(catalogs);

        result.setPageNum(searchParam.getPageNum());
        long total = searchHits.getTotalHits().value;
        result.setTotal(total);
        int totalPages = (int) (total % EsConstant.PRODUCT_PAGE_SIZE == 0 ? total / EsConstant.PRODUCT_PAGE_SIZE : (total / EsConstant.PRODUCT_PAGE_SIZE + 1));
        result.setTotalPages(totalPages);

        ArrayList<Integer> pageNavs = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pageNavs.add(i + 1);
        }
        result.setPageNavs(pageNavs);

        if (CollectionUtils.isNotEmpty(searchParam.getAttrs())) {
            result.setNavs(searchParam.getAttrs().stream().map(attr -> {
                SearchResult.NavVo navVo = new SearchResult.NavVo();
                String[] s = attr.split("_");
                navVo.setNavValue(s[1]);
                Long attrId = Long.valueOf(s[0]);
                result.getAttrIds().add(attrId);

                R r = productFeignService.attrInfo(attrId);

                if (r.getCode() == 0) {
                    AttrResponseVo data = r.getData("attr", new TypeReference<AttrResponseVo>() {
                    });
                    navVo.setNavName(data.getAttrName());
                } else {
                    navVo.setNavName(s[0]);
                }

                navVo.setLink("http://search.gulimall.com/list.html?" + replaceQueryString(searchParam, attr, "attrs"));

                return navVo;
            }).collect(Collectors.toList()));
        }

        if (CollectionUtils.isNotEmpty(searchParam.getBrandId())) {
            List<SearchResult.NavVo> navs = result.getNavs();
            SearchResult.NavVo navVo = new SearchResult.NavVo();
            navVo.setNavName("品牌");
            R r = productFeignService.brandInfo(searchParam.getBrandId());
            if (r.getCode() == 0) {
                List<BrandVo> brand = r.getData("brands", new TypeReference<List<BrandVo>>() {
                });

                String replace = "";
                StringBuilder buffer = new StringBuilder();
                for (BrandVo brandVo : brand) {
                    buffer.append(brandVo.getName()).append(";");
                    replace = replaceQueryString(searchParam, brandVo.getBrandId().toString(), "brandId");
                }
                navVo.setNavValue(buffer.toString());
                navVo.setLink("http://search.gulimall.com/list.html?" + replace);
            }
            navs.add(navVo);
        }

        if (searchParam.getCatalog3Id() != null) {
            List<SearchResult.NavVo> navs = result.getNavs();
            SearchResult.NavVo nav = new SearchResult.NavVo();
            nav.setNavName(("分类"));
            nav.setNavValue(catalogName);
            StringBuffer buffer = new StringBuffer();
            navs.add(nav);
        }

        return result;
    }

    private String replaceQueryString(SearchParam searchParam, String value, String key) {
        String encode;
        try {
            encode = URLEncoder.encode(value, StandardCharsets.UTF_8.name()).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return searchParam.get_queryString().replace("&" + key + "=" + encode, "").replace(key + "=" + encode, "");
    }

    private SearchRequest buildSearchRequest(SearchParam param) {
//        {
//            "query": {
//            "bool": {
//                "must": [
//                {
//                    "match": {
//                    "skuTitle": "手机"
//                }
//                }
//      ],
//                "filter": [
//                {
//                    "term": {
//                    "catalogId": "225"
//                }
//                },
//                {
//                    "terms": {
//                    "brandId": [
//                    "3",
//                            "12"
//            ]
//                }
//                },
//                {
//                    "nested": {
//                    "path": "attrs",
//                            "query": {
//                        "bool": {
//                            "must": [
//                            {
//                                "term": {
//                                "attrs.attrId": {
//                                    "value": "15"
//                                }
//                            }
//                            },
//                            {
//                                "terms": {
//                                "attrs.attrValue": [
//                                "海思（Hisilicon）",
//                                        "以官网信息为准"
//                      ]
//                            }
//                            }
//                ]
//                        }
//                    }
//                }
//                },
//                {
//                    "term": {
//                    "hasStock": {
//                        "value": "true"
//                    }
//                }
//                },
//                {
//                    "range": {
//                    "skuPrice": {
//                        "gte": 0,
//                                "lte": 7000
//                    }
//                }
//                }
//      ]
//            }
//        },
//            "sort": [
//            {
//                "skuPrice": {
//                "order": "desc"
//            }
//            }
//  ],
//            "from": 0,
//                "size": 2,
//                "highlight": {
//            "fields": {
//                "skuTitle": {}
//            },
//            "pre_tags": "<b style='color: red'>",
//                    "post_tags": "</b>"
//        },
//            "aggs": {
//            "brand_agg": {
//                "terms": {
//                    "field": "brandId",
//                            "size": 10
//                },
//                "aggs": {
//                    "brand_name_agg": {
//                        "terms": {
//                            "field": "brandName",
//                                    "size": 10
//                        }
//                    },
//                    "brand_img_agg": {
//                        "terms": {
//                            "field": "brandImg",
//                                    "size": 10
//                        }
//                    }
//                }
//            },
//            "catalog_agg": {
//                "terms": {
//                    "field": "catalogId",
//                            "size": 10
//                },
//                "aggs": {
//                    "catalog_name_agg": {
//                        "terms": {
//                            "field": "catalogName",
//                                    "size": 10
//                        }
//                    }
//                }
//            },
//            "attr_agg": {
//                "nested": {
//                    "path": "attrs"
//                },
//                "aggs": {
//                    "attr_id_agg": {
//                        "terms": {
//                            "field": "attrs.attrId",
//                                    "size": 10
//                        },
//                        "aggs": {
//                            "attr_name_agg": {
//                                "terms": {
//                                    "field": "attrs.attrName",
//                                            "size": 10
//                                }
//                            },
//                            "attr_value_agg": {
//                                "terms": {
//                                    "field": "attrs.attrValue",
//                                            "size": 10
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        }

        SearchSourceBuilder builder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(param.getKeyword())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("skuTitle", param.getKeyword()));
        }

        if (param.getCatalog3Id() != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("catalogId", param.getCatalog3Id()));
        }

        if (CollectionUtils.isNotEmpty(param.getBrandId())) {
            boolQueryBuilder.filter(QueryBuilders.termsQuery("brandId", param.getBrandId()));
        }

        if (CollectionUtils.isNotEmpty(param.getAttrs())) {
            for (String attr : param.getAttrs()) {
                // attrs=1_白色:蓝色
                String[] attrs = attr.split("_");
                String attrId = attrs[0];
                String[] attrValues = attrs[1].split(":");
                BoolQueryBuilder nestedBoolQueryBuilder = QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("attrs.attrId", attrId))
                        .must(QueryBuilders.termsQuery("attrs.attrValue", attrValues));

                NestedQueryBuilder nestedQueryBuilder = QueryBuilders.nestedQuery("attrs", nestedBoolQueryBuilder, ScoreMode.None);
                boolQueryBuilder.filter(nestedQueryBuilder);
            }
        }

        if (param.getHasStock() != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("hasStock", param.getHasStock() == 1));
        }

        // 1.2.5.价格区间【多种区间传参方式：1_500/_500/500_】
        if (StringUtils.isNotBlank(param.getSkuPrice())) {
            String[] prices = param.getSkuPrice().split("_");
            if (prices.length == 2) {
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("skuPrice").gte(prices[0]).lte(prices[1]));
            } else if (prices.length == 1) {
                if (param.getSkuPrice().startsWith("_")) {
                    boolQueryBuilder.filter(QueryBuilders.rangeQuery("skuPrice").lte(prices[0]));
                } else if (param.getSkuPrice().endsWith("_")) {
                    boolQueryBuilder.filter(QueryBuilders.rangeQuery("skuPrice").gte(prices[1]));
                }
            }
        }

        builder.query(boolQueryBuilder);

        // 1.4.1.排序 【传参方式：saleCount_asc/desc】
        if (StringUtils.isNotBlank(param.getSort())) {
            String[] sorts = param.getSort().split("_");
//            SortOrder sortOrder = sorts[1].toLowerCase().equals(SortOrder.ASC.toString()) ? SortOrder.ASC : SortOrder.DESC;
            SortOrder sortOrder = sorts[1].equalsIgnoreCase("asc") ? SortOrder.ASC : SortOrder.DESC;
            builder.sort(sorts[0], sortOrder);
        }

        builder.from(EsConstant.PRODUCT_PAGE_SIZE * (param.getPageNum() - 1));
        builder.size(EsConstant.PRODUCT_PAGE_SIZE);

        if (StringUtils.isNotBlank(param.getKeyword())) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("skuTitle").preTags("<b style='color:red'>").postTags("</b>");
            builder.highlighter(highlightBuilder);
        }

        TermsAggregationBuilder brandAgg = AggregationBuilders.terms("brand_agg").field("brandId").size(50);
        brandAgg.subAggregation(AggregationBuilders.terms("brand_name_agg").field("brandName").size(1));
        brandAgg.subAggregation(AggregationBuilders.terms("brand_img_agg").field("brandImg").size(1));
        builder.aggregation(brandAgg);

        TermsAggregationBuilder catalogAgg = AggregationBuilders.terms("catalog_agg").field("catalogId").size(20);
        catalogAgg.subAggregation(AggregationBuilders.terms("catalog_name_agg").field("catalogName").size(1));
        builder.aggregation(catalogAgg);

        NestedAggregationBuilder attrNestedAgg = AggregationBuilders.nested("attr_agg", "attrs");
        TermsAggregationBuilder attrIdAgg = AggregationBuilders.terms("attr_id_agg").field("attrs.attrId").size(50);
        attrIdAgg.subAggregation(AggregationBuilders.terms("attr_name_agg").field("attrs.attrName").size(1));
        attrIdAgg.subAggregation(AggregationBuilders.terms("attr_value_agg").field("attrs.attrValue").size(50));
        attrNestedAgg.subAggregation(attrIdAgg);
        builder.aggregation(attrNestedAgg);

        System.out.println("构建的DSL语句: " + builder.toString());

        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.PRODUCT_INDEX}, builder);

        return searchRequest;
    }

}
