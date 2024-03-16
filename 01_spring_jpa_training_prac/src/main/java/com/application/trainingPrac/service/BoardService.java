package com.application.trainingPrac.service;

import java.util.List;

import com.application.trainingPrac.data.BoardDTO;

public interface BoardService {
	
	public void createBoard(BoardDTO boardDTO);
	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardDetail(Long boardId);
	
	// 암호
	public boolean checkAuthorizedUser(BoardDTO boardDTO);
	public void updateBoard(BoardDTO boardDTO);
	public void deleteBoard(Long boardId);
}
