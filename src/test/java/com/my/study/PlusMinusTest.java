package com.my.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlusMinusTest {

  int i = 5;

  @Test
  void plusTest() {
    plus();
    Assertions.assertEquals(10, i);
  }

  @Test
  void minusTest() {
    minus();
    Assertions.assertEquals(0, i);
  }

  void plus() {
    i += 5;
  }

  void minus() {
    i -= 5;
  }
}
