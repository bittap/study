package com.my.study.object.chapter02.discount.condition;

import java.time.LocalTime;
import com.my.study.object.chapter02.Schedule;
import com.my.study.object.chapter02.Utility;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PeriodDiscountCondition implements DiscountConditon {

  private LocalTime startedAt;

  private LocalTime endedAt;

  @Override
  public boolean isSatisfiedBy(Schedule schedule) {
    return Utility.isEqualOrBefore(startedAt, schedule.getStartedAt())
        && Utility.isEqualOrAfter(endedAt, schedule.getStartedAt());
  }
}
