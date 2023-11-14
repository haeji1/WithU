package com.ssafy.spring.member.service;

import com.ssafy.spring.member.dto.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto dto);
	public MemberDto mypage(String id);
	public int modify(MemberDto dto);
	public int join(MemberDto dto);
	public int delete(String id);
	
}
