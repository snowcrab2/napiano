package org.nrk.service;

import java.util.List;

import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;

public interface CommunityService {
	// 글쓰기
	public void register(CommunityBoardVO cboard);
	
	// 상세내용
	public CommunityBoardVO get(int bno);
	
	// 수정
	public boolean modify(CommunityBoardVO cboard);
	
	// 삭제
	public boolean remove(int bno);
	
	// 목록, 페이징
	public List<CommunityBoardVO> getList(Criteria cri);
	
	// 총 게시글 수
	public int getTotal(Criteria cri);
	
	// 추천
	public void recommend(int bno);
}
