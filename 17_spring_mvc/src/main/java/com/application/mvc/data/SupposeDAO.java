package com.application.mvc.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/*

	@Repository
	
	- 스프링 프레임워크에서 @Repository 어노테이션은 데이터 접근 계층(DAO, Data Access Object)의 클래스에 사용된다.
	
	- 이 어노테이션은 클래스를 스프링 컨테이너에 빈으로 등록하며, 주로 데이터베이스와의 통신을 담당하는 컴포넌트임을 나타낸다. 
		
		- @Repository는 스프링의 스테레오타입 어노테이션 중 하나로, 데이터베이스 연산을 수행하는 클래스에 부여함으로써 
		  스프링이 해당 클래스를 DAO로 인식하게 한다.
	
	- [ 주요 기능과 사용 목적 ] 
	
		1) 예외 변환: @Repository 어노테이션을 사용하면, 스프링은 데이터 접근 계층에서 발생하는 예외를 스프링이 제공하는 데이터 접근 예외로 자동 변환한다. 
					   이를 통해 데이터베이스 기술(예: JDBC, JPA 등)에 종속적인 예외를 스프링의 일관된 예외 계층 구조로 처리할 수 있게 됩니다.
					  
		2) 빈 자동 등록: @Repository 어노테이션을 사용하여 클래스를 정의하면 스프링 컨테이너는 해당 클래스의 인스턴스를 빈으로 자동 등록한다. 
						 이를 통해 의존성 주입과 같은 스프링 컨테이너의 기능을 활용할 수 있다.
						 
		3) 코드의 명시성: 이 어노테이션은 클래스가 데이터 접근 계층의 컴포넌트임을 명시적으로 표현한다.
						  이는 애플리케이션의 아키텍처를 이해하는 데 도움이 된다.

*/

@Repository
public class SupposeDAO {

	// String
	public String getString() {
		return "글자 데이터";
	}
	
	// int , long
	public int getInt() {
		return 7777777;
	}

	// double
	public double getDouble() {
		return 7777777.777;
	}
	
	// boolean
	public boolean getBoolean() {
		return true;
	}

	// Date
	public Date getDate() {
		return new Date();
	}
	
	// DTO
	public ProductDTO getDTO() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(2);
		productDTO.setProductNm("노트북1");
		productDTO.setPrice(2000000);
		productDTO.setDeliveryPrice(0);
		productDTO.setEnrollDt(new Date());
		productDTO.setBrandId(1);
		
		return productDTO;

	}
	
	
	// DTO List
	public List<ProductDTO> getDTOList() {
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		for (int i = 1; i < 11; i++) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(i);
			productDTO.setProductNm("노트북 " + i);
			productDTO.setPrice(100000 * i);
			productDTO.setDeliveryPrice(2500);
			productDTO.setEnrollDt(new Date());
			productDTO.setBrandId(i);
			productList.add(productDTO);
		}

		return productList;

	}
	
	
	// Map
	public Map<String,Object> getMap() {
		
		Map<String,Object> productMap = new HashMap<String, Object>();
		
		//ProductDTO property
		productMap.put("productId", 1);
		productMap.put("productNm", "노트북1");
		productMap.put("brandId", 1);
		productMap.put("price", 10000);
		productMap.put("deliveryPrice", 2500);
		productMap.put("enrollDt",  new Date());
		
		// ProductDTO property에 포함되지 않는 데이터
		productMap.put("addTax", 10000 * 0.1);
		productMap.put("totalPrice" , 10000 + 10000 * 0.1);
		
		//BrandDTO property
		productMap.put("brandNm", "브랜드1");
		productMap.put("enteredDt", new Date());
		productMap.put("activeYn", "Y");
		
		return productMap;

	}

	
	// Map List
	public List<Map<String,Object>> getMapList() {
		
		List<Map<String,Object>> productMapList = new ArrayList<Map<String,Object>>();
		
		for (int i = 1; i < 11; i++) {
			
			Map<String,Object> productMap = new HashMap<String, Object>();
			productMap.put("productId", i);
			productMap.put("productNm", "노트북 " + i);
			productMap.put("brandId", "b" + i);
			productMap.put("price", 10000 * i);
			productMap.put("deliveryPrice", 2500);
			productMap.put("enrollDt",  new Date());
			
			// ProductDTO property에 포함되지 않는 데이터
			productMap.put("addTax", (10000 * i) * 0.1);
			productMap.put("totalPrice" , (10000 * i) + (10000 * i) * 0.1);
			
			//BrandDTO property
			productMap.put("brandNm", "브랜드" + i);
			productMap.put("enteredDt", new Date());
			productMap.put("activeYn", "Y");
			
			productMapList.add(productMap);
			
		}
		
		return productMapList;
		
	}
	
}
