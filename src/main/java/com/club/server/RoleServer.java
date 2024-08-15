package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.RoleSpecificationExecutor;
import com.club.pojo.Role;

@Service
public class RoleServer implements RoleSpecificationExecutor {
	
	@Autowired
	private RoleSpecificationExecutor roleSpecificationExecutor;
	

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Role> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.findAll();
	}

	@Override
	public List<Role> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getOne(Integer roleId) {
		// TODO Auto-generated method stub
		return this.roleSpecificationExecutor.getOne(roleId);
	}

	@Override
	public <S extends Role> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.save(arg0);
	}

	@Override
	public <S extends Role> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.save(arg0);
	}

	@Override
	public Page<Role> findAll(Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> S save(S paramS) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.save(paramS);
	}

	@Override
	public Role findOne(Integer paramID) {
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
	public void delete(Role paramT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Role> paramIterable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Role> S findOne(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> paramExample,
			Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Role> long count(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Role> boolean exists(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count(Specification<Role> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> findAll(Specification<Role> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> findAll(Specification<Role> spenc, Pageable page) {
		// TODO Auto-generated method stub
		return this.roleSpecificationExecutor.findAll(spenc, page);
	}

	@Override
	public List<Role> findAll(Specification<Role> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findOne(Specification<Role> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getCurUserRoleList(Integer userId) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.getCurUserRoleList(userId);
	}

	@Override
	public List<Role> getAllRoleList(String roleName) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.getAllRoleList(roleName);
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.findRoleByRoleName(roleName);
	}

	@Override
	public int updateRole(String roleName,Integer roleId) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.updateRole(roleName,roleId);
	}

	@Override
	public Role getCurUserRoleListByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.getCurUserRoleListByRoleId(roleId);
	}

	@Override
	public int deleteRoleByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleSpecificationExecutor.deleteRoleByRoleId(roleId);
	}

}
