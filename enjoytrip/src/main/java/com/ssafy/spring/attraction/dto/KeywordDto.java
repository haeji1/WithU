package com.ssafy.spring.attraction.dto;

public class KeywordDto {
	private int sidoCode;
	private int gugunCode;
	private int contentTypeId;
	private String keyword;
	
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public KeywordDto() {
		super();
	}
	public KeywordDto(int sidoCode, int gugunCode, int contentTypeId, String keyword) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentTypeId;
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "KeywordDto [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", contentTypeId=" + contentTypeId
				+ ", keyword=" + keyword + "]";
	}
	
	
}
