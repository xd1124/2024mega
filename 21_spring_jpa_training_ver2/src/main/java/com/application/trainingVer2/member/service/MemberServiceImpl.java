package com.application.trainingVer2.member.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.config.MemberMapper;
import com.application.trainingVer2.member.data.Member;
import com.application.trainingVer2.member.data.MemberDTO;
import com.application.trainingVer2.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Value("${file.repo.path}")
    private String fileRepositoryPath;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	
	@Override
	public void createMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) {
			String originalFilename = uploadProfile.getOriginalFilename();
			memberDTO.setProfileOriginalName(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			memberDTO.setProfileUuid(uploadFile);
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));
			
		}
		
		if (memberDTO.getSmsstsYn() == null)   memberDTO.setSmsstsYn("n");
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");
		
		memberDTO.setPasswd(passwordEncoder.encode(memberDTO.getPasswd())); 
		memberDTO.setActiveYn("y");
		memberDTO.setJoinAt(new Date());
		memberRepository.save(MemberMapper.toEntity(memberDTO));
	}

	
	@Override
	public String checkValidId(String memberId)  {
		
		String isValidId = "y";
		if (memberRepository.checkValidId(memberId) != null) {
			isValidId = "n";
		}
		
		return isValidId;
		
	}
	
	
	@Override
	public boolean login(MemberDTO memberDTO)  {
		
		MemberDTO validateData = memberRepository.login(memberDTO.getMemberId());
		if (validateData != null) {
			if (passwordEncoder.matches(memberDTO.getPasswd() , validateData.getPasswd()) && !validateData.getActiveYn().equals("n")) {
				return true;
			} 
		}
		
		return false;
		
	}
	
	
	@Override
	public MemberDTO getMemberDetail(String memberId)  {
		return MemberMapper.toDTO(memberRepository.findById(memberId).orElse(null));
	}
	
	
	@Override
	public void updateMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		Member member = memberRepository.findById(memberDTO.getMemberId()).orElse(null);
		
		if (!uploadProfile.isEmpty()) {
			
			new File(fileRepositoryPath + memberDTO.getProfileUuid()).delete();
			
			String originalFilename = uploadProfile.getOriginalFilename();
			memberDTO.setProfileOriginalName(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			memberDTO.setProfileUuid(uploadFile);
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));
			
		}
		member.setProfileOriginalName(memberDTO.getProfileOriginalName());
		member.setProfileUuid(memberDTO.getProfileUuid());
		member.setMemberNm(memberDTO.getMemberNm());
		member.setSex(memberDTO.getSex());
		member.setBirthAt(memberDTO.getBirthAt());
		member.setHp(memberDTO.getHp());
		member.setSmsstsYn(memberDTO.getSmsstsYn());
		member.setEmail(memberDTO.getEmail());
		member.setEmailstsYn(memberDTO.getEmailstsYn());
		member.setZipcode(memberDTO.getZipcode());
		member.setRoadAddress(memberDTO.getRoadAddress());
		member.setJibunAddress(memberDTO.getJibunAddress());
		member.setNamujiAddress(memberDTO.getNamujiAddress());
		member.setEtc(memberDTO.getEtc());
		memberRepository.save(member);
	
	}
	
	
	@Override
	public void updateInactiveMember(String memberId)  {
		Member member = memberRepository.findById(memberId).orElse(null);
		member.setActiveYn("n");
		member.setInactiveAt(new Date());
		memberRepository.save(member);
	}

	
	@Override
	@Scheduled(cron="59 59 23 * * *")
	public void getTodayNewMemberCnt()  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		logger.info("(" + today + ") 신규회원수 : " + memberRepository.getTodayNewMemberCnt(today));
	}
	
	
	@Override
	@Scheduled(cron="59 59 23 * * *")
	public void deleteMemberScheduler()  {
		List<Member> deleteMemberList = memberRepository.getInActiveMemberList();
		if (!deleteMemberList.isEmpty()) {
			for (Member member : deleteMemberList) {
				new File(fileRepositoryPath + member.getProfileUuid()).delete();
				memberRepository.deleteById(member.getMemberId());
			}
		}
	}
	
}
