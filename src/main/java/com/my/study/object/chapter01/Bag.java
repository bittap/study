package com.my.study.object.chapter01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Bag {

  private int moeny;

  private Invitation invitation;

  @Setter
  private Ticket ticket;

  public int hold(Ticket ticket) {
    int fee = 0;
    if (Objects.isNull(invitation) || !isMatchedTicket(invitation.getWhen())) {
      fee = ticket.getFee();
      this.minusMoney(fee);
    } else {
      this.giveInvitation();
    }

    this.setTicket(ticket);

    return fee;
  }

  public Invitation hasInvitation() {
    return this.invitation;
  }

  public Ticket hasTicket() {
    return this.ticket;
  }

  public void plusMoney(int moeny) {
    this.moeny += moeny;
  }

  public void minusMoney(int moeny) {
    this.moeny -= moeny;
  }

  public Invitation giveInvitation() {
    Invitation temp = this.invitation;
    removeInvitation();
    return temp;
  }

  private void removeInvitation() {
    this.invitation = null;
  }

  private boolean isMatchedTicket(LocalDateTime compared) {
    LocalDate nowDate = LocalDate.now();
    LocalDate comparedDate = compared.toLocalDate();

    if (comparedDate.isEqual(nowDate)) {
      return true;
    } else {
      return false;
    }
  }
}
