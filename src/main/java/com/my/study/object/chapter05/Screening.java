package com.my.study.object.chapter05;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Screening {
  private Movie movie;
  private Schedule schedule;


  public Reservation reserve(List<Customer> customers) {
    return new Reservation(this, customers,
        movie.calculateFee(this.getSchedule()).times(customers.size()));
  }
}
