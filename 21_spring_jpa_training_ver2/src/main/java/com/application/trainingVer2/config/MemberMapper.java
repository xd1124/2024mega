package com.application.trainingVer2.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.trainingVer2.member.data.Member;
import com.application.trainingVer2.member.data.MemberDTO;

public class MemberMapper {

	public static Member toEntity(MemberDTO memberDTO) {
		
		Member entity = new Member();
		entity.setMemberId(memberDTO.getMemberId());
		entity.setPasswd(memberDTO.getPasswd());
		entity.setProfileOriginalName(memberDTO.getProfileOriginalName());
		entity.setProfileUuid(memberDTO.getProfileUuid());
		entity.setMemberNm(memberDTO.getMemberNm());
		entity.setSex(memberDTO.getSex());
		entity.setBirthAt(memberDTO.getBirthAt());
		entity.setHp(memberDTO.getHp());
		entity.setSmsstsYn(memberDTO.getSmsstsYn());
		entity.setEmail(memberDTO.getEmail());
		entity.setEmailstsYn(memberDTO.getEmailstsYn());
		entity.setZipcode(memberDTO.getZipcode());
		entity.setRoadAddress(memberDTO.getRoadAddress());
		entity.setJibunAddress(memberDTO.getJibunAddress());
		entity.setNamujiAddress(memberDTO.getNamujiAddress());
		entity.setEtc(memberDTO.getEtc());
		entity.setActiveYn(memberDTO.getActiveYn());
		entity.setInactiveAt(memberDTO.getInactiveAt());
		entity.setJoinAt(memberDTO.getJoinAt());
		return entity;
		
	} 
	
	public static MemberDTO toDTO(Member entity) {
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(entity.getMemberId());
		dto.setPasswd(entity.getPasswd());
		dto.setProfileOriginalName(entity.getProfileOriginalName());
		dto.setProfileUuid(entity.getProfileUuid());
		dto.setMemberNm(entity.getMemberNm());
		dto.setSex(entity.getSex());
		dto.setBirthAt(entity.getBirthAt());
		dto.setHp(entity.getHp());
		dto.setSmsstsYn(entity.getSmsstsYn());
		dto.setEmail(entity.getEmail());
		dto.setEmailstsYn(entity.getEmailstsYn());
		dto.setZipcode(entity.getZipcode());
		dto.setRoadAddress(entity.getRoadAddress());
		dto.setJibunAddress(entity.getJibunAddress());
		dto.setNamujiAddress(entity.getNamujiAddress());
		dto.setEtc(entity.getEtc());
		dto.setActiveYn(entity.getActiveYn());
		dto.setInactiveAt(entity.getInactiveAt());
		dto.setJoinAt(entity.getJoinAt());
		
		return dto;
		
	} 
	
	public static List<MemberDTO> toDTOList(List<Member> members) {
		return members.stream().map(MemberMapper::toDTO).collect(Collectors.toList());
	}
	
}


