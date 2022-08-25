package com.nofirst.coupon.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nofirst")
public class CouponCalculationImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponCalculationImplApplication.class, args);
    }

}
