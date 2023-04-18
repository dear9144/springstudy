package com.gdu.app01.java02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
public class AppContext {
	//임의의 학생을 만들어서 main class에서 확인하기 
	
	@Bean
	public Student stu() {
		
		//난수 만들기
		List<Integer> scores = new ArrayList<Integer>();
		for(int cnt = 0; cnt<5; cnt++) {
			scores.add((int)(Math.random() * 101) );
		}
		//상 3개 
		Set<String> awards = new HashSet<String>();
		awards.add("개근상");
		awards.add("장려상");
		awards.add("참가상");
		
		//address, tel
		Map<String, String> contact = new HashMap<String, String>();
		contact.put("address", "seoul");
		contact.put("tel", "02-1234-5678");
		
		// Bean 생성 및 반환 
		Student student = new Student();
		student.setScores(scores);
		student.setAwards(awards);
		student.setContact(contact);
		return student;
		
		
	}

	
	
}
