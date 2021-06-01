package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyVO;

public interface PlayingReplyMapper {
	// ��� ���
	public int insert(ReplyVO vo);
		
	// ��� ��ȸ
	public ReplyVO read(int rno);
		
	// ��� ����
	public int delete(int rno);
		
	// ��� ����
	public int update(ReplyVO vo);
		
	// ��� ���
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);
		
	// ��� ��
	public int getCountByBno(int bno);
}
