package com.ssafy.spring.attraction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssafy.spring.attraction.dto.AttractionDto;
import com.ssafy.spring.attraction.dto.KeywordDto;
import com.ssafy.spring.attraction.repository.AttractionRepository;


@Service
public class AttractionServcieImpl implements AttractionService{
	
	private AttractionRepository repo;
	
	@Autowired
	public AttractionServcieImpl(AttractionRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public List<AttractionDto> getList(KeywordDto dto) {		
		return repo.getList(dto);
	}

}
