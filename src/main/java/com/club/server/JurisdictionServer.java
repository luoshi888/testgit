package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.JurisdictionJpaSpecificationExecutor;
import com.club.pojo.Jurisdiction;

@Service
public class JurisdictionServer implements JurisdictionJpaSpecificationExecutor {
	
	@Autowired
	private JurisdictionJpaSpecificationExecutor jurisdictionJSE;

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Jurisdiction> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jurisdiction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jurisdiction> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jurisdiction> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jurisdiction getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Jurisdiction> findAll(Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> S save(S paramS) {
		// TODO Auto-generated method stub
		return jurisdictionJSE.save(paramS);
	}

	@Override
	public Jurisdiction findOne(Integer paramID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer paramID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer paramID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Jurisdiction paramT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Jurisdiction> paramIterable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Jurisdiction> S findOne(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> Page<S> findAll(Example<S> paramExample,
			Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Jurisdiction> long count(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Jurisdiction> boolean exists(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count(Specification<Jurisdiction> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Jurisdiction> findAll(Specification<Jurisdiction> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Jurisdiction> findAll(Specification<Jurisdiction> arg0,
			Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jurisdiction> findAll(Specification<Jurisdiction> arg0,
			Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jurisdiction findOne(Specification<Jurisdiction> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jurisdiction> getRoleJurisdiction(Integer jurisdictionId,
			String roleIdStr) {
		// TODO Auto-generated method stub
		return jurisdictionJSE.getRoleJurisdiction(jurisdictionId, roleIdStr);
	}

	@Override
	public int deleteRoleJurisdictionByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return jurisdictionJSE.deleteRoleJurisdictionByRoleId(roleId);
	}

	@Override
	public int addJurisdiction(Integer jurisdictionId, Integer roleId) {
		// TODO Auto-generated method stub
		return jurisdictionJSE.addJurisdiction(jurisdictionId, roleId);
	}

	@Override
	public List<Jurisdiction> getJurisdictionByRoleId(Integer roleId){
		// TODO Auto-generated method stub
		return jurisdictionJSE.getJurisdictionByRoleId(roleId);
	}

}
