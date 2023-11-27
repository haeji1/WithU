package com.ssafy.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.member.dto.MemberDto;
import com.ssafy.spring.member.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{

	private MemberRepository repo;
	
	@Autowired	
	public MemberServiceImpl(MemberRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return repo.login(dto);
	}

	@Override
	public MemberDto mypage(String id) {
		return repo.mypage(id);
	}

	@Override
	public int modify(MemberDto dto) {
		return repo.modify(dto);
	}

	@Override
	public int join(MemberDto dto) {
		return repo.join(dto);
	}

	@Override
	public int delete(String id) {
		return repo.delete(id);
	}

}
