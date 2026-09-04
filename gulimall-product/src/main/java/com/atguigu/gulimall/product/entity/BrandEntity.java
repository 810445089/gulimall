package com.atguigu.gulimall.product.entity;

import com.atguigu.common.valid.AddGroup;
import com.atguigu.common.valid.ListValue;
import com.atguigu.common.valid.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 鍝佺墝
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍝佺墝id
	 */
	@TableId
    @NotNull(message = "修改品牌必须指定品牌id", groups = { UpdateGroup.class })
    @Null(message = "新增品牌不能指定id", groups = { AddGroup.class })
	private Long brandId;
	/**
	 * 鍝佺墝鍚
	 */
    @NotBlank(message = "品牌名必须非空", groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 鍝佺墝logo鍦板潃
	 */
    @NotEmpty(groups = { AddGroup.class })
    @URL(message = "必须是一个合法的url地址", groups = { UpdateGroup.class, AddGroup.class })
	private String logo;
	/**
	 * 浠嬬粛
	 */
	private String descript;
	/**
	 * 鏄剧ず鐘舵?[0-涓嶆樉绀猴紱1-鏄剧ず]
	 */
    @NotNull(groups = { AddGroup.class })
    @ListValue(values = {0, 1}, groups = { AddGroup.class })
	private Integer showStatus;
	/**
	 * 妫?储棣栧瓧姣
	 */
    @NotEmpty(groups = { AddGroup.class })
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = { AddGroup.class, UpdateGroup.class })
	private String firstLetter;
	/**
	 * 鎺掑簭
	 */
    @NotNull(groups = { AddGroup.class })
    @Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
