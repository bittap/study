package com.my.study;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.my.study.object.chapter01.Audience;
import com.my.study.object.chapter01.Bag;
import com.my.study.object.chapter01.Invitation;
import com.my.study.object.chapter01.Theater;
import com.my.study.object.chapter01.Ticket;
import com.my.study.object.chapter01.TicketOffice;
import com.my.study.object.chapter01.TicketSeller;

public class TheatherTest {

  Ticket[] tickets = new Ticket[] {new Ticket(500), new Ticket(1000)};

  TicketOffice office = new TicketOffice(0L, tickets);

  TicketSeller ticketSeller = new TicketSeller(office);

  Theater theater = new Theater(ticketSeller);

  @Test
  void givenNoInvitationAudience_whenEnter_resultAudienceIsMinusFee() {
    Audience ExpecetedAudience = new Audience(new Bag(0, null, tickets[0]));

    Audience audience = new Audience(new Bag(500, null, null));


    List<Audience> audiences = List.of(audience);
    theater.enter(audiences);

    Assertions.assertEquals(ExpecetedAudience, audiences.get(0));
  }

  @Test
  void givenHaveInvitationAudience_whenEnter_resultExpectedAudience() {
    Audience ExpecetedAudience = new Audience(new Bag(0, null, tickets[0]));

    Audience audience = new Audience(new Bag(0, new Invitation(LocalDateTime.now()), null));


    List<Audience> audiences = List.of(audience);
    theater.enter(audiences);

    Assertions.assertEquals(ExpecetedAudience, audiences.get(0));
  }
}
