package com.soni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HelloWorldController {

		@RequestMapping(value="/hello")
		public ModelAndView hello() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("hi");
			mv.addObject("userName", "Ramu");
			return mv;						// InternalViewResolver
		}
		
		@RequestMapping(value="/welcome")
		public String welcome(Model model) {
			model.addAttribute("userName", "Ramya");
			return "WelcomePage";	// XmlViewResolver
		}
		
		@RequestMapping(value="/bye")
		public String bye(Model model) {
			model.addAttribute("userName", "Honey");
			return "ByePage";				// ResourceBundleViewResolver
		}
}
