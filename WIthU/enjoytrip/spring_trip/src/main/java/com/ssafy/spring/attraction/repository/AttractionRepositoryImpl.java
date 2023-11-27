package com.ssafy.spring.attraction.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.attraction.dto.AttractionDto;
import com.ssafy.spring.attraction.dto.KeywordDto;

@Repository
public class AttractionRepositoryImpl implements AttractionRepository{

	SqlSession session;
			
	public AttractionRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}

	String ns = "com.ssafy.spring.attraction.repository.AttractionRepository.";


	@Override
	public List<AttractionDto> getList(KeywordDto dto) {
		
		return session.selectList(ns + "getlist", dto);
	}

}
