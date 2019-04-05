package kitri.foodCourt.management.member;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	
	private JTable adminTable = new JTable(60, 5);
	
	/**
	 * Create the panel.
	 */
	public AdminTable() {
		setSize(new Dimension(780, 640));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(adminTable);
		add(scrollPane);
	}
}
