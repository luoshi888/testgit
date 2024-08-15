package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Approval;

public interface ApprovalJpaSpecificationExecutor  extends JpaRepository<Approval, Integer>,JpaSpecificationExecutor<Approval>{

	@Query(value=" select a.objId, t.typeName as apprName,c.clubName as objName,a.objType,u.userName as respUser,'待审批' as status,a.approvalUser from approval a ,types t,club c,users u"
			    + " where  a.approvalType=t.category and a.objId=c.clubId and c.responsibleId=u.userId and a.status!='approval' and a.approvalUser=? "
			    + "UNION ALL "
			    + "select a.objId, t.typeName as apprName,ac.activityName as objName,a.objType,u.userName as respUser,'待审批' as status,a.approvalUser from approval a ,types t,activity ac,users u "
			    + "where  a.approvalType=t.category and a.objId=ac.activityId  and ac.activityResp=u.userId and a.status!='approval' and a.approvalUser=?",nativeQuery=true)
	List<Object> findApprovalListByApprUser(Integer approvalUser,Integer approvalUser2);
	
	@Query(value=" select * from approvalView where approvalUser=? limit ?,?",nativeQuery=true)
	List<Object> findApprovalListByApprUserPage(Integer approvalUser,Integer startPage,Integer numb);
	
	@Query(value=" select count(*) from approvalView where approvalUser=?",nativeQuery=true)
	int findApprovalListByApprUserCount(Integer approvalUser);
}
