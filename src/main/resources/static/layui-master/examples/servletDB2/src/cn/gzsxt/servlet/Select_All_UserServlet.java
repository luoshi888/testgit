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

public class Select_All_UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		UserDao userdao = new UserDaoimpl();
		List<User> list = userdao.SeleAlluser();
		request.setAttribute("userlist", list);
		
		request.getRequestDispatcher("/all_user_show.jsp").forward(request, response);
	}

}
