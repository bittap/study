package com.my.study.object.chapter02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.my.study.object.chapter02.discount.condition.PeriodDiscountCondition;
import com.my.study.object.chapter02.discount.condition.SequenceDiscountCondition;
import com.my.study.object.chapter02.discount.policy.AmountDiscountPolicy;
import com.my.study.object.chapter02.discount.policy.PercentDiscountPolicy;

public class ScreeningTest {

  String movieName = "Start wars";

  Money movieFee = new Money(10000);

  Duration movieDuration = Duration.ofSeconds(90L);

  Customer customer1 = new Customer("Customer1");

  Customer customer2 = new Customer("Customer2");

  Schedule Schedule = new Schedule(10, LocalTime.of(10, 0));

  @Test
  void whenTwoPeople_resultFeeIsTwopeole() {
    Reservation reservation =
        new Screening(Schedule, new Movie(movieName, movieFee, movieDuration, null))
            .reserve(customer1, customer2);

    Assertions.assertEquals(List.of(customer1, customer2), reservation.getCustomers());
    Assertions.assertEquals(new Money(10000.0 * 2), reservation.getMoney());
  }

  @Test
  void whenAmountDiscountAndSequncePolicy_resultDiscounted() {
    Reservation reservation = new Screening(Schedule,
        new Movie(movieName, movieFee, movieDuration,
            new AmountDiscountPolicy(List.of(new SequenceDiscountCondition(10)), new Money(1000))))
                .reserve(customer1, customer2);

    Assertions.assertEquals(List.of(customer1, customer2), reservation.getCustomers());
    Assertions.assertEquals(new Money(9000.0 * 2), reservation.getMoney());
    Assertions.assertEquals(Schedule, reservation.getScreening().getSchedule());
  }

  @Test
  void whenAmountDiscountAndPeriodPolicy_resultDiscounted() {
    Reservation reservation = new Screening(Schedule,
        new Movie(movieName, movieFee, movieDuration,
            new AmountDiscountPolicy(
                List.of(new PeriodDiscountCondition(LocalTime.of(9, 0), LocalTime.of(11, 0))),
                new Money(1000)))).reserve(customer1);

    Assertions.assertEquals(List.of(customer1), reservation.getCustomers());
    Assertions.assertEquals(new Money(9000.0), reservation.getMoney());
    Assertions.assertEquals(Schedule, reservation.getScreening().getSchedule());
  }

  @Test
  void whenPercentDiscountAndSequncePolicy_resultDiscounted() {
    Reservation reservation = new Screening(Schedule,
        new Movie(movieName, movieFee, movieDuration,
            new PercentDiscountPolicy(List.of(new SequenceDiscountCondition(10)), 0.1)))
                .reserve(customer1, customer2);

    Assertions.assertEquals(List.of(customer1, customer2), reservation.getCustomers());
    Assertions.assertEquals(0,
        new Money(9000 * 2).getAmount().compareTo(reservation.getMoney().getAmount()));
    Assertions.assertEquals(Schedule, reservation.getScreening().getSchedule());
  }

  @Test
  void whenPercentDiscountAndPeriodPolicy_resultDiscounted() {
    Reservation reservation = new Screening(Schedule,
        new Movie(movieName, movieFee, movieDuration, new PercentDiscountPolicy(
            List.of(new PeriodDiscountCondition(LocalTime.of(9, 0), LocalTime.of(11, 0))), 0.1)))
                .reserve(customer1);

    Assertions.assertEquals(List.of(customer1), reservation.getCustomers());
    Assertions.assertEquals(0,
        new Money(9000).getAmount().compareTo(reservation.getMoney().getAmount()));
    Assertions.assertEquals(Schedule, reservation.getScreening().getSchedule());
  }
}
