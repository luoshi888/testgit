package cn.gzsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;
import cn.gzsxt.po.User;

public class Select_user_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			String idi = request.getParameter("id");
			HttpSession sessiion = request.getSession();
			sessiion.setAttribute("id", idi);
			String ob = (String) sessiion.getAttribute("id");
			User user = new User();
			UserDao  userdao = new UserDaoimpl();
			List<User> userlist = userdao.UserSelect(ob);
			
			request.setAttribute("userlist", userlist);
			request.getRequestDispatcher("/user_show.jsp").forward(request, response);
			
	}

}
