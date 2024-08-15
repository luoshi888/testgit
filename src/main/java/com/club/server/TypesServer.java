package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.dao.TypesRepository;
import com.club.pojo.Types;

@Service
public class TypesServer implements TypesRepository{
	
	@Autowired
	private TypesRepository typesRepository;

	@Override
	public List<Types> findByClueType(String category) {
		// TODO Auto-generated method stub
		return typesRepository.findByClueType(category);
	}

	@Override
	public Types findTypesById(Integer typeId) {
		// TODO Auto-generated method stub
		return typesRepository.findTypesById(typeId);
	}

}
