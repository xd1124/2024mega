package com.application.di_ioc.asIsModel;

public class AsIsController {

	/*

		# AsIs Model
	  
		- 객체의 생성 순서 Controller > Service > DAO
		- 객체가 생성됨과 동시에 상위클래스 내부에서 하위클래스의 객체를 생성한다.
		- 결합력(의존성)이 강하다. 
		- 상위클래스와 하위 클래스간의 종속성이 생긴다.
		- 유지보수시 재사용성이 줄어들며 클래스를 수정해야 하는 빈도 및 위험이 높아진다. 
		- 유연성과 테스트 용이성이 부족하다.
		- 유지보수가 어려워 질 수 있다.
	
	*/
	
	AsIsService asIsService = new AsIsService();
	
}
