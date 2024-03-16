package com.application.trainingPrac.data;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private long boardId;
	private String passwd;
	private String content;
	private String writer;
	private String subject;
	private long readCnt;
	private Date enrollAt;
	
}
