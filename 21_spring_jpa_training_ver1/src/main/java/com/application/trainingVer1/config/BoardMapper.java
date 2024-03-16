package com.application.trainingVer1.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.trainingVer1.data.Board;
import com.application.trainingVer1.data.BoardDTO;

public class BoardMapper {

	public static Board toEntity(BoardDTO boardDTO) {
		
		Board entity = new Board();
		entity.setBoardId(boardDTO.getBoardId());
		entity.setPasswd(boardDTO.getPasswd());
		entity.setWriter(boardDTO.getWriter());
		entity.setSubject(boardDTO.getSubject());
		entity.setContent(boardDTO.getContent());
		entity.setReadCnt(boardDTO.getReadCnt());
		entity.setEnrollAt(boardDTO.getEnrollAt());
		return entity;
		
	} 
	
	public static BoardDTO toDTO(Board entity) {
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardId(entity.getBoardId());
		dto.setPasswd(entity.getPasswd());
		dto.setWriter(entity.getWriter());
		dto.setSubject(entity.getSubject());
		dto.setContent(entity.getContent());
		dto.setReadCnt(entity.getReadCnt());
		dto.setEnrollAt(entity.getEnrollAt());
		return dto;
		
	} 
	
	public static List<BoardDTO> toDTOList(List<Board> boards) {
		return boards.stream().map(BoardMapper::toDTO).collect(Collectors.toList());
	}
	
}


