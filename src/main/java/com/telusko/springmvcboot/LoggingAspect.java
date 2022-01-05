package com.telusko.springmvcboot;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.telusko.springmvcboot.model.Alien;


@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.telusko.springmvcboot.AlienControllerRestApi.getAliens())")
	public void beforeLog() {
		
		LOGGER.info("getAliens method called from aspect");
	}
	
	/*
	
	// @After : after finally : gets executed anyway  
	@After("execution(public * com.telusko.springmvcboot.AlienControllerRestApi.getAliens())")
	public void afterLog() {
		
		LOGGER.info("getAliens method executed from aspect.");
	}
	
	*/
	
	// @AfterReturning : gets executed only after return statement is executed
	@AfterReturning("execution(public * com.telusko.springmvcboot.AlienControllerRestApi.getAliens())")
	public void afterLog() {
		
		LOGGER.info("getAliens method executed from aspect.");
	}
	
	
	//@AfterThrowing : gets executed only after an Exception occured 
	@AfterThrowing("execution(public * com.telusko.springmvcboot.AlienControllerRestApi.getAliens())")
	public void logException() {
		
		LOGGER.info("execution ISSUE !!");
	}
	
}
