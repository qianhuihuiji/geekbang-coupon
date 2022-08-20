package com.nofirst.coupon.template.api.beans.rules;

public class TemplateRule {

    /** 可以享受的折扣 */
    private Discount discount;

    // 每个人最多可以领券数量
    private Integer limitation;

    // 过期时间
    private Long deadline;

}
