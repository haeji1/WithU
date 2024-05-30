package com.ssafy.spring.member.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.member.dto.MemberDto;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	SqlSession session;
	
	public MemberRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	String ns = "com.ssafy.spring.member.repository.MemberRepository.";

	@Override
	public MemberDto login(MemberDto dto) {		
		MemberDto member = session.selectOne(ns + "login", dto); 
		return member;
	}

	@Override
	public MemberDto mypage(String id) {
		return session.selectOne(ns + "mypage", id);
	}

	@Override
	public int modify(MemberDto dto) {
		return session.update(ns + "modify", dto);
	}

	@Override
	public int join(MemberDto dto) {		
		return session.insert(ns + "join", dto);
	}

	@Override
	public int delete(String id) {
		return session.delete(ns + "delete", id);
	}

}
