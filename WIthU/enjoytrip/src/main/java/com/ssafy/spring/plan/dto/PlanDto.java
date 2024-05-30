package com.ssafy.spring.plan.dto;

import java.util.List;

public class PlanDto {
//	const article = ref({
//		  articleNo: 0,
//		  subject: "",
//		  content: "",
//		  userId: "",
//		  userName: "",
//		  travellist: [],
//		  hit: 0,
//		  startDate: "",
//		  endDate: "",
//		  registerDate: "",
//		});
	private int planNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private String startDate;
	private String endDate;
	

	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "PlanDto [planNo=" + planNo + ", userId=" + userId + ", subject=" + subject + ", content=" + content
				+ ", hit=" + hit + ", registerTime=" + registerTime + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
	
}
