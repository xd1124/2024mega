package com.application.trainingPrac.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.trainingPrac.config.BoardMapper;
import com.application.trainingPrac.data.Board;
import com.application.trainingPrac.data.BoardDTO;
import com.application.trainingPrac.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createBoard(BoardDTO boardDTO) { // dto(글 내용) 받기만 함 ( 데이터 생성)
		boardDTO.setPasswd(passwordEncoder.encode(boardDTO.getPasswd()));
		boardDTO.setEnrollAt(new Date());
		
		boardRepository.save(BoardMapper.toEntity(boardDTO));
	}

	@Override
	public List<BoardDTO> getBoardList() { // 받을건 없고 list를 줌
		return BoardMapper.toDTOList(boardRepository.findAll());
	}

	@Override
	public BoardDTO getBoardDetail(Long boardId) { // id 받으면(클릭) DTO( + 조회수) 줌
		Board board = boardRepository.findById(boardId).orElse(null);
		
		board.setReadCnt(board.getReadCnt() + 1);
		boardRepository.save(board);
		
		return BoardMapper.toDTO(boardRepository.findById(boardId).orElse(null));
	}

	@Override
	public boolean checkAuthorizedUser(BoardDTO boardDTO) { // DTO(패스워드) 를 받으면 인증해줌
		
		boolean isAuthorizedUser = false;
		
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		board.getPasswd();
		
		if (passwordEncoder.matches(boardDTO.getPasswd(), board.getPasswd())) {
			isAuthorizedUser = true;
		}
		
		return isAuthorizedUser;
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) { // DTO(제목 + 내용)를 받음 ( 업데이트 )
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		board.setContent(boardDTO.getContent());
		board.setSubject(boardDTO.getSubject());
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) { // id(삭제할 게시물)를 받음 ( 삭제 )
		boardRepository.deleteById(boardId);
	}
}
