package com.my.study.object.chapter14.refactoring;

import java.util.List;

import lombok.Getter;

/**
 * 通話料金を計算する
 * 
 * @author Carmel
 *
 */
public class Phone {
  /**
   * 料金計算
   */
  private RatePolicy ratePolicy;
  /**
   * 通話履歴
   */
  @Getter
  private List<Call> calls;

  /**
   * 通話料金を計算する
   * 
   * @return 通話料金
   */
  public long calculateFee() {
    return ratePolicy.calculateFee(this);
  }

}
