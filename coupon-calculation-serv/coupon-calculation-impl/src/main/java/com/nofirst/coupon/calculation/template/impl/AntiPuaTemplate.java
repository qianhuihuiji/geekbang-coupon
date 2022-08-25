package com.nofirst.coupon.calculation.template.impl;

import com.nofirst.coupon.calculation.template.AbstractRuleTemplate;
import com.nofirst.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// PAU客户专用优惠计算逻辑，每笔订单享受996暴击
@Slf4j
@Component("antiPuaTemplate")
public class AntiPuaTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        // 凡是在职场碰到上述满口价值观、味道重、不说人话、散播PUA思想的人
        // 不管这是同事还是老板，请一顿996组合拳伺候

        return orderTotalAmount * 996;
    }

    // 设置订单最小支付金额=996
    @Override
    protected long minCost() {
        return 996;
    }
}
