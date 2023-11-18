package com.ssafy.spring.map.service;

import java.util.List;

import com.ssafy.spring.map.model.SidoGugunCodeDto;


public interface MapService {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	
}
