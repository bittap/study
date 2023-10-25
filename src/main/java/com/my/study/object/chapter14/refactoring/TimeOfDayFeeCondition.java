package com.my.study.object.chapter14.refactoring;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOfDayFeeCondition implements FeeCondition {

    private LocalTime from;

    private LocalTime to;

    @Override
    public List<DatetimeInterval> findIntervals(Call call) {
        List<DatetimeInterval> intervals = new ArrayList<>();
        for (DatetimeInterval interval : call.splitBy()) {
            LocalTime starTime = getFrom(from, interval);
            LocalTime endTime = getTo(to, interval);

            intervals.add(DatetimeInterval.of(LocalDateTime.of(null, starTime),
                    LocalDateTime.of(null, endTime)));
        }

        return intervals;
    }

    private LocalTime getFrom(LocalTime timeFrom, DatetimeInterval interval) {
        LocalTime intervalFrom = interval.getFrom().toLocalTime();
        return intervalFrom.isBefore(timeFrom)
                ? timeFrom
                : intervalFrom;
    }

    private LocalTime getTo(LocalTime timeTo, DatetimeInterval interval) {
        LocalTime intervalTo = interval.getTo().toLocalTime();
        return intervalTo.isBefore(timeTo)
                ? intervalTo
                : timeTo;
    }
}
