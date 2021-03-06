package com.soni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soni.model.Description;
import com.soni.model.Hobby;
import com.soni.model.UserDetail;

@Controller
public class DescriptionController {
	
	@RequestMapping(value="/description", method=RequestMethod.POST)
	public @ResponseBody Description getDescription(@RequestBody UserDetail userDetail) { 
		Description d = new Description();
		
		d.setDesc(userDetail.getFirstName() + " is nice person." );
		d.setHobby(new Hobby("Playing cricket"));
		return d;
	}
	
}
