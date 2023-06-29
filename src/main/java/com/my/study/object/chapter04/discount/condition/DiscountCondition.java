package com.my.study.object.chapter04.discount.condition;

import java.time.LocalTime;
import com.my.study.object.chapter05.data.Schedule;
import com.my.study.object.chapter05.data.Utility;
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

  public boolean isSatisFied(Schedule schedule) {
    if (this.conditionType == CondtionType.SEQUENCE) {
      return this.isSatisFiedSequence(schedule);
    } else {
      return this.isSatisFiedPeriod(schedule);
    }
  }

  private boolean isSatisFiedSequence(Schedule schedule) {
    return this.getSequence() == schedule.getSequence() ? true : false;
  }

  private boolean isSatisFiedPeriod(Schedule schedule) {
    return Utility.isEqualOrBefore(this.getStartedAt(), schedule.getStartedAt())
        && Utility.isEqualOrAfter(this.getEndedAt(), schedule.getStartedAt());
  }
}
