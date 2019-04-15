package kitri.foodCourt.dto;

import java.util.Date;

public class UserDto {
	//공통정보 
	String userId;
	String name;
	String phoneNumberFirst;
	String phoneNumberMiddle;
	String phoneNumberlast;
	int userPoint;
	
	//관리자
	String joinDate;
	String secessionDate;
	char enable;
	//회의 필요함 비밀번호와 비밀번호 퀴즈 답변은 시스템이 담고 있어야하는가?
	//유저시스템은 당연 필요없지만, 관리자에서도 안보이게 할건지 정해야할듯
	String password;
	String passwordQuiz;
	String passwordAnswer;
	
	public UserDto() {
		super();
	}
	
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getSecessionDate() {
		return secessionDate;
	}
	public void setSecessionDate(String secessionDate) {
		this.secessionDate = secessionDate;
	}
	public char getEnable() {
		return enable;
	}
	public void setEnable(char enable) {
		this.enable = enable;
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

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", phoneNumberFirst=" + phoneNumberFirst
				+ ", phoneNumberMiddle=" + phoneNumberMiddle + ", phoneNumberlast=" + phoneNumberlast + ", userPoint="
				+ userPoint + ", joinDate=" + joinDate + ", secessionDate=" + secessionDate + ", enable=" + enable
				+ ", password=" + password + ", passwordQuiz=" + passwordQuiz + ", passwordAnswer=" + passwordAnswer
				+ "]";
	}
}
