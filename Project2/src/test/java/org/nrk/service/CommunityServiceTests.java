package org.nrk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nrk.domain.CommunityBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommunityServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private CommunityService service;
	/*
	@Test
	public void testRegister() {
		CommunityBoardVO cboard = new CommunityBoardVO();
		
		cboard.setCategory("잡담");
		cboard.setTitle("새로 작성하는 글");
		cboard.setContent("새로 작성하는 내용");
		cboard.setWriter("newbie");
		
		service.register(cboard);
		log.info("생성된 게시물의 번호 : " + cboard.getBno());
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(cboard -> log.info(cboard));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1));
	}
	
	@Test
	public void testDelete() {
		log.info("Remove result : " + service.remove(5));
	}
	
	@Test
	public void testUpdate() {
		CommunityBoardVO cboard = new CommunityBoardVO();
		if(cboard == null) return;
		cboard.setTitle("수정ㅇㅇ");
		log.info("Modify result : " + service.modify(cboard));
	}
	*/
}
