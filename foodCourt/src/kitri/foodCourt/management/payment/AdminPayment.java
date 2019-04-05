package kitri.foodCourt.management.payment;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class AdminPayment extends JPanel {
	
	JTextField textField = new JTextField();
	
	JTable collectionTable = new JTable(60, 4);
	JTable receiptTable = new JTable(13, 3);

	JLabel searchLabel = new JLabel("\uAC80\uC0C9");
	JLabel receiptLabel = new JLabel("\uC601\uC218\uC99D");
	JLabel totalLabel = new JLabel("\uCD1D\uD569");
	JLabel totalPriceLabel = new JLabel("\uAE08\uC561");
	JLabel moneyLabel = new JLabel("\uD604\uAE08");
	JLabel moneyPriceLabel = new JLabel("\uD604\uAE08\uCD1D\uC561");
	JLabel cardLabel = new JLabel("\uCE74\uB4DC");
	JLabel cardPriceLabel = new JLabel("\uCE74\uB4DC\uCD1D\uC561");
	JLabel pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	JLabel overallLabel = new JLabel("\uCD1D\uD569");
	JLabel overallPriceLabel = new JLabel("\uCD1D\uACC4\uAE08\uC561");
	JLabel tableTotalLabel = new JLabel("\uCD1D\uD569");
	JLabel tableTotalPriceLabel = new JLabel("\uAE08\uC561");
	JLabel pointPriceLabel = new JLabel("\uD3EC\uC778\uD2B8\uCD1D\uC561");
	
	JPanel receiptPanel = new JPanel();
	JPanel totalPanel = new JPanel();
	JPanel selectPanel = new JPanel();
	JPanel overallPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	JPanel panel = new JPanel();
	JPanel optionPanel = new JPanel();
	JPanel tableTotalPanel = new JPanel();
	
	JButton moneyBtn = new JButton("\uD604\uAE08");
	JButton cardBtn = new JButton("\uCE74\uB4DC");
	JButton pointBtn = new JButton("\uD3EC\uC778\uD2B8");
	JButton okBtn = new JButton("\uACB0\uC81C");
	JButton cancelBtn = new JButton("\uCDE8\uC18C");
	JButton choiceDeleteBtn = new JButton("\uC120\uD0DD\uC0AD\uC81C");

	JScrollPane smallTablePane = new JScrollPane();
	JScrollPane bigTablePane = new JScrollPane();
	
	/**
	 * Create the panel.
	 */
	public AdminPayment() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setBounds(0, 0, 110, 60);
		add(searchLabel);
		
		textField.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 1, true));
		textField.setBounds(110, 0, 515, 60);
		add(textField);
		
		receiptPanel.setBounds(648, 0, 360, 575);
		receiptPanel.setLayout(null);
		add(receiptPanel);
		
		receiptLabel.setOpaque(true);
		receiptLabel.setBackground(Color.LIGHT_GRAY);
		receiptLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		receiptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiptLabel.setBounds(0, 0, 360, 60);
		receiptPanel.add(receiptLabel);
		
		smallTablePane.setBounds(0, 85, 360, 236);
		smallTablePane.setViewportView(receiptTable);
		receiptPanel.add(smallTablePane);
		
		totalPanel.setLayout(new GridLayout(1, 2, 0, 0));
		totalPanel.setBorder(null);
		totalPanel.setBounds(0, 331, 360, 31);
		receiptPanel.add(totalPanel);
		
		totalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalPanel.add(totalLabel);
		
		totalPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalPanel.add(totalPriceLabel);
		
		selectPanel.setBounds(0, 372, 360, 66);
		receiptPanel.add(selectPanel);
		selectPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		moneyBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectPanel.add(moneyBtn);
		
		cardBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectPanel.add(cardBtn);
		
		pointBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectPanel.add(pointBtn);
		
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		panel.setBounds(0, 448, 170, 127);
		receiptPanel.add(panel);
		
		moneyLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(moneyLabel);
		
		moneyPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(moneyPriceLabel);
		
		cardLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cardLabel);
		
		cardPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cardPriceLabel);
		
		pointLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(pointLabel);
		
		pointPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(pointPriceLabel);
		
		overallPanel.setBounds(182, 465, 178, 90);
		overallPanel.setLayout(new GridLayout(1, 2, 0, 0));
		receiptPanel.add(overallPanel);
		
		overallLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		overallLabel.setHorizontalAlignment(SwingConstants.CENTER);
		overallPanel.add(overallLabel);
		
		overallPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		overallPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		overallPanel.add(overallPriceLabel);
		
		btnPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
		btnPanel.setBounds(648, 585, 360, 127);
		btnPanel.setLayout(new GridLayout(1, 2, 30, 30));
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		add(btnPanel);
		
		bigTablePane.setBounds(0, 60, 625, 515);
		bigTablePane.setViewportView(collectionTable);
		add(bigTablePane);
		
		optionPanel.setLayout(null);
		optionPanel.setBounds(0, 585, 625, 100);
		add(optionPanel);
		
		choiceDeleteBtn.setBounds(12, 10, 125, 50);
		optionPanel.add(choiceDeleteBtn);
		
		tableTotalPanel.setBorder(null);
		tableTotalPanel.setBounds(385, 10, 240, 31);
		tableTotalPanel.setLayout(new GridLayout(1, 2, 0, 0));
		optionPanel.add(tableTotalPanel);
		
		tableTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tableTotalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTotalPanel.add(tableTotalLabel);
		
		tableTotalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tableTotalPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTotalPanel.add(tableTotalPriceLabel);
	}

}
