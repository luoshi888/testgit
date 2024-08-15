package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.RoleUseCrudReposiroty;
import com.club.dao.RoleUseRespository;
import com.club.pojo.RoleUser;

@Service
public class RoleUserServer implements RoleUseRespository{

	@Autowired
	private RoleUseRespository roleUseRespository;
	
	@Autowired
	private RoleUseCrudReposiroty roleUserCrudposiroty;
	@Override
	public int deleteRoleUseryRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleUseRespository.deleteRoleUseryRoleId(roleId);
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteInBatch(Iterable<RoleUser> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RoleUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RoleUser> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RoleUser> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RoleUser getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return roleUseRespository.saveAndFlush(arg0);
	}
	@Override
	public Page<RoleUser> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(RoleUser arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Iterable<? extends RoleUser> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public RoleUser findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> S save(S arg0) {
		// TODO Auto-generated method stub
		return roleUseRespository.save(arg0);
	}
	@Override
	public <S extends RoleUser> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends RoleUser> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <S extends RoleUser> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends RoleUser> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long count(Specification<RoleUser> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<RoleUser> findAll(Specification<RoleUser> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<RoleUser> findAll(Specification<RoleUser> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RoleUser> findAll(Specification<RoleUser> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RoleUser findOne(Specification<RoleUser> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RoleUser> getCurRoleByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return roleUseRespository.getCurRoleByUserId(userId);
	}
	@Override
	public int addRole(Integer userId,Integer roleid) {
		// TODO Auto-generated method stub
		return roleUserCrudposiroty.addRole(userId,roleid);
	}
	@Override
	public List<RoleUser> getUserByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleUseRespository.getUserByRoleId(roleId);
	}

	
}
