package com.club.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.pojo.Jurisdiction;
import com.club.pojo.User;
import com.club.server.JurisdictionServer;

@Service
public class JurisdictionHepler {
	
	public static final Integer deleteRole_Jurisdiction = 1;//删除角色
	
	public static final Integer updateRole_Jurisdiction = 2;//修改角色
	
	public static final Integer addRole_Jurisdiction = 3;//添加角色
	
	@Autowired
	private UserHelper userHepler;
	
	@Autowired
	private JurisdictionServer jurisdictionServer;

	/**
	 * 判断用户是否有某个权限
	 * @param user
	 * @param jurisictionId
	 * @return
	 */
	public boolean getRole(User user,Integer jurisictionId){
		if(user==null || user.getUserId()==null){
			return false;
		}
		List<Integer> userRoleIdList = userHepler.getCurUserRoleIdList(user);
		String roleIdStr = null;
		if(userRoleIdList!=null&&userRoleIdList.size()>0){
			for (Integer roleId : userRoleIdList) {
				if(roleIdStr==null){
					roleIdStr = roleId.toString();
				}else{
					roleIdStr +=","+roleId.toString();
				}
			}
		}else{
			roleIdStr="-1";
		}
		List<Jurisdiction> jurisdictionList = jurisdictionServer.getRoleJurisdiction(jurisictionId, roleIdStr);
		if(jurisdictionList!=null && jurisdictionList.size()>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否有删除角色的权限
	 * @param user
	 * @return
	 */
	public boolean isDeleteRole(User user){
		return getRole(user, deleteRole_Jurisdiction);
	}
	
	/**
	 * 是否有修改角色的权限
	 * @param user
	 * @return
	 */
	public boolean isUpateRole(User user){
		return getRole(user, updateRole_Jurisdiction);
	}
	
	/**
	 * 是否有修改角色的权限
	 * @param user
	 * @return
	 */
	public boolean isAddRole(User user){
		return getRole(user, addRole_Jurisdiction);
	}
	
	
}
