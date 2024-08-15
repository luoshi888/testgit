package com.club.pojo;

import java.io.Serializable;

public class RoleJuridictionPk implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer jurisdictionId;
	
	private Integer roleId;

	public Integer getJurisdictionId() {
		return jurisdictionId;
	}

	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
