package com.my.study.object.chapter02;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Schedule {

  private int sequence;

  private LocalTime startedAt;
}
