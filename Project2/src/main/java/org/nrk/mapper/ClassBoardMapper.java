package org.nrk.mapper;

import java.util.List;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;

public interface ClassBoardMapper {
	// 게시물 리스트,페이징
	public List<ClassBoardVO> getListWithPaging(Criteria cri);
		
	// 게시글 등록
	public void insert(ClassBoardVO oboard);
	public void insertSelectKey(ClassBoardVO oboard);
			
	// 게시물 상세내용
	public ClassBoardVO read(int bno);
		
	// 게시물 삭제
	public int delete(int bno);
			
	// 게시물 수정
	public int update(ClassBoardVO oboard);
		
	// 총 게시글 수
	public int getTotalCount(Criteria cri);
	
	// 추천
	public void recommend(int bno);
}
