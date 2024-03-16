package com.application.aop.ex;

import org.springframework.stereotype.Component;

// 테스트 클래스
@Component
public class Boss {

	public void work () {
		System.out.println("사장의 일을 한다.");
	}
	
	public void getWorkingTime() {
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getInfo(String title , int salary) {
		
	}
	
	public void getError() {
		System.out.println(0/0);
	}
	
	
}
