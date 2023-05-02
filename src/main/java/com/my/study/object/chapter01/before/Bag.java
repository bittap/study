package com.my.study.object.chapter01.before;

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

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public boolean hasTicket() {
    return Objects.nonNull(this.ticket) ? true : false;
  }

  public boolean hasInvitation() {
    return Objects.nonNull(this.invitation) ? true : false;
  }

  public void plusAmount(long amount) {
    this.amount += amount;
  }

  public void minusAmount(long amount) {
    this.amount -= amount;
  }
}
