package kitri.foodCourt.management.payment;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kitri.foodCourt.management.menu.AdminModifyMenu;
import kitri.foodCourt.management.menu.AdminRegisterMenu;
import kitri.foodCourt.management.request.AdminViewOrder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class AdminPayment extends JPanel {
	
	private JTextField searchTextField = new JTextField();
	private JTable commonTable = new JTable(60, 8);
	
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");

	JScrollPane scrollPane = new JScrollPane(commonTable);
	private JPanel menuPanel = new JPanel();
	
	private JButton checkReceiptBtn = new JButton("\uC601\uC218\uC99D\uD655\uC778");
	private JButton deleteBtn = new JButton("\uC0AD\uC81C");
	
	JFrame jfR = new JFrame("영수증");
	
	AdminViewReceipt avr;
	
	/**
	 * Create the panel.
	 */
	public AdminPayment() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setBounds(0, 0, 110, 60);
		add(searchLabel);
		
		searchTextField.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchTextField.setFont(new Font("굴림", Font.PLAIN, 24));
		searchTextField.setBounds(110, 0, 681, 60);
		searchTextField.setColumns(10);
		add(searchTextField);
		
		commonTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		commonTable.setBounds(0, 356, 791, 366);
		commonTable.setShowGrid(true);
		commonTable.setShowVerticalLines(true);
		commonTable.setAutoCreateRowSorter(true);
		commonTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrollPane.setBounds(0, 58, 791, 664);
		add(scrollPane);

		menuPanel.setLayout(new GridLayout(2, 1, 0, 60));
		menuPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		menuPanel.setBounds(799, 432, 209, 290);
		
		checkReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				avr = new AdminViewReceipt();
				
				jfR.getContentPane().add(avr);
				jfR.setSize(395, 720);
				jfR.setVisible(true);
			}
		});
		menuPanel.add(checkReceiptBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] option = {"예", "아니오"};
				JOptionPane.showOptionDialog(deleteBtn, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
			}
		});
		menuPanel.add(deleteBtn);

		add(menuPanel);
	}

}
