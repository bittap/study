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

  private long fee;

  @Override
  protected long calculateCallFee(Call call) {
    long seconds = Duration.between(call.getStartDatetime(), call.getEndDatetime()).getSeconds();
    return seconds / amount * fee;
  }

}
