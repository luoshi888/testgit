package com.club.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.ApprovalHelper;
import com.club.helper.UserHelper;
import com.club.pojo.Approval;
import com.club.pojo.User;
import com.club.server.ApprovalServer;

@Controller
@RequestMapping("/club")
public class HomeController {
	
	@Autowired
	private ApprovalServer approvalServer;
	
	@Autowired
	private UserHelper userHelper;
	
	@Autowired
	private ApprovalHelper approvalHelper;

	/**
	 * 整体页面框架布局
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")
	public String showHome(Model model){
		
		//读取d盘下是否存在该目录D://temp-rainy，是否存在图片picture_own.jpg
		File file = new File("D:\\temp-rainy");
		File[] files = file.listFiles();
		if(files==null ||files.length==0){
			model.addAttribute("pictruePath","/images/login/picture_own.jpg");
			return "home";
		}
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory() && files[i].getName().contains("picture_own.jpg")) {
				model.addAttribute("pictruePath","../temp-rainy/picture_own.jpg");
				break;
			} 
		}
		return "home";
	}
	
	@RequestMapping("/testIndex")
	public String showtestIndex(){
		
		
		return "testIndex";
	}
	
	/**
	 * 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/Index")
	public String showIndex(Model model,HttpServletRequest request){
		/*model.addAttribute("pageA", 1);
		model.addAttribute("pageA", 1);
		model.addAttribute("countB", 0);*/
		return "Index";
	}
	
	@RequestMapping("/homeIframe")
	public String showiframe1(){
		
		
		return "homeIframe";
	}
	
	/**
	 * 打开更换头像弹出页面
	 */
	@RequestMapping("/openUploadPicture")
	public String openUploadPicture(Model model,HttpServletRequest requst){
		String pictruePath = requst.getParameter("pictruePath");
		model.addAttribute("pictruePath",pictruePath);
		return "uploadPicture";
	}
	
}
