package com.ssafy.spring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.member.dto.MemberDto;
import com.ssafy.spring.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private MemberService service;
	
	@Autowired	
	public MemberController(@Qualifier("MemberServiceImpl") MemberService service) {
		super();
		this.service = service;
	}

	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public ModelAndView login(ModelAndView mav, MemberDto dto, HttpServletRequest req) {
		try {
			MemberDto login = service.login(dto);	
			
			if(login != null) {
				req.getSession().setAttribute("userinfo", dto);
				mav.setViewName("index");
			} else {
				mav.setViewName("redirect:/service/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		
		return mav;
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		try {
			req.getSession().invalidate();
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/error";
		}
	}
	
	@PostMapping("mypage")
	public ModelAndView mypage(String id, ModelAndView mav) {
		MemberDto member = service.mypage(id);
		mav.addObject("info", member);
		mav.setViewName("member/mypage");		
		return mav;
	}
	
	@PostMapping("modify")
	public ModelAndView modify(MemberDto dto, ModelAndView mav) {
		int res = service.modify(dto);
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public ModelAndView join(ModelAndView mav, MemberDto dto) {
		System.out.println(dto);
		int res = service.join(dto);
		mav.setViewName("redirect:/member/login");
		return mav;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(ModelAndView mav, String id, HttpServletRequest req) {
		int res = service.delete(id);
		req.getSession().invalidate();
		mav.setViewName("index");
		return mav;
	}
	
	
}
