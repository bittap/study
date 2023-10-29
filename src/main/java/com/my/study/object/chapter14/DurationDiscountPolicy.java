package com.my.study.object.chapter14;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 期間別料金を計算する
 * 30分までにはxx円
 * 31~50分までにはxx円
 * その後xx円
 * 
 * @author Carmel
 *
 */
public class DurationDiscountPolicy extends FixedFeePolicy {

  private Duration from;

  private Duration to;

  /**
   * @param from
   * @param to
   */
  public DurationDiscountPolicy(Duration from, Duration to, int amount, Duration seconds) {
    super(amount, seconds);
    this.from = from;
    this.to = to;
  }

  @Override
  protected long calculateCallFee(Call call) {
    long sumFee = 0L;

    if (call.getDuration().compareTo(to) > 0) {
      return sumFee;
    }

    if (call.getDuration().compareTo(from) < 0) {
      return sumFee;
    }

    LocalDateTime fromLdt = call.getFrom().plus(from);
    LocalDateTime toLdt = call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo();

    return super.calculateCallFee(new Call(fromLdt, toLdt));
  }

}
