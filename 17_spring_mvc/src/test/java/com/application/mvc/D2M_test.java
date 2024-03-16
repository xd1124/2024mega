package com.application.mvc;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter03_mybatis.D2M;
import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

/*

	# 테스트 코드 
	
	- 테스트 코드를 작성하는 것은 애플리케이션의 안정성을 보장하고, 
	기능이 예상대로 동작하는지 확인하기 위한 중요한 과정이다.
	
	- 단위 테스트(Unit Test): 가장 작은 코드 단위의 기능을 테스트한다.
	보통 메소드 레벨에서 이루어지며, 스프링 컨텍스트를 로드하지 않아 실행 속도가 빠르다.
	
	- @SpringBootTest 애너테이션을 클래스 레벨에 사용하여 스프링 부트의 테스트 환경을 구성한다. 
	@Test 애너테이션을 메서드 레벨에 사용하여 테스트 케이스를 정의한다.

*/ 

@SpringBootTest
public class D2M_test {

	@Autowired
	private D2M d2m;
	
	// 단일 데이터 전송 예시1
	@Test
	public void ex01() {
		
		System.out.println("\n - ex01 - \n");
		
		long productId = 1;
		d2m.ex01(productId);
		
	}
	
	
	// 단일 데이터 전송 예시2
	@Test
	public void ex02() {
		
		System.out.println("\n - ex02 - \n");
		
		long brandId = 6;
		d2m.ex02(brandId);
		
	}
	
	// 단일 데이터 전송 예시3
	@Test
	public void ex03() {
		
		System.out.println("\n - ex03 - \n");
		
		String brandNm = "apple";
		for (BrandDTO brandDTO : d2m.ex03(brandNm)) {
			System.out.println(brandDTO);
		}
		
	}
	
	
	// DTO 전송 예시1
	@Test
	public void ex04() {
		
		System.out.println("\n - ex04 - \n");
		
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandId(101); 	 			// Duplicate entry '~~~' for key 'PRIMARY' : primary key 중복 에러
		brandDTO.setBrandNm("추가된브랜드");
		//brandDTO.setActiveYn("N12345678");    // Data too long for column : 데이터 길이 오버플로우 에러
		brandDTO.setActiveYn("N");   
		d2m.ex04(brandDTO);
		
	}
	
	
	// DTO 전송 예시2
	@Test
	public void ex05() {
		
		System.out.println("\n - ex05 - \n");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNm("추가된 상품1");
		productDTO.setPrice(1);
		productDTO.setDeliveryPrice(1);
		productDTO.setBrandId(1);
		d2m.ex05(productDTO);
		
	}
	
	
	// DTO 전송 예시3
	@Test
	public void ex06() {
		
		System.out.println("\n - ex06 - \n");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(1000000);
		productDTO.setDeliveryPrice(3000);
		
		for (ProductDTO dto : d2m.ex06(productDTO)) {
			System.out.println(dto);
		}
		
	}
	
	
	// Map 전송 예시1
	@Test
	public void ex07() {
		
		System.out.println("\n - ex07 - \n");
		
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		priceMap.put("min", 500000);
		priceMap.put("max", 1000000);
		
		for (ProductDTO productDTO :d2m.ex07(priceMap)) {
			System.out.println(productDTO);
		}
		
	}
	
	
	// Map 전송 예시2
	@Test
	public void ex08() {
		
		System.out.println("\n - ex08 - \n");
		
		Map<String, String> dateMap = new HashMap<String, String>();
		dateMap.put("startDate","2021-01-01");
		dateMap.put("endDate", "2021-03-31");
		
		for (BrandDTO brandDTO :d2m.ex08(dateMap)) {
			System.out.println(brandDTO);
		}
		
	}
	
	
	// Map 전송 예시3
	@Test
	public void ex09() {
		
		System.out.println("\n - ex09 - \n");
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("activeYn","N");
		searchMap.put("price", 1000000);
		
		for (Map<String, Object> resultMap :d2m.ex09(searchMap)) {
			System.out.println(resultMap);
		}
		
	}
	
}
