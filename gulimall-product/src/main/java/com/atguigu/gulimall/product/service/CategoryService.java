package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.Catalog2Vo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 鍟嗗搧涓夌骇鍒嗙被
 *
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    Long[] findCatelogPath(Long catelogId);

    List<CategoryEntity> getLevel1Categorys();

    Map<String, List<Catalog2Vo>> getCatalogJson();

    Map<String, List<Catalog2Vo>> getCatalogJson2();

    void updateCascade(CategoryEntity category);
}

