package kitri.foodCourt.user.member;
 
import java.io.PrintStream;
import java.sql.*;
 
public class LoginService {
    
	Connection conn = null; // DB연결된 상태(세션)을 담은 객체
    PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
	
	LoginControl logc;
//	DBConnection dbConnection;
	
    LoginService(LoginControl logc) { 
    	
    	this.logc = logc;
//    	dbConnection = new DBConnection();
    	
    }
    
    public void logJoin() {
    	
    	String quary = "select user_id, password from fook_user";
    	
    	logc.login.idtextField.getText();
    	logc.login.pwtextfd.getPassword();
    	
        try {
        	conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

//			System.out.println("user_id \t password");
//			System.out.println("=========================");
			
			
			String str = new String(logc.login.pwtextfd.getPassword());
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
				}
				
				
			}
			
			if ((logc.login.idtextField.getText().isEmpty()) || (logc.login.pwtextfd.getPassword().length == 0)) {
				javax.swing.JOptionPane.showMessageDialog(logc.login, "아이디 또는 비밀번호를 입력해 주세요.");

			}else if (checking == 0) {
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
    
    public void showJoinpage() {
      System.out.println("test");
    }
    
}




























