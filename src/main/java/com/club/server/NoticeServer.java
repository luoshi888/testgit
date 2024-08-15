package com.club.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.club.dao.NoticeJpaSpecificationExecutor;
import com.club.pojo.Notice;

@Service
public class NoticeServer implements NoticeJpaSpecificationExecutor{

	@Autowired
	private NoticeJpaSpecificationExecutor noticeJpaSpecificationExecutor;
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Notice> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notice getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Notice> findAll(Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> S save(S paramS) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findOne(Integer paramID) {
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
	public void delete(Notice paramT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Notice> paramIterable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Notice> S findOne(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> Page<S> findAll(Example<S> paramExample,
			Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notice> long count(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Notice> boolean exists(Example<S> paramExample) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count(Specification<Notice> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notice> findAll(Specification<Notice> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Notice> findAll(Specification<Notice> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> findAll(Specification<Notice> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findOne(Specification<Notice> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> findNoticeListPage(Integer startPage, Integer number) {
		// TODO Auto-generated method stub
		return noticeJpaSpecificationExecutor.findNoticeListPage(startPage, number);
	}

	@Override
	public int getNoticeCount() {
		// TODO Auto-generated method stub
		return noticeJpaSpecificationExecutor.getNoticeCount();
	}

}
