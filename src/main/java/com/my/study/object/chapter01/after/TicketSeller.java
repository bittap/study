package com.my.study.object.chapter01.after;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketSeller {
  private TicketOffice ticketOffice;

  public void sellTo(Audience audience) {
    Ticket ticket = ticketOffice.getTicket();
    long sellAmount = audience.buy(ticket);
    ticketOffice.plusAmount(sellAmount);
  }
}
