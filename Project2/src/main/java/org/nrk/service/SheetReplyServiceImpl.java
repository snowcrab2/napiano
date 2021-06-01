package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyPageDTO;
import org.nrk.domain.ReplyVO;
import org.nrk.mapper.SheetBoardMapper;
import org.nrk.mapper.SheetReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SheetReplyServiceImpl implements SheetReplyService {
	@Setter(onMethod_ = @Autowired)
	private SheetReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private SheetBoardMapper boardmapper;

	// ��۾��� ������
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("register........" + vo);
		boardmapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	// ��� �󼼳��� ������
	@Override
	public ReplyVO get(int rno) {
		log.info("get........." + rno);
		return mapper.read(rno);
	}

	// ��� ���� ������
	@Override
	public int modify(ReplyVO vo) {
		log.info("modify........." + vo);
		return mapper.update(vo);
	}

	// ��� ���� ������
	@Transactional
	@Override
	public int remove(int rno) {
		log.info("remove............" + rno);
		ReplyVO vo = mapper.read(rno);
		boardmapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	// ��� ��� ������
	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	// ��� �� ������
	@Override
	public ReplyPageDTO getListPage(Criteria cri, int bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
}
