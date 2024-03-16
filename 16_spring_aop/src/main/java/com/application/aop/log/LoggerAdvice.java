package com.application.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* 

	# 스프링부트 로깅 구현방법 
	
		1) build.gradle파일에 의존성 확인 
		
		- Spring Web의존성에 이미 logback이 구현되어 있다.
		(확인)'org.springframework.boot:spring-boot-starter-web' 
		
		
		2) src/main/resources경로 아래 logback.xml 파일을 생성하고 관련 설정을 추가한다.
		
			<?xml version="1.0" encoding="UTF-8"?>
			<configuration>
			    
			    <!-- 로그 파일 경로 -->
			    <property name="LOG_PATH" value="${user.home}/logs/test.log"/>
			    
			    <!-- 콘솔로깅 appender -->
			    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
			        <encoder>
			            <pattern>%date{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>  <!-- 로깅 패턴 -->
			        </encoder>
			    </appender>
			    
			    <!-- 파일 로깅 appender (DailyRollingFileAppender )-->
			    <appender name="DAILY_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
			        <file>${LOG_PATH}</file>													  <!-- 로그파일 경로 및 이름 설정 -->
			        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			            <fileNamePattern>app.log.%d{yyyy-MM-dd}.log</fileNamePattern>             <!-- 파일 이름 패턴 설정 -->
			        </rollingPolicy>
			        <encoder>
			            <pattern>%date{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>  <!-- 로깅 패턴 -->
			        </encoder>
			    </appender>
	
			    <!-- application 기본설정 -->
			    <root level="INFO"> 
			        <appender-ref ref="CONSOLE"/> 					<!-- 콘솔환경에 로깅 구현 -->
			        <appender-ref ref="DAILY_FILE"/> 				<!-- 파일환경에 로깅 구현 -->
			    </root>
	
			</configuration>

*/





@Aspect
@Component
public class LoggerAdvice {

	
	/* 
	
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
	
	 	Logger객체 생성 (private) static Logger logger = LoggerFactory.getLogger(클래스이름.class);
	
	
		[ Logger를 사용하는 이유 ]
	
	 	- 여러개발자가 협업을 하는 경우 logback 로깅방식을 통해서 로깅방법을 통일할 수 있다.
	 	- logback을 사용하여 로그의 레벨별로 체계적인 로그관리가 가능한다.
	 	- SQL , File과 연동하여 부가적인 기능 구현이 가능하다.
	 	
	 	
	 	[ Logging Level ]
	 	
	 	- 로깅 레벨을 설정하면 그 이상 레벨을 로깅한다.
	 	- Spring Boot는 기본적으로 INFO 레벨로 설정되어 있다. 
	 	
			level 6) FATAL : 몇몇 로깅 프레임워크에서만 지원하는 레벨로 치명적인 오류를 나타낸다.
			level 5) ERROR : 에러 레벨은 치명적인 오류 메시지를 기록한다. 애플리케이션은 계속 실행될 수 있지만 심각한 문제가 발생했음을 나타낸다.
			level 4) WARN  : 경고 레벨은 경고 메시지를 기록한다. 어떤 문제가 발생했지만 애플리케이션은 계속 실행될 수 있다.
			level 3) INFO  : 일반적인 실행에 대한 정보를 기록한다. 애플리케이션의 주요 이벤트 및 상태 변경에 대한 정보를 보여준다.
			level 2) DEBUG : 디버깅에 유용한 로그를 기록한다. 개발 중에 자세한 정보를 확인할 때 사용된다.
		 	level 1) TRACE : 가장 낮은 로깅 레벨로 매우 상세한 로그를 기록한다. 개발 중 디버깅에 사용된다.
		
	  	
	*/	
	
	private static Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);
	
	
	@Around("execution(public void com.application.aop.log.*.*(..))")
	public void around(ProceedingJoinPoint pjp) {
		
		long startTime = System.currentTimeMillis();
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		//System.out.println(pjp.getSignature().getName() + " 메서드 실행 시간 : " + (endTime - startTime)/1000.0 + "초");
		logger.info(pjp.getSignature().getName() + " 메서드 실행 시간 : " + (endTime - startTime)/1000.0 + "초");
		
	}
	
}
