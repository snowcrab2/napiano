package org.nrk.service;

import java.util.List;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;

public interface ClassBoardService {
	// 글쓰기
	public void register(ClassBoardVO oboard);
			
	// 상세내용
	public ClassBoardVO get(int bno);
			
	// 수정
	public boolean modify(ClassBoardVO oboard);
		
	// 삭제
	public boolean remove(int bno);
			
	// 목록, 페이징
	public List<ClassBoardVO> getList(Criteria cri);
			
	// 총 게시글 수
	public int getTotal(Criteria cri);
	
	// 추천
	public void recommend(int bno);

}