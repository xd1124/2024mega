package com.application.trainingVer2.boardAdvance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.boardAdvance.dto.MainBoardDTO;
import com.application.trainingVer2.boardAdvance.dto.ReplyDTO;

@Mapper
public interface BoardAdvanceDAO {

	public int getAllBoardCnt(Map<String, String> searchCntMap);
	public List<MainBoardDTO> getBoardList(Map<String, Object> searchMap);
	public MainBoardDTO getBoardDetail(long boardId);
	public void updateReadCnt(long boardId);
	public void createBoard(MainBoardDTO mainBoardDTO);
	public void updateBoard(MainBoardDTO mainBoardDTO);
	public void deleteBoard(long boardId);
	public String getPasswd(long boardId);
	public void createBoardDummy(List<MainBoardDTO> dummyBoardList);

	public int getReplyCnt(long boardId);
	public List<ReplyDTO> getReplyList(long boardId);
	public ReplyDTO getReplyDetail(long replyId);
	public void createReply(ReplyDTO replyDTO);
	public void updateReply(ReplyDTO replyDTO);
	public void deleteReply(long replyId);
	public String validateReplyUserCheck(long replyId);
	
	public int getTodayEnrolledBoardCnt(String today);
	public int getTodayEnrolledReplyCnt(String today);
	
}
