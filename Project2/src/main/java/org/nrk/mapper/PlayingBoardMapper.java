package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.Criteria;
import org.nrk.domain.PlayingBoardVO;

public interface PlayingBoardMapper {
	// 게시물 리스트,페이징
	public List<PlayingBoardVO> getListWithPaging(Criteria cri);
		
	// 게시글 등록
	public void insert(PlayingBoardVO pboard);
	public void insertSelectKey(PlayingBoardVO pboard);
		
	// 게시물 상세내용
	public PlayingBoardVO read(int bno);
		
	// 게시물 삭제
	public int delete(int bno);
		
	// 게시물 수정
	public int update(PlayingBoardVO pboard);
		
	// 게시글 조회수
	public void pboardHit(int bno);
		
	// 총 게시글 수
	public int getTotalCount(Criteria cri);
		
	// 추천
	public void recommend(int bno);
		
	// 댓글 수
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
