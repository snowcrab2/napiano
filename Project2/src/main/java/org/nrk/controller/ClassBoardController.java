package org.nrk.controller;

import org.nrk.domain.ClassBoardVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.PageDTO;
import org.nrk.service.ClassBoardService;
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
@RequestMapping("/class/*")
@AllArgsConstructor
public class ClassBoardController {
	private ClassBoardService service;
	
	// �� ���
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		// ī�װ��� select�ؼ� model�� ����
		model.addAttribute("list", service.getList(cri));
				
		// �� �Խñ� �� ���ϱ�
		int total = service.getTotal(cri);
		log.info("total: " + total);
		// ����¡�ϱ�
		model.addAttribute("pageMaker", new PageDTO(cri, total));
				
	}
			
	// �� �ۼ� ������ �����ֱ�
	@GetMapping("/register")
	public void register() {
				
	}
			
	// �� �ۼ�
	@PostMapping("/register")
	public String register(ClassBoardVO oboard, RedirectAttributes rttr) {
		log.info("register: " + oboard);
		service.register(oboard);
		rttr.addFlashAttribute("result", oboard.getBno());
		return "redirect:/class/list";
	}
			
	// �� �󼼳���
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("oboard", service.get(bno));
	}
		
	// �� ����
	@PostMapping("/modify")
	public String modify(ClassBoardVO oboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + oboard);
				
		if(service.modify(oboard)) {
			rttr.addFlashAttribute("result", "success");
		}
				
		return "redirect:/class/list" + cri.getListLink();
	}
			
	// �� ����
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove: " + bno);
				
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
				
		return "redirect:/class/list" + cri.getListLink();
	}
	
	// �Խñ� ��õ
	@RequestMapping("/recommend")
	public String recommend(@RequestParam("bno") int bno) {
		service.recommend(bno);
		return "forward:/class/get";
	}
}
