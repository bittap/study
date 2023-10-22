package com.my.study.object.chapter14;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

/**
 * 時間別料金を計算する
 * 
 * @author Carmel
 *
 */
public class TimeOfDayDiscountPolicy extends BasicRatePolicy {

  private List<LocalTime> startTimes;

  private List<LocalTime> endTimes;

  private int amount;

  private List<Long> fees;

  private DatetimeInterval datetimeInterval = new DatetimeInterval();

  @Override
  protected long calculateCallFee(Call call) {
    long sumFee = 0L;
    List<Call> callDays = datetimeInterval.splitBy(call);
    for (Call callDay : callDays) {
      for (int i = 0; i < startTimes.size(); i++) {
        LocalTime feeStartTime = startTimes.get(i);
        LocalTime feeEndTime = endTimes.get(i);

        // 基準時間が開催時間前
        LocalTime starTime = feeStartTime.isBefore(callDay.getStartDatetime().toLocalTime())
            ? callDay.getStartDatetime().toLocalTime()
            : feeStartTime;

        LocalTime endTime = feeEndTime.isBefore(callDay.getEndDatetime().toLocalTime())
            ? feeEndTime
            : callDay.getEndDatetime().toLocalTime();

        Duration duration = Duration.between(starTime, endTime);
        long seconds = duration.getSeconds();
        sumFee += seconds / amount * fees.get(i);
      }
    }

    return sumFee;
  }

}
