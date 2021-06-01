package org.nrk.service;

import java.util.List;

import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;

public interface CommunityService {
	// �۾���
	public void register(CommunityBoardVO cboard);
	
	// �󼼳���
	public CommunityBoardVO get(int bno);
	
	// ����
	public boolean modify(CommunityBoardVO cboard);
	
	// ����
	public boolean remove(int bno);
	
	// ���, ����¡
	public List<CommunityBoardVO> getList(Criteria cri);
	
	// �� �Խñ� ��
	public int getTotal(Criteria cri);
	
	// ��õ
	public void recommend(int bno);
}
