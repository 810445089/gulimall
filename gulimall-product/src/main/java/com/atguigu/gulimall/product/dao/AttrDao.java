package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 鍟嗗搧灞炴?
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	List<Long> selectSearchAttrIds(@Param("attrIds") List<Long> attrIds);
}
