package com.nofirst.coupon.calculation.service;

import com.nofirst.coupon.calculation.api.beans.ShoppingCart;
import com.nofirst.coupon.calculation.api.beans.SimulationOrder;
import com.nofirst.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
