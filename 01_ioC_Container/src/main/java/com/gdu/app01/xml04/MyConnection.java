package com.gdu.app01.xml04;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	
		//field
		private String driver;
		private String url;
		private String user;
		private String password;
		
		//default constructor
		
		//method(getter, setter, getConnection
		public Connection getConnection() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Oracle 접속 완료되었습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return con;
		}//코드를 외우는게 중요한게 아님 , jdbc 완전 초창기 코드임

		public String getDriver() {
			return driver;
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
		
		
		
}
