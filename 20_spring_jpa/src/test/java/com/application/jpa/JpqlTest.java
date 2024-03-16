package com.application.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.JpqlRepository;
import com.application.jpa.entity.Product;

@SpringBootTest
public class JpqlTest {

	@Autowired
	private JpqlRepository jpqlRepository;

	
	// 쿼리 메서드 Test
	
	@Test
	public void findByDeliveryPrice() {
		for (Product product : jpqlRepository.findByDeliveryPrice(0)) {
			System.out.println(product);
		}
	}
	
	@Test
	public void findByPriceGreaterThan() {
		for (Product product : jpqlRepository.findByPriceGreaterThan(1000000)) {
			System.out.println(product);
		}
	}
	
	@Test
	public void findByPriceGreaterThanOrderByPriceDesc() {
		for (Product product : jpqlRepository.findByPriceGreaterThanOrderByPriceDesc(1000000)) {
			System.out.println(product);
		}
	}
	
	// JPQL Test
	
	// 1) basic 예시
	@Test
	public void basicEx() {
		
		for (Product product : jpqlRepository.basicEx()) {
			System.out.println(product);
		}
		
	}
	
	// 2) where 예시
	@Test
	public void whereEx() {
		
		for (Product product : jpqlRepository.whereEx(500000 , 1000000)) {
			System.out.println(product);
		}
		
	}
	
	// 3) order by 예시
	@Test
	public void orderByEx() {
		
		for (Product product : jpqlRepository.orderByEx(0)) {
			System.out.println(product);
		}
		
	}
	
	// 4) group by 예시
	@Test
	public void groupByEx() {
		for (Object[] result : jpqlRepository.groupByEx()) {
			System.out.println(result[0] + " / " + result[1]);
		}
	}
	
	// 5) join 예시
	@Test
	public void joinEx() {
		for (Product product : jpqlRepository.joinEx("y")) {
			System.out.println(product);
		}
	}
	
	// 6) subquery 예시
	@Test
	public void subqueryEx() {
		for (Product product : jpqlRepository.subqueryEx()) {
			System.out.println(product);
		}
	}
	
	
}
