package com.club.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@IdClass(RoleJuridictionPk.class)
@Entity
@Table(name="jurisdiction")
public class Jurisdiction  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jurRoleId;
	
	@Column(name="jurisdictionId")
	private Integer jurisdictionId;
	
	@Column(name="jurisdictionName")
	private String jurisdictionName;
	
	
	@JoinColumn(name="roleId")
	private Integer roleId;

	public Integer getJurisdictionId() {
		return jurisdictionId;
	}

	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}

	public String getJurisdictionName() {
		return jurisdictionName;
	}

	public void setJurisdictionName(String jurisdictionName) {
		this.jurisdictionName = jurisdictionName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getJurRoleId() {
		return jurRoleId;
	}

	public void setJurRoleId(Integer jurRoleId) {
		this.jurRoleId = jurRoleId;
	}
	
	

}
