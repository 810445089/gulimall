package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 璁㈠崟鎿嶄綔鍘嗗彶璁板綍
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order_operate_history")
public class OrderOperateHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 璁㈠崟id
	 */
	private Long orderId;
	/**
	 * 鎿嶄綔浜篬鐢ㄦ埛锛涚郴缁燂紱鍚庡彴绠＄悊鍛榏
	 */
	private String operateMan;
	/**
	 * 鎿嶄綔鏃堕棿
	 */
	private Date createTime;
	/**
	 * 璁㈠崟鐘舵?銆?->寰呬粯娆撅紱1->寰呭彂璐э紱2->宸插彂璐э紱3->宸插畬鎴愶紱4->宸插叧闂?紱5->鏃犳晥璁㈠崟銆
	 */
	private Integer orderStatus;
	/**
	 * 澶囨敞
	 */
	private String note;

}
