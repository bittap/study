package com.my.study.object.chapter01.after;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theator {
  private TicketSeller ticketSeller;

  public void enter(Audience audience) {
    ticketSeller.sellTo(audience);
  }
}
