package kitri.foodCourt.management.order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JScrollPane;

public class OrderDetailDialog extends JDialog {
	
	JLabel labRequestNum = new JLabel("request");
	JLabel labTimeNow = new JLabel("\uD604\uC7AC\uC2DC\uAC04");
	JButton btnCheck = new JButton("\uD655\uC778");
	
	String columns[] = {"메뉴", "수량"};
	Object[] rowData = new Object[2];
	
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable menuTable;
	JScrollPane scrollPaneTable = new JScrollPane(menuTable);
	private JTable table = new JTable();

	public OrderDetailDialog(OrderListFrame orderListFrame) {
		super(orderListFrame, "\uC8FC\uBB38\uC815\uBCF4", false);
		getContentPane().setBackground(new Color(220, 220, 220));
		getContentPane().setLayout(null);

		labRequestNum.setHorizontalAlignment(SwingConstants.CENTER);
		labRequestNum.setBounds(118, 92, 153, 37);
		getContentPane().add(labRequestNum);

		labTimeNow.setOpaque(true);
		labTimeNow.setBackground(new Color(255, 228, 196));
		labTimeNow.setHorizontalAlignment(SwingConstants.CENTER);
		labTimeNow.setBounds(72, 37, 249, 45);
		getContentPane().add(labTimeNow);

		btnCheck.setBounds(118, 520, 153, 43);
		getContentPane().add(btnCheck);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 369, 376);
		getContentPane().add(scrollPane);

		table.setPreferredSize(new Dimension(380, 376));
		table.setPreferredScrollableViewportSize(new Dimension(380, 376));

		scrollPane.setViewportView(table);
		
		defaultTableModel.addColumn(columns[0]);
		defaultTableModel.addColumn(columns[1]);
		
		setBounds(200, 200, 410, 610);
		
//		amm.jdM.getContentPane().add(amm.am);
//		amm.jdM.setSize(750, 650);
//		setModal(true);
		setResizable(false);
		defaultTableModel.addRow(rowData);
		menuTable = new JTable(defaultTableModel) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
	}
	public void setOrderDetail(int count, Vector<String[]> menuList) {
		for(int i=0; i<count; i++) {
			defaultTableModel.addRow(menuList.get(i));
		}
	}
}
