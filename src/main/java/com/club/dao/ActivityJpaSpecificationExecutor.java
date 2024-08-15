package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Activity;

public interface ActivityJpaSpecificationExecutor extends JpaRepository<Activity, Integer>,JpaSpecificationExecutor<Activity>{

	//List<Activity> findActivityReadyListPageByResp();
}
