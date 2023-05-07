package com.my.study.object.chapter01.after;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Audience {
  private Bag bag;

  public long buy(Ticket ticket) {
    long fee = ticket.getFee();
    this.bag.setTicket(ticket);
    if (this.bag.hasInvitation()) {
      return 0;
    } else {
      this.bag.minusAmount(fee);
      return fee;
    }
  }
}
