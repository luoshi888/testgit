package com.club.pojo;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="approval")
public class Approval  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Approval() {
		// TODO Auto-generated constructor stub
	}
	public Approval(Integer objId,String apprName,String objName,String objType,String respUser,String status) {
		// TODO Auto-generated constructor stub
		this.objId = objId;
		this.apprName = apprName;
		this.objName = objName;
		this.respUser = respUser;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="approvalId")
	private Integer approvalId;
	
	@Column(name="approvalParentId")
	private Integer approvalParentId;
	
	@Transient
	private String apprName;
	
	@Column(name="approvalType")
	private String approvalType;
	
	
	@Column(name="objId")
	private Integer objId;
	
	@Column(name="objType")
	private String objType;
	
	@Column(name="status")
	private String status;
	
	@Transient
	private String objName;
	
	@Transient
	private String respUser;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="approvalUser")
	private User approvalUser;
	
	@Column(name="approvalTime")
	private Date approvalTime;
	
	@Column(name="createTime")
	private Date createTime;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="createUser")
	private User createUser;

	public Integer getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public Integer getObjId() {
		return objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String obType) {
		this.objType = obType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public User getApprovalUser() {
		return approvalUser;
	}

	public void setApprovalUser(User approvalUser) {
		this.approvalUser = approvalUser;
	}

	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	
	public Integer getApprovalParentId() {
		return approvalParentId;
	}

	public void setApprovalParentId(Integer approvalParentId) {
		this.approvalParentId = approvalParentId;
	}

	public String getApprName() {
		return apprName;
	}

	public void setApprName(String apprName) {
		this.apprName = apprName;
	}

	public String getRespUser() {
		return respUser;
	}

	public void setRespUser(String respUser) {
		this.respUser = respUser;
	}

	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", approvalType="
				+ approvalType + ", objId=" + objId + ", obType=" + objType
				+ ", status=" + status + ", objName=" + objName
				+ ", approvalUser=" + approvalUser + ", approvalTime="
				+ approvalTime + ", createTime=" + createTime + ", createUser="
				+ createUser + "]";
	}
	
	
}


