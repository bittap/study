package com.my.study.object.chapter05;

import java.time.Duration;
import java.util.List;
import com.my.study.object.chapter05.discount.condition.DiscountConditon;
import lombok.Getter;


public class Movie {
  @Getter
  private String title;
  @Getter
  private Duration runningTime;
  @Getter
  private Money fee;
  private List<DiscountConditon> discountConditions;


  private Type type;
  private int aumountDiscount;
  private double percent;


  public Money calculateFee(Schedule schedule) {
    if (isDiscountable(schedule)) {
      return calculateDiscount();
    }
    return fee;
  }

  private boolean isDiscountable(Schedule schedule) {
    return discountConditions.stream().anyMatch((e) -> e.isSatisfiedBy(schedule));
  }

  private Money calculateDiscount() {
    if (type == Type.AMOUNT) {
      return calculateAmountDiscount();
    } else {
      return calculatePercentDiscount();
    }
  }

  private Money calculateAmountDiscount() {
    return this.fee.minus(aumountDiscount);
  }

  private Money calculatePercentDiscount() {
    return this.fee.times(percent);
  }

  public static enum Type {
    AMOUNT, PERCENT;
  }
}
