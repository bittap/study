package com.my.study.object.chapter14;

import java.util.List;

/**
 * 基本通話料金を計算する ・固定料金 ・時間別料金 ・曜日別料金 ・通話期間料金
 * 
 * @author Carmel
 *
 */
public abstract class BasicRatePolicy implements RatePolicy {

  @Override
  public long calculateFee(Phone phone) {
    List<Call> calls = phone.getCalls();
    long fee = 0;
    for (Call call : calls) {
      fee += this.calculateCallFee(call);
    }

    return fee;
  }

  protected abstract long calculateCallFee(Call call);
}
