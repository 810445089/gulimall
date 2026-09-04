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
@TableName("wms_ware_order_task")
public class WareOrderTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * order_id
	 */
	private Long orderId;
	/**
	 * order_sn
	 */
	private String orderSn;
	/**
	 * 鏀惰揣浜
	 */
	private String consignee;
	/**
	 * 鏀惰揣浜虹數璇
	 */
	private String consigneeTel;
	/**
	 * 閰嶉?鍦板潃
	 */
	private String deliveryAddress;
	/**
	 * 璁㈠崟澶囨敞
	 */
	private String orderComment;
	/**
	 * 浠樻?鏂瑰紡銆?1:鍦ㄧ嚎浠樻? 2:璐у埌浠樻?銆
	 */
	private Integer paymentWay;
	/**
	 * 浠诲姟鐘舵?
	 */
	private Integer taskStatus;
	/**
	 * 璁㈠崟鎻忚堪
	 */
	private String orderBody;
	/**
	 * 鐗╂祦鍗曞彿
	 */
	private String trackingNo;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 浠撳簱id
	 */
	private Long wareId;
	/**
	 * 宸ヤ綔鍗曞?娉
	 */
	private String taskComment;

}
