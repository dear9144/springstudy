package com.gdu.app04.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.BoardDTO;
import com.gdu.app04.repository.BoardDAO;
import com.gdu.app04.service.BoardService;

@RequestMapping("/board") //모든 mapping에 /board prefix(앞에) 추가된다 
@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/add.do")
	public String add(BoardDTO board) {
		boardService.addBoard(board);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/detail.do")
	public String detail(@RequestParam(value="board_no", required = false, defaultValue = "0") int board_no 
						, Model model) {
		model.addAttribute("b", boardService.getBoardByNo(board_no));
		return "board/detail";
	}
	
	@GetMapping("/remove.do")
	public String remove(@RequestParam(value="board_no", required = false, defaultValue = "0")int board_no) { 
				boardService.removeBoard(board_no);
		return "redirect:/board/list.do";
	}
	
	@PostMapping("/modify.do")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail.do?board_no=" + board.getBoard_no();
	}
	
}






