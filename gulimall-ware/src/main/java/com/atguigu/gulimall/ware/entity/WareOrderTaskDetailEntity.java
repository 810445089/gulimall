package com.atguigu.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 搴撳瓨宸ヤ綔鍗
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:21:10
 */
@Data
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * sku_name
	 */
	private String skuName;
	/**
	 * 璐?拱涓?暟
	 */
	private Integer skuNum;
	/**
	 * 宸ヤ綔鍗昳d
	 */
	private Long taskId;

}
