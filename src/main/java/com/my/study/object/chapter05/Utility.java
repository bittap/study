package com.my.study.object.chapter05;

import java.time.LocalTime;

public class Utility {

  private Utility() {

  }

  public static boolean isEqualOrBefore(LocalTime compared1, LocalTime compared2) {
    return compared1.equals(compared2) || compared1.isBefore(compared2) ? true : false;
  }

  public static boolean isEqualOrAfter(LocalTime compared1, LocalTime compared2) {
    return compared1.equals(compared2) || compared1.isAfter(compared2) ? true : false;
  }
}
