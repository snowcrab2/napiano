package org.nrk.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.nrk.domain.BoardAttachVO;
import org.nrk.domain.Criteria;
import org.nrk.domain.PageDTO;
import org.nrk.domain.SheetBoardVO;
import org.nrk.service.SheetBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sheet/*")
@AllArgsConstructor
public class SheetBoardController {
	private SheetBoardService service;
	
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
	public String register(SheetBoardVO sboard, RedirectAttributes rttr) {
		/*
		log.info("register: " + sboard);
		service.register(sboard);
		rttr.addFlashAttribute("result", sboard.getBno());
		return "redirect:/sheet/list";
		 */
		log.info("register: " + sboard);
		
		if(sboard.getAttachList() != null) {
			sboard.getAttachList().forEach(attach -> log.info(attach));
		}
		log.info("=====================");
		service.register(sboard);
		rttr.addFlashAttribute("result", sboard.getBno());
		return "redirect:/sheet/list";
	}
	
	// �� �󼼳���
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("sboard", service.get(bno));
	}
	
	// �� ����
	@PostMapping("/modify")
	public String modify(SheetBoardVO sboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + sboard);
			
		if(service.modify(sboard)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/sheet/list" + cri.getListLink();
	}
	
	// �� ����
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		/*
		log.info("remove: " + bno);
			
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/sheet/list" + cri.getListLink();
		*/
		log.info("remove: " + bno);
		
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if(service.remove(bno)) {
			// deleteFiles �޼��� ȣ��
			deleteFiles(attachList);
			
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/sheet/list" + cri.getListLink();
	}
	
	
	
	
	// ÷������
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody // @RestController�� �ۼ����� �ʾұ� ������ @ResponseBody �����ؼ� JSON������ ��ȯ�ؾ���
	public ResponseEntity<List<BoardAttachVO>> getAttachList(int bno){
		log.info("getAttachList " + bno);
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
	
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		
		log.info("delete attach files...........");
		log.info(attachList);
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get("C:\\upload\\" +attach.getUploadPath()+"\\"+
										attach.getUuid()+"_"+attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_" +
												attach.getUuid()+"_"+attach.getFileName());
					
					Files.delete(thumbNail);
				}
			}catch(Exception e) {
				log.error("delete file error" + e.getMessage());
			}// end catch
		});// end forEach
	}
}
