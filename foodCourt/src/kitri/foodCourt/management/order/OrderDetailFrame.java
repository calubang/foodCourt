package kitri.foodCourt.management.order;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class OrderDetailFrame extends JFrame{
	JLabel labRequestNum = new JLabel("request");
	JLabel labTimeNow = new JLabel("\uD604\uC7AC\uC2DC\uAC04");
	JButton btnCheck = new JButton("\uD655\uC778");
	private JTable table = new JTable();
	public OrderDetailFrame() {
		super("\uC8FC\uBB38\uC815\uBCF4");
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
		setBounds(200, 200, 410, 610);
		setVisible(true);
	}
	public static void main(String[] args) {
		new OrderDetailFrame();
	}
}
