package com.club.pojo;

import java.io.Serializable;


public class RoleUserPk  implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Integer roleId;

	private Integer userId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
