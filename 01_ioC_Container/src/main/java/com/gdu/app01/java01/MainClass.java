package com.gdu.app01.java01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		  @Configuration, @Bean 애너테이션으로 생성한 Bean을 가져올 떄 사용하는 스프링 클래스
		  AnnotationConfigApplicationContext
		 */
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);//AppContext.java 파일에 있는 Bean을 주세요 
		//AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java01"); //com.gdu.app01.java01 패키지에 있는 모든 bean을 주세요 
	
		User user1 = ctx.getBean("user1", User.class);
		System.out.println(user1.getId());
		System.out.println(user1.getContact().getTel());
		System.out.println(user1.getContact().getFax());
		
		ctx.close();
	}

}
