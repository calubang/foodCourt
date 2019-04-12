package kitri.foodCourt.user.member;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginControl implements ActionListener {
	
	public LoginService loginService;
	public LoginMain loginMain;
	public Login login;
	public Join join;
	public FindIdMain findIdMain;
	public FindId findId;
	public FindIdCheck findIdCheck;
	public FindPwMain findPwMain;
	public FindPw findPw;
	public FindPwCheck findPwCheck;
	public FindRPw findRPw;
//	public DBConnection dbConnection;

	public LoginControl(LoginMain loginMain) {
		this.loginMain = loginMain;
		this.login = loginMain.panLogin;
		this.join = loginMain.panJoin;
		this.findIdMain = loginMain.findIdMain;
		this.findId = loginMain.findIdMain.findId;
		this.findIdCheck = loginMain.findIdMain.findIdCheck;
		this.findPwMain = loginMain.findPwMain;
		this.findPw = loginMain.findPwMain.findPw;
		this.findPwCheck = loginMain.findPwMain.findPwCheck;
		this.findRPw = loginMain.findPwMain.findRPw;
		
		this.loginService = new LoginService(this);
//		dbConnection = new DBConnection();
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
//		로그인 페이지
		if (ob == this.login.joinbtn) {
			
			this.loginMain.card.show(this.loginMain.panMain, "panJoin");
			this.login.idtextField.setText("");
			this.login.pwtextfd.setText("");
			
		} else if (ob == this.login.findidbtn) {
			this.findIdMain.setVisible(true);
		} else if (ob == this.login.findpwbtn) {
			this.findPwMain.setVisible(true);
		} else if (ob == this.login.loginbtn) {
			loginService.logJoin();
			
			
			
//		아이디 찾기
		} else if (ob == this.findId.nextbtn) {
			this.findIdMain.card.show(this.findIdMain.panMain, "findIdCheck");
		} else if (ob == this.findId.cancelbtn) {
			this.findIdMain.setVisible(false);
			this.findIdMain.findId.middleTF.setName("");
			this.findIdMain.findId.lastTF.setName("");
			this.findIdMain.findId.nameTF.setName("");
//		-------------------------------------------------------------------------------------
		} else if (ob == this.findIdCheck.Confirm) {
			this.findIdMain.setVisible(false);
			this.findIdMain.card.show(this.findIdMain.panMain, "findId");
			this.findIdMain.findIdCheck.nameL.setName("");

			
			
			
//		비밀번호 찾기
		} else if (ob == this.findPw.nextbtn) {
			this.findPwMain.card.show(this.findPwMain.panMain, "findPwCheck");
			this.findPw.idTF.setText("");
		} else if (ob == this.findPw.cancelbtn) {
			this.findPwMain.setVisible(false);
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
			this.findPw.idTF.setText("");
		} else if (ob == this.findPw.idfindbtn) {
			this.findPwMain.setVisible(false);
			this.findPw.idTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
			this.findIdMain.card.show(this.findIdMain.panMain, "findId");
			this.findIdMain.setVisible(true);
//		-------------------------------------------------------------------------------------
		} else if (ob == this.findPwCheck.nextbtn) {
			this.findPwCheck.answerTF.setText("");
			this.findPwCheck.questionTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findRPw");
		} else if (ob == this.findPwCheck.cancelbtn) {
			this.findPwMain.setVisible(false);
			this.findPwCheck.answerTF.setText("");
			this.findPwCheck.questionTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
//		-------------------------------------------------------------------------------------
		} else if (ob == this.findRPw.confirmbtn) {
			this.findPwMain.setVisible(false);
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
		} else if (ob == this.findRPw.cancelbtn) {
			this.findPwMain.setVisible(false);
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");

			
			
//		회원가입 페이지
		} else if (ob == this.loginMain.panJoin.cancelbtn) {
			this.join.setVisible(false);
		} else if (ob == this.loginMain.panJoin.sinupbtn) {
			
		} else if (ob == this.loginMain.panJoin.sinupbtn) {
			
		} else if (ob == this.loginMain.panJoin.sinupbtn) {
			
		} else if (ob == this.loginMain.panJoin.sinupbtn) {
			
		}
	}
}
