package kitri.foodCourt.dto;

import java.sql.Date;

public class AdminRegitDto {
	
	private String managerId;
	private String name;
	private String password;
	private String phoneFirst;
	private String phoneMiddle;
	private String phoneLast;
	private String jobId;
	private Date hireDate;
	private String adressZip;
	private String adress;
	private String email;
	private String emailDomain;
	
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneFirst() {
		return phoneFirst;
	}
	public void setPhoneFirst(String phoneFirst) {
		this.phoneFirst = phoneFirst;
	}
	public String getPhoneMiddle() {
		return phoneMiddle;
	}
	public void setPhoneMiddle(String phoneMiddle) {
		this.phoneMiddle = phoneMiddle;
	}
	public String getPhoneLast() {
		return phoneLast;
	}
	public void setPhoneLast(String phoneLast) {
		this.phoneLast = phoneLast;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getAdressZip() {
		return adressZip;
	}
	public void setAdressZip(String adressZip) {
		this.adressZip = adressZip;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	@Override
	public String toString() {
		return "AdminRegitDto [managerId=" + managerId + ", name=" + name + ", password=" + password + ", phoneFirst="
				+ phoneFirst + ", phoneMiddle=" + phoneMiddle + ", phoneLast=" + phoneLast + ", jobId=" + jobId
				+ ", hireDate=" + hireDate + ", adressZip=" + adressZip + ", adress=" + adress + ", email=" + email
				+ ", emailDomain=" + emailDomain + "]";
	}
	
}
