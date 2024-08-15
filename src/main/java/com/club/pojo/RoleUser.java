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

import org.hibernate.annotations.GenericGenerator;

//@IdClass(RoleUserPk.class)
@Entity
@Table(name="roleUser")
public class RoleUser  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleUserId;

	@Column(name="roleId")
	private Integer roleId;
	
	@Column(name="userId")
	private Integer userId;
	
	public RoleUser(){
		
	}

	public Integer getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(Integer roleUserId) {
		this.roleUserId = roleUserId;
	}

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

	@Override
	public String toString() {
		return "RoleUser [roleUserId=" + roleUserId + ", roleId=" + roleId
				+ ", userId=" + userId + "]";
	}

	@Override
    public int hashCode(){
              final int PRIME = 31;
              int result = 1;
              result = PRIME * result + ((roleId == null) ? 0 : roleId.hashCode());
              result = PRIME * result + ((userId == null) ? 0 : userId.hashCode());
              return result;
    }



    @Override
    public boolean equals(Object obj) {
              if (this == obj)
                       return true;

              if (obj == null)
                       return false;

              if (getClass() != obj.getClass())
                       return false;
              final RoleUserPk other = (RoleUserPk) obj;
              if (roleId == null) {
                       if (other.getRoleId() != null)
                                return false;

              } else if (!roleId.equals(other.getRoleId()))
                       return false;
              if (userId == null) {
                       if (other.getUserId() != null)
                                return false;
              } else if (!userId.equals(other.getUserId()))
                       return false;
              return true;

    }
	
}
