package com.ssafy.spring.follow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.follow.dto.FollowDto;
import com.ssafy.spring.follow.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService{

	private FollowRepository repo;
	
	@Autowired
	public FollowServiceImpl(FollowRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<FollowDto> followerlist(String followId) {
		return repo.followerlist(followId);
	}

	@Override
	public List<FollowDto> followlist(String userId) {
		return repo.followlist(userId);
	}

	@Override
	public int follow(FollowDto dto) {
		return repo.follow(dto);
	}

//	@Override
//	public List<BoardDto> followingboard(String followId) {
//		return repo.followingboard(followId);
//	}
	
}
