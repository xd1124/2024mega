package com.application.trainingVer2.boardAdvance.service;

import java.util.List;
import java.util.Map;

import com.application.trainingVer2.boardAdvance.dto.MainBoardDTO;
import com.application.trainingVer2.boardAdvance.dto.ReplyDTO;

public interface BoardAdvanceService {
	
	public List<MainBoardDTO> getBoardList(Map<String, Object> searchMap);
	public int getAllBoardCnt(Map<String, String> searchCntMap);
	public MainBoardDTO getBoardDetail(long boardId , boolean isIncreaseReadCnt);
	public void createBoard(MainBoardDTO mainBoardDTO);
	public boolean checkAuthorizedUser(MainBoardDTO mainBoardDTO);
	public void updateBoard(MainBoardDTO mainBoardDTO);
	public void deleteBoard(long boardId);
	public void createBoardDummy();
	
	public List<ReplyDTO> getReplyList(long boardId);
	public int getReplyCnt(long boardId);
	public ReplyDTO getReplyDetail(long replyId);
	public void createReply(ReplyDTO replyDTO);
	public boolean updateReply(ReplyDTO replyDTO);
	public boolean deleteReply(ReplyDTO replyDTO);
	
	public void getTodayEnrolledBoardAndReplyCnt();
	
}
