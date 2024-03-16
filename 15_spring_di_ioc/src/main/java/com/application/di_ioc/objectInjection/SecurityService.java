package com.application.di_ioc.objectInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	@Autowired
	private PasswordEncoder passwordEncoder; // SecurityConfig에서 생성된 객체를 주입해서 사용
	
	
	
}
