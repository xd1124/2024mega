package com.application.jpa.chapter02_mapping;

import java.util.List;

import com.application.jpa.entity.BrandDTO;

public interface BrandService {

	public List<BrandDTO> getAllBrands();
	public BrandDTO getBrandById(Long brandId);
	public void createBrand(BrandDTO brandDTO);
	public void updateBrand(BrandDTO brandDTO);
	public void deleteBrand(Long brandId);
	
}
