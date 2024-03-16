package com.application.trainingPrac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.trainingPrac.data.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
