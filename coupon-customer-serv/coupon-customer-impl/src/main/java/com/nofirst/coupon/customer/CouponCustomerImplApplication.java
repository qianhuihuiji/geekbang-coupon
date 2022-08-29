package com.nofirst.coupon.customer;

import com.nofirst.coupon.customer.loadbalance.CanaryRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackages = {"com.geekbang"})
@EnableTransactionManagement
//用于扫描Dao @Repository
@EnableJpaRepositories(basePackages = {"com.nofirst"})
//用于扫描JPA实体类 @Entity，默认扫本包当下路径
@EntityScan(basePackages = {"com.nofirst"})
@EnableDiscoveryClient
@LoadBalancerClient(value = "coupon-template-serv", configuration = CanaryRuleConfiguration.class)

public class CouponCustomerImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponCustomerImplApplication.class, args);
    }

}
