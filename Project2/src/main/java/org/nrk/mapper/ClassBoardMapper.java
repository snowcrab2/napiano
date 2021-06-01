package org.nrk.mapper;

import java.util.List;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;

public interface ClassBoardMapper {
	// �Խù� ����Ʈ,����¡
	public List<ClassBoardVO> getListWithPaging(Criteria cri);
		
	// �Խñ� ���
	public void insert(ClassBoardVO oboard);
	public void insertSelectKey(ClassBoardVO oboard);
			
	// �Խù� �󼼳���
	public ClassBoardVO read(int bno);
		
	// �Խù� ����
	public int delete(int bno);
			
	// �Խù� ����
	public int update(ClassBoardVO oboard);
		
	// �� �Խñ� ��
	public int getTotalCount(Criteria cri);
	
	// ��õ
	public void recommend(int bno);
}
