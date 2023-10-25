package com.my.study.object.chapter14.refactoring;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
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
  }

  public Duration getDuration() {
    return Duration.between(from, to);
  }

  public List<DatetimeInterval> splitByDay() {
    Spliter spliter = new Spliter(this);
    return spliter.splitByDay();
  }

  @AllArgsConstructor
  private static class Spliter {

    private DatetimeInterval datetimeInterval;

    private List<DatetimeInterval> splitByDay() {
      // 日数を計算
      long daysDifference = getDays(datetimeInterval);
      if (daysDifference >= 1) {
        splitByDay(daysDifference);
      }

      return Arrays.asList(DatetimeInterval.of(datetimeInterval.getFrom(), datetimeInterval.getTo()));
    }

    private List<DatetimeInterval> splitByDay(long daysDifference) {
      List<DatetimeInterval> intervals = new ArrayList<DatetimeInterval>();
      addFirstDay(intervals);
      addMiddleDay(intervals, daysDifference);
      addLastDay(intervals);
      return intervals;
    }

    private void addMiddleDay(List<DatetimeInterval> intervals, long daysDifference) {
      for (int i = 1; i < daysDifference; i++) {
        LocalDateTime from = datetimeInterval.getFrom().plusDays(i);
        DatetimeInterval middleDayInterval = DatetimeInterval.during(from);
        intervals.add(DatetimeInterval.of(middleDayInterval.getFrom(), middleDayInterval.getTo()));
      }
    }

    private void addLastDay(List<DatetimeInterval> intervals) {
      DatetimeInterval lastDayInterval = DatetimeInterval.fromMidnight(datetimeInterval.getTo());
      intervals.add(DatetimeInterval.of(lastDayInterval.getFrom(), lastDayInterval.getTo()));
    }

    private void addFirstDay(List<DatetimeInterval> intervals) {
      DatetimeInterval firstDayInterval = DatetimeInterval.toMidnight(datetimeInterval.getFrom());
      intervals.add(DatetimeInterval.of(firstDayInterval.getFrom(), firstDayInterval.getTo()));
    }

    private long getDays(DatetimeInterval target) {
      return ChronoUnit.DAYS.between(target.getFrom(), target.getTo());
    }
  }
}
