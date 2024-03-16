package com.application.trainingVer1.service;

import java.util.List;

import com.application.trainingVer1.data.BoardDTO;

public interface BoardService {

	public void createBoard(BoardDTO boardDTO);
	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardDetail(Long boardId);
	public boolean checkAuthorizedUser(BoardDTO boardDTO);
	public void updateBoard(BoardDTO boardDTO);
	public void deleteBoard(Long boardId);
	
}
