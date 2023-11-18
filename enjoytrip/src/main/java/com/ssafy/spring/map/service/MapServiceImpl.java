package com.ssafy.spring.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.map.model.SidoGugunCodeDto;
import com.ssafy.spring.map.repository.MapRepository;

@Service
public class MapServiceImpl implements MapService {
	
	private MapRepository repo;
	
	@Autowired
	public MapServiceImpl(MapRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return repo.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return repo.getGugunInSido(sido);
	}

}
