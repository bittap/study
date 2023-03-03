package com.my.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInstanceVaribale {
	
	int number = 0;

	@Test
	public void test1() {
		number += 3;
		Assertions.assertEquals(3, number);
	}
	
	@Test
	public void test2() {
		number += 5;
		Assertions.assertEquals(5, number);
	}
}
