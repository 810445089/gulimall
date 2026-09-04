package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 璁㈠崟閰嶇疆淇℃伅
 * 
 * @author wy
 * @email wy@gmail.com
 * @date 2026-08-28 17:02:42
 */
@Data
@TableName("oms_order_setting")
public class OrderSettingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 绉掓潃璁㈠崟瓒呮椂鍏抽棴鏃堕棿(鍒?
	 */
	private Integer flashOrderOvertime;
	/**
	 * 姝ｅ父璁㈠崟瓒呮椂鏃堕棿(鍒?
	 */
	private Integer normalOrderOvertime;
	/**
	 * 鍙戣揣鍚庤嚜鍔ㄧ‘璁ゆ敹璐ф椂闂达紙澶╋級
	 */
	private Integer confirmOvertime;
	/**
	 * 鑷?姩瀹屾垚浜ゆ槗鏃堕棿锛屼笉鑳界敵璇烽?璐э紙澶╋級
	 */
	private Integer finishOvertime;
	/**
	 * 璁㈠崟瀹屾垚鍚庤嚜鍔ㄥソ璇勬椂闂达紙澶╋級
	 */
	private Integer commentOvertime;
	/**
	 * 浼氬憳绛夌骇銆?-涓嶉檺浼氬憳绛夌骇锛屽叏閮ㄩ?鐢?紱鍏朵粬-瀵瑰簲鐨勫叾浠栦細鍛樼瓑绾с?
	 */
	private Integer memberLevel;

}
