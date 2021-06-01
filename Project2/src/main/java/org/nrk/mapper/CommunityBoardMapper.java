package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;

public interface CommunityBoardMapper {
	// �Խù� ����Ʈ
	public List<CommunityBoardVO> getList();
	
	// �Խù� ����¡
	public List<CommunityBoardVO> getListWithPaging(Criteria cri);
	
	// �Խñ� ���
	public void insert(CommunityBoardVO cboard);
	public void insertSelectKey(CommunityBoardVO cboard);
	
	// �Խù� �󼼳���
	public CommunityBoardVO read(int bno);
	
	// �Խù� ����
	public int delete(int bno);
	
	// �Խù� ����
	public int update(CommunityBoardVO cboard);
	
	// �Խñ� ��ȸ��
	public void cboardHit(int bno);
	
	// �� �Խñ� ��
	public int getTotalCount(Criteria cri);
	
	// ��õ
	public void recommend(int bno);
	
	// ��� ��
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
