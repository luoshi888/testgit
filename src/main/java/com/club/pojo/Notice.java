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

@Entity
@Table(name="notice")
public class Notice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="noticeId")
	private Integer noticeId;
	
	@Column(name="noticeName")
	private String noticeName;
	
	@Column(name="noticeCon")
	private String noticeCon;
	
	@Column(name="createTime")
	private Date createTime;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="createUser")
	private User createUser;
	
	@Column(name="level")
	private String level;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public String getNoticeCon() {
		return noticeCon;
	}

	public void setNoticeCon(String noticeCon) {
		this.noticeCon = noticeCon;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeName=" + noticeName
				+ ", noticeCon=" + noticeCon + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", level=" + level + "]";
	}
	
	
}
