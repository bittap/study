package com.my.study.object.chapter14.refactoring;

import java.util.List;

public interface FeeCondition {

    public List<DatetimeInterval> findIntervals(Call call);
}
