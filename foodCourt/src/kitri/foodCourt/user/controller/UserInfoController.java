package kitri.foodCourt.user.controller;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.JPasswordField;

import kitri.foodCourt.user.service.UserInfoService;
import kitri.foodCourt.user.view.UserInfo;

public class UserInfoController implements KeyListener, ActionListener {

	public UserInfo userInfo;
	public UserInfoService service;
	
	public UserInfoController(UserInfo userInfo) {
		this.userInfo = userInfo;
		
		service = new UserInfoService(this);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Component component = e.getComponent();
		//비밀번호 입력칸에 하나라도 들어오면 체크
		if(component instanceof JPasswordField) {
			service.isCorrectPassword();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == userInfo.btnModify) {
			//수정
			service.modify();
		} else if(obj == userInfo.btnCancel) {
			//취소
			service.cancel();
		}
	}


}
