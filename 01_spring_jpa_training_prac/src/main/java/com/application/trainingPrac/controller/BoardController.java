package com.application.trainingPrac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingPrac.data.BoardDTO;
import com.application.trainingPrac.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/createBoard")
	public String createBoard() {
		return "board/createBoard";
	}
	
	@PostMapping("/createBoard")
	@ResponseBody
	public String createBoard(@ModelAttribute BoardDTO boardDTO) {

		boardService.createBoard(boardDTO);

		String jsScript = """
				<script>
					   alert('작성 되었습니다.');
					   location.href = '/board/boardList';
				 	    </script>""";

		return jsScript;
		
		
	}
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";

	}

	@GetMapping("/boardDetail")
	public String boardDetail(Model model, @RequestParam("boardId") long boardId) {
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId));
		return "board/boardDetail";

	
	// 인증
	}
	@GetMapping("/authentication")
	public String authentication(Model model , @RequestParam("boardId") Long boardId , @RequestParam("menu") String menu) {
		model.addAttribute("boardDTO" , boardService.getBoardDetail(boardId)); 
		model.addAttribute("menu", menu);
		return "board/authentication";	
	}
	
	
	@PostMapping("/authentication")
	@ResponseBody
	public String authentication(@ModelAttribute BoardDTO boardDTO , @RequestParam("menu") String menu) {
		
		String jsScript = "";
		if (boardService.checkAuthorizedUser(boardDTO)) {
			
			if (menu.equals("update")) {
				jsScript = String.format("""
						<script>
					 	   location.href = '/board/updateBoard?boardId=%d';
				   	    </script>""" , boardDTO.getBoardId());
			}
			else if (menu.equals("delete")) {
				jsScript = String.format("""
						<script>
					 	   location.href = '/board/deleteBoard?boardId=%d';
				   	    </script>""" , boardDTO.getBoardId());
			}
			
		}
		else {
			jsScript = """
					<script>
				 	   alert('패스워드를 확인하세요.');
				 	   history.go(-1);
			   	    </script>""";
		}
		
		return jsScript;
	
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model , @RequestParam("boardId") Long boardId) {
		model.addAttribute("boardDTO", boardService.getBoardDetail(boardId));
		return "board/updateBoard";
	}
	
	
	@PostMapping("/updateBoard")
	@ResponseBody
	public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
		
		boardService.updateBoard(boardDTO);
		
		String jsScript = """
				<script>
			 	   alert('수정 되었습니다.');
			 	   location.href = 'boardList';
		   	    </script>""";
		
		return jsScript;	   
			   
	}
	
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Model model , @RequestParam("boardId") Long boardId) {
		model.addAttribute("boardId", boardId);
		return "board/deleteBoard";
	}

	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public String postRemoveBoard(@RequestParam("boardId") Long boardId) {
		
		boardService.deleteBoard(boardId);
		
		String jsScript = """
				<script>
			 	   alert('삭제 되었습니다.');
			 	   location.href = '/board/boardList';
		   	    </script>""";
	
		return jsScript;	
		
	}
}
