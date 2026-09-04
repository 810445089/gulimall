package com.atguigu.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鎴愰暱鍊煎彉鍖栧巻鍙茶?褰
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 16:51:52
 */
@Data
@TableName("ums_growth_change_history")
public class GrowthChangeHistoryEntity implements Serializable {
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
	 * 鏀瑰彉鐨勫?锛堟?璐熻?鏁帮級
	 */
	private Integer changeCount;
	/**
	 * 澶囨敞
	 */
	private String note;
	/**
	 * 绉?垎鏉ユ簮[0-璐?墿锛?-绠＄悊鍛樹慨鏀筣
	 */
	private Integer sourceType;

}
