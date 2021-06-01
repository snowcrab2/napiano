package org.nrk.service;

import java.util.List;

import org.nrk.domain.BoardAttachVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.SheetBoardVO;

public interface SheetBoardService {
	// �۾���
	public void register(SheetBoardVO sboard);
	
	// �󼼳���
	public SheetBoardVO get(int bno);
	
	// ����
	public boolean modify(SheetBoardVO sboard);
	
	// ����
	public boolean remove(int bno);
	
	// ���, ����¡
	public List<SheetBoardVO> getList(Criteria cri);
	
	// �� �Խñ� ��
	public int getTotal(Criteria cri);
	
	// ÷������
	public List<BoardAttachVO> getAttachList(int bno);
}
