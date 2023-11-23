package com.ssafy.spring.plan.repository;

import com.ssafy.spring.plan.dto.PlanDto;
import com.ssafy.spring.plan.dto.TravelDto;

public interface PlanRepository {
	public int write(PlanDto dto);
	public int Twrite(TravelDto dto);
	public int getPlanNo();	
}
