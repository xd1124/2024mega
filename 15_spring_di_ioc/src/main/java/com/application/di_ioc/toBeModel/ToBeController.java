package com.application.di_ioc.toBeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 해당 클래스를 Controller로 지정하여 spring bean으로 등록한다.
public class ToBeController {

	/*

		# ToBe Model
	  
	    - IoC컨테이너에 의해서 ToBeDAO , ToBeService , ToBeController 객체가 생성 및 관리된다.
		- ToBeDAO > ToBeService > ToBeController의 순서로 객체가 생성 및 주입된다.
		- 외부에서 생성된 객체를 주입한다.
		- 결합력(의존성)이 약하다. 
		- 유연성과 테스트 용이성이 좋다.
		- 유지보수에도 용이하다.
	
	*/
	
	
	@Autowired
	private ToBeService toBeService;
	
	
	
}
