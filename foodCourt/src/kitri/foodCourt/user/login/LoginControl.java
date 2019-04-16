package kitri.foodCourt.user.login;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class LoginControl implements ActionListener, KeyListener {
	
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
			
			loginMain.card.show(this.loginMain.panMain, "panJoin");
			login.idtextField.setText("");
			login.pwtextfd.setText("");
			
			
		} else if (ob == this.login.findidbtn) {
			this.findIdMain.setVisible(true);
			
			findId.middleTF.setText("");
			findId.lastTF.setText("");
			findId.nameTF.setText("");
			findIdMain.card.show(findIdMain.panMain, "findId");

			
		} else if (ob == this.login.findpwbtn) {
			this.findPwMain.setVisible(true);
			
			this.findPwCheck.answerTF.setText("");
			this.findPw.idTF.setText("");
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
			
		} else if (ob == this.login.loginbtn) {
			loginService.logJoin();
		}else if (ob == login.idtextField) {
			login.pwtextfd.requestFocus();
		}else if (ob == login.pwtextfd) {
			loginService.logJoin();
			
			
			
//		아이디 찾기
		} else if (ob == this.findId.nextbtn) {
			loginService.findid();
		} else if (ob == this.findId.nameTF) {
			findId.middleTF.requestFocus();			
		} else if (ob == this.findId.middleTF) {
			findId.lastTF.requestFocus();			
		} else if (ob == this.findId.lastTF) {
			loginService.findid();		
		} else if (ob == this.findId.cancelbtn) {
			findIdMain.setVisible(false);
			findId.middleTF.setText("");
			findId.lastTF.setText("");
			findId.nameTF.setText("");
//		-------------------------------------------------------------------------------------
		} else if (ob == findIdCheck.Confirm) {
			findIdMain.setVisible(false);
			findIdMain.card.show(findIdMain.panMain, "findId");
//			findIdCheck.nameL.setText("");
		

			
			
			
//		비밀번호 찾기
		} else if (ob == this.findPw.nextbtn) {
			loginService.findPw();
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
		} else if (ob == findPw.idTF) {
			loginService.findPw();
			
		
//		-------------------------------------------------------------------------------------
		} else if (ob == this.findPwCheck.nextbtn) {
			loginService.findPwCheck();
		} else if (ob == this.findPwCheck.cancelbtn) {
			loginService.reSetting();
			this.findPwMain.setVisible(false);
			this.findPwCheck.answerTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
		} else if (ob == findPwCheck.answerTF) {
			loginService.findPwCheck();
		
			
//		-------------------------------------------------------------------------------------
		} else if (ob == this.findRPw.confirmbtn) {
			loginService.findRPw();
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");
		} else if (ob == this.findRPw.cancelbtn) {
			loginService.reSetting();
			this.findPwMain.setVisible(false);
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");
			this.findPwMain.card.show(this.findPwMain.panMain, "findPw");
		} else if (ob == findRPw.pwTF) {
			findRPw.againPwTF.requestFocus();	
		} else if (ob == findRPw.againPwTF) {
			loginService.findRPw();
			this.findRPw.againPwTF.setText("");
			this.findRPw.pwTF.setText("");

		
			

			
//		회원가입 페이지
		} else if (ob == this.loginMain.panJoin.cancelbtn) {
			join.setVisible(false);
			join.idTextFD.setText("");
			join.pwTextFD.setText("");
			join.pwCheckFD.setText("");
			join.nameFD.setText("");
			join.phLastFD.setText("");
			join.phMiddleFD.setText("");
			join.questionTF.setText("");
			join.answerTF.setText("");
		} else if (ob == this.loginMain.panJoin.doublechekbtn) {
			loginService.doubleCheck();
		} 
		else if (ob == loginMain.panJoin.signupbtn) {
			loginService.signUp();
		}
//		   public JTextField idTextFD;
//		   public JTextField nameFD;
//		   public JTextField phLastFD;
//		   public JTextField phMiddleFD;
//		   public JTextField questionTF;
//		   public JTextField answerTF;
//		   public JPasswordField pwTextFD; 
//		   public JPasswordField pwCheckFD;
		
		else if (ob == join.idTextFD) {
			join.pwTextFD.requestFocus();	
		}else if (ob == join.pwTextFD) {
			join.pwCheckFD.requestFocus();			
		}else if (ob == join.pwCheckFD) {
			join.nameFD.requestFocus();						
		}else if (ob == join.nameFD) {
			join.phMiddleFD.requestFocus();	
		}else if (ob == join.phMiddleFD) {
			join.phLastFD.requestFocus();	
		}else if (ob == join.phLastFD) {
			join.questionTF.requestFocus();						
		}else if (ob == join.questionTF) {
			join.answerTF.requestFocus();			
		}
//		else if (ob == join.answerTF) {
//			join.nameFD.requestFocus();			
//		}  필요없음. 회원가입은 어디서 쓸지 모름.
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) { 		
		
		Object ob = e.getSource();	
		
//		회원가입 페이지 비밀번호 일치 확인 필드
		if (ob == join.pwCheckFD) {
			loginService.pwCompare();
		}
		
//		비밀번호 재설정 페이지
		else if (ob == findRPw.againPwTF) {
			loginService.Rpwcompare();
		}else if (ob == findRPw.pwTF) {
			loginService.Rpwcompare();
		}
		
	}
	
	

	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		
	}
	
	

	
}
