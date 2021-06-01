package org.nrk.service;

import java.util.List;

import org.nrk.domain.BoardAttachVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.SheetBoardVO;

public interface SheetBoardService {
	// 글쓰기
	public void register(SheetBoardVO sboard);
	
	// 상세내용
	public SheetBoardVO get(int bno);
	
	// 수정
	public boolean modify(SheetBoardVO sboard);
	
	// 삭제
	public boolean remove(int bno);
	
	// 목록, 페이징
	public List<SheetBoardVO> getList(Criteria cri);
	
	// 총 게시글 수
	public int getTotal(Criteria cri);
	
	// 첨부파일
	public List<BoardAttachVO> getAttachList(int bno);
}
