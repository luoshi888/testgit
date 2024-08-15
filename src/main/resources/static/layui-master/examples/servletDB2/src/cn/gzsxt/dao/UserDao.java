package cn.gzsxt.dao;

import java.util.List;

import cn.gzsxt.po.User;

public interface UserDao {
	
	public int UserRegister(User user);
	
	public User UserLogin(User usr);
	
	public List<User> UserSelect(String id);
	
	public int updateuser(User user);
	
	public List<User> SeleAlluser();
	
	public int DeleteUser(String id);
	
	public int AllUserUpdate(User user);
}
