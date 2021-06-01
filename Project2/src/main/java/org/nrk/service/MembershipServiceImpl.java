package org.nrk.service;

import org.nrk.domain.MembershipVO;
import org.nrk.mapper.MembershipMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MembershipServiceImpl implements MembershipService{
	private MembershipMapper mapper;

	@Override
	public void register(MembershipVO member) {
		log.info("member register");
		mapper.insert(member);
		
	}

	@Override
	public MembershipVO login(MembershipVO member) {
		log.info("login: " + member);
		return mapper.login(member);
	}

	@Override
	public MembershipVO get(String id) {
		log.info("get............." + id);
		return mapper.read(id);
	}

	@Override
	public boolean modify(MembershipVO mboard) {
		log.info("modify..........");
		return mapper.update(mboard) == 1;
	}

	@Override
	public boolean remove(String id) {
		log.info("remove..........");
		return mapper.delete(id) == 1;
	}

	@Override
	public int checkID(MembershipVO member) {
		log.info("id check...........");
		return mapper.emailChk(member);
	}

}
