package com.my.study.object.chapter05.data;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Schedule {

  private int sequence;

  private LocalTime startedAt;
}
