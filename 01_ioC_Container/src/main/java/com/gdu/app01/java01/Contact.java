package com.gdu.app01.java01;

public class Contact {
	//field
	private String tel;
	private String fax;
	
	// 생성자는 두개 준비할것 defalut constructor
	public Contact() {
		
	}
	// constructor

	public Contact(String tel, String fax) {
		super();
		this.tel = tel;
		this.fax = fax;
	}
	
	
	// gettersetter 
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
}
