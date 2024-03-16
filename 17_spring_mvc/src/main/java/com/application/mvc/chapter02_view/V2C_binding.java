package com.application.mvc.chapter02_view;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.mvc.data.ProductDTO;

@Controller
@RequestMapping("/v2c")
public class V2C_binding {

	@GetMapping
	public String v2cView() {
		return "chapter02_view/v2c";
	}
	
	/*
	 * 
	 *  1) @ModelAttribute
	 *  
	 *  - @ModelAttribute 어노테이션을 사용하여 HTML element name 과 DTO property가 일치된 경우에  
	 *     DTO 형식으로 바인딩(매핑) 된 전달받을 수 있다. 
	 *    
	 *  - @ModelAttribute 의 경우 내부적으로 검증(Validation) 작업을 진행하기 때문에 setter 메서드를 이용하여 값을 바인딩하려고 시도하다가 
	 *   예외를 만날때(데이터 타입 불일치) 작업이 중단되면서 Http 400 Bad Request가 발생한다.
	 *   
	 *  - String to Date 데이터 형식의 바인딩은 DTO클래스 property위에 @DateTimeFormat(pattern = "yyyy-MM-dd")을 추가하여 매핑한다.
	 */
	
	// 405 (get,post불일치)
	@PostMapping("/modelAttribute") // 404 (not found)
	public String modelAttribute(@ModelAttribute ProductDTO productDTO ,
								@RequestParam("isPC") boolean isPC ,
								@RequestParam("locationId") long locationId ,
								@RequestParam("lang") String lang) { // 400(Bad Request : 파라메타 불일치)
		
		System.out.println("\n @ModelAttribute \n");
		System.out.println(productDTO);
		
		System.out.println(isPC);
		System.out.println(locationId);
		System.out.println(lang);
		
		System.out.println();
		
		return "redirect:/v2c"; // 404 (not found)
		
	}
	
	
	/* 
	 * 예시 2) @RequestParam Map<K,V>
	 * 
	 * - 요청 HTML의 name속성명이 Map 컬렉션 프레임워크의 "KEY"로 바인딩되며
	 *   요청 HTML의 name 벨류값이 Map 컬렉션 프레임워크의 "VALUE"로 바인딩된다.
	 * 
	 * - 웹 시스템을 개발할 경우 모델 형식(DTO , POJO)으로 모든 데이터를 전달 받기 어려운 경우가 있는데(DTO + @의 데이터) 
	 *   Map을 사용하면 모든 값을 수용할 수 있다.
	 *
	 * - Map으로 전달되는 데이터가 정수,실수,글자등 다양한 데이터일 경우 다형성을 이용하여 Object타입으로 처리할 수 있다.
	 * 
	 */
	
	@PostMapping("/map")
	public String map(@RequestParam Map<String,Object> productMap) {
		
		System.out.println("\n @RequestParam Map \n");
		System.out.println(productMap);
		System.out.println();
		
		return "redirect:/v2c";
		
	}
	
	
	
	
	
	
}
