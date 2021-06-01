package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyPageDTO;
import org.nrk.domain.ReplyVO;

public interface CommunityReplyService {
	// ����
	public int register(ReplyVO vo);
	
	// �󼼳���
	public ReplyVO get(int rno);
	
	// ����
	public int modify(ReplyVO vo);
	
	// ����
	public int remove(int rno);
	
	// ���
	public List<ReplyVO> getList(Criteria cri, int bno);
	
	// ��� ��
	public ReplyPageDTO getListPage(Criteria cri, int bno);
}
