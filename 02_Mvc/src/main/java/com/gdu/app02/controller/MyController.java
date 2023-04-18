package com.gdu.app02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
	 	안녕 난 컨트롤러야 
	 	@Component를 포함하고 있어서 자동으로 sping container에 bean으로 ㄷ으록되지
	 	나는 스프링에 의해서 사용되고 있어 
	  
 */
@Controller
public class MyController {
	//메소드 : 요청과 응답을 처리하는 단위 , 하나의 요청과 하나의 응답은 메소드 한개가 담당함 
	
	/*
	  메소드 작성 방법
	  1. 반환타입 : String(응답할 jsp 의 이름을 작성)
	  2. 메소드명 : 아무일도 안함 
	  3. 매개변수 : 정해진 바가 없음, 요청과 응답에 따라 다름 , 
	 */
	
	/*
	 	@RequestMapping 
	 	1. value : URL Mapping을 작성 (동작할 주소를 작성) 이 주소가 오면 이메소드를 돌려줘라 라는 의미  
	 	2. method : Request Method를 작성(GET, POST, PUT , DELETE등) 
	 */
	
	/*
	  @RequestMapping(value="/", method = RequestMethod.GET)
	  	URL Mapping "/"이면 context path 경로를 의미함(http://localhost:9090/app02)
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	/*
	 	@RequestMapping 작성 예시
	 	@RequestMapping(value="/list.do", method=RequestMethod.GET)		정식버전
	 	@RequestMapping(value="list.do", method=RequestMethod.GET)		value는 슬래시(/)로 시작하지 않아도 됨 
	 	@RequestMapping(value="list.do")								GET 방식의 method는 생략할 수 있음 
	 	@RequestMapping(/list.do")										value 속성만 작성하는 경우에는 값만 작성할 수 있음 
	 	
	 */
	
	@RequestMapping("/list.do")
	public String list() {
		return "board/list"; //실제 처리되는 경로 : /WEB-INF/views/board/list.jsp
		/*
		 	return "/board/list"; 슬래시(/)로 시작한 Jsp 경로 
		 	실제 처리되는 경로 : /WEB-INF/views//board/list.jsp (중간에 슬래시가 2개 포함된다) 
		 	하지만 실제로는 슬래시 두개는 무시가 돼서 /WEB-INF/views/board/list.jsp 경로로 처리된다. 
		 */
	
	}
	
		
	
	
	
	
	
	
	
}
