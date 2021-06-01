package org.nrk.service;

import java.util.List;

import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;
import org.nrk.mapper.CommunityBoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	private CommunityBoardMapper mapper;

	// 글 작성
	@Override
	public void register(CommunityBoardVO cboard) {
		log.info("register..........");
		mapper.insertSelectKey(cboard);
	}

	// 글 상세내용
	@Override
	public CommunityBoardVO get(int bno) {
		log.info("get............." + bno);
		mapper.cboardHit(bno);
		return mapper.read(bno);
	}

	// 글수정
	@Override
	public boolean modify(CommunityBoardVO cboard) {
		log.info("modify..........");
		return mapper.update(cboard) == 1;
	}
	
	// 글삭제
	@Override
	public boolean remove(int bno) {
		log.info("remove..........");
		return mapper.delete(bno) == 1;
	}
	
	
	// 글목록
	@Override
	public List<CommunityBoardVO> getList(Criteria cri){
		log.info("get List with criteria: " + cri);
		return mapper.getListWithPaging(cri);
	}
	
	
	// 총 게시물 수
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	
	// 추천
	@Override
	public void recommend(int bno) {
		mapper.recommend(bno);
	}
	
	

}
