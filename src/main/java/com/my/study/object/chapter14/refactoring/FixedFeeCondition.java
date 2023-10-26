package com.my.study.object.chapter14.refactoring;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DatetimeInterval> findIntervals(Call call) {
        return Arrays.asList(call.getDatetimeInterval());
    }
}
