package com.ssafy.spring.area.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.spring.area.dto.AreaDto;
import com.ssafy.spring.area.dto.GugunDto;
import com.ssafy.spring.area.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	
	private AreaService service;
	
	@Autowired	
	public AreaController(AreaService service) {
		super();
		this.service = service;
	}

	@GetMapping("/sidosearch")
	public void sidosearch(HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
//		Map<String, String> area = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		List<AreaDto> list = service.sidoList();
		response.setCharacterEncoding("UTF-8");
		mapper.writeValue(response.getWriter(), list);
		
	}
	
	@GetMapping("/gugunsearch")
	public void gugunSearch(HttpServletResponse response, String sido) throws StreamWriteException, DatabindException, IOException {
		int sidoCode = Integer.parseInt(sido);
		
		ObjectMapper mapper = new ObjectMapper();
		List<GugunDto> list = service.gugunList(sidoCode);
		System.out.println(list);
		response.setCharacterEncoding("UTF-8");
		mapper.writeValue(response.getWriter(), list);
	}
	
}
