package com.club.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Jurisdiction;

public interface JurisdictionJpaSpecificationExecutor extends JpaRepository<Jurisdiction, Integer>,JpaSpecificationExecutor<Jurisdiction>{

	@Query(value="select * from jurisdiction where jurisdictionId=? and roleId in (?)",nativeQuery=true)
	List<Jurisdiction> getRoleJurisdiction(Integer jurisdictionId,String roleIdStr);
	
	@Modifying
	@Transactional
	@Query(value="delete from jurisdiction where roleId=?",nativeQuery=true)
	int deleteRoleJurisdictionByRoleId(Integer roleId);
	
	@Modifying
	@Transactional
	@Query(value="insert into jurisdiction (jurisdictionid,roleid) values(?,?)",nativeQuery=true)
	int addJurisdiction(Integer jurisdictionId,Integer roleId);
	
	@Query(value="select * from jurisdiction where roleId =?",nativeQuery=true)
	List<Jurisdiction> getJurisdictionByRoleId(Integer roleId);
	
}
