package com.ssafy.spring.plan.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.plan.dto.PlanDto;
import com.ssafy.spring.plan.dto.TravelDto;

@Repository
public class PlanRepositoryImpl implements PlanRepository{
	SqlSession session;

	public PlanRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	String ns = "com.ssafy.spring.plan.repository.PlanRepository.";

	@Override
	public int write(PlanDto dto) {
		return session.insert(ns+"write", dto);
	}

	@Override
	public int Twrite(TravelDto dto) {
		return session.insert(ns+"travelwrite", dto);
	}

	@Override
	public int getPlanNo() {
		return session.selectOne(ns+"getAutoInc");
	}

	@Override
	public List<PlanDto> list() {
		return session.selectList(ns + "list");
	}

	@Override
	public PlanDto view(int planNo) {
		return session.selectOne(ns + "view", planNo);
	}
	
	
}	
