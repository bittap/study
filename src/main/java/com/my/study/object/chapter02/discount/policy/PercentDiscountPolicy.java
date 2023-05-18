package com.my.study.object.chapter02.discount.policy;

import java.math.BigDecimal;
import java.util.List;
import com.my.study.object.chapter02.Money;
import com.my.study.object.chapter02.discount.condition.DiscountConditon;

public class PercentDiscountPolicy extends DiscountPolicy {

  private BigDecimal discountTIimes;

  public PercentDiscountPolicy(List<DiscountConditon> conditions, Money fee,
      BigDecimal discountTIimes) {
    super(conditions, fee);
    this.discountTIimes = discountTIimes;
  }

  @Override
  protected Money discountFee() {
    return this.fee.times(discountTIimes);
  }
}
