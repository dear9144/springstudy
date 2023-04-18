package com.gdu.app03.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.sym.Name;
import com.gdu.app03.domain.Contact;

public class ThirdServiceImpl implements IThirdService {

	@Override
	public ResponseEntity<Contact> execute1(Contact contact) {
		//이름 또는 전화번호가 공백인 경우 $.ajax error처리
		if(contact.getName().isEmpty() || contact.getTel().isEmpty()) {
			return new ResponseEntity<Contact>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<Map<String, String>> execute2(Map<String, String> map) {
		String name = map.get("name");
		String tel = map.get("tel");
		if(name.isEmpty() || tel.length() <= 3) {
			return new ResponseEntity<Map<String, String>>(HttpStatus.BAD_REQUEST);
		}
	
		map.put("tel", tel.replace("-", ""));
		
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
}
}
