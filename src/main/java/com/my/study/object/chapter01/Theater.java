package com.my.study.object.chapter01;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theater {

  private TicketSeller ticketSeller;

  public void enter(List<Audience> audiences) {
    for (Audience audience : audiences) {
      ticketSeller.sellTo(audience);
    }
  }

}
