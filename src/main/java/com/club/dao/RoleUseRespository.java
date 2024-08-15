package com.club.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.RoleUser;

public interface RoleUseRespository extends JpaRepository<RoleUser, Integer>,JpaSpecificationExecutor<RoleUser>{

	@Modifying
	@Transactional
	@Query(value="delete from roleUser where roleId=?",nativeQuery=true)
	int deleteRoleUseryRoleId(Integer roleId);
	
	@Query(value="select *  from roleUser where userId=?",nativeQuery=true)
	List<RoleUser> getCurRoleByUserId(Integer userId);
	
	@Query(value="insert into roleUser (userId,roleId) values(?,?)",nativeQuery=true)
	int addRole(Integer userId,Integer roleid);
	
	@Query(value="select *  from roleUser where roleId=?",nativeQuery=true)
	List<RoleUser> getUserByRoleId(Integer roleId);
}
