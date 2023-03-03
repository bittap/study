package com.my.study.object.chapter01;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketSeller {

  private TicketOffice ticketOffice;

  public void plusBalance(Integer fee) {
    ticketOffice.plusBalance(fee);
  }

  public void minusBalance(Integer fee) {
    ticketOffice.minusBalance(fee);
  }

  public Ticket getTicket() {
    return ticketOffice.getTicket();
  }

  public void sellTo(Audience audience) {
    int profit = audience.buy(getTicket());
    ticketOffice.plusBalance(profit);
  }
}
