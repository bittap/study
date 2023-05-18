package com.my.study.object.chapter02.discount.policy;

import java.util.List;
import com.my.study.object.chapter02.Money;
import com.my.study.object.chapter02.Schedule;
import com.my.study.object.chapter02.discount.condition.DiscountConditon;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DiscountPolicy {

  private List<DiscountConditon> conditions;

  protected Money fee;

  public Money calculate(Schedule schedule) {
    for (DiscountConditon condition : conditions) {
      if (condition.isSatisfiedBy(schedule)) {
        return fee.minus(this.discountFee());
      }
    }

    return fee;
  }

  protected abstract Money discountFee();
}
