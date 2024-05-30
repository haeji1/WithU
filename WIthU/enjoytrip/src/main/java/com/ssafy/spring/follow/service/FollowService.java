package com.ssafy.spring.follow.service;

import java.util.List;

import com.ssafy.spring.board.dto.BoardDto;
import com.ssafy.spring.follow.dto.FollowDto;

public interface FollowService {
	public List<FollowDto> followerlist(String followId);
	public List<FollowDto> followlist(String userId);
	public int follow(FollowDto dto);
//	public List<BoardDto> followingboard(String followId);
}
