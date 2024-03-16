package com.application.trainingVer2.member.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.trainingVer2.member.data.Member;
import com.application.trainingVer2.member.data.MemberDTO;

public interface MemberRepositoryCustom {

	public String checkValidId(@Param("memberId") String memberId);
	public MemberDTO login(@Param("memberId") String memberId);
	public long getTodayNewMemberCnt(@Param("today") String today);
	public List<Member> getInActiveMemberList();
	
}
