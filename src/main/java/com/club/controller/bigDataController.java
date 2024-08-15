package com.club.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.pojo.User;

@Controller
@RequestMapping("/club")
public class bigDataController {

	@RequestMapping("/bigDataShow")
	public String showBigData(User user,Model model,HttpServletRequest request){
		
		return "bigData";
	}
}
