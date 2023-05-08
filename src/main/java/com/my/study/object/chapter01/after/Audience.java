package com.my.study.object.chapter01.after;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Audience {
  private Bag bag;

  public long buy(Ticket ticket) {
    return bag.hold(ticket);
  }
}
