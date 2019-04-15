package kitri.foodCourt.management.member;

import java.awt.Dimension;
import java.sql.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;

public class MemberTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable memberTable = new JTable(dtm);
	
	private ConnectionMaker connectionMaker;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	String[] column = { "유저ID", "이름", "핸드폰번호", "사용가능포인트", "가입일", "탈퇴일", "활성화여부" };
	/**
	 * Create the panel.
	 */
	public MemberTable() {
		connectionMaker = DbFactory.connectionMaker("oracle");
		
		Object[] rowData = new Object[9];
		try {

			String quary = "SELECT user_id,password,phone_first||phone_middle||phone_last as pn,user_point,password_quiz,password_answer,join_date,secession_date,enable FROM FOOK_USER";
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			
			
			while (rs.next()) {

				rowData[0] = rs.getString("user_id");
				rowData[1] = rs.getString("password");
				rowData[2] = rs.getString("pn");
//				rowData[2] = rs.getString("phone_first");
//				rowData[3] = rs.getString("phone_middle");
//				rowData[4] = rs.getString("phone_last");
				rowData[3] = rs.getInt("user_point");
				rowData[4] = rs.getString("password_quiz");
				rowData[5] = rs.getString("password_answer");
				rowData[6] = rs.getDate("join_date");
				rowData[7] = rs.getDate("secession_date");
				rowData[8] = rs.getString("enable");
				
				
				dtm.addRow(rowData);
			
			}
			
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다.
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			
		}
		
		
		
	}

}
