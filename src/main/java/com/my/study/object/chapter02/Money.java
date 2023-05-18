package com.my.study.object.chapter02;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {

  public static Money ZERO = new Money(new BigDecimal(0));

  private BigDecimal amount;

  public Money plus(int amount) {
    return new Money(this.amount.add(new BigDecimal(amount)));
  }

  public Money minus(int amount) {
    return new Money(this.amount.subtract(new BigDecimal(amount)));
  }

  public Money minus(Money money) {
    return new Money(this.amount.subtract(money.getAmount()));
  }

  public Money times(BigDecimal times) {
    return new Money(this.amount.multiply(times));
  }
}
