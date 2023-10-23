package com.my.study.object.chapter14;

import java.time.Duration;

/**
 * 固定料金を計算する
 * 
 * @author Carmel
 *
 */
public class FixedFeePolicy extends BasicRatePolicy {

  private int amount;

  private Duration seconds;

  @Override
  protected long calculateCallFee(Call call) {
    return call.geDuration().getSeconds() / seconds.getSeconds() * amount;
  }
}
