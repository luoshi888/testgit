package com.club.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.club.pojo.Types;

public interface TypesRepository extends Repository<Types, Integer>{

	@Query(value="select typeId,category,typeName  from types where category=?",nativeQuery=true)
	List<Types> findByClueType(String category);
	
	@Query(value="select * from types where typeId =?" ,nativeQuery=true)
	Types findTypesById(Integer typeId);
}
