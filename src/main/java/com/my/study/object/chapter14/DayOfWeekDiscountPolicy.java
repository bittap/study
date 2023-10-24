package com.my.study.object.chapter14;

import java.util.List;

/**
 * 曜日別料金を計算する
 * 
 * @author Carmel
 *
 */
public class DayOfWeekDiscountPolicy extends BasicRatePolicy {

	private List<DayOfWeekDiscountRule> dayOfWeekDiscountRules;

	/**
	 * @param dayOfWeekDiscountRules
	 */
	public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> dayOfWeekDiscountRules) {
		this.dayOfWeekDiscountRules = dayOfWeekDiscountRules;
	}

	@Override
	protected long calculateCallFee(Call call) {
		long sumFee = 0L;
		for (Call oneDayCall : call.splitBy()) {
			for (DayOfWeekDiscountRule dayOfWeekDiscountRule : dayOfWeekDiscountRules) {
				sumFee += dayOfWeekDiscountRule.calculate(oneDayCall);
			}
		}

		return sumFee;
	}

}
