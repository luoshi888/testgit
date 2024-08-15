package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.dao.UsersRepository;
import com.club.pojo.User;

@Service
public class UserServer implements UsersRepository{
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<User> findByNameAndPassWord(String userName, String passWord) {
		// TODO Auto-generated method stub
		return usersRepository.findByNameAndPassWord(userName, passWord);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return usersRepository.findAllUser();
	}

	@Override
	public User findUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return usersRepository.findUserByUserId(userId);
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return usersRepository.findUserByUserName(userName);
	}

}
