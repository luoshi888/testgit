package com.club.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.NoticeHelper;
import com.club.helper.UserHelper;
import com.club.pojo.Notice;
import com.club.pojo.User;
import com.club.server.NoticeServer;

@Controller
@RequestMapping("/club")
public class NoticeController {

	@Autowired
	private UserHelper userHelper;
	
	@Autowired
	private NoticeServer noticeServer;
	
	@Autowired
	private NoticeHelper noticeHelper;
	/**
	 * 公告列表
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showNoticeListPage")
	public String showNoticeListPage(Notice notice,Model model,HttpServletRequest request){
		User curUser = userHelper.getCurUser(request);
		String curPageStr = request.getParameter("curPage");
		//公告总记录
		int countN = noticeServer.getNoticeCount();
		List<Notice> noticeList = noticeHelper.getNoticeListPage(request);
		if(noticeList!=null &&noticeList.size()>0){
			model.addAttribute("noticeList", noticeList);	
		}
		model.addAttribute("pageN", curPageStr==null?0:Integer.parseInt(curPageStr));
		model.addAttribute("countN", countN);
		return "noticeList";
	}
}
