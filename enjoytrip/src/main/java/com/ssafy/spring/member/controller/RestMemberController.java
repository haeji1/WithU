package com.ssafy.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.spring.member.dto.MemberDto;
import com.ssafy.spring.member.service.MemberService;

@CrossOrigin("*")
@Controller
@RequestMapping("/resmem")
public class RestMemberController {

	private MemberService service;

	@Autowired
	public RestMemberController(@Qualifier("RestMemberServiceImpl") MemberService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/join")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> MemberJoin(@RequestBody MemberDto dto) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			int res = service.join(dto);
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
	
	@GetMapping("/mypage/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> mypage(@PathVariable("id") String id) {
		MemberDto dto = new MemberDto();
		Map<String, Object> map = new HashMap<>();
		
		try {
			MemberDto member = service.mypage(id);
			map.put("resdata", member);
			map.put("resmsg", "조회성공");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "조회실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> MemberUpdate(@RequestBody MemberDto dto) {
		Map<String,Object> map = new HashMap();
		try {
			int res = service.modify(dto);
			map.put("resdata", res);
			map.put("resmsg", "수정성공");
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> MemberDelete(@PathVariable("id")String id) {
		Map<String,Object> map = new HashMap();
		MemberDto dto = new MemberDto();
		try {
			int res = service.delete(id);
			map.put("resdata", res);
			map.put("resmsg", "삭제성공");
			
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
}
