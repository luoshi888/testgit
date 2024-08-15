package com.club.helper;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.ActivityJpaSpecificationExecutor;
import com.club.pojo.Activity;
import com.club.pojo.Club;
import com.club.pojo.User;
import com.club.server.ActivityServer;

@Service
public class ActivityHelper {

	@Autowired	
	private ActivityJpaSpecificationExecutor activityJpaSpecificationExecutor;
	@Autowired
	private ActivityServer activityServer;
	@Autowired
	private UserHelper userHelper;
	
	public Page<Activity> getActivityReadyListPageByResp(HttpServletRequest request){
		
		final User curUser = userHelper.getCurUser(request);
		Integer curPage  = 0;//当前页
		String curPageStr = request.getParameter("curPage");
		if(curPageStr!=null){
			curPage = Integer.parseInt(curPageStr)-1;
		}
		Integer limit = 5;//每页显示5条记录
		
		Sort sort = new Sort(Direction.DESC,"activityId");
		//分页的定义
		Pageable pageable = new PageRequest(curPage,5, sort);
		
		//查询条件
		Specification<Activity> spec = new Specification<Activity>() {
			List<Predicate> predicates = Lists.newArrayList(); 

			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				predicates.add(cb.equal(root.get("activityResp"), curUser));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
		};
		Page<Activity> page = this.activityServer.findAll(spec, pageable);
		
		return page;
	}
}
