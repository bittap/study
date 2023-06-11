package com.my.study.object.chapter04;

import java.util.List;
import java.util.Objects;
import com.my.study.object.chapter04.discount.condition.CondtionType;
import com.my.study.object.chapter04.discount.condition.DiscountCondition;

public class ReservationAgency {

  public Reservation reserve(Screening screening, List<Customer> customers, Money money) {
    money = Objects.nonNull(screening.getMovie().getDiscountPolicy())
        ? this.calculate(screening.getMovie(), screening.getSchedule())
        : screening.getMovie().getFee();

    return new Reservation(screening, customers, money);
  }

  private Money discountFee(Movie movie) {
    if (movie.getDiscountType() == DiscountType.AMOUNT) {
      return new Money(movie.getDiscountAmount());
    } else {
      return movie.getFee().times(movie.getDiscountTimes());
    }
  }

  private Money calculate(Movie movie, Schedule schedule) {
    for (DiscountCondition condition : movie.getConditions()) {
      if (this.isSatisfiedBy(condition, schedule)) {
        return movie.getFee().minus(this.discountFee(movie));
      }
    }

    return movie.getFee();
  }

  public boolean isSatisfiedBy(DiscountCondition condition, Schedule schedule) {
    if (condition.getConditionType() == CondtionType.SEQUENCE) {
      return condition.getSequence() == schedule.getSequence() ? true : false;
    } else {
      return Utility.isEqualOrBefore(condition.getStartedAt(), schedule.getStartedAt())
          && Utility.isEqualOrAfter(condition.getEndedAt(), schedule.getStartedAt());
    }
  }
}
