package com.my.study.object.chapter14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * 日付別に{@code Call}を分ける
 * 
 * @author Carmel
 *
 */
public class DatetimeInterval {

  public List<Call> splitBy(Call call) {
    List<Call> calls = new ArrayList<Call>();
    // 日数を計算
    long daysDifference = ChronoUnit.DAYS.between(call.getStartDatetime(), call.getEndDatetime());
    for (int i = 0; i <= daysDifference; i++) {
      Call tmpCall = new Call();
      boolean firstDay = (i == 0) ? true : false;
      boolean lastDay = (i == daysDifference) ? true : false;
      tmpCall.setStartDatetime(getStartDateTime(call.getStartDatetime(), firstDay));
      tmpCall.setEndDatetime(getEndDateTime(call.getEndDatetime(), lastDay));
      calls.add(tmpCall);
    }

    return calls;
  }

  private LocalDateTime getStartDateTime(LocalDateTime startDateTime, boolean firstDay) {
    return (firstDay) ? startDateTime : this.getDayOfStart(startDateTime.toLocalDate());
  }

  private LocalDateTime getEndDateTime(LocalDateTime endDateTime, boolean lastDay) {
    return (lastDay) ? endDateTime : this.getDayOfEnd(endDateTime.toLocalDate());
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
