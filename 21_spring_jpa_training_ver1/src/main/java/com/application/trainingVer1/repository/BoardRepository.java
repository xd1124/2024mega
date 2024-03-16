package com.application.trainingVer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.trainingVer1.data.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	
}
