package com.ssafy.spring.board.dto;

public class CommentDto {
	private int articleNo;
	private String userId;
	private String date;
	private String content;
	private int commentNo;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public CommentDto() {
		super();
	}
	public CommentDto(int articleNo, String userId, String date, String content, int commentNo) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.date = date;
		this.content = content;
		this.commentNo = commentNo;
	}
	@Override
	public String toString() {
		return "CommentDto [articleNo=" + articleNo + ", userId=" + userId + ", date=" + date + ", content=" + content
				+ ", commentNo=" + commentNo + "]";
	}
	
		
	
	
}
