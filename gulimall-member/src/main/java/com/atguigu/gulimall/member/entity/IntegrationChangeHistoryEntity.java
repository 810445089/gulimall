package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉?垎鍙樺寲鍘嗗彶璁板綍
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_integration_change_history")
public class IntegrationChangeHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 鍙樺寲鐨勫?
	 */
	private Integer changeCount;
	/**
	 * 澶囨敞
	 */
	private String note;
	/**
	 * 鏉ユ簮[0->璐?墿锛?->绠＄悊鍛樹慨鏀?2->娲诲姩]
	 */
	private Integer sourceTyoe;

}
