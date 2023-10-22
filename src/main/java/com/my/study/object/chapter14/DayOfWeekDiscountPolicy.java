package com.my.study.object.chapter14;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.List;

/**
 * 曜日別料金を計算する
 * 
 * @author Carmel
 *
 */
public class DayOfWeekDiscountPolicy extends BasicRatePolicy {

	private List<DayOfWeek> dayOfWeeks;

	private int amount;

	private List<Long> fees;

	private DatetimeInterval datetimeInterval = new DatetimeInterval();

	@Override
	protected long calculateCallFee(Call call) {
		long sumFee = 0L;
		List<Call> callDays = datetimeInterval.splitBy(call);
		for (Call callDay : callDays) {
			for (int i = 0; i < dayOfWeeks.size(); i++) {
				Duration duration = Duration.between(callDay.getStartDatetime(), callDay.getEndDatetime());
				long seconds = duration.getSeconds();
				sumFee += seconds / amount * fees.get(i);
			}
		}

		return sumFee;
	}

}
