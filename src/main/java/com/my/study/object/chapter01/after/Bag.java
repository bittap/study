package com.my.study.object.chapter01.after;

import java.util.Objects;
import lombok.ToString;

@ToString
public class Bag {
  private Invitation invitation;
  private Ticket ticket;
  private Long amount;

  public Bag(Long amount) {
    this.amount = amount;
  }

  public Bag(Invitation invitation, Long amount) {
    this.invitation = invitation;
    this.amount = amount;
  }

  public long hold(Ticket ticket2) {
    long fee = ticket.getFee();
    this.setTicket(ticket);
    if (this.hasInvitation()) {
      return 0;
    } else {
      this.minusAmount(fee);
      return fee;
    }
  }

  private void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  private boolean hasTicket() {
    return Objects.nonNull(this.ticket) ? true : false;
  }

  private boolean hasInvitation() {
    return Objects.nonNull(this.invitation) ? true : false;
  }

  private void plusAmount(long amount) {
    this.amount += amount;
  }

  public void minusAmount(long amount) {
    this.amount -= amount;
  }
}
