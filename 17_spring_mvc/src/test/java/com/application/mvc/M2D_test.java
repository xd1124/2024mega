package com.application.mvc;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter03_mybatis.M2D;
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
public class M2D_test {

	@Autowired
	private M2D m2d;
	
	// DTO List 반환 예시1
	@Test
	public void ex01() {
		System.out.println("\n - ex01 - \n");
		for (ProductDTO productDTO : m2d.ex01()) {
			System.out.println(productDTO);
		}  
	}
	
	// DTO List 반환 예시2
	@Test
	public void ex02() {
		System.out.println("\n - ex02 - \n");
		for (BrandDTO brandDTO : m2d.ex02()) {
			System.out.println(brandDTO);
		}
	}
	
	// DTO 반환 예시1
	@Test
	public void ex03() {
		System.out.println("\n - ex03 - \n");
		System.out.println(m2d.ex03());
	}
	
	// DTO 반환 예시2
	@Test
	public void ex04() {
		System.out.println("\n - ex04 - \n");
		System.out.println(m2d.ex04());
	}
	
	// 단일 데이터 반환 예시1
	@Test
	public void ex05() {
		System.out.println("\n - ex05 - \n");
		System.out.println(m2d.ex05());
	}
	
	// 단일 데이터 반환 예시2
	@Test
	public void ex06() {
		System.out.println("\n - ex06 - \n");
		System.out.println(m2d.ex06());
	}
	
	// 단일 데이터 반환 예시3
	@Test
	public void ex07() {
		System.out.println("\n - ex07 - \n");
		System.out.println(m2d.ex07());
	}
	
	// <![CDATA[]]> 사용예시
	@Test
	public void ex08() {
		System.out.println("\n - ex08 - \n");
		for (ProductDTO productDTO : m2d.ex08()) {
			System.out.println(productDTO);
		}
	}
	
	// map 컬렉션 프레임워크 사용 예시
	@Test
	public void ex09() {
		System.out.println("\n - ex09 - \n");
		for (Map<String,Object> map : m2d.ex09()) {
			System.out.println(map);
		} 
	}
	
	// resultMap 사용 예시1
	@Test
	public void ex10() {
		System.out.println("\n - ex10 - \n");
		for (Map<String,Object> map : m2d.ex10()) {
			System.out.println(map);
		} 
	}
	
	// resultMap 사용 예시2
	@Test
	public void ex11() {
		System.out.println("\n - ex11 - \n");
		for (Map<String,Object> map : m2d.ex11()) {
			System.out.println(map);
		} 
	}
}
