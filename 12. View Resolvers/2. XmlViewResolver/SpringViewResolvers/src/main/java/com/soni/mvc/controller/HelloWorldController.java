package com.soni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HelloWorldController {

		@RequestMapping(value="/hello")
		public String hello(Model model) {
			model.addAttribute("userName", "Ramu");
			return "WelcomePage";
		}
}
