package com.my.study.object.chapter01.before;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theator {
  private TicketSeller ticketSeller;

  public void enter(Audience audience) {
    if (audience.getBag().hasInvitation()) {
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().setTicket(ticket);
    } else {
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      long fee = ticket.getFee();
      audience.getBag().minusAmount(fee);
      audience.getBag().setTicket(ticket);
    }
  }
}
