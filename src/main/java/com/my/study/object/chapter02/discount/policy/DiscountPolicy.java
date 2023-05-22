package com.my.study.object.chapter02.discount.policy;

import java.util.List;
import com.my.study.object.chapter02.Money;
import com.my.study.object.chapter02.Schedule;
import com.my.study.object.chapter02.discount.condition.DiscountConditon;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public abstract class DiscountPolicy {

  @NonNull
  private List<DiscountConditon> conditions;

  public Money calculate(Schedule schedule, Money fee) {
    for (DiscountConditon condition : conditions) {
      if (condition.isSatisfiedBy(schedule)) {
        return fee.minus(this.discountFee(fee));
      }
    }

    return fee;
  }

  protected abstract Money discountFee(Money fee);
}
