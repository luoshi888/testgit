package cn.gzsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gzsxt.dao.UserDao;
import cn.gzsxt.impl.UserDaoimpl;
import cn.gzsxt.po.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    User user = new User();
		    user.setName(request.getParameter("name"));
		    user.setPwd(request.getParameter("psw"));
		    UserDao userdao = new UserDaoimpl();
		    User userre = userdao.UserLogin(user);
		    
		    if(userre!=null&&userre.getName()!=null){
		    	HttpSession session = request.getSession();
		    	session.setAttribute("idlist", userre.getId());
		    	request.getRequestDispatcher("/login_success.jsp").forward(request, response);
		    }else{
		    	request.getRequestDispatcher("/login.jsp").forward(request, response);
		    }
		    
	}

}
