package com.application.trainingVer1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.trainingVer1.config.BoardMapper;
import com.application.trainingVer1.data.Board;
import com.application.trainingVer1.data.BoardDTO;
import com.application.trainingVer1.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createBoard(BoardDTO boardDTO) {
		
		boardDTO.setPasswd(passwordEncoder.encode(boardDTO.getPasswd()));
		boardDTO.setEnrollAt(new Date());
		
		boardRepository.save(BoardMapper.toEntity(boardDTO));
		
	}

	@Override
	public List<BoardDTO> getBoardList() {
		return BoardMapper.toDTOList(boardRepository.findAll());
	}

	@Override
	public BoardDTO getBoardDetail(Long boardId) {
		
		Board board = boardRepository.findById(boardId).orElse(null);
		
		board.setReadCnt(board.getReadCnt() + 1);
		boardRepository.save(board);
		
		return BoardMapper.toDTO(board);
		
	}

	@Override
	public boolean checkAuthorizedUser(BoardDTO boardDTO) {
	
		boolean isAuthorizedUser = false;
		
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		
		if (passwordEncoder.matches(boardDTO.getPasswd(), board.getPasswd())) {
			isAuthorizedUser = true;
		}
		
		return isAuthorizedUser;
		
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		board.setSubject(boardDTO.getSubject());
		board.setContent(boardDTO.getContent());
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}
	
}
