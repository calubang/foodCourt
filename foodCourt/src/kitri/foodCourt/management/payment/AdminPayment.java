package kitri.foodCourt.management.payment;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;


@SuppressWarnings("serial")
public class AdminPayment extends JPanel {
	
	JTextField searchTextField = new JTextField();
	DefaultTableModel dtm = new DefaultTableModel();
	JTable commonTable = new JTable(dtm) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");

	JScrollPane scrollPane = new JScrollPane(commonTable);
	JPanel menuPanel = new JPanel();
	
	JButton checkReceiptBtn = new JButton("\uC601\uC218\uC99D\uD655\uC778");
	JButton deleteBtn = new JButton("\uC0AD\uC81C");
	
	AdminPaymentControl apc;
	AdminViewReceipt avr;
	
	/**
	 * Create the panel.
	 */
	public AdminPayment() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setBounds(0, 0, 110, 60);
		add(searchLabel);
		
		searchTextField.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchTextField.setFont(new Font("±¼¸²", Font.PLAIN, 24));
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

		menuPanel.add(checkReceiptBtn);
		menuPanel.add(deleteBtn);

		add(menuPanel);
		
		
		// Add Listener
		apc = new AdminPaymentControl(this);
		avr = apc.avr;
		
		checkReceiptBtn.addActionListener(apc);
		deleteBtn.addActionListener(apc);
		searchTextField.addKeyListener(apc);
		
		avr.confirmBtn.addActionListener(apc);
	}
}
