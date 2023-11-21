package com.ssafy.spring.follow.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.follow.dto.FollowDto;

@Repository
public class FollowRepositoryImpl implements FollowRepository{
	
	SqlSession session;
	
	public FollowRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}

	String ns = "com.ssafy.spring.follow.repository.FollowRepository.";
	
	@Override
	public List<FollowDto> followerlist(String followId) {
		return session.selectList(ns + "followerlist", followId);
	}

	@Override
	public List<FollowDto> followlist(String userId) {
		return session.selectList(ns + "followlist",userId);
	}

	@Override
	public int follow(FollowDto dto) {
		return session.insert(ns+"follow", dto);
	}

//	@Override
//	public List<BoardDto> followingboard(String followId) {
//		return session.selectList(ns+"fofollowingboard"+followId);
//	}

}
