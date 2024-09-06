package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13MemberDao;
import com.mycompany.springframework.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch13MemberService {
	public enum JoinResult{
		SUCCESS,
		FAIL_DUPLICATED_MID,
	}
	
	public enum LoginResult{
		SUCCESS,
		FAIL_MID,
		FAIL_MPASSWORD,
		FAIL_ENABLED
	}
	
	@Resource
	private Ch13MemberDao memberDao;
	
	//컨트롤러에서 form유효성 검사후 service에서 비지니스 로직 처리
	public JoinResult join(Ch13Member member) {
		boolean exist = isMid(member.getMid());
		if(exist) {
			return JoinResult.FAIL_DUPLICATED_MID;
		}
		memberDao.insert(member);
		return JoinResult.SUCCESS;
	}
	
	public boolean isMid(String mid) {
		Ch13Member member = memberDao.selectByMid(mid);
		if(member==null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public LoginResult login(Ch13Member member) {
		Ch13Member dbmember = memberDao.selectByMid(member.getMid());
		if(dbmember==null) {
			return LoginResult.FAIL_MID;
		}
		if(!dbmember.isMenabled()) {
			return LoginResult.FAIL_ENABLED;
		}
		if(!dbmember.getMpassword().equals(member.getMpassword())) {
			return LoginResult.FAIL_MPASSWORD;
		}
		return LoginResult.SUCCESS;
	}
	
	public void logout(String mid) {
		
	}
	
}
