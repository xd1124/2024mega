package com.application.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*

	@Controller

	- 스프링 프레임워크에서 @Controller 어노테이션은 클래스 레벨에서 사용되며
	  해당 클래스를 웹 요청을 처리하는 컨트롤러로 지정하는 데 사용한다.
	  
	- @Controller가 붙은 클래스는 스프링 MVC의 웹 레이어의 일부로서 
	   클라이언트의 요청을 받아 처리한 후 적절한 응답을 반환하는 역할을 한다.
	
	
	- [ 주요 기능과 사용 목적 ] 

	1) @Controller 어노테이션이 지정된 클래스는 HTTP 요청을 처리하는 엔드포인트를 정의한다. 
		이러한 클래스 내에서 정의된 메소드들은 특정 요청 경로(URL), HTTP 메소드(GET, POST 등)에 매한다.
		
    2) 요청 매핑: @RequestMapping 어노테이션 또는 그와 유사한 어노테이션(@GetMapping, @PostMapping 등)을 사용하여 메소드를 특정 요청에 매핑한다.
				  이러한 메소드들은 요청을 처리하고, 데이터 모델을 준비하며, 뷰 이름을 반환하여 클라이언트에게 응답을 보낸다.
		
	3) 데이터 모델과 뷰: 컨트롤러 메소드는 데이터 모델을 뷰에 전달할 수 있다. 
	  모델 데이터는 Model 객체를 통해 뷰에 전달되며 뷰 템플릿(예: Thymeleaf, JSP 등)에서 이 데이터를 사용하여 동적인 웹 페이지를 생성할 수 있다.
	  
	4) 뷰 리졸버: 스프링 MVC는 컨트롤러가 반환한 뷰 이름을 기반으로 실제 뷰 템플릿의 위치를 찾으며 이 과정은 뷰 리졸버(view resolver)에 의해 수행된다.
	
*/

@Controller

// 클래스에 @RequestMapping을 사용할 수 있으며 해당 클래스의 모든 메서드가 /basic 경로로 매핑된다.
@RequestMapping("/basic")
public class MVCController {

	// value에는 url주소를 작성 , method는 요청방식을 작성한다. (method를 생략할 경우 GET , POST를 모두 처리한다.)
	//@RequestMapping(value="/main" , method=RequestMethod.GET)
	@GetMapping("/main")
	//@PostMapping("/main")
	public String main() {
		return "main"; // return "/templates/main.html";
	}
	
	/*
	 *
	 *	- Spring Boot Controller에서 메서드의 return타입은 view(html)를 명시할 String타입을 기본적으로 사용한다.
	 *  - application.properties 파일의 아래의 설정으로 바인딩되어 view(html)화면으로 포워딩 한다.
	 *		
	 *		spring.thymeleaf.prefix=classpath:/templates/ 
	 *		spring.thymeleaf.suffix=.html
	 *
	 *		예시)
	 *
	 *			return "home"		 		> /templates/home.html
	 *			return "goods/main"   		> /templates/goods/main.html
	 *			return "order/orderList"	> /templates/order/orderList.html
	 *
	 *  - 특정 페이지로 리다이렉트시키는 방법은 "redirect:경로" 와 같은 형태로 사용한다.
	 * 
	 * 		예시)
	 * 			return "redirect:/admin/memberList"	 > /admin/memberList
	 *  		return "redirect:/order/modifyOrder" > /order/modifyOrder
	 *	
	 *  - view로 이동하는 방법과 controller로 리다이렉트하는 방법의 차이점
	 *	 
	 *		html로 이동하는 경우 : 페이지만 이동  
	 *		redirect하는 경우    : url에 포함된 모든 비즈니스 로직(Controller , Service , DAO)을 수행한 후 페이지 이동
	 *
	 */
	
	
	
	
	
	
}

