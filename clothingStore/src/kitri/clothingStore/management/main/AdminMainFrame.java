package kitri.clothingStore.management.main;

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

import kitri.clothingStore.management.member.AdminMemberInfo;
import kitri.clothingStore.management.payment.AdminPayment;
import kitri.clothingStore.management.product.AdminProductManagement;
import kitri.clothingStore.management.product.AdminRegisterProduct;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminMainFrame extends JFrame {

	JPanel contentPanel = new JPanel();
	JPanel ampPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	JButton productManageBtn = new JButton("\uC81C\uD488\uAD00\uB9AC");
	JButton memberManageBtn = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
	JButton helpManageBtn = new JButton("\uC694\uCCAD\uAD00\uB9AC");
	JButton paymentBtn = new JButton("\uACB0\uC81C");
	JButton statisticsBtn = new JButton("\uD1B5\uACC4");
	
	AdminProductManagement apm = new AdminProductManagement();
	AdminMemberInfo ami = new AdminMemberInfo();
	AdminPayment ap = new AdminPayment();
	
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		buttonPanel.setLayout(new GridLayout(5, 1, 0, 60));
		buttonPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAD00\uB9AC\uC790", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 20, 40, 20)));
		buttonPanel.setBounds(12, 25, 150, 722);
		contentPanel.add(buttonPanel);
		
		productManageBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								cl.show(ampPanel, "AdminProduct");
							}
						});
		
		buttonPanel.add(productManageBtn);
		
		memberManageBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cl.show(ampPanel, "AdminMember");
							}
						});
		
		buttonPanel.add(memberManageBtn);
		buttonPanel.add(helpManageBtn);
		paymentBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cl.show(ampPanel, "AdminPayment");
						}
					});
		buttonPanel.add(paymentBtn);
		buttonPanel.add(statisticsBtn);
		
		ampPanel.setBounds(174, 25, 1008, 722);
		ampPanel.setLayout(cl);
		ampPanel.add("AdminProduct", apm);
		ampPanel.add("AdminMember", ami);
		ampPanel.add("AdminPayment", ap);
		cl.show(ampPanel, "AdminProduct");
		
		contentPanel.add(ampPanel);
	}
}
