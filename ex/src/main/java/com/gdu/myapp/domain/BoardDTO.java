package com.gdu.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private int boardNo; //너무 줄여서 이름을 사용하다보면 오류가 생길 수 있어서 너무 줄여서 쓰지는 말 것 
	private String title;
}
