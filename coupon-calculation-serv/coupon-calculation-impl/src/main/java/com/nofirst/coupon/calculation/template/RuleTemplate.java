package com.nofirst.coupon.calculation.template;

import com.nofirst.coupon.calculation.api.beans.ShoppingCart;

public interface RuleTemplate {
    ShoppingCart calculate(ShoppingCart settlement);
}
