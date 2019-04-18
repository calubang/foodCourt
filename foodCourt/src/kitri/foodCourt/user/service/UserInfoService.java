package kitri.foodCourt.user.service;

import java.awt.Color;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.controller.UserInfoController;
import kitri.foodCourt.user.dao.UserInfoDao;
import kitri.foodCourt.user.swing.FOptionPane;
import kitri.foodCourt.user.swing.SwingFactory;
import kitri.foodCourt.user.view.FoodMain;
import kitri.foodCourt.user.view.UserInfo;

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
			userInfo.lbPasswordInfo.setText("");
			return;
		}
		
		if(newPassword.length() < 6) {
			userInfo.setModifiable(false);
			userInfo.lbPasswordInfo.setText("패스워드가 너무 짧습니다.");
			return;
		}
		if(newPassword.length() > 20) {
			userInfo.setModifiable(false);
			userInfo.lbPasswordInfo.setText("패스워드가 너무 깁니다.");
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
		//이름
		if(userInfo.tfName.getText().trim().isEmpty())  {
			SwingFactory.getOptionPane("errorMessage", userInfo, "입력 오류", "이름을 입력해주세요.");
			return;
		}
		if(userInfo.tfName.getText().length() > 20)  {
			SwingFactory.getOptionPane("errorMessage", userInfo, "입력 오류", "이름이 너무 깁니다.");
			return;
		}
		
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
		if(userInfo.tfPhoneMiddle.getText().trim().isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "전화번호 오류", "전화번호를 확인해주세요.");
			return;
		}
		if(userInfo.tfPhoneLast.getText().trim().isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "전화번호 오류", "전화번호를 확인해주세요.");
			return;
		}
		
		//비밀번호 찾기
		if(userInfo.tfPasswordQuiz.getText().trim().isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 찾기 오류", "비밀번호 찾기의 질문을 입력해주세요.");
			return;
		}
		if(userInfo.tfPasswordQuiz.getText().length() > 40) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 찾기 오류", "비밀번호 찾기의 질문이 너무 깁니다.");
			return;
		}
		if(userInfo.tfPasswordAnswer.getText().trim().isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 찾기 오류", "비밀번호 찾기의 답변을 입력해주세요.");
			return;
		}
		if(userInfo.tfPasswordAnswer.getText().length() > 40) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "비밀번호 찾기 오류", "비밀번호 찾기의 답변이 너무 깁니다.");
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
		userDto.setPasswordQuiz(userInfo.tfPasswordQuiz.getText());
		userDto.setPasswordAnswer(userInfo.tfPasswordAnswer.getText());
		
		if(dao.modify(userDto) != 1) {
			SwingFactory.getOptionPane("errorMessage", userInfo, "시스템 오류", "시스템 오류입니다. 관리자에게 문의하세요.");
			return;
		}
		
		//자바user 도 변경
		user.setDto(userDto);
		
		//화면전환
		int result = SwingFactory.getOptionPane("message", userInfo, "회원정보 수정", "회원정보가 수정되었습니다.");
		if(result == 0 ) {
			foodMain.labName.setText(user.getName() +"님");
			foodMain.foodMainController.foodMainService.userInfo();
			foodMain.card.show(foodMain.panChangePanel, "foodMainView");
			foodMain.currentPanelName = "foodMainView";
		}
	}
	
	public boolean allSameData() {
		User user = User.getInstance();
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
		
		//비밀번호 찾기
		if( !userInfo.tfPasswordQuiz.getText().equals(user.getPasswordQuiz())) {
			return false;
		}
		if( !userInfo.tfPasswordAnswer.getText().equals(user.getPasswordAnswer()) ) {
			return false;
		}

		return true;
	}

	public void cancel() {
		foodMain.foodMainController.foodMainService.clickMain();
	}
	
	//회원탈퇴
	public void secession() {
		int result = SwingFactory.getOptionPane("warning", userInfo, "탈퇴 확인", "탈퇴하면 모든 포인트가 소멸됩니다.\n정말 탈퇴 하시겠습니까?");
		if(result == 0) {
			//탈퇴
			User user = User.getInstance();
			if(dao.secession(user.getUserId()) == 1) {
				//정상탈퇴
				user.logout();
				foodMain.card.show(foodMain.panChangePanel, "foodMainView");
				foodMain.currentPanelName = "foodMainView";
				foodMain.setVisible(false);
				foodMain.loginMain.card.show(foodMain.loginMain.panMain, "panLogin");
				foodMain.loginMain.setVisible(true);
			}
		} else {
			SwingFactory.getOptionPane("errorMessage", userInfo, "시스템 오류", "시스템 오류입니다. 관리자에게 문의하세요.");
			return;
		}
	}
}
