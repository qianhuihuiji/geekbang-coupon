package com.nofirst.coupon.customer.feign;

import com.nofirst.coupon.calculation.api.beans.ShoppingCart;
import com.nofirst.coupon.calculation.api.beans.SimulationOrder;
import com.nofirst.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coupon-calculation-serv", path = "/calculator")
public interface CalculationService {

    // 优惠券结算
    @PostMapping("/checkout")
    ShoppingCart checkout(ShoppingCart settlement);

    // 优惠券列表挨个试算
    // 给客户提示每个可用券的优惠额度，帮助挑选
    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}