package com.my.study.object.chapter02;

import java.time.Duration;
import java.util.Objects;
import com.my.study.object.chapter02.discount.policy.DiscountPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Movie {

  @Getter
  private String title;

  @Getter
  private Money fee;

  @Getter
  private Duration runningTime;

  private DiscountPolicy discountPolicy;

  public Money calculateFee(Screening screening) {
    return Objects.nonNull(discountPolicy)
        ? discountPolicy.calculate(screening.getSchedule(), this.fee)
        : this.fee;
  }

}
