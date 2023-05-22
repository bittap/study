package com.my.study.object.chapter02.discount.policy;

import java.util.List;
import com.my.study.object.chapter02.Money;
import com.my.study.object.chapter02.discount.condition.DiscountConditon;

public class AmountDiscountPolicy extends DiscountPolicy {

  private Money discountFee;

  public AmountDiscountPolicy(List<DiscountConditon> conditions, Money discountFee) {
    super(conditions);
    this.discountFee = discountFee;
  }

  @Override
  protected Money discountFee(Money fee) {
    return this.discountFee;
  }
}
