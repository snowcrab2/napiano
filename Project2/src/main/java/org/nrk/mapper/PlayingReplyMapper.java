package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyVO;

public interface PlayingReplyMapper {
	// ´ñ±Û µî·Ï
	public int insert(ReplyVO vo);
		
	// ´ñ±Û Á¶È¸
	public ReplyVO read(int rno);
		
	// ´ñ±Û »èÁ¦
	public int delete(int rno);
		
	// ´ñ±Û ¼öÁ¤
	public int update(ReplyVO vo);
		
	// ´ñ±Û ¸ñ·Ï
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);
		
	// ´ñ±Û ¼ö
	public int getCountByBno(int bno);
}
