package com.application.mvc.chapter04_dynamicQuery;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

@Mapper
public interface DynamicQueryDAO {

	public List<ProductDTO> ifEx(Map<String,Object> searchMap);   // [ if ] 사용예시
	public List<ProductDTO> whenEx(Map<String,Object> searchMap); // [ when ] 사용예시
	public List<ProductDTO> otherwiseEx(int deliveryPrice);		  // [ otherwise ] 사용예시
	
	public void foreachEx01(List<BrandDTO> brandList);			// [ foreach ] insert 사용예시
	public List<BrandDTO> foreachEx02(long[] brandIdList); 		// [ foreach ] select 사용예시
	public void foreachEx03(long[] brandIdList);				// [ foreach ] delete 사용예시
	public void foreachEx04(long[] productIdList);				// [ foreach ] update 사용예시1
	public void foreachEx05(List<Map<String,Object>> mapList);// [ foreach ] update 사용예시2
	
	public List<ProductDTO> whereEx(ProductDTO productDTO);	// [ where ] 사용예시
	public void setEx(ProductDTO productDTO);				// [ set ] 사용예시
	
}




