package com.application.trainingVer2.boardAdvance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer2.boardAdvance.dto.MainBoardDTO;
import com.application.trainingVer2.boardAdvance.dto.ReplyDTO;
import com.application.trainingVer2.boardAdvance.service.BoardAdvanceService;


@Controller
@RequestMapping("/boardAdvance")
public class BoardAdvanceController {

	@Autowired								
	private BoardAdvanceService boardAdvanceService;		
	
	
	@GetMapping("/boardList")
	public String boardList(Model model ,
							@RequestParam(name="searchKeyword" , defaultValue = "total") String searchKeyword,
							@RequestParam(name="searchWord" , defaultValue = "") String searchWord,
							@RequestParam(name="onePageViewCnt" , defaultValue = "10")  int onePageViewCnt,
							@RequestParam(name="currentPageNumber" , defaultValue = "1") int currentPageNumber) {
		
		Map<String, String> searchCntMap = new HashMap<String, String>();
		searchCntMap.put("searchKeyword", searchKeyword);
		searchCntMap.put("searchWord", searchWord);
		
		
		int allBoardCnt = boardAdvanceService.getAllBoardCnt(searchCntMap);
		
		int allPageCnt = allBoardCnt / onePageViewCnt + 1;
		
		if (allBoardCnt % onePageViewCnt == 0) allPageCnt--;
		
		int startPage = (currentPageNumber - 1)  / 10  * 10 + 1;
		if (startPage == 0) {
			startPage = 1;
		}
		
		int endPage = startPage + 9;
		
		if (endPage > allPageCnt) endPage = allPageCnt;
		if (endPage == 0) endPage = 1;
		
		
		int startBoardIdx = (currentPageNumber - 1) * onePageViewCnt;
		
		model.addAttribute("startPage"         , startPage);
		model.addAttribute("endPage"           , endPage);
		model.addAttribute("allBoardCnt"   	 , allBoardCnt);
		model.addAttribute("allPageCnt"   	 , allPageCnt);
		model.addAttribute("onePageViewCnt"    , onePageViewCnt);
		model.addAttribute("currentPageNumber" , currentPageNumber);
		model.addAttribute("startBoardIdx"     , startBoardIdx);
		model.addAttribute("searchKeyword"     , searchKeyword);
		model.addAttribute("searchWord"        , searchWord);
		
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("onePageViewCnt" , onePageViewCnt);
		searchMap.put("startBoardIdx"  , startBoardIdx);
		searchMap.put("searchKeyword"  , searchKeyword);
		searchMap.put("searchWord"     , searchWord);
		model.addAttribute("boardList"      ,  boardAdvanceService.getBoardList(searchMap));		
		
		return "boardAdvance/board/boardList";
		
	}
	
	
	@GetMapping("/createBoard")
	public String createBoard(){
		return "boardAdvance/board/createBoard";
	}
	
	
	@PostMapping("/createBoard")
	public String createBoard(MainBoardDTO mainBoardDTO){
		boardAdvanceService.createBoard(mainBoardDTO);
		return "redirect:/boardAdvance/boardList";
	}
	
	
	@GetMapping("/boardDetail")
	public String boardDetail(Model model , @RequestParam("boardId") long boardId){
		
		model.addAttribute("mainBoardDTO" , boardAdvanceService.getBoardDetail(boardId , true));
		model.addAttribute("allReplyCnt" , boardAdvanceService.getReplyCnt(boardId));
		model.addAttribute("replyList" , boardAdvanceService.getReplyList(boardId));
		
		return "boardAdvance/board/boardDetail";
		
	}
	
	
	@GetMapping("/boardAuthentication")
	public String boardAuthentication(Model model ,
								     @RequestParam("menu") String menu ,
									 @RequestParam("boardId") long boardId){
		
		model.addAttribute("mainBoardDTO" , boardAdvanceService.getBoardDetail(boardId , true));
		model.addAttribute("menu" , menu);
		
		return "boardAdvance/board/authentication";
		
	}
	
	
	@PostMapping("/boardAuthentication")
	@ResponseBody
	public String boardAuthentication(@RequestParam("menu") String menu ,
									  @ModelAttribute MainBoardDTO mainBoardDTO) {
		
		String jsScript = "";
		if (boardAdvanceService.checkAuthorizedUser(mainBoardDTO)) {
			
			if (menu.equals("update")) {
				jsScript = "<script>";
				jsScript += "location.href='/boardAdvance/updateBoard?boardId=" + mainBoardDTO.getBoardId() + "';";
				jsScript += "</script>";
			}
			else if (menu.equals("delete")) {
				jsScript = "<script>";
				jsScript += "location.href='/boardAdvance/deleteBoard?boardId=" +  mainBoardDTO.getBoardId() + "';";
				jsScript += "</script>";
			}
			
		}
		else {
			jsScript = """
			   <script> 
				   alert('check your password');
				   history.go(-1);
			   </script>""";
		}
		
		return jsScript;
	
	}
	
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model , @RequestParam("boardId") long boardId) {
		model.addAttribute("mainBoardDTO" , boardAdvanceService.getBoardDetail(boardId , false));
		return "boardAdvance/board/updateBoard";
	}
	
	
	@PostMapping("/updateBoard")
	public String updateBoard(MainBoardDTO mainBoardDTO) {
		boardAdvanceService.updateBoard(mainBoardDTO);
		return "redirect:/boardAdvance/boardList";
	}
	
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Model model , @RequestParam("boardId") long boardId) {
		model.addAttribute("boardId" , boardId);
		return "boardAdvance/board/deleteBoard";
	}
	
	
	@PostMapping("/deleteBoard")
	public String postdeleteBoard(@RequestParam("boardId") long boardId) {
		boardAdvanceService.deleteBoard(boardId);
		return "redirect:/boardAdvance/boardList";
	}
	
	
	@GetMapping("/createBoardDummy")
	public String createBoardDummy(){
		boardAdvanceService.createBoardDummy();
		return "redirect:/boardAdvance/boardList";
	}
	
	
	@GetMapping("/createReply")
	public String createReply(Model model , @RequestParam("boardId") long boardId) {
		model.addAttribute("boardId" , boardId);
		return "boardAdvance/reply/createReply";
	}
	
	
	@PostMapping("/createReply")
	public String createReply(@ModelAttribute ReplyDTO replyDTO){
		boardAdvanceService.createReply(replyDTO);
		return "redirect:/boardAdvance/boardDetail?boardId=" + replyDTO.getBoardId();
	}
	
	
	@GetMapping("/updateReply")
	public String updateReply(Model model , @RequestParam("replyId") long replyId){
		
		model.addAttribute("replyDTO" , boardAdvanceService.getReplyDetail(replyId));
		return "boardAdvance/reply/updateReply";
		
	}
	
	
	@PostMapping("/updateReply")
	@ResponseBody
	public String updateReply(ReplyDTO replyDTO){
		
		String jsScript = "";
		if (boardAdvanceService.updateReply(replyDTO)) {
			jsScript += "<script>";
			jsScript += "location.href='/boardAdvance/boardDetail?boardId=" + replyDTO.getBoardId() + "';";
			jsScript += "</script>";

		}
		else {
		   jsScript = """
		   <script> 
			   alert('check your password');
			   history.go(-1);
		   </script>""";
		}
		
		return jsScript;
		
	}
	
	
	@GetMapping("/deleteReply")
	public String deleteReply(Model model , @RequestParam("replyId") long replyId) {
		model.addAttribute("replyDTO" , boardAdvanceService.getReplyDetail(replyId));
		return "boardAdvance/reply/deleteReply";
	}
	
	
	@PostMapping("/deleteReply")
	@ResponseBody
	public String deleteReply(ReplyDTO replyDTO) {
		
		String jsScript = "";
		if (boardAdvanceService.deleteReply(replyDTO)) {
			jsScript += "<script>";
			jsScript += "location.href='/boardAdvance/boardDetail?boardId=" + replyDTO.getBoardId() + "';";
			jsScript += "</script>";
		}
		else {
			jsScript = """
			   <script> 
				   alert('check your password');
				   history.go(-1);
			   </script>""";
		}
		
		return jsScript;
		
	}
	
}
