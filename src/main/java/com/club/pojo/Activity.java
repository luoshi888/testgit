package com.club.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name="activity")
public class Activity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="activityId")
	private Integer activityId;
	
	@Column(name="activityName")
	private String activityName;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="activityType")
	private Types activityType;
	
	@Column(name="activityCostSin")
	private String activityCostSin;
	
	@Column(name="activityNumber")
	private String activityNumber;
	
	@Column(name="activityCountCost")
	private String activityCountCost;
	
	@Column(name="activityCostExplain")
	private String activityCostExplain;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="activityResp")
	private User activityResp;
	
	@Column(name="otherExplain")
	private String otherExplain;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="clubId")
	private Club clubId;
	
	@Column(name="planStartTime")
	private Date planStartTime;
	
	@Column(name="planEndTime")
	private Date planEndTime;
	
	@Column(name="actStartTime")
	private Date actStartTime;
	
	@Column(name="actEndTime")
	private Date actEndTime;
	
	@Column(name="createTime")
	private Date createTime;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="createUser")
	private User createUser;
	
	@Transient
	private String status;
	
	//用户页面当逾期的时候，显示红色
	@Transient
	private int statusCode;
	
	@Transient
	private String planStartTimeStr;
	

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Types getActivityType() {
		return activityType;
	}

	public void setActivityType(Types activityType) {
		this.activityType = activityType;
	}

	public String getActivityCostSin() {
		return activityCostSin;
	}

	public void setActivityCostSin(String activityCostSin) {
		this.activityCostSin = activityCostSin;
	}

	public String getActivityNumber() {
		return activityNumber;
	}

	public void setActivityNumber(String activityNumber) {
		this.activityNumber = activityNumber;
	}

	public String getActivityCountCost() {
		return activityCountCost;
	}

	public void setActivityCountCost(String activityCountCost) {
		this.activityCountCost = activityCountCost;
	}

	public String getActivityCostExplain() {
		return activityCostExplain;
	}

	public void setActivityCostExplain(String activityCostExplain) {
		this.activityCostExplain = activityCostExplain;
	}

	public User getActivityResp() {
		return activityResp;
	}

	public void setActivityResp(User activityResp) {
		this.activityResp = activityResp;
	}

	public String getOtherExplain() {
		return otherExplain;
	}

	public void setOtherExplain(String otherExplain) {
		this.otherExplain = otherExplain;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Date getActStartTime() {
		return actStartTime;
	}

	public void setActStartTime(Date actStartTime) {
		this.actStartTime = actStartTime;
	}

	public Date getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
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

	
	public String getStatus() {
		Date curDate= new Date();
		if(planStartTime!=null){
			if(this.planStartTime.getTime()>curDate.getTime()){
				Long l = 0L;
		        try {
		            long sTime = planStartTime.getTime();
		            long  eTime= curDate.getTime();

		            l = (eTime - sTime) / (1000 * 60 * 60 * 24);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				status = "计划 "+l.intValue()+" 天后开始";
			}else if(this.planStartTime.getTime()==curDate.getTime()){
				status = "今天开始 ";
			}else if(this.planStartTime.getTime()<curDate.getTime()&&this.actStartTime==null){
				Long l = 0L;
		        try {
		            long sTime = planStartTime.getTime();
		            long  eTime= curDate.getTime();

		            l = (eTime - sTime) / (1000 * 60 * 60 * 24);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				status = "逾期 "+l.intValue()+"天未开始";
			}else if(this.planStartTime.getTime()<curDate.getTime()
					&&(this.actEndTime==null || curDate.getTime()<this.actEndTime.getTime())){
				status = "进行中";
			}
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public int getStatusCode() {
		Date curDate= new Date();
		if(this.planStartTime.getTime()<curDate.getTime()&&this.actStartTime==null){
			statusCode = 1;
		}
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	
	public String getPlanStartTimeStr() {
		if(this.planStartTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			planStartTimeStr = sdf.format(this.planStartTime);
		}
		return planStartTimeStr;
	}

	public void setPlanStartTimeStr(String planStartTimeStr) {
		this.planStartTimeStr = planStartTimeStr;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName="
				+ activityName + ", activityType=" + activityType
				+ ", activityCostSin=" + activityCostSin + ", activityNumber="
				+ activityNumber + ", activityCountCost=" + activityCountCost
				+ ", activityCostExplain=" + activityCostExplain
				+ ", activityResp=" + activityResp + ", otherExplain="
				+ otherExplain + ", clubId=" + clubId + ", planStartTime="
				+ planStartTime + ", planEndTime=" + planEndTime
				+ ", actStartTime=" + actStartTime + ", actEndTime="
				+ actEndTime + ", createTime=" + createTime + ", createUser="
				+ createUser + ", status=" + status + ", statusCode="
				+ statusCode + ", planStartTimeStr=" + planStartTimeStr + "]";
	}

	

	
}
