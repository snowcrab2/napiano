package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyPageDTO;
import org.nrk.domain.ReplyVO;

public interface CommunityReplyService {
	// 쓰기
	public int register(ReplyVO vo);
	
	// 상세내용
	public ReplyVO get(int rno);
	
	// 수정
	public int modify(ReplyVO vo);
	
	// 삭제
	public int remove(int rno);
	
	// 목록
	public List<ReplyVO> getList(Criteria cri, int bno);
	
	// 댓글 수
	public ReplyPageDTO getListPage(Criteria cri, int bno);
}
