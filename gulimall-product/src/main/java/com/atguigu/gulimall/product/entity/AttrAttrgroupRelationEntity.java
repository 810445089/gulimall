package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 灞炴?&灞炴?鍒嗙粍鍏宠仈
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 灞炴?id
	 */
	private Long attrId;
	/**
	 * 灞炴?鍒嗙粍id
	 */
	private Long attrGroupId;
	/**
	 * 灞炴?缁勫唴鎺掑簭
	 */
	private Integer attrSort;

}
