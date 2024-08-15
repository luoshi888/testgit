package cn.gzsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;
import cn.gzsxt.po.User;

public class Update_User_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("uid");
		int idi = Integer.parseInt(id);
		UserDao uesrdao = new UserDaoimpl();
		User user = new User(idi,request.getParameter("name"),request.getParameter("psw"),request.getParameter("age"));
		
	
		int num = uesrdao.updateuser(user);
		if(num==1){
			
			request.getRequestDispatcher("/user/Select_user_Servlet?id="+idi).forward(request, response);
		}
		else if(num==0){
			
		}
	}

}
