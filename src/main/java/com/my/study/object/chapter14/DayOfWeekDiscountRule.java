package com.my.study.object.chapter14;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.List;

public class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks;
    private Duration duration;
    private int amount;

    /**
     * @param dayOfWeeks
     * @param duration
     * @param amount
     */
    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, int amount) {
        this.dayOfWeeks = dayOfWeeks;
        this.duration = duration;
        this.amount = amount;
    }

    public Long calculate(Call oneDayCall) {
        if (dayOfWeeks.contains(oneDayCall.getFrom().getDayOfWeek())) {
            return oneDayCall.getDuration().getSeconds() / duration.getSeconds() * amount;
        }

        return 0L;
    }

}
