package com.ssafy.spring.plan.service;

import java.util.List;

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
		return repo.Twrite(dto);
	}

	public int getPlanNo() {
		return repo.getPlanNo();
	}
	public List<PlanDto> list(){
		return repo.list();
	}
	public PlanDto view(int planNo) {
		return repo.view(planNo);
	}
	
	public List<TravelDto> getTravelInfo(int planNo){
		return repo.getTravelInfo(planNo);
	}
}
