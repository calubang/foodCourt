package kitri.foodCourt.management.main;

import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import kitri.foodCourt.management.member.AdminMemberInfo;
import kitri.foodCourt.management.menu.AdminMenuManagement;
import kitri.foodCourt.management.payment.AdminPayment;
import kitri.foodCourt.management.request.AdminRequest;
//import kitri.foodCourt.management.statistics.AdminStatistics;


@SuppressWarnings("serial")
public class AdminMainFrame extends JFrame {

	JPanel contentPanel = new JPanel();
	JPanel ampPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel emptyPanel = new JPanel();
	
	JButton menuManageBtn = new JButton("\uBA54\uB274\uAD00\uB9AC");
	JButton memberManageBtn = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
	JButton requestManageBtn = new JButton("\uC694\uCCAD\uAD00\uB9AC");
	JButton paymentBtn = new JButton("\uACB0\uC81C\uAD00\uB9AC");
	JButton logoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
	
	AdminMenuManagement amm = new AdminMenuManagement();
	AdminMemberInfo ami = new AdminMemberInfo();
	AdminRequest ar = new AdminRequest();
	AdminPayment ap = new AdminPayment();
//	AdminStatistics as = new AdminStatistics();
	
	AdminMainFrameControl amfc;
	
	CardLayout cl = new CardLayout(0, 0);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMainFrame() {
		super("Food Court");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		buttonPanel.setLayout(new GridLayout(6, 1, 0, 45));
		buttonPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAD00\uB9AC\uC790", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 20, 40, 20)));
		buttonPanel.setBounds(12, 25, 150, 722);
		
		buttonPanel.add(menuManageBtn);
		buttonPanel.add(memberManageBtn);
		buttonPanel.add(requestManageBtn);
		buttonPanel.add(paymentBtn);
		buttonPanel.add(emptyPanel);
		buttonPanel.add(logoutBtn);
		contentPanel.add(buttonPanel);
		
		ampPanel.setBounds(174, 25, 1008, 722);
		ampPanel.setLayout(cl);
		ampPanel.add("AdminMenuManagement", amm);
		ampPanel.add("AdminMemberInfo", ami);
		ampPanel.add("AdminRequest", ar);
		ampPanel.add("AdminPayment", ap);
//		ampPanel.add("AdminStatistics", as);
		cl.show(ampPanel, "AdminProduct");
		
		contentPanel.add(ampPanel);
		
		

		amfc = new AdminMainFrameControl(this);
		
		menuManageBtn.addActionListener(amfc);
		memberManageBtn.addActionListener(amfc);
		requestManageBtn.addActionListener(amfc);
		paymentBtn.addActionListener(amfc);
		logoutBtn.addActionListener(amfc);
	}
}
