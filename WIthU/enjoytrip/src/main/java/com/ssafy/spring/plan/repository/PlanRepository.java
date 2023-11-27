package com.ssafy.spring.plan.repository;

import java.util.List;

import com.ssafy.spring.plan.dto.PlanDto;
import com.ssafy.spring.plan.dto.TravelDto;

public interface PlanRepository {
	public int write(PlanDto dto);
	public int Twrite(TravelDto dto);
	public int getPlanNo();	
	public List<PlanDto> list();
	public PlanDto view(int planNo);
	public List<TravelDto> getTravelInfo(int planNo);
}
