package org.nrk.mapper;

import java.util.List;

import org.nrk.domain.PlayingBoardVO;

public interface HomeMapper {
	// ����Ʈ 1
	public List<PlayingBoardVO> getListWithPaging();
	
	// ����Ʈ 2
	public List<PlayingBoardVO> getListWithPaging2();
	
	// Ŭ���� ����Ʈ 
	public List<PlayingBoardVO> getListWithPaging3();
}
