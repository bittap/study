package com.my.study.object.chapter14;

import java.time.Duration;
import java.util.List;

/**
 * 期間別料金を計算する
 * 30分までにはxx円
 * 31~50分までにはxx円
 * その後xx円
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
    int callMinutes = (int) call.getDuration().getSeconds() / 60;
    long sumFee = 0L;
    for (int i = 0; i < durations.size(); i++) {
      int minutes = (int) durations.get(i).getSeconds() / 60;
      if (callMinutes > minutes) {
        sumFee += (minutes * 60) / amount * fees.get(i);
        callMinutes -= minutes;
      } else {
        sumFee += (callMinutes * 60) / amount * fees.get(i);
        break;
      }
    }
    return sumFee;
  }

}
