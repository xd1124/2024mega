package com.application.jpa;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter01_basic.BasicRepository;
import com.application.jpa.entity.Brand;

@SpringBootTest
public class BasicTest {

	@Autowired
	private BasicRepository basicRepository;
	
	@Test
	public void getAllBrands() {
		// findAll() : 테이블의 전체 데이터를 반환한다.
		for (Brand brand : basicRepository.findAll()) {
			System.out.println(brand);
		}
	}
	
	@Test
	public void getBrandById() {
		// findById(primary key) : id에 해당되는 데이터 반환한다.
		System.out.println(basicRepository.findById(2l));
	}
	
	@Test
	public void createBrand() {
		// save() : 새로운 엔티티를 데이터베이스에 저장하며 이미 존재하는 엔티티의 경우 업데이트를 수행한다.
		Brand brand = new Brand();
		brand.setBrandId(100l);
		brand.setBrandNm("추가된브랜드100");
		brand.setActiveYn("N");
		brand.setEnteredDt(new Date());
		basicRepository.save(brand);
	}
	
	@Test
	public void updateBrand() {
		// 기존에 저장되어 있는 데이터를 조회하여 수정한다.
		// save() : 새로운 엔티티를 데이터베이스에 저장하며 이미 존재하는 엔티티의 경우 업데이트를 수행한다.
		
		//Brand brand = new Brand();
		//brand.setBrandId(100l);
		
		Brand brand = basicRepository.findById(100l).orElse(null);
		brand.setBrandNm("수정된브랜드100_1");
		brand.setActiveYn("N");
		brand.setEnteredDt(new Date());
		basicRepository.save(brand);
	
	}
	
	@Test
	public void deleteBrand() {
		// deleteById(primary key); id에 해당되는 데이터 삭제한다.
		basicRepository.deleteById(100l);
	}
	
	
}
