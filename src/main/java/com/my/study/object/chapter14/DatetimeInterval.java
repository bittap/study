package com.my.study.object.chapter14;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

/**
 * 開始日時と終了日時に関するクラス
 * 
 * @author Carmel
 *
 */
@Getter
public class DatetimeInterval {

  private LocalDateTime from;

  private LocalDateTime to;

  private Spliter spliter = new Spliter();

  public static DatetimeInterval of(LocalDateTime from, LocalDateTime to) {
    return new DatetimeInterval(from, to);
  }

  public static DatetimeInterval toMidnight(LocalDateTime from) {
    return new DatetimeInterval(
        from,
        LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59)));
  }

  public static DatetimeInterval fromMidnight(LocalDateTime to) {
    return new DatetimeInterval(
        LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)),
        to);
  }

  public static DatetimeInterval during(LocalDateTime from) {
    return new DatetimeInterval(
        LocalDateTime.of(from.toLocalDate(), LocalTime.of(0, 0)),
        LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59)));
  }

  private DatetimeInterval(LocalDateTime from, LocalDateTime to) {
    this.from = from;
    this.to = to;
    this.spliter = new Spliter();
  }

  public Duration getDuration() {
    return Duration.between(from, to);
  }

  public List<Call> splitByDay() {
    return spliter.splitByDay(this);
  }

  private static class Spliter {
    private List<Call> splitByDay(DatetimeInterval datetimeInterval) {
      // 日数を計算
      long daysDifference = getDays(datetimeInterval);
      if (daysDifference >= 1) {
        splitByDay(datetimeInterval, daysDifference);
      }

      return Arrays.asList(new Call(datetimeInterval.getFrom(), datetimeInterval.getTo()));
    }

    private List<Call> splitByDay(DatetimeInterval datetimeInterval, long daysDifference) {
      List<Call> calls = new ArrayList<Call>();
      addFirstDay(calls, datetimeInterval);
      addMiddleDay(calls, datetimeInterval, daysDifference);
      addLastDay(calls, datetimeInterval);
      return calls;
    }

    private void addMiddleDay(List<Call> calls, DatetimeInterval datetimeInterval, long daysDifference) {
      for (int i = 1; i < daysDifference; i++) {
        LocalDateTime from = datetimeInterval.getFrom().plusDays(i);
        DatetimeInterval middleDayInterval = DatetimeInterval.during(from);
        calls.add(new Call(middleDayInterval.getFrom(), middleDayInterval.getTo()));
      }
    }

    private void addLastDay(List<Call> calls, DatetimeInterval datetimeInterval) {
      DatetimeInterval lastDayInterval = DatetimeInterval.fromMidnight(datetimeInterval.getTo());
      calls.add(new Call(lastDayInterval.getFrom(), lastDayInterval.getTo()));
    }

    private void addFirstDay(List<Call> calls, DatetimeInterval datetimeInterval) {
      DatetimeInterval firstDayInterval = DatetimeInterval.toMidnight(datetimeInterval.getFrom());
      calls.add(new Call(firstDayInterval.getFrom(), firstDayInterval.getTo()));
    }

    private long getDays(DatetimeInterval target) {
      return ChronoUnit.DAYS.between(target.getFrom(), target.getTo());
    }
  }
}
