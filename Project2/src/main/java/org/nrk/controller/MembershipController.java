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
	
	// 회원가입 화면 보여주기
	@GetMapping("/newMember")
	public void register() {
				
	}
	
	// 회원가입
	@PostMapping("/register")
	public String register(MembershipVO member) {
		log.info("membership register");
		service.register(member);
		return "redirect:/membership/loginForm";
	}
	
	// 회원정보 수정 창 보여주기
	@PostMapping({"/get"})
	public void get(@RequestParam("id") String id, Model model) {
		log.info("/get or modify");
		model.addAttribute("mboard", service.get(id));
	}
	
	// 회원정보 수정
	@PostMapping("/modify")
	public String modify(MembershipVO member, RedirectAttributes rttr) {
		log.info("modify:" + member);
			
		if(service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/";
	}
	
	// 회원탈퇴
	@PostMapping("/remove")
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr, HttpSession session) {
		log.info("remove: " + id);
			
		if(service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
			session.removeAttribute("loginMember");
		}
		return "redirect:/";
	}
	
	// 로그인화면 보여주기
	@GetMapping("/loginForm")
	public void loginGet() {
		
	}
	
	// 로그인
	@PostMapping("/login")
	public String loginPost(MembershipVO member, HttpSession session, RedirectAttributes rttr) {
		log.info("login 시도");

		MembershipVO vo = service.login(member);
		session.setAttribute("loginMember", vo);
		
		// select결과에 값이 있으면
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}else {
			session.setAttribute("errorMessage", "fail");
			log.info(session.getAttribute("errorMessage"));
			return "redirect:/membership/loginForm";
		}
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String logoutPost(HttpSession session) {
		log.info("logout");
		
		// loginMember에 저장된 세션정보 삭제
		session.removeAttribute("loginMember");
		// 또는 session.invalidate();
		return "redirect:/";
	}
	
	// 아이디 중복확인
	@ResponseBody
	@RequestMapping(value="/emailChk", method=RequestMethod.POST)
	public int checkID(MembershipVO member) {
		log.info("id check");
		int result = service.checkID(member);
		return result;
	}
	

	
	/*
	// 로그인화면 보여주기
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
	
	// 로그아웃
	@GetMapping("/logoutForm")
	public void logoutGET() {
		log.info("logout");
	}
	
	// 게스트 화면 보여주기
	@GetMapping("/guest")
	public void doguest() {
		log.info("do guest");
	}
	
	// 로그인된 화면 보여주기
	@GetMapping("/member")
	public void doMember() {
		log.info("logined member");
	}
	
	// 관리자 화면 보여주기
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}
	
	// 접근제한 화면
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	*/
}
