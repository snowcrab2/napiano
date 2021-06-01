package org.nrk.service;

import java.util.List;

import org.nrk.domain.BoardAttachVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.SheetBoardVO;
import org.nrk.mapper.BoardAttachMapper;
import org.nrk.mapper.SheetBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SheetBoardServiceImpl implements SheetBoardService {
	@Setter(onMethod_ = @Autowired)
	private SheetBoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;

	// �� �ۼ�
	@Transactional
	@Override
	public void register(SheetBoardVO sboard) {
		/*
		log.info("register..........");
		mapper.insertSelectKey(sboard);
		*/
		log.info("register............." + sboard);
		mapper.insertSelectKey(sboard);
		
		if(sboard.getAttachList() == null|| sboard.getAttachList().size() <= 0) {
			return;
		}
		
		sboard.getAttachList().forEach(attach ->{
			attach.setBno(sboard.getBno());
			attachMapper.insert(attach);
		});
	}

	// �� �󼼳��� 
	@Override
	public SheetBoardVO get(int bno) {
		log.info("get............." + bno);
		mapper.sboardHit(bno);
		return mapper.read(bno);
	}

	// �ۼ���
	@Override
	public boolean modify(SheetBoardVO sboard) {
		log.info("modify..........");
		return mapper.update(sboard) == 1;
	}

	// �ۻ���
	@Transactional
	@Override
	public boolean remove(int bno) {
		log.info("remove..........");
		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}

	// �۸��
	@Override
	public List<SheetBoardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		return mapper.getListWithPaging(cri);
	}

	// �� �Խù� ��
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	// ÷������ ��ȸ
	@Override
	public List<BoardAttachVO> getAttachList(int bno) {
		log.info("get Attach list by bno" + bno);
		
		return attachMapper.findByBno(bno);
	}

}
