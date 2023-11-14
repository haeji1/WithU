package com.ssafy.spring.attraction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.spring.attraction.dto.AttractionDto;
import com.ssafy.spring.attraction.dto.KeywordDto;
import com.ssafy.spring.attraction.service.AttractionService;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
	
	private AttractionService service;

	public AttractionController(AttractionService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/search")
	public void search(HttpServletResponse response, KeywordDto dto, String keyword) throws StreamWriteException, DatabindException, IOException {
		System.out.println("==============");
		System.out.println(dto);		
		System.out.println("==============");
		
		ObjectMapper mapper = new ObjectMapper();
		List<AttractionDto> list = service.getList(dto);
		response.setCharacterEncoding("UTF-8");
		mapper.writeValue(response.getWriter(), list);		
	}
	
}
