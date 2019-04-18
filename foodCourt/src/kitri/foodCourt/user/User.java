package kitri.foodCourt.user;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.swing.FLabel;

public class User {
	//하나의 유저만 가질수 있도록 싱글톤 적용
	private static User user =  new User();
	
	//공통정보 
	private String userId;
	private String name;
	private String phoneNumberFirst;
	private String phoneNumberMiddle;
	private String phoneNumberlast;
	private int userPoint;
	
	//19.04.14 패스워드 추가
	private String password;
	private String passwordQuiz;
	private String passwordAnswer;
	

	//하나의 장바구니
	Basket basket;
	
	private User() {
		super();
		basket = new BasketImpl();
	}
	
	private User(String userId, String name, int userPoint) {
		super();
		this.userId = userId;
		this.name = name;
		this.userPoint = userPoint;
		basket = new BasketImpl();
	}
	
	public static User getInstance() {
		return user;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPasswordQuiz() {
		return passwordQuiz;
	}

	public void setPasswordQuiz(String passwordQuiz) {
		this.passwordQuiz = passwordQuiz;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
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
		setPasswordQuiz(userDto.getPasswordQuiz());
		setPasswordAnswer(userDto.getPasswordAnswer());
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
		userDto.setPasswordQuiz(getPasswordQuiz());
		userDto.setPasswordAnswer(getPasswordAnswer());
		return userDto;
	}
	
	public void logout() {
		user.userId = null;
		user.password = null;
		user.name = null;
		user.phoneNumberFirst = null;
		user.phoneNumberMiddle = null;
		user.phoneNumberlast = null;
		user.passwordQuiz = null;
		user.passwordAnswer = null;
		user.userPoint = 0;
		FLabel label = user.basket.getOrderCount();
		user.basket = new BasketImpl();
		user.basket.setOrderCount(label);
	}
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phoneNumberFirst=" + phoneNumberFirst
				+ ", phoneNumberMiddle=" + phoneNumberMiddle + ", phoneNumberlast=" + phoneNumberlast + ", userPoint="
				+ userPoint + ", basket=" + basket + "]";
	}
	
}
