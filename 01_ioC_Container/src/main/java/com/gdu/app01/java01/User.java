package com.gdu.app01.java01;

public class User {

		//field
		private String id;
		private Contact contact;
		
		//default 생성자
		public User() {
			
		}

		//그냥 생성자 
		public User(String id, Contact contact) {
			super();
			this.id = id;
			this.contact = contact;
		}

		
		//gettersetter
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public Contact getContact() {
			return contact;
		}
		
		public void setContact(Contact contact) {
			this.contact = contact;
		}
		
}
