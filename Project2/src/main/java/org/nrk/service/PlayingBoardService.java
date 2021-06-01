package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.PlayingBoardVO;

public interface PlayingBoardService {
	// �۾���
	public void register(PlayingBoardVO cboard);
		
	// �󼼳���
	public PlayingBoardVO get(int bno);
		
	// ����
	public boolean modify(PlayingBoardVO cboard);
		
	// ����
	public boolean remove(int bno);
		
	// ���, ����¡
	public List<PlayingBoardVO> getList(Criteria cri);
		
	// �� �Խñ� ��
	public int getTotal(Criteria cri);
		
	// ��õ
	public void recommend(int bno);
}
