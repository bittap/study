package com.my.study;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestDouble {

	@Test
	void doubleTest() {
		List<Double> dous = List.of(4d,4.0d,4.00d,4.1236d);

		dous.stream().forEach((e)->System.out.println(new BigDecimal(e).setScale(2,RoundingMode.HALF_EVEN)));
	}
}
