package com.gdu.app02.domain;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {
	
	
	@GetMapping("/post/detail.do")
	public String detail(HttpServletRequest request) throws Exception{
	
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("/post/detail.do");
		System.out.println("name: " + name + ", age: " + age);
		
		//redirect: 이동경로 작성 
		return "redirect:/post/list.do?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age; 
		
}
	
	@GetMapping("/post/list.do")
	public String list(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		// /WEB-INF/views/post/list.jsp.로 forward 하겠다 
		return "post/list";
		
	}
	
	@GetMapping("/post/detail.me")
	public String datailMe(HttpServletRequest request, 
						   RedirectAttributes redirectAttributes) {
		String neme = request.getParameter("name");
		String age = request.getParameter("age");
		
		
		//Redirect 경로까지 전달되는 속성 : flash Attribute
		redirectAttributes.addFlashAttribute("name", neme);
		redirectAttributes.addFlashAttribute("age", age);
	
		return "redirect:/post/list.me";
	}
	
	@GetMapping("/post/list.me")
	public String listMe() { //Flash Atribute는 Redirect 경로까지 자동으로 전달되므로 별도의 
		return "post/list";
	}
	
}
