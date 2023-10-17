package com.my.study.object.chapter14;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 一回に通話した記録を保つ
 * 
 * @author Carmel
 *
 */
@Getter
@Setter
public class Call {
  /**
   * 開始日時
   */
  private LocalDateTime startDatetime;
  /**
   * 終了日時
   */
  private LocalDateTime endDatetime;

}
