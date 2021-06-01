package org.nrk.mapper;

import org.nrk.domain.MembershipVO;

public interface MembershipMapper {
	// 회원가입
	public void insert(MembershipVO member);
	
	// 로그인
	public MembershipVO login(MembershipVO member);
	
	// 회원정보 상세내용
	public MembershipVO read(String id);
	
	// 회원정보 수정
	public int update(MembershipVO mboard);
	
	// 회원탈퇴
	public int delete(String id);
	
	// 아이디 중복확인
	public int emailChk(MembershipVO member);
}
