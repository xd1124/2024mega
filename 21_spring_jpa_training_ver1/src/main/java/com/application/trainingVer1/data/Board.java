package com.application.trainingVer1.data;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity  		// 해당 클래스가 JPA 엔티티임을 나타낸다.
@Data    		// getter, setter, toString, equals, hashCode 메소드를 자동으로 생성해 준다.
@DynamicUpdate  // 변경이 감지된 데이터만 업데이트한다.
public class Board {
	
	@Id  // 엔티티의 기본 키를 나타낸다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 값을 데이터베이스가 자동으로 생성해준다.
	private Long boardId;
	
	@Column(nullable = false)   // 해당 필드가 데이터베이스 컬럼으로 매핑되며 null 값을 허용하지 않음을 나타낸다.
	private String passwd;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Long readCnt;
	
	@Column(nullable = false)
	private Date enrollAt;
	
}
