package org.nrk.service;

import java.util.List;

import org.nrk.domain.PlayingBoardVO;

public interface HomeService {
	// ���ֿ��� ���1
	public List<PlayingBoardVO> getList();
	// ���ֿ��� ���2
	public List<PlayingBoardVO> getList2();
	
	// Ŭ���� ����Ʈ
	public List<PlayingBoardVO> getList3();
}
