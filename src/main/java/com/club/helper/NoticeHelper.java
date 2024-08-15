package com.club.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.pojo.Notice;
import com.club.pojo.User;
import com.club.server.NoticeServer;

@Service
public class NoticeHelper {

	@Autowired
	private UserHelper userHelper;
	
	@Autowired
	private NoticeServer noticeServer;
	public List<Notice> getNoticeListPage (HttpServletRequest request){
		User curUser = userHelper.getCurUser(request);
		Integer curPage  = 0;//当前页
		String curPageStr = request.getParameter("curPage");
		if(curPageStr!=null){
			curPage = Integer.parseInt(curPageStr)-1;
		}
		Integer limit = 5;//每页显示5条记录
		Integer startNumber = curPage*limit;//每页开始的记录
		
		List<Notice> noticeList = noticeServer.findNoticeListPage(startNumber, 10);
		
		return noticeList;
	}
}
