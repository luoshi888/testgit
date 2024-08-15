package com.club.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.ActivityHelper;
import com.club.pojo.Activity;

@Controller
@RequestMapping("/club")
public class ActivityController {
	
	@Autowired
	private ActivityHelper activityHelper;

	/**
	 * 待办活动列表
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showActivityReadyListPage")
	public String showActivityReadyListPage(Activity act,Model model,HttpServletRequest request){
		String curPageStr = request.getParameter("curPage");
		
		Page<Activity> page = this.activityHelper.getActivityReadyListPageByResp(request);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		
		List<Activity> activityList = page.getContent();
		
		model.addAttribute("activityList", activityList);
		model.addAttribute("pageB", curPageStr==null?0:Integer.parseInt(curPageStr));
		model.addAttribute("countB", page.getTotalElements());
		return "activityReadyList";
	}
}
