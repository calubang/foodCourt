package kitri.foodCourt.user.basket;

import java.awt.Color;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.swing.FOptionPane;

public class UserInfoService {

	public UserInfoController controller;
	public UserInfo userInfo;
	public FoodMain foodMain;
	public UserInfoDao dao;
	
	public UserInfoService(UserInfoController controller) {
		this.controller = controller;
		this.userInfo = controller.userInfo;
		this.foodMain = userInfo.foodMain;
		dao = new UserInfoDao(this);
	}

	public void isCorrectPassword() {
		
		String newPassword = new String(userInfo.pfNewPassword.getPassword());
		String rePassword = new String(userInfo.pfRePassword.getPassword());
		
		//모두 빈칸이면 비밀번호 수정 안하는걸로 간주
		if(newPassword.isEmpty() && rePassword.isEmpty()) {
			userInfo.setModifiable(true);
			return;
		}
		
		if(newPassword.length() < 6) {
			userInfo.setModifiable(false);
			userInfo.lbPasswordInfo.setText("패스워드가 너무 짧습니다.");
			return;
		}
			
		if(!newPassword.equals(rePassword)) {
			userInfo.lbPasswordInfo.setForeground(Color.RED);
			userInfo.lbPasswordInfo.setText("패스워드가 일치하지 않습니다.");
			userInfo.setModifiable(false);
		}else {
			userInfo.lbPasswordInfo.setForeground(Color.BLACK);
			userInfo.lbPasswordInfo.setText("패스워드가 일치합니다.");
			userInfo.setModifiable(true);
		}
	}

	//회원수정
	public void modify() {
		User user = foodMain.user;
		String newPassword = new String(userInfo.pfNewPassword.getPassword());
		
		//유효성 검사
		if(!userInfo.getModifiable()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 오류", "비밀번호를 다시 확인해주세요.");
			return;
		}
		if(allSameData()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "회원수정 오류", "변경된 회원수정내역이 없습니다.");
			return;
		}
		
		//대소문자 or 숫자
		int size = newPassword.length();
		for(int i = 0 ; i<size ; i++) {
			char key = newPassword.charAt(i);
			if(  !((key >= '0' && key <= '9') || ( key >= 'A' && key <= 'Z' ) || (key >= 'a' && key <= 'z')) ) {
				SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 오류", "비밀번호는 영어대소문자 or 숫자만 사용이 가능합니다.");
				return;
			}
		}

		//전화번호 4자리 체크
		if(userInfo.tfPhoneMiddle.getText().length() > 4 || userInfo.tfPhoneLast.getText().length() > 4) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "전화번호 오류", "전화번호는 4자리까지 가능합니다.");
			return;
		}
		
		//회원변경 수정
		//수정반영된 유저정보 생성
		UserDto userDto = user.getDto();
		userDto.setName(userInfo.tfName.getText());
		if( !new String(userInfo.pfRePassword.getPassword()).isEmpty()) {
			userDto.setPassword(new String(userInfo.pfRePassword.getPassword()));
		}
		userDto.setPhoneNumberFirst(userInfo.cbPhoneFirst.getSelectedItem().toString());
		userDto.setPhoneNumberMiddle(userInfo.tfPhoneMiddle.getText());
		userDto.setPhoneNumberlast(userInfo.tfPhoneLast.getText());
		
		if(dao.modify(userDto) != 1) {
			return;
		}
		
		//자바user 도 변경
		user.setDto(userDto);
		
		//화면전환
		int result = SwingFactory.getOptionPane("message", userInfo, "회원정보 수정", "회원정보가 수정되었습니다.");
		if(result == 0 ) {
			foodMain.labName.setText(user.getName() +"님");
			foodMain.foodMainController.foodMainService.userInfo();
		}
	}
	
	public boolean allSameData() {
		User user = foodMain.user;
		//이름
		if( !userInfo.tfName.getText().equals(user.getName())) {
			return false;
		}
		
		//전화번호
		if( !userInfo.cbPhoneFirst.getSelectedItem().equals(user.getPhoneNumberFirst())) {
			return false;
		}
		if( !userInfo.tfPhoneMiddle.getText().equals(user.getPhoneNumberMiddle()) ) {
			return false;
		}
		if( !userInfo.tfPhoneLast.getText().equals(user.getPhoneNumberlast())) {
			return false;
		}
		
		//비밀번호
		String newPassword = new String(userInfo.pfNewPassword.getPassword());
		if(!newPassword.isEmpty() && !newPassword.equals(user.getPassword()) ) {
			return false;
		}

		return true;
	}

	public void cancel() {
		foodMain.foodMainController.foodMainService.clickMain();
	}
}
