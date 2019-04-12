package kitri.foodCourt.management.member;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	
	private JTable adminTable = new JTable(60, 5);
	
	String[] column = { "아이디", "이름", "비밀번호", "번호1","번호2","번호3", "직업코드", "입사일", "우편번호", "주소", "이메일", "이메일도메인" };
	/**
	 * Create the panel.
	 */
	public AdminTable() {
		
//		for (int i = 0; i < column.length; i++) {
//			adminTable.addColumn(column[i]);
//		}
		
		setSize(new Dimension(780, 640));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(adminTable);
		add(scrollPane);
	}
}
