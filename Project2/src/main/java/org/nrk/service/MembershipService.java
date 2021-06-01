package org.nrk.service;

import org.nrk.domain.MembershipVO;

public interface MembershipService {
	// 회원가입
	public void register(MembershipVO member);
	
	// 로그인
	public MembershipVO login(MembershipVO member);
	
	// 회원정보 상세내용
	public MembershipVO get(String id);
	
	// 회원정보 수정
	public boolean modify(MembershipVO mboard);
	
	// 회원탈퇴
	public boolean remove(String id);
	
	// 아이디 중복확인
	public int checkID(MembershipVO member);
}
