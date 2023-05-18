package com.my.study.object.chapter02.discount.condition;

import com.my.study.object.chapter02.Schedule;

public interface DiscountConditon {

  public boolean isSatisfiedBy(Schedule schedule);
}
