package com.application.di_ioc.toBeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스를 Service로 지정하여 spring bean으로 등록한다.
public class ToBeServiceImpl implements ToBeService {

	
	@Autowired
	private ToBeDAO toBeDAO;
	
	
	
	
}
