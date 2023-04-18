package com.gdu.app04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.app04.domain.BoardDTO;
import com.gdu.app04.repository.BoardDAO;

//JUnit4
@RunWith(SpringJUnit4ClassRunner.class)

/*
 	@ContextConfiguration
 	1. 어떤 방식으로 Spring Container에 Bean을 등록했는지 알려주는 역할 
 */

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

/* 
 테스트 순서 
 1. 순서 : 삽입 
 노션 
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardUnitTest {

	@Autowired
	private BoardDAO boardDAO;
	
	
	//logger org.slf4j.logger를 동작시킨다 (사진 참고)
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardUnitTest.class);
	
	
	//테스트 메소드 
	@Test
	public void a1삽입테스트() {
		BoardDTO board = new BoardDTO(0, "제목", "내용", "작성자", null, null);
		assertEquals(1, boardDAO.insertBoard(board));  // boardDAO.insertBoard(board) 결과가 1이면 테스트 성공!
	}
	
	@Test
	public void a2상세테스트() {
		int board_no = 1;  // 조회할 게시글의 번호
		BoardDTO board = boardDAO.selectBoardByNo(board_no);
		//System.out.println("a2 - " + board);  // LOG 기능으로 대체할 예정
		LOGGER.debug(board.toString());
		assertNotNull(board);  // board가 null이 아니면 테스트 성공!
	}
	
	@Test
	public void a3수정테스트() {
		BoardDTO board = new BoardDTO(1, "[수정]제목", "[수정]내용", null, null, "2023-04-17 15:40:00");
		assertEquals(1, boardDAO.updateBoard(board));  // boardDAO.updateBoard(board) 결과가 1이면 테스트 성공!
	}
	
	@Test
	public void a4상세테스트() {
		int board_no = 1;  // 조회할 게시글의 번호
		BoardDTO board = boardDAO.selectBoardByNo(board_no);
		//System.out.println("a4 - " + board);  // LOG 기능으로 대체할 예정
		LOGGER.debug(board.toString());
		assertNotNull(board);  // board가 null이 아니면 테스트 성공!
	}
	
	@Test
	public void a5목록테스트() {
		List<BoardDTO> list = boardDAO.selectBoardList();
		//System.out.println("a5 - " + list);  // LOG 기능으로 대체할 예정
		LOGGER.debug(list.toString());
		assertEquals(1, list.size());  // 목록 개수가 1개이면 테스트 성공!
	}
	
	@Test
	public void a6삭제테스트() {
		int board_no = 1;  // 삭제할 게시글 번호
		assertEquals(1, boardDAO.deleteBoard(board_no));  // boardDAO.deleteBoard(board) 결과가 1이면 테스트 성공!
	}
	

}