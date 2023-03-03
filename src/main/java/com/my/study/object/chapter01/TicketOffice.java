package com.my.study.object.chapter01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TicketOffice {

  private Long balance;

  private List<Ticket> tickets;

  public TicketOffice(Long balance, Ticket... tickets) {
    this.balance = balance;
    this.tickets = new LinkedList<>(Arrays.asList(tickets));
  }

  public void plusBalance(Integer fee) {
    this.balance += Long.valueOf(fee);
  }

  public void minusBalance(Integer fee) {
    this.balance -= Long.valueOf(fee);
  }

  public Ticket getTicket() {
    return tickets.remove(0);
  }
}
