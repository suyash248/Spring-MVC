package com.soni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class DemoController {
	
	@RequestMapping(value="/userDetails", method=RequestMethod.GET)
	public String userDetails(Model model) { 
		model.addAttribute("name", "Suyash");
		model.addAttribute("type", "User");
		return "showDetails.def";
	}
	
	@RequestMapping(value="/managerDetails", method=RequestMethod.GET)
	public String managerDetails(Model model) { 
		model.addAttribute("name", "Ramya");
		model.addAttribute("type", "Manager");
		return "showDetails.def";
	}
	
}
