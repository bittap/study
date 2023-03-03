package com.my.study.object.chapter01;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Audience {

  private Bag bag;

  public int buy(Ticket ticket) {
    return bag.hold(ticket);
  }

}
