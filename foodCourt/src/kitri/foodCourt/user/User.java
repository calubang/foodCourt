package kitri.foodCourt.user;

import kitri.foodCourt.dto.UserDto;

public class User {
	//공통정보 
	private String userId;
	private String name;
	private String phoneNumberFirst;
	private String phoneNumberMiddle;
	private String phoneNumberlast;
	private int userPoint;
	
	//19.04.14 패스워드 추가
	private String password;

	//하나의 장바구니
	Basket basket;

	public User(String userId, String name, int userPoint) {
		super();
		this.userId = userId;
		this.name = name;
		this.userPoint = userPoint;
		basket = new BasketImpl();
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
	public Basket getBasket() {
		return basket;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//dto생성 or dto로 데이터변경
	public void setDto(UserDto userDto) {
		this.userId = userDto.getUserId();
		this.name = userDto.getName();
		this.phoneNumberFirst = userDto.getPhoneNumberFirst();
		this.phoneNumberMiddle = userDto.getPhoneNumberMiddle();
		this.phoneNumberlast = userDto.getPhoneNumberlast();
		this.userPoint = userDto.getUserPoint();
		this.password = userDto.getPassword();
	}
	public UserDto getDto() {
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto.setPassword(password);
		userDto.setName(name);
		userDto.setPhoneNumberFirst(phoneNumberFirst);
		userDto.setPhoneNumberMiddle(phoneNumberMiddle);
		userDto.setPhoneNumberlast(phoneNumberlast);
		userDto.setUserPoint(userPoint);
		return userDto;
	}
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phoneNumberFirst=" + phoneNumberFirst
				+ ", phoneNumberMiddle=" + phoneNumberMiddle + ", phoneNumberlast=" + phoneNumberlast + ", userPoint="
				+ userPoint + ", basket=" + basket + "]";
	}
	
}
