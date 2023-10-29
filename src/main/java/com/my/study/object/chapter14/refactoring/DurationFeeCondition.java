package com.my.study.object.chapter14.refactoring;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DurationFeeCondition implements FeeCondition {

    private Duration from;

    private Duration to;

    @Override
    public List<DatetimeInterval> findIntervals(Call call) {
        if (call.getDatetimeInterval().getDuration().compareTo(from) < 0) {
            return Collections.emptyList();
        }

        return Arrays.asList(DatetimeInterval.of(
                call.getDatetimeInterval().getFrom().plus(from),
                call.getDatetimeInterval().getDuration().compareTo(to) > 0
                        ? call.getDatetimeInterval().getFrom().plus(to)
                        : call.getDatetimeInterval().getTo()));
    }
}
