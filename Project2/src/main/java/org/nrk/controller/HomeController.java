package org.nrk.controller;

import java.util.Locale;

import org.nrk.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	@Setter(onMethod_ = @Autowired)
	private HomeService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.");
		
		model.addAttribute("list", service.getList());
		model.addAttribute("list2", service.getList2());
		model.addAttribute("list3", service.getList3());
		
		return "home";
	}
	

	
}
