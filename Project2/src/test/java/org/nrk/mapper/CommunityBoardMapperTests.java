package org.nrk.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommunityBoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private CommunityBoardMapper mapper;
	
	/*
	@Test
	public void testGetList() {
		mapper.getList().forEach(cboard -> log.info(cboard));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<CommunityBoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(cboard -> log.info(cboard));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("ÇÇ¾Æ³ë");
		cri.setType("T");
		
		List<CommunityBoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(cboard -> log.info(cboard));
	}
	*/
	
}
