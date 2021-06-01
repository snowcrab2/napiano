package org.nrk.service;

import org.nrk.domain.MembershipVO;

public interface MembershipService {
	// ȸ������
	public void register(MembershipVO member);
	
	// �α���
	public MembershipVO login(MembershipVO member);
	
	// ȸ������ �󼼳���
	public MembershipVO get(String id);
	
	// ȸ������ ����
	public boolean modify(MembershipVO mboard);
	
	// ȸ��Ż��
	public boolean remove(String id);
	
	// ���̵� �ߺ�Ȯ��
	public int checkID(MembershipVO member);
}
