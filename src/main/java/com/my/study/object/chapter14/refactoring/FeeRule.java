package com.my.study.object.chapter14.refactoring;

import com.my.study.object.chapter14.Call;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeeRule {

    private FeePerDuration feePerDuration;

    private FeeCondition feeCondition;

    public long calculateRuleFee(Call call) {
        return feeCondition.findIntervals(call).stream()
                .map(e -> feePerDuration.calculate(e))
                .reduce(0L, (first, second) -> first + second);
    }
}
