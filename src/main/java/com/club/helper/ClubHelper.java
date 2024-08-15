package com.club.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.pojo.Club;
import com.club.pojo.Types;
import com.club.pojo.User;
import com.club.server.ClubServer;
import com.club.server.TypesServer;
import com.club.server.UserServer;

@Service
public class ClubHelper {
	
	@Autowired
	private UserServer userServer;
	
	@Autowired
	private TypesServer typesServer;
	
	@Autowired
	private DateHelper dateHelper;
	
	@Autowired
	private ClubServer clubServer;

	/**
	 * 新增修改前，封装club，赋必要的值
	 * @param club
	 * @param request
	 */
	public void initAddForm(Club club,boolean isAdd,HttpServletRequest request){
		Date date = new Date();
		//负责人
		if(club.getResUserId()!=null){
			Integer resUserId = club.getResUserId();
			User resUser = userServer.findUserByUserId(resUserId);
			resUser.setUserId(resUserId);
			club.setResUser(resUser);
		}
		if(club.getTypeId()!=null){
			Integer typeId = club.getTypeId();
			Types types = typesServer.findTypesById(typeId);
			types.setTypeId(typeId);
			club.setTypes(types);
		}
		//当前登录用户
		Integer curUserId = ((Integer)request.getSession().getAttribute("curUserId"));
		/*User curUser = new User();
		curUser.setUserId(curUserId);*/
		//创建人
		club.setCreateUser(curUserId);
		//创建时间
		if(isAdd){
			if(club.getCreateTimeStr()==null || club.getCreateTimeStr()==""){
				club.setCreateTime(date);
				club.setCreateTimeStr(dateHelper.DataToString("yyyy-MM-dd hh:mm:ss", date));
			}else{
				String createTime = club.getCreateTimeStr();
				Date createDate = dateHelper.StringToDate("yyyy-MM-dd hh:mm:ss", createTime);
				club.setCreateTime(createDate);
			}
		}
		if(!isAdd){
			club.setUpdateTime(date);
			club.setUpdateUser(curUserId);
		}
	}
	
	/**
	 * 页面回显前的数据封装
	 * @param club
	 * @param request
	 */
	public void initViewForm(Club club,HttpServletRequest request){
		//
		club.setResUserName(club.getResUser().getUserName());
		club.setResUserId(club.getResUser().getUserId());
		
		club.setCreateTimeStr(dateHelper.DataToString("yyyy-MM-dd hh:mm:ss", club.getCreateTime()));
	}
	
	/**
	 * 判断俱乐部名称是否存在
	 * @param clubId
	 * @return
	 */
	public boolean isExistClubName(Integer clubId,String clubName){
		if(clubName==null || "".equals(clubName.trim())){
			return false;
		}
		if(clubId==null){
			clubId = -20000;
		}
		List<Club> clubList = clubServer.findClubByClubName(clubId,clubName);
		if(clubList!=null && clubList.size()>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 检查提交信息
	 * @param club
	 * @param errorMessageList
	 */
	public boolean checkForm(Club club,List<String> errorMessageList){
		boolean isHavaError = false;
		if(club.getClubName()==null || "".equals(club.getClubName().trim())){
			errorMessageList.add("俱乐部名称不能为空！");
			isHavaError = true;
		}
		if(club.getResUserName()==null || "".equals(club.getResUserName())){
			errorMessageList.add("负责人不能为空！");
			isHavaError = true;
		}else if(club.getResUserId()==null || "".equals(club.getResUserId())){
			errorMessageList.add("请通过单击进行选择负责人！");
			isHavaError = true;
		}
		if(club.getTypeId()==null || "".equals(club.getTypeId())){
			errorMessageList.add("俱乐部类型不能为空！");
			isHavaError = true;
		}
		if(club.getActivityTimes()==null || "".equals(club.getActivityTimes())){
			errorMessageList.add("活动次数不能为空！");
			isHavaError = true;
		}
		if(club.getNumberOfMembers()==null || "".equals(club.getNumberOfMembers())){
			errorMessageList.add("会员数量不能为空！");
			isHavaError = true;
		}
		return isHavaError;
	}
	
}
