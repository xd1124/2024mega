package com.application.trainingPrac.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.trainingPrac.data.Board;
import com.application.trainingPrac.data.BoardDTO;

public class BoardMapper {
	
	public static Board toEntity(BoardDTO boardDTO) {
		
		Board entity = new Board();
		entity.setBoardId(boardDTO.getBoardId());
		entity.setPasswd(boardDTO.getPasswd());
		entity.setContent(boardDTO.getContent());
		entity.setWriter(boardDTO.getWriter());
		entity.setSubject(boardDTO.getSubject());
		entity.setReadCnt(boardDTO.getReadCnt());
		entity.setEnrollAt(boardDTO.getEnrollAt());
		return entity ;
	}
	
	public static BoardDTO toDTO(Board board) {
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardId(board.getBoardId());
		dto.setPasswd(board.getPasswd());
		dto.setContent(board.getContent());
		dto.setWriter(board.getWriter());
		dto.setSubject(board.getSubject());
		dto.setReadCnt(board.getReadCnt());
		dto.setEnrollAt(board.getEnrollAt());
		return dto ;
	}
	
	public static List<BoardDTO> toDTOList(List<Board> boards) {
		
		return boards.stream().map(BoardMapper::toDTO).collect(Collectors.toList());
	}
}
