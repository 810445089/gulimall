package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 鍟嗗搧涓夌骇鍒嗙被
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍒嗙被id
	 */
	@TableId
	private Long catId;
	/**
	 * 鍒嗙被鍚嶇О
	 */
	private String name;
	/**
	 * 鐖跺垎绫籭d
	 */
	private Long parentCid;
	/**
	 * 灞傜骇
	 */
	private Integer catLevel;
	/**
	 * 鏄?惁鏄剧ず[0-涓嶆樉绀猴紝1鏄剧ず]
	 */
    @TableLogic(value = "1", delval = "0")
	private Integer showStatus;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 鍥炬爣鍦板潃
	 */
	private String icon;
	/**
	 * 璁￠噺鍗曚綅
	 */
	private String productUnit;
	/**
	 * 鍟嗗搧鏁伴噺
	 */
	private Integer productCount;

    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CategoryEntity> children;
}
