package com.club.helper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.pojo.Approval;
import com.club.pojo.User;
import com.club.server.ApprovalServer;

@Service
public class ApprovalHelper {

	@Autowired
	private ApprovalServer approvalServer;
	
	@Autowired
	private UserHelper userHelper;
	
	/**
	 * 待审批事项的分页方法
	 * @param request
	 * @return
	 */
	public List<Approval> findApprovalListPage(HttpServletRequest request){
		User curUser = userHelper.getCurUser(request);
		Integer curPage  = 0;//当前页
		String curPageStr = request.getParameter("curPage");
		if(curPageStr!=null){
			curPage = Integer.parseInt(curPageStr)-1;
		}
		Integer limit = 5;//每页显示5条记录
		Integer startNumber = curPage*limit;//每页开始的记录
		
		List<Object> approvalObjList = approvalServer.findApprovalListByApprUserPage(curUser.getUserId(),startNumber,limit);
		List<Approval> approvalList = new ArrayList<Approval>();
		if(approvalObjList!=null && approvalObjList.size()>0){
			for (Object obj : approvalObjList) {
				Approval appr = new Approval();
				Object[] objList = (Object[])obj;
				appr.setObjId((Integer)objList[0]);
				appr.setApprName((String)objList[1]);
				appr.setObjName((String)objList[2]);
				appr.setObjType((String)objList[3]);
				appr.setRespUser((String)objList[4]);
				appr.setStatus((String)objList[5]);
				approvalList.add(appr);
			}
		}
		return approvalList;
	}
	
}
