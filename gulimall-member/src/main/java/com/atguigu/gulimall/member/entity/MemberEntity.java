package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼氬憳
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 浼氬憳绛夌骇id
	 */
	private Long levelId;
	/**
	 * 鐢ㄦ埛鍚
	 */
	private String username;
	/**
	 * 瀵嗙爜
	 */
	private String password;
	/**
	 * 鏄电О
	 */
	private String nickname;
	/**
	 * 鎵嬫満鍙风爜
	 */
	private String mobile;
	/**
	 * 閭??
	 */
	private String email;
	/**
	 * 澶村儚
	 */
	private String header;
	/**
	 * 鎬у埆
	 */
	private Integer gender;
	/**
	 * 鐢熸棩
	 */
	private Date birth;
	/**
	 * 鎵?湪鍩庡競
	 */
	private String city;
	/**
	 * 鑱屼笟
	 */
	private String job;
	/**
	 * 涓??绛惧悕
	 */
	private String sign;
	/**
	 * 鐢ㄦ埛鏉ユ簮
	 */
	private Integer sourceType;
	/**
	 * 绉?垎
	 */
	private Integer integration;
	/**
	 * 鎴愰暱鍊
	 */
	private Integer growth;
	/**
	 * 鍚?敤鐘舵?
	 */
	private Integer status;
	/**
	 * 娉ㄥ唽鏃堕棿
	 */
	private Date createTime;

}
