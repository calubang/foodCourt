package kitri.foodCourt.management.member;

import java.awt.Dimension;
import java.sql.*;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.management.regit.DBConnection;

public class AdminTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable adminTable;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	String[] column = { "관리자ID", "이름", "핸드폰번호", "직업코드", "입사일", "우편번호", "주소", "이메일", "이메일도메인" };
	/**
	 * Create the panel.
	 */
	public AdminTable() {
		Object[] rowData = new Object[12];
		try {

			String quary = "SELECT* FROM FOOK_MANAGER";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			
			
			while (rs.next()) {

				rowData[0] = rs.getString("MANAGER_ID");
				rowData[1] = rs.getString("NAME");
				rowData[2] = rs.getString("PASSWORD");
				rowData[3] = rs.getString("PHONE_FIRST");
				rowData[4] = rs.getString("PHONE_MIDDLE");
				rowData[5] = rs.getString("PHONE_LAST");
				rowData[6] = rs.getString("JOB_ID");
				rowData[7] = rs.getDate("HIRE_DATE");
				rowData[8] = rs.getString("ADDRESS_ZIP");
				rowData[9] = rs.getString("ADDRESS");
				rowData[10] = rs.getString("EMAIL");
				rowData[11] = rs.getString("EMAIL_DOMAIN");
				
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
		
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
		adminTable = new JTable(dtm);
		setSize(new Dimension(780, 640));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(adminTable);
		add(scrollPane);
	}
}
