package kitri.clothingStore.management.member;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberTable extends JPanel {

	JScrollPane scrollPane = new JScrollPane();
	
	private JTable memberTable = new JTable(60, 5);
	
	
	/**
	 * Create the panel.
	 */
	public MemberTable() {
		setSize(new Dimension(780, 640));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 780, 640);
		scrollPane.setViewportView(memberTable);
		add(scrollPane);
	}

}
