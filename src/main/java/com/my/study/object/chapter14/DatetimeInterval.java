package com.my.study.object.chapter14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * 日付別に{@code Call}を分ける
 * 
 * @author Carmel
 *
 */
public class DatetimeInterval {

  @Setter(value = AccessLevel.PRIVATE)
  private LocalDateTime startDateTime;

  @Setter(value = AccessLevel.PRIVATE)
  private LocalDateTime endDateTime;

  public List<DatetimeInterval> splitBy(Call call) {
    List<DatetimeInterval> datetimeIntervals = new ArrayList<DatetimeInterval>();
    // 日数を計算
    long daysDifference = ChronoUnit.DAYS.between(call.getStartDatetime(), call.getEndDatetime());
    for (int i = 0; i <= daysDifference; i++) {
      DatetimeInterval datetimeInterval = new DatetimeInterval();
      boolean firstDay = (i == 0) ? true : false;
      boolean lastDay = (i == daysDifference) ? true : false;
      datetimeInterval.setStartDateTime(call.getStartDatetime(), firstDay);
      datetimeInterval.setEndDateTime(call.getEndDatetime(), lastDay);
      datetimeIntervals.add(datetimeInterval);
    }

    return datetimeIntervals;
  }

  private void setStartDateTime(LocalDateTime startDateTime, boolean firstDay) {
    if (firstDay) {
      this.setStartDateTime(startDateTime);
    } else {
      this.setStartDateTime(this.getDayOfStart(startDateTime.toLocalDate()));
    }
  }

  private void setEndDateTime(LocalDateTime endDateTime, boolean lastDay) {
    if (lastDay) {
      this.setEndDateTime(endDateTime);
    } else {
      this.setEndDateTime(this.getDayOfEnd(endDateTime.toLocalDate()));
    }
  }

  /**
   * その日の最終時間23:59:59時間を取得する
   * 
   * @param target
   * @return
   */
  private LocalDateTime getDayOfEnd(LocalDate target) {
    return LocalDateTime.of(target, LocalTime.of(23, 59, 59));
  }

  /**
   * その日の開始時間0:0:0時間を取得する
   * 
   * @param target
   * @return
   */
  private LocalDateTime getDayOfStart(LocalDate target) {
    return LocalDateTime.of(target, LocalTime.of(0, 0, 0));
  }
}
