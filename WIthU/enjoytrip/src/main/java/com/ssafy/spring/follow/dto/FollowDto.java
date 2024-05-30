package com.ssafy.spring.follow.dto;

public class FollowDto {

	private String userId;
	private String followId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	
	@Override
	public String toString() {
		return "FollowDto [userId=" + userId + ", followId=" + followId + "]";
	}

}
