package org.nrk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;

public interface CommunityBoardMapper {
	// 게시물 리스트
	public List<CommunityBoardVO> getList();
	
	// 게시물 페이징
	public List<CommunityBoardVO> getListWithPaging(Criteria cri);
	
	// 게시글 등록
	public void insert(CommunityBoardVO cboard);
	public void insertSelectKey(CommunityBoardVO cboard);
	
	// 게시물 상세내용
	public CommunityBoardVO read(int bno);
	
	// 게시물 삭제
	public int delete(int bno);
	
	// 게시물 수정
	public int update(CommunityBoardVO cboard);
	
	// 게시글 조회수
	public void cboardHit(int bno);
	
	// 총 게시글 수
	public int getTotalCount(Criteria cri);
	
	// 추천
	public void recommend(int bno);
	
	// 댓글 수
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
