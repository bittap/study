package com.my.study.object.chapter05.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Screening {

  @Getter
  private Schedule schedule;

  @Getter
  private Movie movie;
}
