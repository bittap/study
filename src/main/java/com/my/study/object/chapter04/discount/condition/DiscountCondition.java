package com.my.study.object.chapter04.discount.condition;

import java.time.LocalTime;
import com.my.study.object.chapter04.Schedule;
import com.my.study.object.chapter04.Utility;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DiscountCondition {

  @Getter
  private LocalTime startedAt;

  @Getter
  private LocalTime endedAt;

  @Getter
  private int sequence;

  @Getter
  private CondtionType conditionType;

  public boolean isSatisfiedBy(Schedule schedule) {
    if (conditionType == CondtionType.SEQUENCE) {
      return this.sequence == schedule.getSequence() ? true : false;
    } else {
      return Utility.isEqualOrBefore(startedAt, schedule.getStartedAt())
          && Utility.isEqualOrAfter(endedAt, schedule.getStartedAt());
    }
  }
}
