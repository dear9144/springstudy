package com.gdu.app01.xml_into_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		//upload라는 Bean을 가져다 쓰고 싶어 
		Upload upload = ctx.getBean("upload", Upload.class);
		
		System.out.println("첨부제목: " + upload.getTitle());
		System.out.println("첨부파일: " + upload.getAttach().getFilename());
		System.out.println("첨부경로: " + upload.getAttach().getPath());
		
		ctx.close();
	}

}
