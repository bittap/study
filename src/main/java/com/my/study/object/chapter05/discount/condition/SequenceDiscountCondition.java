package com.my.study.object.chapter05.discount.condition;

import com.my.study.object.chapter05.Schedule;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SequenceDiscountCondition implements DiscountConditon {

  private int sequence;

  @Override
  public boolean isSatisfiedBy(Schedule schedule) {
    return this.sequence == schedule.getSequence() ? true : false;
  }
}
