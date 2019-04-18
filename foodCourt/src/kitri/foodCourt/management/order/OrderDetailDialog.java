package kitri.foodCourt.management.order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JScrollPane;
import java.awt.Font;

public class OrderDetailDialog extends JDialog {
	
	JLabel labRequestNum = new JLabel("");
	JLabel labTimeNow = new JLabel("");
	JButton btnCheck = new JButton("\uD655\uC778");
	
	String columns[] = {"메뉴", "수량"};
	Object[] rowData = new Object[2];
	
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable menuTable = new JTable(defaultTableModel) {

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	JScrollPane scrollPaneTable = new JScrollPane(menuTable);

	public OrderDetailDialog(OrderListFrame orderListFrame) {
		super(orderListFrame, "\uC8FC\uBB38\uC815\uBCF4", false);
		getContentPane().setBackground(new Color(220, 220, 220));
		getContentPane().setLayout(null);
		labRequestNum.setFont(new Font("굴림", Font.PLAIN, 16));

		labRequestNum.setHorizontalAlignment(SwingConstants.CENTER);
		labRequestNum.setBounds(125, 92, 146, 37);
		getContentPane().add(labRequestNum);
		labTimeNow.setFont(new Font("굴림", Font.PLAIN, 16));

		labTimeNow.setOpaque(true);
		labTimeNow.setBackground(new Color(255, 228, 196));
		labTimeNow.setHorizontalAlignment(SwingConstants.CENTER);
		labTimeNow.setBounds(76, 37, 245, 45);
		getContentPane().add(labTimeNow);

		btnCheck.setBounds(118, 520, 153, 43);
		getContentPane().add(btnCheck);
		scrollPaneTable.setBounds(12, 133, 380, 377);
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 135, 369, 376);
		getContentPane().add(scrollPaneTable);


		scrollPaneTable.setViewportView(menuTable);
		
		
		setBounds(200, 200, 410, 610);
		
//		amm.jdM.getContentPane().add(amm.am);
//		amm.jdM.setSize(750, 650);
		setModal(true);
		setResizable(false);
		setAlwaysOnTop(true);
		//menuTable.setPreferredSize(new Dimension(380, 376));
		menuTable.setShowHorizontalLines(true);
		menuTable.setPreferredScrollableViewportSize(new Dimension(380, 376));
		defaultTableModel.addColumn(columns[0]);
		defaultTableModel.addColumn(columns[1]);
		//가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = menuTable.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		//이벤트 등록부----------------------------------
		btnCheck.addActionListener(orderListFrame.orderController);
	}
	public void setOrderDetail(int count, Vector<String[]> menuList) {
		defaultTableModel.setRowCount(0);
		for(int i=0; i<count; i++) {
			defaultTableModel.addRow(menuList.get(i));
		}
	}
}
