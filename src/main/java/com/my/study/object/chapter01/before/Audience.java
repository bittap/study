package com.my.study.object.chapter01.before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Audience {
  @Getter
  private Bag bag;
}
