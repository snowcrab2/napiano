package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.SheetBoardVO;

public interface SheetBoardMapper {
	// �Խù� ����Ʈ�� ����¡
	public List<SheetBoardVO> getListWithPaging(Criteria cri);
	
	// �Խñ� ���
	public void insert(SheetBoardVO sboard);
	public void insertSelectKey(SheetBoardVO sboard);
	
	// �Խù� �󼼳���
	public SheetBoardVO read(int bno);
	
	// �Խù� ����
	public int delete(int bno);
		
	// �Խù� ����
	public int update(SheetBoardVO sboard);
	
	// �Խñ� ��ȸ��
	public void sboardHit(int bno);
		
	// �� �Խñ� ��
	public int getTotalCount(Criteria cri);
		
	// ��� ��
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
