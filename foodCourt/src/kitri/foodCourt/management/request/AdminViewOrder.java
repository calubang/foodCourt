package kitri.foodCourt.management.request;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class AdminViewOrder extends JPanel {

	JTable table = new JTable(15, 4);

	JPanel panel = new JPanel();
	JPanel totalPanel = new JPanel();
	JPanel orderNumPanel = new JPanel();
	JPanel orderDatePanel = new JPanel();
	JPanel memberIDPanel = new JPanel();

	JLabel totalLabel = new JLabel("\uCD1D\uD569");
	JLabel priceLabel = new JLabel("\uAE08\uC561");
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
	public AdminViewOrder() {
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 380, 540);
		add(panel);
		
		scrollPane.setBounds(0, 120, 380, 280);
		panel.add(scrollPane);
		
		table.setPreferredSize(new Dimension(380, 250));
		table.setPreferredScrollableViewportSize(new Dimension(380, 280));
		scrollPane.setViewportView(table);
		
		totalPanel.setLayout(new GridLayout(1, 2, 0, 0));
		totalPanel.setBorder(null);
		totalPanel.setBounds(10, 415, 360, 31);
		panel.add(totalPanel);
		
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(totalLabel);
		
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(priceLabel);
		
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
		
		confirmBtn.setBounds(127, 469, 128, 48);
		panel.add(confirmBtn);
	}
}
