package org.nrk.service;

import java.util.List;

import org.nrk.domain.Criteria;
import org.nrk.domain.PlayingBoardVO;
import org.nrk.mapper.PlayingBoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PlayingBoardServiceImpl implements PlayingBoardService{
	private PlayingBoardMapper mapper;

	@Override
	public void register(PlayingBoardVO pboard) {
		log.info("register..........");
		mapper.insertSelectKey(pboard);
	}

	@Override
	public PlayingBoardVO get(int bno) {
		log.info("get............." + bno);
		mapper.pboardHit(bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(PlayingBoardVO pboard) {
		log.info("modify..........");
		return mapper.update(pboard) == 1;
	}

	@Override
	public boolean remove(int bno) {
		log.info("remove..........");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<PlayingBoardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public void recommend(int bno) {
		mapper.recommend(bno);
	}
}
