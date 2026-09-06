package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 鍝佺墝鍒嗙被鍏宠仈
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 鍒嗙被id
	 */
	@NotNull(message = "分类id不能为空")
	private Long catelogId;
	/**
	 * 
	 */
	private String brandName;
	/**
	 * 
	 */
	private String catelogName;

}
