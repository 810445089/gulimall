package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉掓潃娲诲姩鍦烘?
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鍦烘?鍚嶇О
	 */
	private String name;
	/**
	 * 姣忔棩寮??鏃堕棿
	 */
	private Date startTime;
	/**
	 * 姣忔棩缁撴潫鏃堕棿
	 */
	private Date endTime;
	/**
	 * 鍚?敤鐘舵?
	 */
	private Integer status;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;

}
