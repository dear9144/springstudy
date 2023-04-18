package com.gdu.app01.java02;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java02");
		Student student = ctx.getBean("stu", Student.class);
		System.out.println("점수: " + student.getScores());
		System.out.println("상: " + student.getAwards());
		System.out.println("연락처: " + student.getContact());
	}

}
