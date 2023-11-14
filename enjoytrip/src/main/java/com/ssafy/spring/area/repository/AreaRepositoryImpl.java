package com.ssafy.spring.area.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.area.dto.AreaDto;
import com.ssafy.spring.area.dto.GugunDto;

@Repository
public class AreaRepositoryImpl implements AreaRepository{

	SqlSession session;
		
	public AreaRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	String ns = "com.ssafy.spring.area.repository.AreaRepository.";


	@Override
	public List<AreaDto> sidoList() {
		// TODO Auto-generated method stub
		return session.selectList(ns+"sidolist");
	}

	@Override
	public List<GugunDto> gugunList(int sidoCode) {		
		return session.selectList(ns + "gugunlist", sidoCode);
	}

}
