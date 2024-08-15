package com.club.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="role")
public class Role  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleId")
	private Integer roleId;
	
	@Column(name="roleName")
	private String roleName;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="createUser")
	private User createUser;
	
	@Transient
	private List<Integer> roleJurisdiction;
	
	@Transient
	private String roleUser;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public List<Integer> getRoleJurisdiction() {
		return roleJurisdiction;
	}

	public void setRoleJurisdiction(List<Integer> roleJurisdiction) {
		this.roleJurisdiction = roleJurisdiction;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", userId=" + ", createUser=" + createUser + "]";
	}
	
	
}
