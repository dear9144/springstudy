package com.gdu.app02.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app02.domain.Person;
@Controller
public class MvcController {

		/*
		 	@RequestMapping을 대체하는 새로운 애너테이션
		 	1. @GetMapping
		 	2. @PostMapping
		 	3. @PutMapping
		 	4. @DeleteMapping
		 */
	
	/*
	 요청 파라미터의 UTF-8 인코딩 처리
	 메소드마다 request.setCaracterEncoding("UTF-8") 을 작성하는 것은 매우 비효율적이므로
	 모든요청(contextpath를 가진 모든 요청) 마다 동작하도록 filter를 사용한다 
	 characterEncodingFilter를 통해서 모든 요청마다 자동으로 UTF-8로 인코딩됨
	 참고할 파일 : /WEB-INF/web.xml  
	  
	*/
	  /*	1. HttpServletrequest로 요청 파라미터 처리 */
	
	@GetMapping("/detail.do")
	public String detail(HttpServletRequest request, Model model) {
		
		//name 의 전달이 없으면 "홍길동"이 사용됨 
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("name"));
		String name = opt1.orElse("홍길동");
		
		//age의 전달이 없으면 "0"이 사용됨 
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("age"));
		int age = Integer.parseInt(opt2.orElse("0"));
		/*
		 	Model model
		 	1. 스프링에서 사용하는 데이터(속성) 전달 객체
		 	2. Model2(Jsp/Servlet)에서는 HttpServletRequest request 객체를 사용해서 데이터를 전달했는데 
		 	   스프링에서는 Model model 객체를 사용
		 */
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "mvc/detail";
	
		
		
	}
	/*
	   2. @RequestParam으로 요청 파라미터 처리하기
	   		1. value		: 요청 파라미터 이름 
	   		2. required 	: 요청 파라미터의 필수여부 (디폴트는 true)
	   		3. defaultValue : 요청 파라미터가 없을 때 대신 사용할 값 
	 */
	@GetMapping("/detail.me")
	public String detailMe(@RequestParam(value = "name", required = false, defaultValue = "홍길동")String name,
						   @RequestParam(value="age", required = false, defaultValue = "0" ) int age,
						   Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "mvc/detail";
		
	}
	
	@GetMapping("/detail.gdu")
	public String detailGdu(Person p) {  // name과 age를 필드로 가진 커맨드 객체 Person p
		                                 // Model에 저장될 때 객체 이름인 p를 사용하지 않고,
		                                 // 객체 타입인 Person을 사용한다.
		                                 // Model에 저장되는 속성명은 객체 타입 Person을 person으로 수정해서 사용한다.
		return "mvc/detail";
	
	}
	
	
	
	
	
	
}
