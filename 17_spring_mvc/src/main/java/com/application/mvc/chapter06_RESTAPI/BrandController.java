package com.application.mvc.chapter06_RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.mvc.data.BrandDTO;

@Controller
class BrandTestController {
	
	@GetMapping("/restAPI/view")
	public String view() {
		return "chapter06_RESTAPI/brand";
	}
}


@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandDAO brandDAO;
	
	@GetMapping // 브랜드 데이터 전체 요청
	public List<BrandDTO> getBrandList() {
		return brandDAO.getBrandList();
	}
	
	@GetMapping("/{brandId}") // 브랜드 데이터 상세 요청
	public BrandDTO getBrandDetail(@PathVariable("brandId") long brandId) {
		return brandDAO.getBrandDetail(brandId);
	}
	
	@PostMapping // 브랜드 데이터 추가 요청
	public void createBrand(@RequestBody BrandDTO brandDTO) {
		brandDAO.createBrand(brandDTO);
	} 
	
	@PutMapping // 브랜드 데이터 수정 요청
	public void updateBrand(@RequestBody BrandDTO brandDTO) {
		brandDAO.updateBrand(brandDTO);
	}
	
	@DeleteMapping("/{brandId}") // 브랜드 데이터 삭제 요청
	public void deleteBrand(@PathVariable("brandId") long brandId) {
		brandDAO.deleteBrand(brandId);
	}
	
	
	
	
	
}
