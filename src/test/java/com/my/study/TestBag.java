package com.my.study;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.my.study.object.chapter01.Bag;
import com.my.study.object.chapter01.Invitation;

public class TestBag {

  Bag bag = new Bag(0, new Invitation(LocalDateTime.now()), null);

  @Test
  void test() {
    Assertions.assertNotNull(bag.giveInvitation());
  }
}
