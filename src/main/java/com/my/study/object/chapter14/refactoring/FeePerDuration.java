package com.my.study.object.chapter14.refactoring;

import java.time.Duration;

public class FeePerDuration {
    private int fee;
    private Duration duration;

    public long calculate(DatetimeInterval interval) {
        return interval.getDuration().getSeconds() / duration.getSeconds() * fee;
    }
}
