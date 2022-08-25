package com.nofirst.coupon.calculation.template;

import com.nofirst.coupon.calculation.api.beans.ShoppingCart;
import com.nofirst.coupon.calculation.template.impl.DummyTemplate;
import com.nofirst.coupon.template.api.beans.CouponTemplateInfo;
import com.nofirst.coupon.template.api.enums.CouponType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Map;

// 工厂方法根据订单中的优惠券信息，返回对应的Template用于计算优惠价
@Component
@Slf4j
public class CouponTemplateFactory {

    @Resource
    private Map<String, RuleTemplate> ruleTemplateMap;

    @Resource
    private DummyTemplate dummyTemplate;

    public RuleTemplate getTemplate(ShoppingCart order) {
        // 不使用优惠券
        if (CollectionUtils.isEmpty(order.getCouponInfos())) {
            // dummy模板直接返回原价，不进行优惠计算
            return dummyTemplate;
        }

        // 获取优惠券的类别
        // 目前每个订单只支持单张优惠券
        CouponTemplateInfo template = order.getCouponInfos().get(0).getTemplate();
        CouponType category = CouponType.convert(template.getType());

        return ruleTemplateMap.getOrDefault(category.getTemplateName(), dummyTemplate);
    }

}
