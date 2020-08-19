package com.mercury.SpringBootRestDemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Value("${app.name}")
	private String appName;

//	@Before("execution (* com.mercury.SpringBootRestDemo.controllers.*.save(..))")
	@Before("execution (* com.mercury.SpringBootRestDemo.controllers.*.getAll())")
	public void printAppName() {
		// Aspect
		// what : the logic need to be done
		System.out.println(appName);
	}
}
