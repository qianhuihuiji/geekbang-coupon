package com.nofirst.coupon.template.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponType {

    UNKNOWN("unknown", "0", "unknownTemplate"),
    MONEY_OFF("满减券", "1", "moneyOfTemplate"),
    DISCOUNT("打折", "2", "discountTemplate"),
    RANDOM_REDUCTION("随机减", "3", "randomReductionTemplate"),
    LONELY_NIGHT_MONEY_OFF("寂寞午夜double券", "4", "lonelyNightMoneyOffTemplate"),
    ANTI_PUA("PUA加倍奉还券", "5", "antiPuaTemplate");

    private String description;

    // 存在数据库里的最终code
    private String code;

    private String templateName;

    public static CouponType convert(String code) {
        return Stream.of(values())
                .filter(couponType -> couponType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
