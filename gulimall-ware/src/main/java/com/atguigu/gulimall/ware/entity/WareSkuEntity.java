package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 鍟嗗搧搴撳瓨
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:21:10
 */
@Data
@TableName("wms_ware_sku")
public class WareSkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @JsonSerialize(using = ToStringSerializer.class)
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * 浠撳簱id
	 */
    @JsonSerialize(using = ToStringSerializer.class)
	private Long wareId;
	/**
	 * 搴撳瓨鏁
	 */
	private Integer stock;
	/**
	 * sku_name
	 */
	private String skuName;
	/**
	 * 閿佸畾搴撳瓨
	 */
	private Integer stockLocked;

}
