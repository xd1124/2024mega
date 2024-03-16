package com.application.mvc.chapter03_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

@Mapper
public interface D2M {

	/*
	 * 
	 * # DAO To Mapper
	 * 
	 *  - 2개 이상의 파라미터를 Mapper로 전달할 수 없고 오직 1개의 파라미터만 전송이 가능하다.
	 *  - 2개 이상의 데이터는 DTO , Map형식으로 전송한다.
	 *  - 전송되는 복수의 데이터가 DTO의 멤버로 포함되어 있으면 일반적으로 DTO 전송 방식을 사용하고
	 *    전송되는 복수의 데이터가 DTO의 멤버에 포함되어 있지 않은 경우 Map 전송 방식을 사용한다.
	 * 
	 * */
	
	// 단일 데이터 전송예시1
	public void ex01(long productId);
	
	// 단일 데이터 전송예시2
	public void ex02(long brandId);
	
	// 단일 데이터 전송예시3
	public List<BrandDTO> ex03(String brandNm);
	
	
	
	// DTO 전송예시1
	public void ex04(BrandDTO brandDTO);
	
	// DTO 전송예시2
	public void ex05(ProductDTO productDTO);

	// DTO 전송예시3
	public List<ProductDTO> ex06(ProductDTO productDTO);
	
	
	// Map 전송예시1
	public List<ProductDTO> ex07(Map<String,Integer> priceMap);
	
	// Map 전송예시2
	public List<BrandDTO> ex08(Map<String,String> dateMap);
	
	// Map 전송예시3
	public List<Map<String,Object>> ex09(Map<String,Object> searchMap);
	
}
