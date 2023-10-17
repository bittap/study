package com.my.study.object.chapter14;

/**
 * ユーザの通話料金ポリシーにより通話料金を計算する
 * 
 * @author Carmel
 *
 */
public interface RatePolicy {

  /**
   * phoneにより料金を計算する
   * 
   * @param phone 通話履歴を保つ
   * @return 料金
   */
  public long calculateFee(Phone phone);
}
