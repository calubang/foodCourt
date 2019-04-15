package kitri.foodCourt.user.member;

public class UserDto {
	
	private String userId;
	private String name;
	private String phoneNumberFirst;

	private String phoneNumberMiddle;
	private String phoneNumberlast;
	private int userPoint;
	
	private String password;
	private String passwordQuiz;
	private String passwordAnswer;
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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
		return "UserDto [userId=" + userId + ", name=" + name + ", phoneNumberFirst=" + phoneNumberFirst +
				", phoneNumberMiddle=" + phoneNumberMiddle + ", phoneNumberlast=" + phoneNumberlast + 
				", userPoint=" + userPoint +
				", password=" + password + ", passwordQuiz=" + passwordQuiz + ", passwordAnswer=" + passwordAnswer
				+ "]";
	}

}
