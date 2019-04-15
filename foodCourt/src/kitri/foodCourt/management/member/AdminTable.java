package kitri.foodCourt.management.member;

import java.awt.Dimension;
import java.sql.*;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.management.regit.DBConnection;

public class AdminTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable adminTable;
	
	private ConnectionMaker connectionMaker;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	String[] column = { "관리자ID", "이름", "핸드폰번호", "직업코드", "입사일", "우편번호", "주소", "이메일", "이메일도메인" };

	/**
	 * Create the panel.
	 */
	public AdminTable() {
		//db 연동
		connectionMaker = DbFactory.connectionMaker("oracle");
		
		
		initView();
		selectAdmin();
	}
	
	public void initView() {
		adminTable = new JTable(dtm);
		setSize(new Dimension(780, 640));
		setLayout(null);
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(adminTable);
		add(scrollPane);
		
		selectAdmin();
	}
	
	public void selectAdmin() {
		Object[] rowData = new Object[12];
		try {

			String quary = "SELECT MANAGER_ID,NAME,PASSWORD,PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST,JOB_ID,HIRE_DATE,ADDRESS_ZIP,ADDRESS,EMAIL,EMAIL_DOMAIN FROM FOOK_MANAGER";
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) {

				rowData[0] = rs.getString("manager_id");
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
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
