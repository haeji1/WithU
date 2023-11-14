package com.ssafy.spring.area.repository;

import java.util.List;

import com.ssafy.spring.area.dto.AreaDto;
import com.ssafy.spring.area.dto.GugunDto;

public interface AreaRepository {
	public List<AreaDto> sidoList();
	public List<GugunDto> gugunList(int sidoCode);
}
