package cn.gzsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;

public class Dele_User_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		UserDao userdao =new UserDaoimpl();
		
		int num = userdao.DeleteUser(id);
		if(num==1){
			request.getRequestDispatcher("/user/Select_All_UserServlet").forward(request, response);
		}else if(num==0){
			request.getRequestDispatcher("/all_user_show.jsp").forward(request, response);
		}
	}

}
