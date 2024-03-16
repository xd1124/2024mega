package com.application.di_ioc.objectInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*

	# 패스워드 인코더 적용 예시
	1) build.gradle 파일에 아래의 의존성 추가 후에 refresh build project 
		implementation 'org.springframework.boot:spring-boot-starter-security'
		
	2) config 객체를 생성
	
	3) 의존성 주입하여 기능 구현

*/

@Configuration       // 스프링 컨테이너는 @Configuration이 붙은 클래스를 구성 클래스로 인식하고 이 안에서 선언된 메소드들을 통해 빈을 등록한다.
@EnableWebSecurity   // @EnableWebSecurity 어노테이션은 스프링 시큐리티 설정을 활성화한다. 
public class SecurityConfig {

	@Bean  // @Bean 어노테이션은 메소드 레벨에서 사용되며 메소드가 반환하는 객체를 스프링 컨테이너의 빈으로 등록하도록 한다.
	public PasswordEncoder passwordEncoder() {
		
		PasswordEncoder object = new BCryptPasswordEncoder();
		
		// 테스트 및 기타로직 구현 가능
		
		return object;	// PasswordEncoder는 스프링 시큐리티에서 비밀번호를 안전하게 인코딩하거나 검증할 때 사용하는 인터페이스이다.			
	
	}
	
	
}
