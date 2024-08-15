package com.club.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.helper.ClubHelper;
import com.club.helper.UserHelper;
import com.club.pojo.Club;
import com.club.pojo.Types;
import com.club.pojo.User;
import com.club.server.ClubServer;
import com.club.server.TypesServer;
import com.club.server.UserServer;

@Controller
@RequestMapping("/club")
public class ClubController {
	
	@Autowired
	private ClubServer clubServer;
	
	@Autowired
	private TypesServer typesServer;
	
	@Autowired
	private UserServer userServer;
	@Autowired
	private ClubHelper clubHelper;
	
	@Autowired
	private UserHelper userHelper;
	
	
	
	/**
	 * 跳转到俱乐部页面,分页省略
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/clubList")
	public String showClubList(User user,Model model,HttpServletRequest request){
		final String myClub = request.getParameter("myClub");
		final User curUser = userHelper.getCurUser(request);
		Sort sort = new Sort(Direction.DESC,"clubId");
		//分页的定义
		Pageable pageable = new PageRequest(0,50, sort);
		
		//查询条件
		Specification<Club> spec = new Specification<Club>() {

			@Override
			public Predicate toPredicate(Root<Club> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if("1".equals(myClub)){
					Predicate pre = cb.equal(root.get("resUser"), curUser);
					return pre;
				}else{
					return null;
				}
			}
			
		};
		Page<Club> page = this.clubServer.findAll(spec, pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		List<Club> clubList = page.getContent();
		model.addAttribute("clubList", clubList);
		return "clubList";
	}
	
	/**
	 * 跳转到添加页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showAdd")
	public String doShowAdd (Model model,HttpServletRequest request){
		
		User user = new User();
		Types currentTypes = new Types();
		//获取所有俱乐部类型；
		List<Types> typesList = typesServer.findByClueType("club");
		if(typesList==null){
			typesList = new ArrayList<Types>();
		}
		model.addAttribute("typesList", typesList);
		model.addAttribute("currentTypes", currentTypes);
		Club club = new Club();
		club.setResUser(user);
		club.setTypes(currentTypes);
		model.addAttribute("club", club);
		return "clubInfo";
	}
	/**
	 * 选择用户列表
	 * @param model
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAllUser")
	public String findAllUser(Model model,User user,HttpServletRequest request){
		List<User> userList = userServer.findAllUser();
		model.addAttribute("userList", userList);
		return "userList";
	}
	
	/**
	 * 新增或者跳转到更新操作
	 * @param model
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/add")
	public String doAddClube(Model model,Club club,HttpServletRequest request){
		Integer clubId = club.getClubId();;
		if(clubId==null){
			//新增
			clubHelper.initAddForm(club, true, request);
			if(club.getTypes()==null){
				club.setTypes(new Types());
			}
			if(club.getResUser()==null){
				club.setResUser(new User());
			}
			List<String> errorMessageList =new ArrayList<String>();
			boolean isExistClubName = clubHelper.isExistClubName(club.getClubId(),club.getClubName());
			boolean isHavaError =  clubHelper.checkForm(club,errorMessageList);
			if(!isExistClubName  && !isHavaError){
				clubServer.save(club);
			}
			if(isExistClubName){
				errorMessageList.add("俱乐部名称已存在，请重新输入！");
				model.addAttribute("errorMessageList", errorMessageList);
			}
			model.addAttribute("errorMessageList", errorMessageList);
			//获取所有俱乐部类型；
			List<Types> typesList = typesServer.findByClueType("club");
			if(typesList==null){
				typesList = new ArrayList<Types>();
			}
			model.addAttribute("typesList", typesList);
			model.addAttribute("currentTypes", club.getTypes());
			model.addAttribute("club", club);
			return "clubInfo";
		}else{
			//修改
			return "forward:/club/doUpdateClub";
		}
		
	}
	
	/**
	 * 修改
	 * @param model
	 * @param club
	 * @param request
	 * @return
	 */
	@RequestMapping("/doUpdateClub")
	public String doUpdateUser(Model model,Club club,HttpServletRequest request){
		Integer clubId = club.getClubId();
		if(clubId!=null){
			//club = clubServer.findOne(Integer.parseInt(clubId));
			clubHelper.initAddForm(club, false, request);
			List<String> errorMessageList =new ArrayList<String>();
			boolean isExistClubName = clubHelper.isExistClubName(club.getClubId(),club.getClubName());
			boolean isHavaError =  clubHelper.checkForm(club,errorMessageList);
			if(!isExistClubName && !isHavaError){
				clubServer.save(club);
			}
			if(isExistClubName){
				errorMessageList.add("俱乐部名称已存在，请重新输入！");
			}
			model.addAttribute("errorMessageList", errorMessageList);
		}
		Types currentTypes = club.getTypes();
		//获取所有俱乐部类型；
		List<Types> typesList = typesServer.findByClueType("club");
		if(typesList==null){
			typesList = new ArrayList<Types>();
		}
		model.addAttribute("typesList", typesList);
		model.addAttribute("currentTypes", currentTypes);
		model.addAttribute("club", club);
		return "clubInfo";
	}
	
	/**
	 * 删除
	 * @param model
	 * @param club
	 * @param request
	 * @return
	 */
	@RequestMapping("/doDeleteClub")
	public String doDeleteClub(Model model,Club club,HttpServletRequest request){
		String clubId = request.getParameter("clubId");
		if(clubId!=null){
			clubServer.delete(Integer.parseInt(clubId));
		}
		return "forward:/club/clubList";
	}
	
	/**
	 * 跳转到更新页面
	 * @param model
	 * @param club
	 * @param request
	 * @return
	 */
	@RequestMapping("/doShowUpdate")
	public String doShowUpdate(Model model,Club club,HttpServletRequest request){
		String clubId = request.getParameter("clubId");
		if(clubId!=null&&!"".equals(clubId.trim())){
			club = clubServer.findOne(Integer.parseInt(clubId));
		}
		clubHelper.initViewForm(club,request);
		Types currentTypes = club.getTypes();
		//获取所有俱乐部类型；
		List<Types> typesList = typesServer.findByClueType("club");
		if(typesList==null){
			typesList = new ArrayList<Types>();
		}
		model.addAttribute("typesList", typesList);
		model.addAttribute("currentTypes", currentTypes);
		model.addAttribute("club", club);
		return "clubInfo";
	}

}
