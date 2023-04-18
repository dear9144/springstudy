package com.gdu.app05.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app05.service.BoardService;
import com.sun.org.slf4j.internal.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app05.domain.BoardDTO;
import com.gdu.app05.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	
	private static final Logger Logger = org.slf4j.LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/list.do")
	public String list(Model model) {
		List<BoardDTO> list = boardService.getBoardList();
		Logger.debug(list.toString()); //목록 확인 
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/add.do")
	public String add(BoardDTO board) {
		Logger.debug(board.toString());
		Logger.debug(boardService.addBoard(board) + "");
		boardService.addBoard(board);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/detail.do")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no
			           , Model model) {
		Logger.debug(board_no + ""); 
		BoardDTO b = boardService.getBoardByNo(board_no);
		Logger.debug(b.toString());
		model.addAttribute("b", b));
		return "board/detail";
	}
	
	@GetMapping("/remove.do")
	public String remove(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no) {
		Logger.debug(board_no + "");
		Logger.debug(boardService.removeBoard(board_no) + "");
		boardService.removeBoard(board_no);
		return "redirect:/board/list.do";
	}
	
	@PostMapping("/modify.do")
	public String modify(BoardDTO board) {
		Logger.debug(board.toString());
		Logger.debug(null)
		boardService.modifyBoard(board);
		return "redirect:/board/detail.do?board_no=" + board.getBoard_no();
	}
}
