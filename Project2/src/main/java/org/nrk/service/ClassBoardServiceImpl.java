package org.nrk.service;

import java.util.List;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;
import org.nrk.mapper.ClassBoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ClassBoardServiceImpl implements ClassBoardService{
	private ClassBoardMapper mapper;

	@Override
	public void register(ClassBoardVO oboard) {
		log.info("register..........");
		mapper.insertSelectKey(oboard);
	}

	@Override
	public ClassBoardVO get(int bno) {
		log.info("get............." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(ClassBoardVO oboard) {
		log.info("modify..........");
		return mapper.update(oboard) == 1;
	}

	@Override
	public boolean remove(int bno) {
		log.info("remove..........");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<ClassBoardVO> getList(Criteria cri) {
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
