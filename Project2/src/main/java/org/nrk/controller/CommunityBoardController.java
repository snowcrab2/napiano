package org.nrk.controller;

import org.nrk.domain.CommunityBoardVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.PageDTO;
import org.nrk.service.CommunityService;
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
@RequestMapping("/community/*")
@AllArgsConstructor
public class CommunityBoardController {
	private CommunityService service;
	
	// �� ���
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
	}
	
	// �� �ۼ� ������ �����ֱ�
	@GetMapping("/register")
	public void register() {
		
	}
	
	// �� �ۼ�
	@PostMapping("/register")
	public String register(CommunityBoardVO cboard, RedirectAttributes rttr) {
		log.info("register: " + cboard);
		service.register(cboard);
		rttr.addFlashAttribute("result", cboard.getBno());
		return "redirect:/community/list";
	}
	
	// �� �󼼳���
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("cboard", service.get(bno));
	}
	
	// �� ����
	@PostMapping("/modify")
	public String modify(CommunityBoardVO cboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + cboard);
		
		if(service.modify(cboard)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/community/list" + cri.getListLink();
	}
	
	// �� ����
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove: " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/community/list" + cri.getListLink();
	}
	
	// �Խñ� ��õ
	@RequestMapping("/recommend")
	public String recommend(@RequestParam("bno") int bno) {
		service.recommend(bno);
		return "forward:/community/get";
	}
}
