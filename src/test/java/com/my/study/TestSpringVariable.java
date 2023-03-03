package com.my.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.my.study.car.Car;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestSpringVariable {

	@Autowired
	Car car;
	
	@Test
	@Order(1)
	public void test1() {
		car.name = "testCar";
		Assertions.assertEquals("testCar", car.name);
	}
	
	@Test
	@Order(2)
	public void test2() {
		// this is fail. expected: <myCar> but was: <testCar>
		// but I want expected: <myCar> but was: <myCar>
		Assertions.assertEquals("myCar", car.name); 
	}
}
