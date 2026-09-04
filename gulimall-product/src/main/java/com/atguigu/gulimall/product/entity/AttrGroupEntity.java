package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 灞炴?鍒嗙粍
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍒嗙粍id
	 */
	@TableId
	private Long attrGroupId;
	/**
	 * 缁勫悕
	 */
	private String attrGroupName;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 鎻忚堪
	 */
	private String descript;
	/**
	 * 缁勫浘鏍
	 */
	private String icon;
	/**
	 * 鎵?睘鍒嗙被id
	 */
	private Long catelogId;

    @TableField(exist = false)
    private Long[] catalogPath;

}
