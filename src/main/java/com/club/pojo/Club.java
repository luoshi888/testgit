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
@Table(name="club")
public class Club implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clubId")
	private Integer clubId;
	
	@Column(name="clubName")
	private String clubName;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="clubType")
	private Types types;
	
	@Transient
	private Integer typeId;
	
	@Column(name="activityTimes")
	private Integer activityTimes;
	
	@Column(name="numberOfMembers")
	private Integer numberOfMembers;
	
	@Column(name="createUser")
	private Integer createUser;
	
	@Column(name="createTime")
	private Date createTime;
	
	//用于页面显示
	@Transient/* 表示数据库中不存在该字段*/
	private String createTimeStr;
	
	@Column(name="updateTime")
	private Date updateTime;
	
	@Column(name="updateUser")
	private Integer updateUser;
	
	@Column(name="remarks")
	private String remarks;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="responsibleId")
	private User resUser;
	
	@Transient
	private Integer resUserId;
	
	@Transient
	private String resUserName;

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	
	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Integer getActivityTimes() {
		return activityTimes;
	}

	public void setActivityTimes(Integer activityTimes) {
		this.activityTimes = activityTimes;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(Integer numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public User getResUser() {
		return resUser;
	}

	public void setResUser(User resUser) {
		this.resUser = resUser;
	}

	public Integer getResUserId() {
		return resUserId;
	}

	public void setResUserId(Integer resUserId) {
		this.resUserId = resUserId;
	}

	public String getResUserName() {
		return resUserName;
	}

	public void setResUserName(String resUserName) {
		this.resUserName = resUserName;
	}

	
	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", types="
				+ types + ", activityTimes=" + activityTimes
				+ ", numberOfMembers=" + numberOfMembers + ", createUser="
				+ createUser + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", updateUser=" + updateUser + ", remarks="
				+ remarks + ", resUser=" + resUser + "]";
	}

}
