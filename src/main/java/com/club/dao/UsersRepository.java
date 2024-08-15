package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.club.pojo.User;

public interface UsersRepository extends Repository<User, Integer>{

	@Query(value="select userId,userCode,userName,passWord,userType from users where userName=? and passWord=?",nativeQuery=true)
	List<User> findByNameAndPassWord(String userName,String passWord);
	
	@Query(value="select userId,userCode,userName,passWord,case userType when 'responsible' then '负责人' when 'administer' then '管理员' else '' end userType from users where userId not in(1) ",nativeQuery=true)
	List<User> findAllUser();
	
	@Query(value="select * from users where userId=?",nativeQuery=true)
	User findUserByUserId(Integer userId);
	
	@Query(value="select * from users where userName=?",nativeQuery=true)
	User findUserByUserName(String userName);
	
}
