package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.ClubJpaSpecificationExecutor;
import com.club.pojo.Club;
import com.club.pojo.Types;

@Service
public class ClubServer implements ClubJpaSpecificationExecutor{
	
	@Autowired
	private ClubJpaSpecificationExecutor clubJpaSpecificationExecutor;

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Club> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Club> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Club> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Club> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Club> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Club> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Club getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Club> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Club> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Club> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer clubId) {
		// TODO Auto-generated method stub
		clubJpaSpecificationExecutor.delete(clubId);
	}

	@Override
	public void delete(Club arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Club> arg0) {
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
	public Club findOne(Integer clubId) {
		// TODO Auto-generated method stub
		return clubJpaSpecificationExecutor.findOne(clubId);
	}

	@Override
	public <S extends Club> S save(S club) {
		// TODO Auto-generated method stub
		return clubJpaSpecificationExecutor.save(club);
	}

	@Override
	public <S extends Club> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Club> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Club> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Club> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<Club> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Club> findAll(Specification<Club> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Club> findAll(Specification<Club> spec, Pageable page) {
		// TODO Auto-generated method stub
		return clubJpaSpecificationExecutor.findAll(spec, page);
	}

	@Override
	public List<Club> findAll(Specification<Club> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Club findOne(Specification<Club> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Club> findClubByClubName(Integer clubId,String clubName) {
		// TODO Auto-generated method stub
		return clubJpaSpecificationExecutor.findClubByClubName(clubId,clubName);
	}


}
