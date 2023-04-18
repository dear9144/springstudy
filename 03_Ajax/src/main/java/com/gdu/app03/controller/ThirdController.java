package com.gdu.app03.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app03.domain.Contact;
import com.gdu.app03.service.IThirdService;

@Controller
public class ThirdController {
	
	//field
	private IThirdService thirdService;
	
	
	//setter method
	@Autowired
	public void method(IThirdService thirdService) {
		this.thirdService = thirdService;
	}
	@PostMapping(value="/third/ajax1", produces="application/json")
	public ResponseEntity<Contact> ajax1(@RequestBody Contact contact) {
		return thirdService.execute1(contact);
		
	}

	@PostMapping(value="/third/ajax2", produces="application/json")
	public ResponseEntity<Map<String, String>> ajax2(@RequestBody Map<String, String> map) {
		return thirdService.execute2(map);
	}
}
