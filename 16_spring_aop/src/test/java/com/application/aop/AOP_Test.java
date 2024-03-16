package com.application.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.aop.ex.Boss;
import com.application.aop.ex.Employee;
import com.application.aop.ex.Manager;

@SpringBootTest
public class AOP_Test {

	@Autowired
	private Boss boss;
	
	@Autowired
	private Manager manager;
	
	@Autowired 
	private Employee employee;
	
	@Test
	void testMethod() {
		
		boss.work();
		manager.work();
		employee.work();
		
		System.out.println("\n\n");
		
		boss.getWorkingTime();
		manager.getWorkingTime();
		employee.getWorkingTime();
		
		System.out.println("\n\n");
		
		boss.getInfo("사장", 1000);
		manager.getInfo("매니저", 500);
		employee.getInfo("직원", 300);
		
		boss.getError();
		
	}
	
}
