package com.ssafy.spring.map.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.map.model.SidoGugunCodeDto;

@Repository
public class MapRepositoryImpl implements MapRepository{
	
	SqlSession session;
	
	
	
	public MapRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	String ns = "com.ssafy.spring.map.repository.MapRepository.";

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return session.selectList(ns + "getSido");
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return session.selectList(ns + "getGugunInSido",sido);
	}

}
