package com.application.mvc.chapter06_RESTAPI;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;

@Mapper
public interface BrandDAO {

	public List<BrandDTO> getBrandList();
	public BrandDTO getBrandDetail(long brandId);
	public void createBrand(BrandDTO brandDTO);
	public void updateBrand(BrandDTO brandDTO);
	public void deleteBrand(long brandId);
	
}
