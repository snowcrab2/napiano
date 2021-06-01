package org.nrk.controller;

import org.nrk.domain.Criteria;
import org.nrk.domain.ReplyPageDTO;
import org.nrk.domain.ReplyVO;
import org.nrk.service.SheetReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/sreplies/")
@RestController
@Log4j
@AllArgsConstructor
public class SheetReplyController {
	private SheetReplyService service;
	
	// ��� ��� (POST���)
	@PostMapping(value="/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO: " + vo);
		int insertCount = service.register(vo);
		log.info("Reply INSERT COUNT: " +insertCount);
			
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// ��� ���(GET���)
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getListPage(@PathVariable("page") int page, @PathVariable("bno") int bno){
		Criteria cri = new Criteria(page, 10);
		log.info("get Reply List bno: " + bno);
		log.info("cri: " + cri);
			
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	// ��� ��ȸ(GET���)
	@GetMapping(value = "/{rno}",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		log.info("get: " + rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	// ��� ����(DELETE���)
	@DeleteMapping(value = "/{rno}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		log.info("remove: " + rno);
		return service.remove(rno) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// ��� ����(PUT���)
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") int rno){
		vo.setRno(rno);
		log.info("rno: " + rno);
		log.info("modify: " + vo);
		return service.modify(vo) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}