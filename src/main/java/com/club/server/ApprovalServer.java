package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.ApprovalJpaSpecificationExecutor;
import com.club.pojo.Approval;

@Service
public class ApprovalServer implements ApprovalJpaSpecificationExecutor{

	@Autowired
	private ApprovalJpaSpecificationExecutor approvalJpaSpecificationExecutor;
	
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Approval> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Approval> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Approval> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Approval> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Approval getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Approval> findAll(Pageable arg0) {
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
	public void delete(Approval arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Approval> arg0) {
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
	public Approval findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Approval> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Approval> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<Approval> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Approval> findAll(Specification<Approval> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Approval> findAll(Specification<Approval> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Approval> findAll(Specification<Approval> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Approval findOne(Specification<Approval> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findApprovalListByApprUser(Integer approvalUser,Integer approvalUser2) {
		// TODO Auto-generated method stub
		if(approvalUser==null || approvalUser2==null){
			return null;
		}
		return approvalJpaSpecificationExecutor.findApprovalListByApprUser(approvalUser,approvalUser2);
	}
	
	@Override
	public List<Object> findApprovalListByApprUserPage(Integer approvalUser,Integer startPage,Integer numb) {
		// TODO Auto-generated method stub
		if(approvalUser==null){
			return null;
		}
		return approvalJpaSpecificationExecutor.findApprovalListByApprUserPage(approvalUser,startPage,numb);
	}

	@Override
	public int findApprovalListByApprUserCount(Integer approvalUser) {
		// TODO Auto-generated method stub
		if(approvalUser==null){
			return 0;
		}
		return approvalJpaSpecificationExecutor.findApprovalListByApprUserCount(approvalUser);
	}

}
