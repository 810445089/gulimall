package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu淇℃伅
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 10:47:12
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍟嗗搧id
	 */
	@TableId
	private Long id;
	/**
	 * 鍟嗗搧鍚嶇О
	 */
	private String spuName;
	/**
	 * 鍟嗗搧鎻忚堪
	 */
	private String spuDescription;
	/**
	 * 鎵?睘鍒嗙被id
	 */
	private Long catalogId;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 
	 */
	private BigDecimal weight;
	/**
	 * 涓婃灦鐘舵?[0 - 涓嬫灦锛? - 涓婃灦]
	 */
	private Integer publishStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
