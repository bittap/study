package com.my.study.object.chapter14.refactoring;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DayOfWeekFeeCondition implements FeeCondition {

    private List<DayOfWeek> dayOfWeeks;

    @Override
    public List<DatetimeInterval> findIntervals(Call call) {
        List<DatetimeInterval> intervals = new ArrayList<>();
        for (DatetimeInterval interval : call.splitBy()) {
            if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
                intervals.add(interval);
            }
        }

        return intervals;
    }
}
