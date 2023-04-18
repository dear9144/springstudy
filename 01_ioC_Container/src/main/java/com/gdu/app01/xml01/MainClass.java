package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 <bean> 태그로 생성한 Bean을 가져올 때 사용하는 스프링 클래스 
		 
		 */
		
		
		// src/main/resources/xml01 디렉토리에 있는 app-context.xml 파일에 정의된 Bean을 쓸게요 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/app-context.xml"); 
		//src/main/resources는 명시하지 않음 
		
		//Bean 중에서 student란 id를 가진 Bean을 주세요 
		Student hakSaeng = ctx.getBean("student", Student.class); //(Student)ctx.getBean("Student")
		
		//haksaeng 의 calculator를 이용한 메소드를 호출
		hakSaeng.getCalculator().add(5, 2);
		hakSaeng.getCalculator().sub(5, 2);
		hakSaeng.getCalculator().mul(5, 2);
		hakSaeng.getCalculator().div(5, 2);
		
		//자원 반납합니다 
		ctx.close();
	}

}
