package kitri.foodCourt.management.login;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.management.main.AdminMainFrame;


public class LoginService {

	LoginControl lc;
	LoginMain lm;
	Login l;
	
	private ConnectionMaker connectionMaker;
	
    // For OracleDB
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
	
	public LoginService(LoginControl lc) {
		this.lc = lc;
		lm = lc.lm;
		l = lm.panLogin;
		
		connectionMaker = DbFactory.connectionMaker("oracle");
	}


	public void loginAdmin() {
		String id = l.idtextField.getText().trim();
		if (id.isEmpty()) {
			warningMessage(l.idtextField, "아이디를 입력하세요.", "관리자 로그인 오류");
		}
		
		String pw = String.valueOf(l.pwtextfd.getPassword());
		if (pw.isEmpty()) {
			warningMessage(l.pwtextfd, "패스워드를 입력하세요.", "관리자 로그인 오류");
		}
		
		String adminID = null;
		try {
			c = connectionMaker.makeConnection();
			
			ps = c.prepareStatement("select manager_id "
								  + "from fook_manager "
								  + "where name = (?) and password = (?)");
			
			ps.setString(1, id);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				adminID = rs.getString("manager_id");
			}
		} catch (SQLException e) {
			warningMessage(l.loginbtn, e.getMessage(), "관리자 로그인 오류");
		} finally {
			closeOracleConnection(l.loginbtn, c, ps, rs);
			
			if (adminID == null) {
				warningMessage(l.loginbtn, "아이디 또는 패스워드가 일치하지 않습니다.", "관리자 로그인 오류");
				return;
			}
			
			new AdminMainFrame(adminID).setVisible(true);
			lm.dispose();
		}
	}
	
	private void closeOracleConnection(Component comp, Connection c, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				rs = null;
			}
		}
		
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				ps = null;
			}
		}
		
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				c = null;
			}
		}
	}
	
	private void warningMessage(Component component, Object msg, String title) {
		JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
	}
}
