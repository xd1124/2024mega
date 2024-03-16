package com.application.mvc.chapter03_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

@Mapper
public interface M2D {

	public List<ProductDTO> ex01(); 		// DTO List 반환 예시1
	public List<BrandDTO> ex02();   		// DTO List 반환 예시2
	
	public ProductDTO ex03();				// DTO 반환 예시1
	public BrandDTO ex04();					// DTO 반환 예시2
	
	public int ex05();						// 단일 데이터 반환 예시1
	public double ex06();					// 단일 데이터 반환 예시2
	public String ex07();					// 단일 데이터 반환 예시3
	
	public List<ProductDTO> ex08();			// <![CDATA[]]> 사용예시
	
	public List<Map<String,Object>> ex09(); // map 컬렉션 프레임워크 사용 예시
	
	public List<Map<String,Object>> ex10(); // resultMap 사용 예시1
	public List<Map<String,Object>> ex11(); // resultMap 사용 예시2
	
}
