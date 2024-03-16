package com.application.trainingVer2.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.trainingVer2.member.data.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> , MemberRepositoryCustom{

	
}
