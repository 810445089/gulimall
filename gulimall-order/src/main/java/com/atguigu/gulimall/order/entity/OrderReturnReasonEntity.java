package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 閫?揣鍘熷洜
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order_return_reason")
public class OrderReturnReasonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 閫?揣鍘熷洜鍚
	 */
	private String name;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 鍚?敤鐘舵?
	 */
	private Integer status;
	/**
	 * create_time
	 */
	private Date createTime;

}
