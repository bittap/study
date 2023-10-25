package com.my.study.object.chapter14.refactoring;

import java.util.List;

import com.my.study.object.chapter14.Call;
import com.my.study.object.chapter14.Phone;

import lombok.AllArgsConstructor;

/**
 * 複数の通話を計算する
 * 
 * @author Carmel
 *
 */
@AllArgsConstructor
public class BasicRatePolicy {

  private List<FeeRule> feeRules;

  public long calculateFee(Phone phone) {
    return phone.getCalls().stream()
        .map(e -> this.calculateCallFee(e))
        .reduce(0L, (first, second) -> first + second);
  }

  private long calculateCallFee(Call call) {
    return feeRules.stream()
        .map(e -> e.calculateRuleFee(call))
        .reduce(0L, (first, second) -> first + second);
  }
}
