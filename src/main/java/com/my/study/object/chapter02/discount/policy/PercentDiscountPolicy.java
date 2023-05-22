package com.my.study.object.chapter02.discount.policy;

import java.util.List;
import com.my.study.object.chapter02.Money;
import com.my.study.object.chapter02.discount.condition.DiscountConditon;

public class PercentDiscountPolicy extends DiscountPolicy {

  private double discountTIimes;

  public PercentDiscountPolicy(List<DiscountConditon> conditions, double discountTIimes) {
    super(conditions);
    this.discountTIimes = discountTIimes;
  }

  @Override
  protected Money discountFee(Money fee) {
    return fee.times(discountTIimes);
  }
}
