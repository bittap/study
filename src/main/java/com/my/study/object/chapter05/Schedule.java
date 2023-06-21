package com.my.study.object.chapter05;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Schedule {

  private int sequence;

  private LocalTime startedAt;
}
