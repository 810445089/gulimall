package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼氬憳鏀惰揣鍦板潃
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_member_receive_address")
public class MemberReceiveAddressEntity implements Serializable {
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
	 * 鏀惰揣浜哄?鍚
	 */
	private String name;
	/**
	 * 鐢佃瘽
	 */
	private String phone;
	/**
	 * 閭?斂缂栫爜
	 */
	private String postCode;
	/**
	 * 鐪佷唤/鐩磋緰甯
	 */
	private String province;
	/**
	 * 鍩庡競
	 */
	private String city;
	/**
	 * 鍖
	 */
	private String region;
	/**
	 * 璇︾粏鍦板潃(琛楅亾)
	 */
	private String detailAddress;
	/**
	 * 鐪佸競鍖轰唬鐮
	 */
	private String areacode;
	/**
	 * 鏄?惁榛樿?
	 */
	private Integer defaultStatus;

}
