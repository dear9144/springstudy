package com.gdu.myapp.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.myapp.domain.BoardDTO;

@Controller
public class BoardController {
	@GetMapping({"/", "/index.do"}) // 슬래시는 contextpath라는 의미 http://localhost:9090/myapp인 경우 동작한다
					 //@getMapping("/board") , @getMapiing("board") 둘다 같은 으미
	//반환타입 String : 이동할 jsp 이름을 반환함 반환된 이름은 Servlet-context.xml 의 ViewResolver에 의해서 rendering 됨 
	//prefix + 반환값 + suffix 
	public String index() {
		return "index";
	}
	
	// <a>, loacation 
	/*
	@GetMapping("/detail.do")
	public void getDetail(HttpServletRequest request) {
		int boardNo =Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		System.out.println(boardNo + ", " + title);
	}
	
	//<form>
	@PostMapping("detail/do")
	public void postDetail(HttpServletRequest request) {
	int boardNo =Integer.parseInt(request.getParameter("boardNo"));
	String title = request.getParameter("title");
	System.out.println(boardNo + ", " + title);
}
	*/
	
	/*
	@GetMapping("/detail.do")
	public void getDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
						, @RequestParam(value="title", required=false, defaultValue="빈제목")String title) {
		System.out.println(boardNo+ "," + title);
	}//  근데 선생님은 이렇게 defaultvalue 처리하기 외엔 requestParam을 별로 추천하지 않는다고 하시네 , 서버가 죽지 않고 어떤 값을 가지고 있으면 계속 동작하게끔 
	
	@PostMapping("/detail.do")
	public void postDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
						, @RequestParam(value="title", required=false, defaultValue="빈제목")String title) {
		System.out.println(boardNo+ "," + title);
	} 
	//파라미터 안 많을때 쓰면 좋겠지 , default 값이 처리 될때 저렇게 하면 좋겠지 <- 값이 안온다면 이렇게 하겠다 처리 
	*/
	
	/*
	@GetMapping("/detail.do")
	public void getDetail(BoardDTO board) { //board.setBoardNo()와 board.setTitle()이 사용됨 <- 외부적으론 이렇게 준비를 하는 부분임 
		System.out.println(board); //객체를 출력하면 toString()이 동작한다 @Data에 getter setter toString들어있잖아  
	}
	@PostMapping("detail.do")
	public void postDetail(BoardDTO board) {//board.setBoardNo()와 board.setTitle()이 사용됨 <- 외부적으론 이렇게 준비를 하는 부분임
		System.out.println(board);
	}
	*/
	
	//Model 
	//1, 주 목적 : jsp로 forward할 데이터(attribute)를 저장하는 용도 -> request를 사용하는 내장객체 
	//2. 속성 저장소 : request, session , pageContext, application
	//3. 컨트롤러에서 매개변수만 선언할 수 있음, 모델을 값 넘길떄 쓰기도 함 굳이 근데..? 
	/*
	@GetMapping("/detail.do")
	public String getDetail(HttpServletRequest request, Model model) {
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo =Integer.parseInt(opt1.orElse("0"));
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("title"));
		String title = opt2.orElse("빈제목");
		model.addAttribute("boardNo", boardNo); //request.setAttribute("boardNo",boardNo); 말리진 않겠는데 누군가 코드를 보면 의아해 할 
		model.addAttribute("title",title);
		return "detail";
	}
	
	
	@PostMapping("detail/do")
	public String postDetail(HttpServletRequest request, Model model) {
	Optional<String> opt1 = Optional.ofNullable(request.getParameter("boardNo"));
	int boardNo =Integer.parseInt(opt1.orElse("0"));
	Optional<String> opt2 = Optional.ofNullable(request.getParameter("title"));
	String title = opt2.orElse("빈제목");
	model.addAttribute("boardNo", boardNo);
	model.addAttribute("title", title);
	return "detail";
	*/
	/*
	@GetMapping("/detail.do")
	public String getDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
						, @RequestParam(value="title", required=false, defaultValue="빈제목")String title
						, Model model {
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("title", title);
		return "detail";
	}//  근데 선생님은 이렇게 defaultvalue 처리하기 외엔 requestParam을 별로 추천하지 않는다고 하시네 , 서버가 죽지 않고 어떤 값을 가지고 있으면 계속 동작하게끔 

	@PostMapping("/detail.do")
	public void postDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo
						, @RequestParam(value="title", required=false, defaultValue="빈제목")String title) {
		System.out.println(boardNo+ "," + title);
	} 
	
	*/
	@GetMapping("/detail.do")
	public String getDetail(BoardDTO board) { //파라미터를 객체로 받으면 자동으로 Model에 저장이 됨 , 속성명은 boardDTO로 저장이 됨 (클래스를 가지고 속성명을 만듬) 
		return "detail";
	}
	@PostMapping("detail.do")
	public String postDetail(@ModelAttribute("board") BoardDTO board) {//Model에 저장하는 속성명을 "board"로 하겠다 ->이름을 바꾼 것 
		return "detail";
	}
}
	

	

