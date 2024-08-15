package cn.gzsxt.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.po.User;
import cn.gzsxt.util.DBUtil;


public class UserDaoimpl implements UserDao{

	@Override
	public int UserRegister(User user) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection conn = null;
		conn = DBUtil.getConn();
		String sql = "insert into usertable(name,pwd,age) values(?,?,?)";
		
		int num = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getPwd());
			ps.setObject(3, user.getAge());
			num = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, null);
		}
		return num;
	}

	@Override
	public User UserLogin(User user) {
		// TODO Auto-generated method stub
		User returnuser = new User();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		String sql = "select * from usertable where name=? and  pwd=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getPwd());
			rs = ps.executeQuery();
		while(rs.next()){
			returnuser.setId(rs.getInt("id"));
			returnuser.setName(rs.getString("name"));
			returnuser.setPwd(rs.getString("pwd"));
			returnuser.setAge(rs.getString("age"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, rs);
		}
		return returnuser;
	}

	@Override
	public List<User> UserSelect(String id) {

		List<User> list = new ArrayList<User>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		String sql = "select * from usertable where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getString("age"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, rs);
		}
		
		return list;
	}

	@Override
	public int updateuser(User user) {
		// TODO Auto-generated method stub
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		
		conn = DBUtil.getConn();
		String sql = "update usertable set name=?,pwd =?,age=?  where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getPwd());
			ps.setObject(3, user.getAge());
			ps.setObject(4, user.getId());
			num = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, null);
		}
		
		return num;
	}

	@Override
	public List<User> SeleAlluser() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		String sql = "select * from usertable";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getString("age"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, rs);
		}
		
		return list;
	}

	@Override
	public int DeleteUser(String id) {
		// TODO Auto-generated method stub
		int idn = Integer.parseInt(id); 
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		conn = DBUtil.getConn();
		String sql = "delete from usertable where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, idn);
			
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int AllUserUpdate(User user) {
		// TODO Auto-generated method stub
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		
		conn = DBUtil.getConn();
		String sql = "update usertable set name=?,pwd =?,age=?  where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getPwd());
			ps.setObject(3, user.getAge());
			ps.setObject(4, user.getId());
			num = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, null);
		}
		
		return num;

	}

}
