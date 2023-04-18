package com.gdu.app01.xml04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml04/app-context.xml");
		MyDAO dao = ctx.getBean("dao", MyDAO.class);
		dao.list(); //list가 get connection을 부르고 있음 
		
		ctx.close();
	}

}
