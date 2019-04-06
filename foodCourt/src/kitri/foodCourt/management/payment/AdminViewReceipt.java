package kitri.foodCourt.management.payment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AdminViewReceipt extends JPanel {

	JTable table = new JTable(15, 4);

	JPanel panel = new JPanel();
	JPanel paymentMethodPanel = new JPanel();
	JPanel orderNumPanel = new JPanel();
	JPanel orderDatePanel = new JPanel();
	JPanel memberIDPanel = new JPanel();
	JLabel orderNumLabel = new JLabel("\uC8FC\uBB38\uBC88\uD638 :");
	JLabel oderNumValueLabel = new JLabel("orderNumber");
	JLabel orderDateLabel = new JLabel("\uC8FC\uBB38\uC77C\uC2DC :");
	JLabel orderDateValueLabel = new JLabel("orderDate");
	JLabel memberIDLabel = new JLabel("\uD68C\uC6D0ID :");
	JLabel memberIDValueLabel = new JLabel("memberID");

	JButton confirmBtn = new JButton("\uD655\uC778");

	JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * Create the panel.
	 */
	public AdminViewReceipt() {
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 380, 680);
		add(panel);
		
		scrollPane.setBounds(0, 120, 380, 280);
		panel.add(scrollPane);
		
		table.setPreferredSize(new Dimension(380, 250));
		table.setPreferredScrollableViewportSize(new Dimension(380, 280));
		scrollPane.setViewportView(table);
		
		paymentMethodPanel.setLayout(new GridLayout(2, 3, 0, 0));
		paymentMethodPanel.setBorder(null);
		paymentMethodPanel.setBounds(10, 415, 360, 62);
		panel.add(paymentMethodPanel);
		
		JLabel moneyLabel = new JLabel("\uD604\uAE08");
		moneyLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(moneyLabel);
		
		JLabel cardLabel = new JLabel("\uCE74\uB4DC");
		cardLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(cardLabel);
		
		JLabel pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
		pointLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(pointLabel);
		
		JLabel moneyValueLabel = new JLabel("money");
		moneyValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(moneyValueLabel);
		
		JLabel cardValueLabel = new JLabel("card");
		cardValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(cardValueLabel);
		
		JLabel pointValueLabel = new JLabel("point");
		pointValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(pointValueLabel);
		
		orderNumPanel.setBorder(null);
		orderNumPanel.setBounds(0, 23, 172, 31);
		orderNumPanel.setLayout(new GridLayout(1, 2, 0, 0));
		panel.add(orderNumPanel);
		
		orderNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderNumLabel.setBorder(null);
		orderNumPanel.add(orderNumLabel);
		
		oderNumValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		oderNumValueLabel.setBorder(null);
		orderNumPanel.add(oderNumValueLabel);
		
		orderDatePanel.setLayout(null);
		orderDatePanel.setBorder(null);
		orderDatePanel.setBounds(184, 23, 188, 31);
		panel.add(orderDatePanel);
		
		orderDateLabel.setBounds(0, 0, 86, 31);
		orderDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderDateLabel.setBorder(null);
		orderDatePanel.add(orderDateLabel);
		
		orderDateValueLabel.setBounds(86, 0, 105, 31);
		orderDateValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		orderDateValueLabel.setBorder(null);
		orderDatePanel.add(orderDateValueLabel);
		
		memberIDPanel.setLayout(new GridLayout(1, 2, 0, 0));
		memberIDPanel.setBorder(null);
		memberIDPanel.setBounds(184, 52, 172, 31);
		panel.add(memberIDPanel);
		
		memberIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberIDLabel.setBorder(null);
		memberIDPanel.add(memberIDLabel);
		
		memberIDValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		memberIDValueLabel.setBorder(null);
		memberIDPanel.add(memberIDValueLabel);
		
		confirmBtn.setBounds(127, 598, 128, 48);
		panel.add(confirmBtn);
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(null);
		totalPanel.setBounds(10, 498, 360, 62);
		panel.add(totalPanel);
		totalPanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel payTotalLabel = new JLabel("\uACB0\uC81C\uAE08\uC561");
		payTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payTotalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(payTotalLabel);
		
		JLabel payTotalValueLabel = new JLabel("money_card_point");
		payTotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payTotalValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(payTotalValueLabel);
		
		JLabel getPointLabel = new JLabel("\uD68D\uB4DD\uD3EC\uC778\uD2B8");
		getPointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getPointLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(getPointLabel);
		
		JLabel getPointValueLabel = new JLabel("percentage15");
		getPointValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getPointValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(getPointValueLabel);
	}
}
