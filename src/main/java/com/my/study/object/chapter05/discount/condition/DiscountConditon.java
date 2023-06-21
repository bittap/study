package com.my.study.object.chapter05.discount.condition;

import com.my.study.object.chapter05.Schedule;

public interface DiscountConditon {

  public boolean isSatisfiedBy(Schedule schedule);
}
