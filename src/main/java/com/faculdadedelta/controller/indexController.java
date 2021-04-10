package com.faculdadedelta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	
	@RequestMapping("/inicio")
	public String index() {
		return "index";
	}
	
	
	
}
