package com.my.study.object.chapter01.after;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    long audienceAmount = 1000;
    // 招待状がある方
    Bag bag1 = new Bag(new Invitation(), audienceAmount);
    Audience audience1 = new Audience(bag1);

    // 招待状がない方
    Bag bag2 = new Bag(audienceAmount);
    Audience audience2 = new Audience(bag2);

    List<Ticket> tickets = new ArrayList<Ticket>(List.of(new Ticket(300L), new Ticket(500L)));
    TicketOffice ticketOffice = new TicketOffice(0L, tickets);
    TicketSeller ticketSeller = new TicketSeller(ticketOffice);
    Theator theator = new Theator(ticketSeller);

    theator.enter(audience1);
    theator.enter(audience2);

    System.out.println("結果");
    System.out.println(ticketOffice);
    System.out.println(audience1);
    System.out.println(audience2);
  }
}
