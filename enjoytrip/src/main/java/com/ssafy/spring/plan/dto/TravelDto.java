package com.ssafy.spring.plan.dto;

public class TravelDto {
	private int planNo;
	private int travelNo;
	private String address_name;
	private String phone;
	private String place_name;
	private String place_url;
	private String x;
	private String y;
	
	public int getTravelNo() {
		return travelNo;
	}
	public void setTravelNo(int travelNo) {
		this.travelNo = travelNo;
	}
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_url() {
		return place_url;
	}
	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "TravelDto [travelNo=" + travelNo + ", planNo=" + planNo + ", address_name=" + address_name + ", phone="
				+ phone + ", place_name=" + place_name + ", place_url=" + place_url + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
}
