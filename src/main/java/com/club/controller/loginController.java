package com.club.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.UserHelper;
import com.club.pojo.User;

@Controller
@RequestMapping("/club")
public class loginController {
	
	@Autowired
	private UserHelper userhelper;

	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin(){
		
		return "login";
	}
	/**
	 * 检查登陆信息，正确跳转到俱乐部列表页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin")
	public String doCheckLoginInfo(User user,Model model,HttpServletRequest request){
		//密码加密逻辑代码省略
		
		Map<String, Object> loginInfoMap = userhelper.checkLoginInfo(user);
		//loginInfoMap.get("isUserExists")!=null ：表明密码和账号都不为空
		if(loginInfoMap.get("isUserExists")!=null){
			boolean isUserExists = (boolean)loginInfoMap.get("isUserExists");
			if(isUserExists){
				HttpSession session = request.getSession();
				session.setAttribute("curUserId", ((User)loginInfoMap.get("user")).getUserId());
				session.setAttribute("user", (User)loginInfoMap.get("user"));
				return "forward:/club/home";
			}else{
				model.addAttribute("userName", user.getUserName());
				model.addAttribute("passWord", user.getPassWord());
				model.addAttribute("message", "用户名或密码错误！");
				return "login";
			}
		}else{
			if(loginInfoMap.get("nameNull")!=null){
				model.addAttribute("nameNull", loginInfoMap.get("nameNull"));
				model.addAttribute("passWord", user.getPassWord());
			}
			if(loginInfoMap.get("passWordNull")!=null){
				model.addAttribute("passWordNull", loginInfoMap.get("passWordNull"));
				model.addAttribute("userName", user.getUserName());
			}
			return "login";
		}
	}
	
}
