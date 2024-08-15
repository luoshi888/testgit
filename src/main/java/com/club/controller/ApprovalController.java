package com.club.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.ApprovalHelper;
import com.club.helper.UserHelper;
import com.club.pojo.Approval;
import com.club.pojo.User;
import com.club.server.ApprovalServer;

@Controller
@RequestMapping("/club")
public class ApprovalController {

	@Autowired
	private ApprovalServer approvalServer;
	
	@Autowired
	private UserHelper userHelper;
	
	@Autowired
	private ApprovalHelper approvalHelper;
	
	/**
	 * 待审批事项分页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showApprovalListPage")
	public String showApprovalListPage(Model model,HttpServletRequest request){
		User curUser = userHelper.getCurUser(request);
		String curPageStr = request.getParameter("curPage");
		//待审批事项总记录
		int countA = approvalServer.findApprovalListByApprUserCount(curUser.getUserId());
		List<Approval> approvalList = approvalHelper.findApprovalListPage(request);
		if(approvalList!=null &&approvalList.size()>0){
			model.addAttribute("approvalList", approvalList);	
		}
		model.addAttribute("pageA", curPageStr==null?0:Integer.parseInt(curPageStr));
		model.addAttribute("countA", countA);
		return "approvalYetNot";
	}
}
