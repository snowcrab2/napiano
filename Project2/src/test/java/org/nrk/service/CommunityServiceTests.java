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
		
		cboard.setCategory("���");
		cboard.setTitle("���� �ۼ��ϴ� ��");
		cboard.setContent("���� �ۼ��ϴ� ����");
		cboard.setWriter("newbie");
		
		service.register(cboard);
		log.info("������ �Խù��� ��ȣ : " + cboard.getBno());
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
		cboard.setTitle("��������");
		log.info("Modify result : " + service.modify(cboard));
	}
	*/
}
