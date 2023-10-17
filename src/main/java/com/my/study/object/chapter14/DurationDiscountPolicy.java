package com.my.study.object.chapter14;

import java.time.Duration;
import java.util.List;

/**
 * 期間別料金を計算する
 * 
 * @author Carmel
 *
 */
public class DurationDiscountPolicy extends BasicRatePolicy {

  private List<Duration> durations;

  private int amount;

  private List<Long> fees;

  @Override
  protected long calculateCallFee(Call call) {
    // TODO Auto-generated method stub
    return 0;
  }

}
