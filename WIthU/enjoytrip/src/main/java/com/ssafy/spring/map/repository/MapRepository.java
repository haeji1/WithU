package com.ssafy.spring.map.repository;

import java.util.List;

import com.ssafy.spring.map.model.SidoGugunCodeDto;

public interface MapRepository {
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
}
