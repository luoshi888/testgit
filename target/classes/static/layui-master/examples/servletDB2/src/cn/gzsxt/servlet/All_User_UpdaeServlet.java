package cn.gzsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;
import cn.gzsxt.po.User;

public class All_User_UpdaeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("uid"));
			User user = new User(id,request.getParameter("name"),request.getParameter("psw"),request.getParameter("age"));
			
			UserDao userdao = new UserDaoimpl();
			int num = userdao.AllUserUpdate(user);
			if(num==1){
				request.getRequestDispatcher("/user/Select_All_UserServlet").forward(request, response);
			}else if(num==0){
				request.getRequestDispatcher("/all_user_show.jsp").forward(request, response);
			}
	}

}
