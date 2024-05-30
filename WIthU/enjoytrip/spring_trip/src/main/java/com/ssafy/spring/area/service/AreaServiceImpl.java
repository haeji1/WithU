package com.ssafy.spring.area.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.area.dto.AreaDto;
import com.ssafy.spring.area.dto.GugunDto;
import com.ssafy.spring.area.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService{

	private AreaRepository repo;
	
	@Autowired	
	public AreaServiceImpl(AreaRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<AreaDto> sidoList() {	
		return repo.sidoList();
	}

	@Override
	public List<GugunDto> gugunList(int sidoCode) {		
		return repo.gugunList(sidoCode);
	}

}
