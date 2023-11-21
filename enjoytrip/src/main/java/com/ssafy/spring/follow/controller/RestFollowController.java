package com.ssafy.spring.follow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.spring.follow.dto.FollowDto;
import com.ssafy.spring.follow.service.FollowService;

@CrossOrigin("*")
@Controller
@RequestMapping("/resfollow")
public class RestFollowController {
	
	private FollowService service;
	
	@Autowired
	public RestFollowController(FollowService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/follow")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Follow(@RequestBody FollowDto dto) {
		Map<String, Object> map = new HashMap<>();
		try {
			int res = service.follow(dto);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}

	@GetMapping("/follower")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> FollowerList(String followId) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<FollowDto> res = service.followerlist(followId);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/following")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> FollowList(String userId) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<FollowDto> res = service.followlist(userId);
			map.put("resmsg", "입력 성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		
		ResponseEntity<Map<String,Object>> res = new ResponseEntity(map,HttpStatus.OK);
		return res;
	}
}
