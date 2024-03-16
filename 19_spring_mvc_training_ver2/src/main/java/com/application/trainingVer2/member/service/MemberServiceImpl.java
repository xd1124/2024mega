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

import com.application.trainingVer2.member.dao.MemberDAO;
import com.application.trainingVer2.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Value("${file.repo.path}")
    private String fileRepositoryPath;
	
	@Autowired
	private MemberDAO memberDAO;
	
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
			memberDTO.setProfileUUID(uploadFile);
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));
			
		}
		
		if (memberDTO.getSmsstsYn() == null)   memberDTO.setSmsstsYn("n");
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");
		
		memberDTO.setPasswd(passwordEncoder.encode(memberDTO.getPasswd())); 
		memberDAO.createMember(memberDTO);
	}

	
	@Override
	public String checkValidId(String memberId)  {
		
		String isValidId = "y";
		if (memberDAO.checkValidId(memberId) != null) {
			isValidId = "n";
		}
		
		return isValidId;
		
	}
	
	
	@Override
	public boolean login(MemberDTO memberDTO)  {
		
		MemberDTO validateData = memberDAO.login(memberDTO.getMemberId());
		
		if (validateData != null) {
			if (passwordEncoder.matches(memberDTO.getPasswd() , validateData.getPasswd()) && !validateData.getActiveYn().equals("n")) {
				return true;
			} 
		}
		
		return false;
		
	}
	
	
	@Override
	public MemberDTO getMemberDetail(String memberId)  {
		return memberDAO.getMemberDetail(memberId);
	}
	
	
	@Override
	public void updateMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) {
			
			new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete();
			
			String originalFilename = uploadProfile.getOriginalFilename();
			memberDTO.setProfileOriginalName(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			memberDTO.setProfileUUID(uploadFile);
			
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));
			
		}
		
		memberDAO.updateMember(memberDTO);
	
	}
	
	
	@Override
	public void updateInactiveMember(String memberId)  {
		memberDAO.updateInactiveMember(memberId);
	}

	
	@Override
	@Scheduled(cron="59 59 23 * * *")
	public void getTodayNewMemberCnt()  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		logger.info("(" + today + ") 신규회원수 : " + memberDAO.getTodayNewMemberCnt(today));
	}
	
	
	@Override
	@Scheduled(cron="59 59 23 * * *")
	public void deleteMemberScheduler()  {
		List<MemberDTO> deleteMemberList = memberDAO.getInActiveMemberList();
		if (!deleteMemberList.isEmpty()) {
			for (MemberDTO memberDTO : deleteMemberList) {
				new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete();
				memberDAO.deleteMember(memberDTO.getMemberId());
			}
		}
	}
	
}
