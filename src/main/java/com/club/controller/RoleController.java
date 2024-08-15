package com.club.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.JurisdictionHepler;
import com.club.helper.UserHelper;
import com.club.pojo.Jurisdiction;
import com.club.pojo.Role;
import com.club.pojo.RoleUser;
import com.club.pojo.User;
import com.club.server.JurisdictionServer;
import com.club.server.RoleServer;
import com.club.server.RoleUserServer;
import com.club.server.UserServer;

@Controller
@RequestMapping("/club")
public class RoleController {
	
	@Autowired
	private JurisdictionHepler jurisdictionHepler;
	
	@Autowired
	private UserHelper userHelper;
	
	@Autowired
	private RoleServer roleServer;
	
	@Autowired
	private UserServer userServer;
	
	@Autowired
	private RoleUserServer roleUserServer;

	@Autowired
	private JurisdictionServer jurisdictionServer;
	/**
	 * 角色list页面
	 * @param role
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showRole")
	public String showRole(Role role,Model model,HttpServletRequest request){
		User curUser = userHelper.getCurUser(request);
		//权限
		boolean addRole = jurisdictionHepler.isAddRole(curUser);
		boolean upateRole = jurisdictionHepler.isUpateRole(curUser);
		boolean deleteRole = jurisdictionHepler.isDeleteRole(curUser);
		
		//所有角色
		List<Role> roleList = roleServer.findAll();
		if(role.getRoleName()!=null&&!"".equals(role.getRoleName().trim())){
			roleList = roleServer.getAllRoleList("%"+role.getRoleName().trim()+"%");
		}
				
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("roleList", roleList);
		model.addAttribute("addRole", addRole);
		model.addAttribute("isUpdateRole", upateRole);
		model.addAttribute("isDeleteRole", deleteRole);
		return "roleList";
	}
	
	/**
	 * 角色权限信息
	 * @param role
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showRoleInfo")
	public String showRoleInfo(Role role,Model model,HttpServletRequest request){
		if(role.getRoleId()!=null){
			role = roleServer.getOne(role.getRoleId());
			//封装所属人返回到页面
			//获取角色所属人id
			List<RoleUser> roleUserList = roleUserServer.getUserByRoleId(role.getRoleId());
			StringBuilder roleUserNameStr = new StringBuilder();
			if (roleUserList != null && roleUserList.size() > 0) {
				for (RoleUser roleUser : roleUserList) {
					User user = userServer.findUserByUserId(roleUser.getUserId());
					roleUserNameStr.append(user.getUserName()+",");
				}
			}
			model.addAttribute("roleUserNameStr", roleUserNameStr);
			
			//封装权限信息返回给页面
			//获取该角色的所有权限
			List<Jurisdiction> jurisdictionList = jurisdictionServer.getJurisdictionByRoleId(role.getRoleId());
		    StringBuilder jrisdictionIdStr = new StringBuilder();
			if(jurisdictionList!=null && jurisdictionList.size()>0){
		    	for (Jurisdiction jurisdiction : jurisdictionList) {
		    		jrisdictionIdStr.append(jurisdiction.getJurisdictionId()+",");
				}
		    }
			model.addAttribute("jrisdictionIdStr", jrisdictionIdStr);
		}else{
			role.setCreateUser(new User());
		}
		model.addAttribute("role", role);
		return "roleInfo";
	}
	
	/**
	 * 提交新增、修改的角色和权限信息
	 * @param role
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/subumitRoleInfo")
	public String subumitRoleInfo(Role role,Model model ,HttpServletRequest request){
		String roleUserStr = role.getRoleUser();
		if(roleUserStr!=null &&!"".equals(roleUserStr.trim())){
			roleUserStr.replace("，", ",");
			String[] roleUserList = roleUserStr.split(",");
			if(roleUserList!=null&& roleUserList.length>0){
				//存放角色 所属用户
				List<User> userList = new ArrayList<>();
				//存放数据库无法找到的用户Name
				List<String> errorNameList = new ArrayList<>();
				
				//匹配数据库用户
				for (String userName : roleUserList) {
					if(userName.trim()!=null && !userName.trim().equals("")){
						User user = userServer.findUserByUserName(userName.trim());
						if(user!=null){
							userList.add(user);
						}else{
							errorNameList.add(userName);
						}
					}
				}
				if(errorNameList.size()==0){
					if(role.getRoleId()==null){
						role.setCreateUser(userHelper.getCurUser(request));
						roleServer.save(role);
					}else{
						roleServer.updateRole(role.getRoleName(),role.getRoleId());
						//删除所属用户
						roleUserServer.deleteRoleUseryRoleId(role.getRoleId());
						//删除权限
						jurisdictionServer.deleteRoleJurisdictionByRoleId(role.getRoleId());
					}
					//添加所属用户
					for (User user : userList) {
						//RoleUser roleUser = new RoleUser();
						//roleUser.setRoleId(role.getRoleId());
						//roleUser.setUserId(user.getUserId());
						roleUserServer.addRole(user.getUserId(), role.getRoleId());
					}
					//重新添加权限
					List<Integer> roleJurisdiction = role.getRoleJurisdiction();
					if(roleJurisdiction!=null&&roleJurisdiction.size()>0){
						for (Integer jurisdicId : roleJurisdiction) {
							//Jurisdiction jur = new Jurisdiction();
							//jur.setJurisdictionId(jurisdicId);
							//jur.setRoleId(role);
							jurisdictionServer.addJurisdiction(jurisdicId, role.getRoleId());
						}
					}
				}else{
					
				}
			}
		}
		
		return "roleInfo";
	}
	
	@RequestMapping("/deleteRole")
	public String deleteRole(Role role,Model model ,HttpServletRequest request){
		if(role!=null && role.getRoleId()!=null){
			//删除该角色下的权限
			jurisdictionServer.deleteRoleJurisdictionByRoleId(role.getRoleId());
			//删除该该角色和用户的绑定关系
			roleUserServer.deleteRoleUseryRoleId(role.getRoleId());
			//删除该角色
			roleServer.deleteRoleByRoleId(role.getRoleId());
		}
		return "roleList";
		
	}
}
