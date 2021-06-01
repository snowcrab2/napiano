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
	
	// 글 상세내용
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("sboard", service.get(bno));
	}
	
	// 글 수정
	@PostMapping("/modify")
	public String modify(SheetBoardVO sboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + sboard);
			
		if(service.modify(sboard)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/sheet/list" + cri.getListLink();
	}
	
	// 글 삭제
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
			// deleteFiles 메서드 호출
			deleteFiles(attachList);
			
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/sheet/list" + cri.getListLink();
	}
	
	
	
	
	// 첨부파일
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody // @RestController로 작성되지 않았기 때문에 @ResponseBody 적용해서 JSON데이터 반환해야함
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
