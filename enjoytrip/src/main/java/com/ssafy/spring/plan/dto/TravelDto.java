package com.ssafy.spring.plan.dto;

public class TravelDto {
	private String travelNo;
	private int planNo;
	private String addressName;
	private String phone;
	private String placeName;
	private String placeUrl;
	private String x;
	private String y;
	public String getTravelNo() {
		return travelNo;
	}
	public void setTravelNo(String travelNo) {
		this.travelNo = travelNo;
	}
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceUrl() {
		return placeUrl;
	}
	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
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
		return "TravelDto [travelNo=" + travelNo + ", planNo=" + planNo + ", addressName=" + addressName + ", phone="
				+ phone + ", placeName=" + placeName + ", placeUrl=" + placeUrl + ", x=" + x + ", y=" + y + "]";
	}
}
