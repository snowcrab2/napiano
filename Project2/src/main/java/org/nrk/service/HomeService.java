package org.nrk.service;

import java.util.List;

import org.nrk.domain.PlayingBoardVO;

public interface HomeService {
	// 연주영상 목록1
	public List<PlayingBoardVO> getList();
	// 연주영상 목록2
	public List<PlayingBoardVO> getList2();
	
	// 클래스 리스트
	public List<PlayingBoardVO> getList3();
}
