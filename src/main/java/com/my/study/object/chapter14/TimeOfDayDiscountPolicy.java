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

  private List<LocalTime> startTimes;

  private List<LocalTime> endTimes;

  private Duration duration;

  private List<Long> fees;

  @Override
  protected long calculateCallFee(Call call) {
    // TODO Auto-generated method stub
    return 0;
  }

}
