package org.nrk.controller;

import org.nrk.domain.Criteria;
import org.nrk.domain.PageDTO;
import org.nrk.domain.PlayingBoardVO;
import org.nrk.service.PlayingBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/playing/*")
@AllArgsConstructor
public class PlayingBoardController {
	private PlayingBoardService service;
	
	// 글 목록
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		// 카테고리별 select해서 model에 저장
		model.addAttribute("list", service.getList(cri));
			
		// 총 게시글 수 구하기
		int total = service.getTotal(cri);
		log.info("total: " + total);
		// 페이징하기
		model.addAttribute("pageMaker", new PageDTO(cri, total));
			
	}
		
	// 글 작성 페이지 보여주기
	@GetMapping("/register")
	public void register() {
			
	}
		
	// 글 작성
	@PostMapping("/register")
	public String register(PlayingBoardVO pboard, RedirectAttributes rttr) {
		log.info("register: " + pboard);
		service.register(pboard);
		rttr.addFlashAttribute("result", pboard.getBno());
		return "redirect:/playing/list";
	}
		
	// 글 상세내용
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("pboard", service.get(bno));
	}
		
	// 글 수정
	@PostMapping("/modify")
	public String modify(PlayingBoardVO pboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + pboard);
			
		if(service.modify(pboard)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/playing/list" + cri.getListLink();
	}
		
	// 글 삭제
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove: " + bno);
			
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/playing/list" + cri.getListLink();
	}
		
	// 게시글 추천
	@RequestMapping("/recommend")
	public String recommend(@RequestParam("bno") int bno) {
		service.recommend(bno);
		return "forward:/playing/get";
	}
}
