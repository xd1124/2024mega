package com.application.trainingVer2.member.repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.application.trainingVer2.member.data.Member;
import com.application.trainingVer2.member.data.MemberDTO;
import com.application.trainingVer2.member.data.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

	private final JPAQueryFactory queryFactory;
	
	QMember member = QMember.member;
	
	@Override
	public String checkValidId(String memberId) {
		return queryFactory
				.select(member.memberId)
				.from(member)
				.where(member.memberId.eq(memberId))
				.fetchOne();
	}

	@Override
	public MemberDTO login(String memberId) {
		Tuple result =  queryFactory
						.select(member.passwd,member.activeYn)
						.from(member)
						.where(member.memberId.eq(memberId))
						.fetchOne();
		
		MemberDTO memberDTO  = new MemberDTO();
		memberDTO.setPasswd(result.get(member.passwd));
		memberDTO.setActiveYn(result.get(member.activeYn));
		
		return memberDTO;
		
	}

	@Override
	public long getTodayNewMemberCnt(String today) {
		
		return queryFactory
			   .select(member.memberId.count())
			   .from(member)
			   .where(Expressions.stringTemplate("DATE_FORMAT({0}, {1})", member.joinAt, "%Y-%m-%d").eq(today))
			   .fetchOne();
	}

	@Override
	public List<Member> getInActiveMemberList() {
		
		LocalDate temp = LocalDate.now().minusDays(90);
		Date daysAgo90 = Date.from(temp.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		List<Tuple> tuples = queryFactory
						        .select(member.memberId , member.profileUuid)
						        .from(member)
						        .where(member.inactiveAt.before(daysAgo90))
						        .fetch();
	
		List<Member> members = new ArrayList<Member>();
		
		for (Tuple tuple : tuples) {
			Member entity = new Member();
			entity.setMemberId(tuple.get(member.memberId));
			entity.setProfileUuid(tuple.get(member.profileUuid));
			members.add(entity);
		}
		
		return members;
		
	}

}
