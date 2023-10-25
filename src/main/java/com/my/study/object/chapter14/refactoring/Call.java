package com.my.study.object.chapter14.refactoring;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

/**
 * 一回に通話した記録を保つ
 * 
 * @author Carmel
 *
 */
@Getter
public class Call {
  private DatetimeInterval datetimeInterval;

  public Call(LocalDateTime from, LocalDateTime to) {
    this.datetimeInterval = DatetimeInterval.of(from, to);
  }

  public List<DatetimeInterval> splitBy() {
    return this.datetimeInterval.splitByDay();
  }

  public LocalDateTime getFrom() {
    return this.datetimeInterval.getFrom();
  }

  public LocalDateTime getTo() {
    return this.datetimeInterval.getTo();
  }

  public Duration getDuration() {
    return datetimeInterval.getDuration();
  }

}
