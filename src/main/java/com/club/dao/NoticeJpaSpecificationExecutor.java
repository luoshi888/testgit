package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Notice;

public interface NoticeJpaSpecificationExecutor extends JpaRepository<Notice, Integer>,JpaSpecificationExecutor<Notice>{

	@Query(value="select * from notice order by createTime desc limit ? ,?",nativeQuery=true)
	List<Notice> findNoticeListPage(Integer startPage,Integer number);
	
	@Query(value="select count(*) from notice",nativeQuery=true)
	int getNoticeCount();
}
