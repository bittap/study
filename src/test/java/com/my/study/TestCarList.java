package com.my.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCarList {
	
	@Test
	public void test() {
		Integer a = 3;
		Integer getInteger = getInteger(a);
		Assertions.assertEquals(a, 3);
		Assertions.assertEquals(getInteger, 4);
		
		Integer a1 = 3;
		Integer a2 = 3;
		Assertions.assertTrue(a1 == a2);
	}
	
	public Integer getInteger(Integer a) {
		a = a+1;
		return a;
	}
}

