package com.my.study.object.chapter14;

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

  private List<LocalTime> froms;

  private List<LocalTime> tos;

  private List<Duration> durations;

  private List<Long> fees;

  @Override
  protected long calculateCallFee(Call call) {
    long sumFee = 0L;
    for (Call callDay : call.splitBy()) {
      for (int i = 0; i < froms.size(); i++) {
        LocalTime timeFrom = froms.get(i);
        LocalTime timeTo = tos.get(i);

        // 基準時間が開催時間前
        LocalTime starTime = getFrom(timeFrom, callDay);
        LocalTime endTime = getTo(timeTo, callDay);

        Duration duration = Duration.between(starTime, endTime);
        long seconds = duration.getSeconds();
        sumFee += seconds / durations.get(i).getSeconds() * fees.get(i);
      }
    }

    return sumFee;
  }

  private LocalTime getFrom(LocalTime timeFrom, Call call) {
    LocalTime callFrom = call.getFrom().toLocalTime();
    return timeFrom.isBefore(callFrom)
        ? callFrom
        : timeFrom;
  }

  private LocalTime getTo(LocalTime timeTo, Call call) {
    LocalTime callTo = call.getTo().toLocalTime();
    return timeTo.isBefore(callTo)
        ? timeTo
        : callTo;
  }

}
