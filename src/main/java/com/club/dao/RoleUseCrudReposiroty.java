package com.club.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.club.pojo.RoleUser;

public interface RoleUseCrudReposiroty extends CrudRepository<RoleUser, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="insert into roleUser (userId,roleId) values(?,?)",nativeQuery=true)
	int addRole(Integer userId,Integer roleid);
}
