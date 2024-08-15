package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.club.pojo.Club;
import com.club.pojo.Types;

public interface ClubJpaSpecificationExecutor extends JpaRepository<Club, Integer>,JpaSpecificationExecutor<Club>{

	@Query(value="select * from club where clubId not in (?) and  clubName = ?",nativeQuery=true)
	List<Club> findClubByClubName(Integer clubId,String clubName);
}
