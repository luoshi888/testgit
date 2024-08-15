package com.club.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class JurisdictionController {

	@RequestMapping("/showJurisdiction")
	public String showJurisdiction(HttpServletRequest request){
		
		return "jurisdiction";
	}
}
