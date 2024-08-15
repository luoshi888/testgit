package com.club.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Role;

public interface RoleSpecificationExecutor extends JpaRepository<Role, Integer>,JpaSpecificationExecutor<Role>{

	@Query(value="select * from role where userId=?",nativeQuery=true)
	List<Role> getCurUserRoleList(Integer userId);
	
	@Query(value="select * from role where roleName like ? ",nativeQuery=true)
	List<Role> getAllRoleList(String roleName);
	
	@Query(value="select * from role where roleName = ? ",nativeQuery=true)
	Role findRoleByRoleName(String roleName);
	
	@Modifying
	@Transactional
	@Query(value="update role  set roleName = ? where roleId=? ",nativeQuery=true)
	int updateRole(String roleName,Integer roleId);
	
	@Query(value="select * from role where roleId=?",nativeQuery=true)
	Role getCurUserRoleListByRoleId(Integer roleId);
	
	@Modifying
	@Transactional
	@Query(value="delete from role where roleId=?",nativeQuery=true)
	int deleteRoleByRoleId(Integer roleId);
}
