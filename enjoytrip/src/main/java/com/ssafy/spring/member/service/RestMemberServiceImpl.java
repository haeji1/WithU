package com.ssafy.spring.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.member.dto.MemberDto;
import com.ssafy.spring.member.repository.MemberRepository;

@Service("RestMemberServiceImpl")
public class RestMemberServiceImpl implements MemberService{
	
	SqlSession session;

	@Autowired
	public RestMemberServiceImpl(SqlSession session) {
		super();
		this.session = session;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto mypage(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(MemberDto dto) {
		// TODO Auto-generated method stub
		return session.getMapper(MemberRepository.class).modify(dto);
	}

	@Override
	public int join(MemberDto dto) {		
		session.getMapper(MemberRepository.class).join(dto);
		return 1;		
	}

	@Override
	public int delete(String id) {
		session.getMapper(MemberRepository.class).delete(id);
		return 1;
	}
	
	

}
