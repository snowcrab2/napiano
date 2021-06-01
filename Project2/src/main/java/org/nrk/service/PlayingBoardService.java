package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.PlayingBoardVO;

public interface PlayingBoardService {
	// 글쓰기
	public void register(PlayingBoardVO cboard);
		
	// 상세내용
	public PlayingBoardVO get(int bno);
		
	// 수정
	public boolean modify(PlayingBoardVO cboard);
		
	// 삭제
	public boolean remove(int bno);
		
	// 목록, 페이징
	public List<PlayingBoardVO> getList(Criteria cri);
		
	// 총 게시글 수
	public int getTotal(Criteria cri);
		
	// 추천
	public void recommend(int bno);
}
