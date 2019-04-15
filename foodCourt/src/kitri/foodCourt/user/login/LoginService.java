package kitri.foodCourt.user.login;
 
import java.awt.Color;
import java.io.PrintStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import kitri.foodCourt.user.User;
import kitri.foodCourt.user.view.FoodMain;
 
public class LoginService {
    
	Connection conn = null; // DB연결된 상태(세션)을 담은 객체
    PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
    
	
	LoginControl logc;
//	DBConnection dbConnection;

	int doubleidCheck; // 회원가입 페이지에서 아이디 중복확인을 눌렀는지 안눌렀는지 판단하기 위한 변수
	int pwCheck; // 비밀번호 일치할때만 가입성공하기 위한 변수
	String userIdJoin;
	// 회원가입버튼을 누를시에 중복버튼을 눌러 사용가능 아이디로 판별된 아이디와 현재 쓴 아이디가 맞는지 확인.
	// 중복확인 눌렀을 때 사용가능이 뜬 후 다시 아이디 바꾸고 중복확인을 누르지 않고 가입하는것을 방지하기 위해서 변수를 만듬.
	// 생성자 안에 넣어놔야 되는 이유는?? logincontrol밑에 둬도 안됬던 이유는??
	// 생성자 안에 넣으면 인식이 안되서 값을 넣으라고 뜸.

	LoginService(LoginControl logc) { 
		doubleidCheck = 0;
		pwCheck = 0;
//		userIdJoin = logc.join.idTextFD.getText();
		this.logc = logc;
//    	dbConnection = new DBConnection();
		
	}

	
    
    public void logJoin() {
    	
    	String quary = "select user_id, password, name, user_point, phone_first, phone_middle, phone_last, password  from fook_user";
    	
//    	logc.login.idtextField.getText();
//    	logc.login.pwtextfd.getPassword();
    	
    	//유효성 위로
		if ((logc.login.idtextField.getText().isEmpty()) || (logc.login.pwtextfd.getPassword().length == 0)) {
			javax.swing.JOptionPane.showMessageDialog(logc.login, "아이디 또는 비밀번호를 입력해 주세요.");
		}
    	
        try {
        	
        	conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

//			System.out.println("user_id \t password");
//			System.out.println("=========================");
			
			
			String str = new String(logc.login.pwtextfd.getPassword()); // 비밀번호는 별표로 뜨게 만드는 소스를 써서 새로 생성해야 쓸 수 있음.
			String user_id;
			String password;
			int checking = 0;
			
			while(rs.next()){
				user_id = rs.getString("user_id");
				password = rs.getString("password");
				
//				Integer.parseInt(password);
				
//				System.out.println(logc.login.pwtextfd.getPassword());
//				System.out.println("데이터베이스 password : " + password + " 내가 친 password  : " + str );
//				System.out.println("비번 : " + str);
//				System.out.println(logc.login.idtextField.getText());
//				String result = user_id+" "+password;
//				System.out.println(result);
				
				if (logc.login.idtextField.getText().equals(user_id) && str.equals(password)) {
					javax.swing.JOptionPane.showMessageDialog(logc.login, "로그인 성공.");
					checking += 1;
					//성공 
					User user = new User(user_id, rs.getString("name"), rs.getInt("user_point"));
					user.setPhoneNumberFirst(rs.getString("phone_first"));
					user.setPhoneNumberMiddle(rs.getString("phone_middle"));
					user.setPhoneNumberlast(rs.getString("phone_last"));
					user.setPassword(rs.getString("password"));
					
					logc.loginMain.setVisible(false);
					logc.loginMain.foodMain.setVisible(true);
					
					
				}
			}
			
			
			if (checking == 0) {
				javax.swing.JOptionPane.showMessageDialog(logc.login, "아이디와 비번이 다릅니다.");

			}
			
			
			logc.login.idtextField.setText("");
			logc.login.pwtextfd.setText("");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리문 오류");
		} finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
        
        
    }
    
    
//    ------------------------------------------------------------------------------------------------
    

    
    public void doubleCheck() {
    	
        String quary = "select user_id from fook_user";
        userIdJoin = logc.join.idTextFD.getText();
        
        if (userIdJoin.isEmpty()) {
        	javax.swing.JOptionPane.showMessageDialog(logc.join, "아이디를 입력 바랍니다.");
		}
  	
	    
        try {
      		conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();


			String DBuser_id;
			
			int check = 0;
			
			while(rs.next()){
				
				DBuser_id = rs.getString("user_id");
				
				if (userIdJoin.equals(DBuser_id)) {
					
					javax.swing.JOptionPane.showMessageDialog(logc.join, "중복된 아이디가 있습니다.");
					logc.join.idTextFD.setText("");
					
					check = 1;
					doubleidCheck = 1;
				}
			}
			
			if( check == 0 ) {
				javax.swing.JOptionPane.showMessageDialog(logc.join, "사용 가능한 아이디 입니다.");
				doubleidCheck = 2;
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리문 오류");
		} finally{
          // DB 연결을 종료한다.
          try{
              if ( rs != null ){rs.close();}   
              if ( pstm != null ){pstm.close();}   
              if ( conn != null ){conn.close(); }
          }catch(Exception e){
              throw new RuntimeException(e.getMessage());
          }
          
		}
        
        
    }
    
//    --------------------------------------------------------------------------------
    
        
    public void pwCompare() {
    	
    	
    	String pwTextFD = new String(logc.join.pwTextFD.getPassword());
    	String pwCheckFD = new String(logc.join.pwCheckFD.getPassword());
    	
    	
    	if (!(pwTextFD.equals(pwCheckFD)) || pwTextFD.isEmpty() || pwCheckFD.isEmpty()) {
				logc.join.pwCheckL.setForeground(Color.RED);
				logc.join.pwCheckL.setText("비밀번호가 일치하지 않습니다.");
				pwCheck = 0;
			}else if (pwTextFD.length() < 6 || pwCheckFD.length() < 6 ) {
				logc.join.pwCheckL.setForeground(Color.RED);
				logc.join.pwCheckL.setText("비밀번호를 6자리 이상 입력해 주세요.");
				pwCheck = 0;
			}else if (pwTextFD.equals(pwCheckFD)) {
				logc.join.pwCheckL.setForeground(Color.GREEN);			
				logc.join.pwCheckL.setText("비밀번호가 일치합니다.");
				pwCheck = 1;
	//    		if (pwTextFD.isEmpty() || pwCheckFD.isEmpty()) {
	//    			logc.join.pwCheckL.setForeground(Color.DARK_GRAY);
	//    			logc.join.pwCheckL.setText("비밀번호를 입력 바랍니다.");
	//    		}
			} 	
    	}
    
    

	public void signUp() {
		
		
		String id = logc.join.idTextFD.getText();
		String pw = new String(logc.join.pwTextFD.getPassword());
		String pwC = new String(logc.join.pwCheckFD.getPassword());
		String name = logc.join.nameFD.getText();
		String phF = logc.join.comboBox.getSelectedItem().toString();
		String phM = logc.join.phMiddleFD.getText();
		String phL = logc.join.phLastFD.getText();
		String question = logc.join.questionTF.getText();
		String answer = logc.join.answerTF.getText();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
		String str = dayTime.format(new Date());
		
		String quary = "INSERT INTO fook_user(user_id, password, name, phone_first, "
				+ "phone_middle, phone_last, user_point, password_quiz, password_answer, "
				+ "enable) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		// doubleidcheck 이용 중복버튼을 해봤는지 체크 해줌.
		// 0이면 안눌름. 1이면 중복. 2이면 성공.
		
		if ( id.isEmpty() || pw.isEmpty() || pwC.isEmpty()
			|| name.isEmpty() || phM.isEmpty() || phL.isEmpty()) { // == 는 주소값 비교.
			JOptionPane.showMessageDialog(logc.join, "빈 공간을 입력해 주세요.");
		}else if(doubleidCheck == 0 || doubleidCheck == 1) {
			JOptionPane.showMessageDialog(logc.join, "중복 확인을 눌러주세요.");
		}else if ( id.length() > 32) {
			JOptionPane.showMessageDialog(logc.join, "한글 16자 이하 또는 영어 32자 이하로 아이디를 작성하세요.");
		}else if (!(userIdJoin.equals(id))) {
			JOptionPane.showMessageDialog(logc.join, "중복 확인을 눌러주세요.");
		}else if ( pwCheck == 0) {
			JOptionPane.showMessageDialog(logc.join, "비밀번호를 확인해 주세요.");
		}else if (name.length() > 32) {
			JOptionPane.showMessageDialog(logc.join, "한글 16자 이하 또는 영어 32자 이하로 이름을 작성하세요.");
		}else if (phM.length() != 4 || phL.length() != 4) {
			JOptionPane.showMessageDialog(logc.join, "휴대폰 번호를 각각 4자리만 입력해 주세요.");
		}
		
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			
			pstm.setString(1, id);
			pstm.setString(2, pw); 
			pstm.setString(3, name);
			pstm.setString(4, phF);
			pstm.setString(5, phM);
			pstm.setString(6, phL);
			pstm.setInt(7, 0);
			pstm.setString(8, question);
			pstm.setString(9, answer);
			pstm.setString(10, "N");

			
			// SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
			int r = pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		}finally { 
			if(pstm != null) { 
				try { 
					pstm.close(); 
				} catch (SQLException e) { 
					e.printStackTrace(); 
				} 
			} 
			if (conn != null) { 
				try { conn.close(); 
			} catch (SQLException e) { 
				e.printStackTrace(); } 
			}
		}
		
	}



	public void findid() {
		
		String quary = "select name, user_id, phone_first, phone_middle, phone_last from fook_user";
        
		String user_name = logc.findId.nameTF.getText();
		String phF = logc.findId.comboBox.getSelectedItem().toString();
		String phM = logc.findId.middleTF.getText();
		String phL = logc.findId.lastTF.getText();
        
        System.out.println(phM.length());
		
        if (phM.length() != 4 || phL.length() != 4) {
        	javax.swing.JOptionPane.showMessageDialog(logc.join, "핸드폰 번호를 제대로 입력해 주세요.");		
		}else if (user_name.isEmpty()) {
        	javax.swing.JOptionPane.showMessageDialog(logc.join, "아이디를 입력 바랍니다.");
		}else if (phM.isEmpty() || phL.isEmpty()) {
        	javax.swing.JOptionPane.showMessageDialog(logc.join, "핸드폰 번호를 입력 바랍니다.");
		}
        
  	
	    
        try {
      		conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();


			String DBuser_id;
			String DBphF;
			String DBphM;
			String DBphL;
			String Username;
			
			int check = 0;
			
			while(rs.next()){
				
				Username = rs.getString("name");
				DBuser_id = rs.getString("user_id");
				DBphF = rs.getString("phone_first");
				DBphM = rs.getString("phone_middle");
				DBphL = rs.getString("phone_last");
				
				if (user_name.equals(Username) && phF.equals(DBphF) && phM.equals(DBphM) &&
						phL.equals(DBphL)) {
					
					logc.findIdCheck.nameL.setText(DBuser_id);
					logc.findIdMain.card.show(logc.findIdMain.panMain, "findIdCheck");
					logc.findId.middleTF.setText("");
					logc.findId.lastTF.setText("");
					logc.findId.nameTF.setText("");
					check = 1;
				}
				
			}

			
			if (check == 0) {
				javax.swing.JOptionPane.showMessageDialog(logc.join, "일치하는 아이디가 없습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리문 오류");
		} finally{
          // DB 연결을 종료한다.
          try{
              if ( rs != null ){rs.close();}   
              if ( pstm != null ){pstm.close();}   
              if ( conn != null ){conn.close(); }
          }catch(Exception e){
              throw new RuntimeException(e.getMessage());
          }
          
		}
		
	}

	String findPwId; // 비밀번호  재변경시 필요
	
	
	
	
	
	
//	비밀번호 찾기 페이지
	public void reSetting() {
		findPwId = null;
	}

	public void findPw() {
		
		String quary = "select user_id, nvl(password_quiz, 'null') \"password_quiz\" , password_answer from fook_user";
		String name = logc.findPw.idTF.getText();
		String passwordA = logc.findPwCheck.answerTF.getText();
		
        
        if (name.isEmpty()) {
        	javax.swing.JOptionPane.showMessageDialog(logc.findPw, "아이디를 입력 바랍니다.");
		}
  	
	    
        try {
      		
        	conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();


			int idC = 0;
			
			while(rs.next()){

				String DBuser_id = rs.getString("user_id");
				String PasswordQ = rs.getString("password_quiz");
				String PasswordA = rs.getString("password_answer");
				
				if (name.equals(DBuser_id)) {
					logc.findPw.idTF.setText("");
					if (PasswordQ.equals("null")) {
						logc.findPwCheck.questionL.setText("질문 등록을 하지 않았습니다.");
						logc.findPwCheck.answerTF.setEditable(false);
						// 확인 누르면 메인으로 돌아지게 만들기. findPwId 전역변수 초기화 시켜주기
					}else{
						logc.findPwCheck.questionL.setText(PasswordQ);
						findPwId = DBuser_id;
					}
					logc.findPwMain.card.show(logc.findPwMain.panMain, "findPwCheck");
					idC = 1;
				}
			}
			if (idC == 0) {
				javax.swing.JOptionPane.showMessageDialog(logc.findPw, "있는 아이디가 없습니다.");					
			}
			
			
			
			
			
        }catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리문 오류");
		} finally{
          // DB 연결을 종료한다.
          try{
              if ( rs != null ){rs.close();}   
              if ( pstm != null ){pstm.close();}   
              if ( conn != null ){conn.close(); }
          }catch(Exception e){
              throw new RuntimeException(e.getMessage());
          }
          
		}


	}
	
//	----------------------------------------------------------------------------

	
	public void findPwCheck() {
		
		String quary = "select user_id, password_answer from fook_user";
		String answerTF = logc.findPwCheck.answerTF.getText();
		
		try {
			
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while(rs.next()) {
				
				String DBuser_id = rs.getString("user_id");
				String AnswerTF = rs.getString("password_answer");
				
				if (findPwId.equals(DBuser_id)) {
					if (answerTF.equals(AnswerTF)) {
						logc.findPwCheck.answerTF.setText("");
						logc.findPwMain.card.show(logc.findPwMain.panMain, "findRPw");
					}else {
						javax.swing.JOptionPane.showMessageDialog(logc.findPwCheck, "질문이 일치하지 않습니다.");					
					}
				}

			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

//	----------------------------------------------------------------------------------
	
	int RpwCheck = 0; // 확인하기 비밀번호가 제대로 설정이 되었는지.
	
	public void Rpwcompare() {
		
		String password = logc.findRPw.pwTF.getText();
		String againpwTF = logc.findRPw.againPwTF.getText();
		
		
    	if (!(password.equals(againpwTF)) || password.isEmpty() || againpwTF.isEmpty()) {
			logc.findRPw.checkL.setForeground(Color.RED);
			logc.findRPw.checkL.setText("비밀번호가 일치하지 않습니다.");
			RpwCheck = 0;
		}else if (password.length() < 6 || againpwTF.length() < 6 ) {
			logc.findRPw.checkL.setForeground(Color.RED);
			logc.findRPw.checkL.setText("비밀번호를 6자리 이상 입력해 주세요.");
			RpwCheck = 0;
		}else if (password.equals(againpwTF)) {
			logc.findRPw.checkL.setForeground(Color.GREEN);
			logc.join.pwCheckL.setText("비밀번호가 일치합니다.");
			RpwCheck = 1;
		} 
    	
	}

	public void findRPw() {

		String quary = "update fook_user set password = ? where user_id = ?";
		String password = logc.findRPw.pwTF.getText();
		String againpwTF = logc.findRPw.againPwTF.getText();
		
		
		try {
			
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			
			if ( RpwCheck == 1 ) {
				pstm.setString(1, password);
				pstm.setString(2, findPwId);
				int rs = pstm.executeUpdate();
				logc.findPwMain.setVisible(false);
				logc.findPwMain.card.show(logc.findPwMain.panMain, "findPw");
				RpwCheck = 0;
				findPwId = null; // 전역변수 초기화 시켜주기.
			}else if ( RpwCheck == 0) {
				javax.swing.JOptionPane.showMessageDialog(logc.findRPw, "비밀번호를 확인해 주세요.");					
			}
						
			
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}



        
        
        
        
        
        
        
        
        
    
    
}




























