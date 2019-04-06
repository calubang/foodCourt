package kitri.foodCourt.management.menu;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class AdminMenuManagement extends JPanel {

	JTextField searchTextField = new JTextField();
	JTable commonTable = new JTable(60, 8);
	
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");
	JLabel pictureLabel = new JLabel("Picture");

	JPanel picturePanel = new JPanel();
	JPanel menuPanel = new JPanel();

	JScrollPane scrollPane = new JScrollPane(commonTable);
	
	JButton registerBtn = new JButton("\uB4F1\uB85D");
	JButton modifyBtn = new JButton("\uC218\uC815");
	JButton deleteBtn = new JButton("\uC0AD\uC81C");
	
	AdminMenuControl amc;
	
	
	/**
	 * Create the panel.
	 */
	public AdminMenuManagement() {
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
		
		picturePanel.setBounds(803, 0, 205, 213);
		picturePanel.setLayout(new BorderLayout(0, 0));
		pictureLabel.setIcon(null);
		pictureLabel.setForeground(Color.BLACK);
		pictureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picturePanel.add(pictureLabel, BorderLayout.CENTER);
		add(picturePanel);
		
		commonTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		commonTable.setBounds(0, 356, 791, 366);
		commonTable.setShowGrid(true);
		commonTable.setShowVerticalLines(true);
		commonTable.setAutoCreateRowSorter(true);
		commonTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrollPane.setBounds(0, 58, 791, 664);
		add(scrollPane);

		menuPanel.setLayout(new GridLayout(3, 1, 0, 60));
		menuPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		menuPanel.setBounds(799, 243, 209, 479);
		
		menuPanel.add(registerBtn);
		menuPanel.add(modifyBtn);
		menuPanel.add(deleteBtn);

		add(menuPanel);
		
		
		// Add Listener
		amc = new AdminMenuControl(this);
		
		registerBtn.addActionListener(amc);
		modifyBtn.addActionListener(amc);
		deleteBtn.addActionListener(amc);
	}
}
