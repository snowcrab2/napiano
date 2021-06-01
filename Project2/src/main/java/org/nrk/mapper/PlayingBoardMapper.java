package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.PlayingBoardVO;

public interface PlayingBoardMapper {
	// �Խù� ����Ʈ,����¡
	public List<PlayingBoardVO> getListWithPaging(Criteria cri);
		
	// �Խñ� ���
	public void insert(PlayingBoardVO pboard);
	public void insertSelectKey(PlayingBoardVO pboard);
		
	// �Խù� �󼼳���
	public PlayingBoardVO read(int bno);
		
	// �Խù� ����
	public int delete(int bno);
		
	// �Խù� ����
	public int update(PlayingBoardVO pboard);
		
	// �Խñ� ��ȸ��
	public void pboardHit(int bno);
		
	// �� �Խñ� ��
	public int getTotalCount(Criteria cri);
		
	// ��õ
	public void recommend(int bno);
		
	// ��� ��
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
