package com.my.study.object.chapter04;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Reservation {

  private Screening screening;

  private List<Customer> customers;

  private Money money;
}
