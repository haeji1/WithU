package com.ssafy.spring.area.service;

import java.util.List;

import com.ssafy.spring.area.dto.AreaDto;
import com.ssafy.spring.area.dto.GugunDto;

public interface AreaService {
	public List<AreaDto> sidoList();
	public List<GugunDto> gugunList(int sidoCode);

}
