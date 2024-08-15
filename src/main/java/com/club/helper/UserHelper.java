package com.club.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.dao.RoleUseRespository;
import com.club.pojo.Role;
import com.club.pojo.RoleUser;
import com.club.pojo.User;
import com.club.server.RoleServer;
import com.club.server.UserServer;

/**
 * 用户helper类
 * @author luoshi
 *
 */
@Service
public class UserHelper {
	
	@Autowired
	private UserServer userServer;
	
	@Autowired
	private RoleServer roleServer;
	
	@Autowired
	private RoleUseRespository roleUseRespository;

	/**
	 * 判断是否存在该用户,并返回该用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public Map<String,Object> isUserExists(String userName,String passWord){
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userServer.findByNameAndPassWord(userName, passWord);
		map.put("isUserExists", false);
		if(userList !=null && userList.size()>0){
			map.put("isUserExists", true);
			map.put("user", userList.iterator().next());
			return map;
		}
		return map;
	}
	
	/**
	 * 检查登陆用户的登录信息
	 * @param user
	 * @return
	 */
	public Map<String,Object> checkLoginInfo(User user){
		Map<String,Object> messageMap = new HashMap<String,Object>();
		if(user.getUserName().trim()==null || user.getUserName().trim()==""){
			messageMap.put("nameNull", "账号不能为空！");
		}
		if(user.getPassWord().trim()==null || user.getPassWord().trim()==""){
			messageMap.put("passWordNull", "密码不能为空！");
		}
		if(messageMap.size()>0){
			return messageMap;
		}
		Map<String,Object> map = this.isUserExists(user.getUserName(), user.getPassWord());
		messageMap.put("isUserExists", map.get("isUserExists"));
		if(map.get("user")!=null){
			messageMap.put("user", map.get("user"));
		}
		return messageMap;
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public User getCurUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object userObj = session.getAttribute("user");
		User user = new User();
		if(userObj==null){
			Object curUserIdStr = session.getAttribute("curUserId");
			if(curUserIdStr==null){
				return user;
			}
			user= userServer.findUserByUserId((Integer)curUserIdStr);
		}else{
			user= userServer.findUserByUserId(((User)userObj).getUserId());
		}
		return user;
		
	}
	
	/**
	 * 获取当前用户所有的角色
	 * @param user
	 * @return
	 */
	public List<Role> getCurUserRoleList(User user){
		if(user==null||user.getUserId()==null){
			return null;
		}
		List<Role> curUserRoleList = new ArrayList<>();
		List<RoleUser> roleUserList = roleUseRespository.getCurRoleByUserId(user.getUserId());
		if(roleUserList!=null && roleUserList.size()>0){
			for (RoleUser roleUser : roleUserList) {
				curUserRoleList.add(roleServer.getCurUserRoleListByRoleId(roleUser.getRoleId()));
			}
		}
		return curUserRoleList;
	}
	
	/**
	 * 获取当前用户所有的角色ID
	 * @param user
	 * @return
	 */
	public List<Integer> getCurUserRoleIdList(User user){
		if(user==null||user.getUserId()==null){
			return null;
		}
		List<Role> curUserRoleList = this.getCurUserRoleList(user);
		List<Integer> roleIdList = new ArrayList<>();
		if(curUserRoleList!=null &&curUserRoleList.size()>0){
			for (Role role : curUserRoleList) {
				roleIdList.add(role.getRoleId());
			}
		}
		return roleIdList;
	}
}
