package com.my.study.object.chapter02;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Screening {

  @Getter
  private Schedule schedule;

  private Movie movie;

  public Reservation reserve(Customer... customers) {
    return new Reservation(this, Arrays.asList(customers), movie.calculateFee(this));
  }
}
