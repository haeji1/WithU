package com.ssafy.spring.member.repository;

import com.ssafy.spring.member.dto.MemberDto;

public interface MemberRepository {

	public MemberDto login(MemberDto dto);
	public MemberDto mypage(String id);
	public int modify(MemberDto dto);
	public int join(MemberDto dto);
	public int delete(String id);
	
}
