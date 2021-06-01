package org.nrk.service;

import java.util.List;

import org.nrk.domain.PlayingBoardVO;
import org.nrk.mapper.HomeMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {
	private HomeMapper mapper;

	@Override
	public List<PlayingBoardVO> getList() {
		log.info("get List");
		return mapper.getListWithPaging();
	}

	@Override
	public List<PlayingBoardVO> getList2() {
		log.info("get List2");
		return mapper.getListWithPaging2();
	}

	@Override
	public List<PlayingBoardVO> getList3() {
		log.info("get List2");
		return mapper.getListWithPaging3();
	}
	
}
