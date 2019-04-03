package kitri.clothingStore.management.member;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMemberInfo extends JPanel {
	
	private JTextField searchTextField;

	JPanel memberMenuPanel = new JPanel();
	JPanel tablePanel = new JPanel();
	
	JPanel infoPanel = new JPanel();
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");
	
	JButton adminMemberRegisterBtn = new JButton("\uAD00\uB9AC\uC790\uB4F1\uB85D");
	JButton memberRegisterBtn = new JButton("\uD68C\uC6D0\uB4F1\uB85D");
	JButton modifyBtn = new JButton("\uC218\uC815");
	JButton deleteBtn = new JButton("\uC0AD\uC81C");
	JButton storeBtn = new JButton("\uC800\uC7A5");
	JButton adminBtn = new JButton("\uAD00\uB9AC\uC790");
	JButton memberBtn = new JButton("\uD68C\uC6D0");

	AdminTable at = new AdminTable();
	MemberTable mt = new MemberTable();
	
	CardLayout cl = new CardLayout(0, 0);
	
	/**
	 * Create the panel.
	 */
	public AdminMemberInfo() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setBounds(398, 0, 110, 60);
		add(searchLabel);
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		searchTextField.setColumns(10);
		searchTextField.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchTextField.setBounds(508, 0, 500, 60);
		add(searchTextField);
		
		memberMenuPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		memberMenuPanel.setBounds(799, 128, 209, 594);
		memberMenuPanel.setLayout(new GridLayout(5, 1, 0, 40));
		memberMenuPanel.add(adminMemberRegisterBtn);
		memberMenuPanel.add(memberRegisterBtn);
		memberMenuPanel.add(modifyBtn);
		memberMenuPanel.add(deleteBtn);
		memberMenuPanel.add(storeBtn);
		add(memberMenuPanel);
		
		infoPanel.setBounds(0, 12, 250, 70);
		infoPanel.setLayout(new GridLayout(1, 2, 0, 0));
		adminBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cl.show(tablePanel, "AdminTable");
					}
				});
		infoPanel.add(adminBtn);
		memberBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cl.show(tablePanel, "MemberTable");
					}
				});
		infoPanel.add(memberBtn);
		add(infoPanel);

		tablePanel.setBounds(0, 82, 780, 640);
		tablePanel.setLayout(cl);
		tablePanel.add("AdminTable", at);
		tablePanel.add("MemberTable", mt);
		cl.show(tablePanel, "AdminTable");
		
		add(tablePanel);
	}
}
