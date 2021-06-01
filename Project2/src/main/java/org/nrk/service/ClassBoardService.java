package org.nrk.service;

import java.util.List;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;

public interface ClassBoardService {
	// �۾���
	public void register(ClassBoardVO oboard);
			
	// �󼼳���
	public ClassBoardVO get(int bno);
			
	// ����
	public boolean modify(ClassBoardVO oboard);
		
	// ����
	public boolean remove(int bno);
			
	// ���, ����¡
	public List<ClassBoardVO> getList(Criteria cri);
			
	// �� �Խñ� ��
	public int getTotal(Criteria cri);
	
	// ��õ
	public void recommend(int bno);

}