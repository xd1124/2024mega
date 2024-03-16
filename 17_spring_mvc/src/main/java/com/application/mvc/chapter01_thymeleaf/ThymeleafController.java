package com.application.mvc.chapter01_thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.SupposeDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/link")
	public String link() {
		return "chapter01_thymeleaf/link";
	}
	
	
	@GetMapping("/varExpression")
	public String varExpression(HttpServletRequest request) {
		
		 request.setAttribute("string"  , supposeDAO.getString()); 
		 request.setAttribute("int"     , supposeDAO.getInt()); 
		 request.setAttribute("double"  , supposeDAO.getDouble());
		 request.setAttribute("boolean" , supposeDAO.getBoolean());
		 request.setAttribute("date"    , supposeDAO.getDate());
		 request.setAttribute("dto"     , supposeDAO.getDTO()); 
		 request.setAttribute("dtoList" , supposeDAO.getDTOList()); 
		 request.setAttribute("map"      , supposeDAO.getMap()); 
		 request.setAttribute("mapList" , supposeDAO.getMapList());
		 
		 // unescape 예시
		 request.setAttribute("escape1", "<h6 style='color:red;'>테스트 데이터1</h6>");
		 request.setAttribute("escape2", "<div align='center'>테스트 데이터2</div>");
		 
		 // session 예시
		 HttpSession session = request.getSession();
		 session.setAttribute("var1", "abcdefg");
		 session.setAttribute("var2", "admin");
		 
		 return "chapter01_thymeleaf/varExpression";
	
	}
	
	
	@GetMapping("/controlStatement")
	public String controlStatement(HttpServletRequest request) {
		
		 request.setAttribute("string"  , supposeDAO.getString()); 
		 request.setAttribute("int"     , supposeDAO.getInt()); 
		 request.setAttribute("double"  , supposeDAO.getDouble());
		 request.setAttribute("boolean" , supposeDAO.getBoolean());
		 request.setAttribute("date"    , supposeDAO.getDate());
		 request.setAttribute("dto"     , supposeDAO.getDTO()); 
		 request.setAttribute("dtoList" , supposeDAO.getDTOList()); 
		 request.setAttribute("map"      , supposeDAO.getMap()); 
		 request.setAttribute("mapList" , supposeDAO.getMapList());
		 
		 return "chapter01_thymeleaf/controlStatement";
	
	}
	
	
	@GetMapping("/format")
	public String format(HttpServletRequest request) {
		
		 request.setAttribute("string"  , supposeDAO.getString()); 
		 request.setAttribute("int"     , supposeDAO.getInt()); 
		 request.setAttribute("double"  , supposeDAO.getDouble());
		 request.setAttribute("boolean" , supposeDAO.getBoolean());
		 request.setAttribute("date"    , supposeDAO.getDate());
		 request.setAttribute("dto"     , supposeDAO.getDTO()); 
		 request.setAttribute("dtoList" , supposeDAO.getDTOList()); 
		 request.setAttribute("map"      , supposeDAO.getMap()); 
		 request.setAttribute("mapList" , supposeDAO.getMapList());
		 
		 return "chapter01_thymeleaf/format";
	
	}
	
	
	@GetMapping("/form")
	public String form(Model model) {
		 model.addAttribute("dto" , supposeDAO.getDTO()); 
		 return "chapter01_thymeleaf/form";
	}
	
	@GetMapping("/script")
	public String script(HttpServletRequest request) {
		
		 request.setAttribute("string"  , supposeDAO.getString()); 
		 request.setAttribute("int"     , supposeDAO.getInt()); 
		 request.setAttribute("double"  , supposeDAO.getDouble());
		 request.setAttribute("boolean" , supposeDAO.getBoolean());
		 request.setAttribute("date"    , supposeDAO.getDate());
		 request.setAttribute("dto"     , supposeDAO.getDTO()); 
		 request.setAttribute("dtoList" , supposeDAO.getDTOList()); 
		 request.setAttribute("map"      , supposeDAO.getMap()); 
		 request.setAttribute("mapList" , supposeDAO.getMapList());
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("var1", "abcdefg");
		 session.setAttribute("var2", "admin");
		 
		 return "chapter01_thymeleaf/script";
	
	}
	
	@GetMapping("/content1")
	public String content1() {
		return "chapter01_thymeleaf/layout/ex/content1";
	}
	
	@GetMapping("/content2")
	public String content2() {
		return "chapter01_thymeleaf/layout/ex/content2";
	}
	
	@GetMapping("/content3")
	public String content3() {
		return "chapter01_thymeleaf/layout/ex/content3";
	}
	
	@GetMapping("/main")
	public String main() {
		return "chapter01_thymeleaf/layout/bootstrap/main";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "chapter01_thymeleaf/layout/bootstrap/blog";
	}
	
	@GetMapping("/shop")
	public String shop() {
		return "chapter01_thymeleaf/layout/bootstrap/shop";
	}
	
	
	
	
	
}
