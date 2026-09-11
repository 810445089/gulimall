package com.atguigu.common.constant;

import lombok.Getter;

public class WareConstant {

    @Getter
    public enum PurchaseStatusEnum {

        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        RECEIVED(2, "已领取"),
        FINISHED(3, "已完成"),
        HAS_ERROR(4, "待确认");

        private final int code;

        private final String msg;

        PurchaseStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    @Getter
    public enum PurchaseDetailStatusEnum {
        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        RECEIVED(2, "正在采购"),
        FINISHED(3, "已完成"),
        HAS_ERROR(4, "采购失败");

        private final int code;

        private final String msg;

        PurchaseDetailStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
