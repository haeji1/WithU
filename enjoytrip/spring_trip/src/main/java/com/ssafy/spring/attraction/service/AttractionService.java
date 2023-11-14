package com.ssafy.spring.attraction.service;

import java.util.List;

import com.ssafy.spring.attraction.dto.AttractionDto;
import com.ssafy.spring.attraction.dto.KeywordDto;

public interface AttractionService {
	public List<AttractionDto> getList(KeywordDto dto);
}
