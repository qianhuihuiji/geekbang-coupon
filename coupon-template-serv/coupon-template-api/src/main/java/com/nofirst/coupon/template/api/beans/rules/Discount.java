package com.nofirst.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discount {

    // 满减：减掉的钱数
    // 折扣：打多少折，90 即九折
    private Long quota;

    // 最低消费金额
    private Long threshold;
}
