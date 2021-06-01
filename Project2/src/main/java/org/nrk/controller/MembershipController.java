package org.nrk.controller;

import javax.servlet.http.HttpSession;

import org.nrk.domain.Criteria;
import org.nrk.domain.MembershipVO;
import org.nrk.service.MembershipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/membership/")
@AllArgsConstructor
public class MembershipController {
	private MembershipService service;
	
	// ȸ������ ȭ�� �����ֱ�
	@GetMapping("/newMember")
	public void register() {
				
	}
	
	// ȸ������
	@PostMapping("/register")
	public String register(MembershipVO member) {
		log.info("membership register");
		service.register(member);
		return "redirect:/membership/loginForm";
	}
	
	// ȸ������ ���� â �����ֱ�
	@PostMapping({"/get"})
	public void get(@RequestParam("id") String id, Model model) {
		log.info("/get or modify");
		model.addAttribute("mboard", service.get(id));
	}
	
	// ȸ������ ����
	@PostMapping("/modify")
	public String modify(MembershipVO member, RedirectAttributes rttr) {
		log.info("modify:" + member);
			
		if(service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/";
	}
	
	// ȸ��Ż��
	@PostMapping("/remove")
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr, HttpSession session) {
		log.info("remove: " + id);
			
		if(service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
			session.removeAttribute("loginMember");
		}
		return "redirect:/";
	}
	
	// �α���ȭ�� �����ֱ�
	@GetMapping("/loginForm")
	public void loginGet() {
		
	}
	
	// �α���
	@PostMapping("/login")
	public String loginPost(MembershipVO member, HttpSession session, RedirectAttributes rttr) {
		log.info("login �õ�");

		MembershipVO vo = service.login(member);
		session.setAttribute("loginMember", vo);
		
		// select����� ���� ������
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}else {
			session.setAttribute("errorMessage", "fail");
			log.info(session.getAttribute("errorMessage"));
			return "redirect:/membership/loginForm";
		}
	}
	
	// �α׾ƿ�
	@PostMapping("/logout")
	public String logoutPost(HttpSession session) {
		log.info("logout");
		
		// loginMember�� ����� �������� ����
		session.removeAttribute("loginMember");
		// �Ǵ� session.invalidate();
		return "redirect:/";
	}
	
	// ���̵� �ߺ�Ȯ��
	@ResponseBody
	@RequestMapping(value="/emailChk", method=RequestMethod.POST)
	public int checkID(MembershipVO member) {
		log.info("id check");
		int result = service.checkID(member);
		return result;
	}
	

	
	/*
	// �α���ȭ�� �����ֱ�
	@GetMapping("/loginForm")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
	}
	
	// �α׾ƿ�
	@GetMapping("/logoutForm")
	public void logoutGET() {
		log.info("logout");
	}
	
	// �Խ�Ʈ ȭ�� �����ֱ�
	@GetMapping("/guest")
	public void doguest() {
		log.info("do guest");
	}
	
	// �α��ε� ȭ�� �����ֱ�
	@GetMapping("/member")
	public void doMember() {
		log.info("logined member");
	}
	
	// ������ ȭ�� �����ֱ�
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}
	
	// �������� ȭ��
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	*/
}
