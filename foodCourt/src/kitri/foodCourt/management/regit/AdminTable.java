package kitri.foodCourt.management.regit;

import java.awt.Dimension;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;


@SuppressWarnings("serial")
public class AdminTable extends JPanel {

	public JScrollPane scrollPane = new JScrollPane();
	public DefaultTableModel dtm = new DefaultTableModel();
	public JTable adt= new JTable(dtm);

	
	private ConnectionMaker connectionMaker;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	String[] column = { "관리자ID", "이름","비밀번호", "핸드폰번호", "직급", "입사일", "우편번호", "주소", "이메일", "이메일도메인" };

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
//		adminTable = new JTable(dtm);
		setSize(new Dimension(780, 640));
		setLayout(null);
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(adt);
		adt.setShowGrid(true);
		adt.setShowVerticalLines(true);
		adt.setAutoCreateRowSorter(true);
		add(scrollPane);
	}
	
	public void selectAdmin() {
		Object[] rowData = new Object[10];
		try {

			String quary = 
					"SELECT \n" + 
					"    MANAGER_ID\n" + 
					"    ,NAME\n" + 
					"    ,PASSWORD\n" + 
					"    ,PHONE_FIRST||PHONE_MIDDLE||PHONE_LAST as pn\n" + 
					"    ,fj.job_name as job_name\n" + 
					"    ,HIRE_DATE\n" + 
					"    ,ADDRESS_ZIP\n" + 
					"    ,ADDRESS\n" + 
					"    ,EMAIL\n" + 
					"    ,EMAIL_DOMAIN \n" + 
					"FROM \n" + 
					"    FOOK_MANAGER fm \n" + 
					"    , fook_job fj \n" + 
					"where fm.job_id = fj.job_id(+)";
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while (rs.next()) {

				rowData[0] = rs.getString("manager_id");
				rowData[1] = rs.getString("NAME");
				rowData[2] = rs.getString("PASSWORD");
				rowData[3] = rs.getString("pn");
				rowData[4] = rs.getString("job_name");
				rowData[5] = rs.getDate("HIRE_DATE");
				rowData[6] = rs.getString("ADDRESS_ZIP");
				rowData[7] = rs.getString("ADDRESS");
				rowData[8] = rs.getString("email");
				rowData[9] = rs.getString("EMAIL_DOMAIN");
				
				
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
