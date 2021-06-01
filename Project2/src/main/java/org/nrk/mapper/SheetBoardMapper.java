package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.SheetBoardVO;

public interface SheetBoardMapper {
	// 게시물 리스트와 페이징
	public List<SheetBoardVO> getListWithPaging(Criteria cri);
	
	// 게시글 등록
	public void insert(SheetBoardVO sboard);
	public void insertSelectKey(SheetBoardVO sboard);
	
	// 게시물 상세내용
	public SheetBoardVO read(int bno);
	
	// 게시물 삭제
	public int delete(int bno);
		
	// 게시물 수정
	public int update(SheetBoardVO sboard);
	
	// 게시글 조회수
	public void sboardHit(int bno);
		
	// 총 게시글 수
	public int getTotalCount(Criteria cri);
		
	// 댓글 수
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
