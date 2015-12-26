package com.soni.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.soni.model.UserDetail;

@SessionAttributes(value="userDetail")
@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLoginForm(){
		return "loginForm.def";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String submitForm(HttpServletRequest request, HttpSession session){
		UserDetail userDetail = new UserDetail();
		userDetail.setUsername(request.getParameter("username"));
		userDetail.setEmail(request.getParameter("email"));
		userDetail.setAge(Integer.parseInt(request.getParameter("age")));
		userDetail.setPhone(request.getParameter("phone"));

		// This line is not required as we have put @SessionAttribute(value="userDetail"). So while adding any object to Model if the 
		// name of the object will be the same as the name of the argument in @SessionAttributes.
		// that object will be added to the session. 
		session.setAttribute("userDetail", userDetail);	
		
		return "user.def";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showDetail(@ModelAttribute(value="userDetail") UserDetail userDetail) { 
		// userDetail model object will be pre populated with values from session as we are using @SessionAttribute
		// If @SessionAttribute is not used, Then after completion of this method only userName = "Abhi" will be set, reamining fields won't be set.
		userDetail.setUsername("Abhi");
		return "showDetails.def";
	}
	
}
