package com.atguigu.gulimall.search.controller;

import com.atguigu.common.exception.BizCodeEnum;
import com.atguigu.common.to.es.SkuEsModel;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search/save")
public class ElasticSearchController {

    @Autowired
    private ProductSaveService productSaveService;

    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) throws IOException {

        boolean flag = false;
        try {
            flag = productSaveService.productStatusUp(skuEsModels);
        } catch(Exception e){
            log.error("ElasticSearchController商品上架错误: {}", e.getMessage());
        }

        if (flag) {
            return R.ok();
        } else {
            return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.PRODUCT_UP_EXCEPTION.getMessage());
        }
    }
}
