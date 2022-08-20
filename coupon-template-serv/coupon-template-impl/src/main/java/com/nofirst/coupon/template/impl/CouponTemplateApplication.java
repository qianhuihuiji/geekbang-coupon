package com.nofirst.coupon.template.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.nofirst"})
public class CouponTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponTemplateApplication.class, args);
    }

}
