package com.my.study.object.chapter05.data;

import java.util.List;
import com.my.study.object.chapter04.discount.condition.DiscountCondition;

public class ReservationAgency {

  public Reservation reserve(Screening screening, List<Customer> customers) {
    boolean discountable =
        checkDiscountable(screening.getMovie().getConditions(), screening.getSchedule());

    Money money = calculate(screening.getMovie(), customers.size(), discountable);

    return new Reservation(screening, customers, money);
  }

  private Money calculate(Movie movie, int audienceCount, boolean discountable) {
    Money money = movie.getFee();

    if (discountable) {
      money = movie.calculateDiscountFee();
    }

    return money.times(audienceCount);
  }

  private boolean checkDiscountable(List<DiscountCondition> conditions, Schedule schedule) {
    return conditions.stream().anyMatch((e) -> e.isSatisFied(schedule));
  }
}
