package com.application.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.aop.log.TestClass;

@SpringBootTest
public class Logger_Test {

	@Autowired
	private TestClass testClass;
	
	@Test
	public void testMethod() {
		
		testClass.testMethod1();
		testClass.testMethod2();
		testClass.testMethod3();
		testClass.testMethod4();
		testClass.testMethod5();
		
	}
	
}
