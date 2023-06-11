package com.my.study.object.chapter04;

import java.time.Duration;
import java.util.List;
import com.my.study.object.chapter02.discount.policy.DiscountPolicy;
import com.my.study.object.chapter04.discount.condition.DiscountCondition;
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

  @Getter
  private List<DiscountCondition> conditions;

  @Getter
  private DiscountType discountType;

  @Getter
  private int discountAmount;

  @Getter
  private double discountTimes;

  @Getter
  private DiscountPolicy discountPolicy;

}
