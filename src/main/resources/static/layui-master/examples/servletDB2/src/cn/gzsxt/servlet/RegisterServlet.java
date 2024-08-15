package cn.gzsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;
import cn.gzsxt.po.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("psw"));
		user.setAge(request.getParameter("age"));
		UserDao userdao = new UserDaoimpl();
		
		int num = userdao.UserRegister(user);
		if(num==0){
			request.getRequestDispatcher("/user/FalseRegisterServlet").forward(request, response);
		}
		else if(num==1){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
