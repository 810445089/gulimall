package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 棣栭〉涓撻?琛ㄣ?jd棣栭〉涓嬮潰寰堝?涓撻?锛屾瘡涓?笓棰橀摼鎺ユ柊鐨勯〉闈?紝灞曠ず涓撻?鍟嗗搧淇℃伅銆
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:33:53
 */
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 涓撻?鍚嶅瓧
	 */
	private String name;
	/**
	 * 涓撻?鏍囬?
	 */
	private String title;
	/**
	 * 涓撻?鍓?爣棰
	 */
	private String subTitle;
	/**
	 * 鏄剧ず鐘舵?
	 */
	private Integer status;
	/**
	 * 璇︽儏杩炴帴
	 */
	private String url;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 涓撻?鍥剧墖鍦板潃
	 */
	private String img;

}
