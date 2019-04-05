package kitri.foodCourt.dto;

public class UserDto {
	//유저정보 
	//로그인한후 생성
	String userId;
	String name;
	String phoneNumberFirst;
	String phoneNumberMiddle;
	String phoneNumberlast;
	int userPoint;
	
	public UserDto(String userId, String name, String phoneNumberFirst, String phoneNumberMiddle,
			String phoneNumberlast) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNumberFirst = phoneNumberFirst;
		this.phoneNumberMiddle = phoneNumberMiddle;
		this.phoneNumberlast = phoneNumberlast;
	}

	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumberFirst() {
		return phoneNumberFirst;
	}
	public void setPhoneNumberFirst(String phoneNumberFirst) {
		this.phoneNumberFirst = phoneNumberFirst;
	}
	public String getPhoneNumberMiddle() {
		return phoneNumberMiddle;
	}
	public void setPhoneNumberMiddle(String phoneNumberMiddle) {
		this.phoneNumberMiddle = phoneNumberMiddle;
	}
	public String getPhoneNumberlast() {
		return phoneNumberlast;
	}
	public void setPhoneNumberlast(String phoneNumberlast) {
		this.phoneNumberlast = phoneNumberlast;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", phoneNumberFirst=" + phoneNumberFirst
				+ ", phoneNumberMiddle=" + phoneNumberMiddle + ", phoneNumberlast=" + phoneNumberlast + ", userPoint="
				+ userPoint + "]";
	}
}
