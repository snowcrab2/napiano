package org.nrk.mapper;

import java.util.List;

import org.nrk.domain.PlayingBoardVO;

public interface HomeMapper {
	// 리스트 1
	public List<PlayingBoardVO> getListWithPaging();
	
	// 리스트 2
	public List<PlayingBoardVO> getListWithPaging2();
	
	// 클래스 리스트 
	public List<PlayingBoardVO> getListWithPaging3();
}
