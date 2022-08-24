package com.nofirst.coupon.calculation.impl.template.impl;

import com.nofirst.coupon.calculation.api.beans.ShoppingCart;
import com.nofirst.coupon.calculation.impl.template.AbstractRuleTemplate;
import com.nofirst.coupon.calculation.impl.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 默认空实现
 */
@Slf4j
@Component("dummyTemplate")
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        // 获取订单总价
        Long orderTotalAmount = getTotalPrice(order.getProducts());

        order.setCost(orderTotalAmount);
        return order;
    }


    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }
}
