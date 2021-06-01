package org.nrk.mapper;

import org.nrk.domain.MembershipVO;

public interface MembershipMapper {
	// ȸ������
	public void insert(MembershipVO member);
	
	// �α���
	public MembershipVO login(MembershipVO member);
	
	// ȸ������ �󼼳���
	public MembershipVO read(String id);
	
	// ȸ������ ����
	public int update(MembershipVO mboard);
	
	// ȸ��Ż��
	public int delete(String id);
	
	// ���̵� �ߺ�Ȯ��
	public int emailChk(MembershipVO member);
}
