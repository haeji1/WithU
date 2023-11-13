package com.ssafy.spring.area.dto;

public class AreaDto {
	private	int sidoCode;
	private String sidoName;
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public AreaDto() {
		super();
	}
	public AreaDto(int sidoCode, String sidoName) {
		super();
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
	}
	@Override
	public String toString() {
		return "AreaDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + "]";
	}
	
	
}
