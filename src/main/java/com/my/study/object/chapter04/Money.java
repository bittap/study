package com.my.study.object.chapter04;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Money {

  public static Money ZERO = new Money(BigDecimal.ZERO);

  private BigDecimal amount;


  public Money(int amount) {
    this.amount = BigDecimal.valueOf(amount);
  }

  public Money(double amount) {
    this.amount = BigDecimal.valueOf(amount);
  }

  private Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(int amount) {
    return new Money(this.amount.add(BigDecimal.valueOf(amount)));
  }

  public Money minus(int amount) {
    return new Money(this.amount.subtract(BigDecimal.valueOf(amount)));
  }

  public Money minus(Money money) {
    return new Money(this.amount.subtract(money.getAmount()));
  }

  public Money times(double times) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(times)));
  }
}
