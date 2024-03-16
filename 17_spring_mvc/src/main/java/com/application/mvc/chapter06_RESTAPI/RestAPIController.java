package com.application.mvc.chapter06_RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@RestController  			 // @RestController 어노테이션을 사용하여 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다. 
@RequestMapping("/product")  // 자원 기반의 URL을 사용하고 HTTP 메서드를 사용하여 구현한다.
public class RestAPIController {

	@Autowired
	private SupposeDAO supposeDAO;
	
	/* URL자원(데이터)에 대한 CRUD (Create, Read, Update, Delete) 작업을 REST API를 통해 제공한다. */
	
	@GetMapping // 전체 데이터 요청 : Get 요청처리
	public List<ProductDTO> getProductList() {
		return supposeDAO.getDTOList();
	}
	
	@GetMapping("/{productId}") // 상세 데이터 요청 : Get 요청처리
	public ProductDTO getProductDetail(@PathVariable("productId") long productId) { // @PathVariable 애노테이션으로 데이터를 전달 받는다.
		System.out.println(productId);
		return supposeDAO.getDTO();
	}
	
	@PostMapping // 데이터 추가(생성) : Post요청 처리
	public void createProduct(@RequestBody ProductDTO productDTO) {
		System.out.println(productDTO);
	}
	
	@PutMapping("/{productId}") // 데이터 수정 : Put요청 처리
	public void updateProduct(@PathVariable("productId") long productId , @RequestBody ProductDTO productDTO) {
		System.out.println("id : " + productId);
		System.out.println("DTO : " + productDTO);
	}
	
	@DeleteMapping("/{productId}") // 데이터 삭제 : Delete요청 처리
	public void deleteBrand(@PathVariable("productId") long productId) {
		System.out.println("id : " + productId);
	}
	
}
