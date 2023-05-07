package com.my.study.object.chapter01.after;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TicketOffice {
  private Long amount;
  private List<Ticket> tickets;

  public Ticket getTicket() {
    System.out.println(tickets);
    return tickets.remove(0);
  }

  public void plusAmount(long amount) {
    this.amount += amount;
  }

  public void minusAmount(long amount) {
    this.amount -= amount;
  }
}
