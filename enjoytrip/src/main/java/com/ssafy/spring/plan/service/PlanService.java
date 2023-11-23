package com.ssafy.spring.plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.plan.dto.PlanDto;
import com.ssafy.spring.plan.dto.TravelDto;
import com.ssafy.spring.plan.repository.PlanRepository;

@Service
public class PlanService{
	private PlanRepository repo;
	
	@Autowired
	public PlanService(PlanRepository repo) {
		super();
		this.repo = repo;
	}

	public int write(PlanDto dto) {
		// TODO Auto-generated method stub
		return repo.write(dto);
	}
	
	public int Twrite(TravelDto dto) {
		// TODO Auto-generated method stub
		return repo.Twrite(dto);
	}

	public int getPlanNo() {
		// TODO Auto-generated method stub
		return repo.getPlanNo();
	}
	
}
