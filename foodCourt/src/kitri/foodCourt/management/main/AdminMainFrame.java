package kitri.foodCourt.management.main;

//import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import kitri.foodCourt.management.menu.AdminMenuManagement;
import kitri.foodCourt.management.order.OrderListFrame;
import kitri.foodCourt.management.payment.AdminPayment;
import kitri.foodCourt.management.regit.AdminMemberInfo;
import kitri.foodCourt.management.request.AdminRequest;
import java.awt.Insets;
//import kitri.foodCourt.management.statistics.AdminStatistics;


@SuppressWarnings("serial")
public class AdminMainFrame extends JFrame {

	String adminID;
	
	JPanel contentPanel = new JPanel();
	JPanel ampPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel emptyPanel = new JPanel();
	
	JButton menuManageBtn = new JButton(/*"메뉴관리"*/);
	JButton memberManageBtn = new JButton(/*"회원관리"*/);
	JButton requestManageBtn = new JButton(/*"요청관리"*/);
	JButton paymentBtn = new JButton(/*"결제관리"*/);
	JButton logoutBtn = new JButton(/*"로그아웃"*/);
	
	AdminMenuManagement amm;
	AdminMemberInfo ami = new AdminMemberInfo();
	AdminRequest ar = new AdminRequest();
	AdminPayment ap = new AdminPayment();
//	AdminStatistics as = new AdminStatistics();
	
	AdminMainFrameControl amfc;
	
	CardLayout cl = new CardLayout(0, 0);
	// 요청한 주문 목록 프레임
	OrderListFrame orderListFrame = new OrderListFrame();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminMainFrame frame = new AdminMainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminMainFrame(String adminID) {
		super("Food Court");
		
		this.adminID = adminID;
		amm = new AdminMenuManagement(adminID);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		buttonPanel.setLayout(new GridLayout(6, 1, 0, 45));
		buttonPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), this.adminID, TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 20, 40, 20)));
		buttonPanel.setBounds(12, 25, 150, 722);
		
		try {
			menuManageBtn.setMargin(new Insets(0, 0, 0, 0));
			menuManageBtn.setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/menuLabel.jpg").getFile()))));
			memberManageBtn.setMargin(new Insets(0, 0, 0, 0));
			memberManageBtn.setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/memberLabel.jpg").getFile()))));
			requestManageBtn.setMargin(new Insets(0, 0, 0, 0));
			requestManageBtn.setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/requestLabel.jpg").getFile()))));
			paymentBtn.setMargin(new Insets(0, 0, 0, 0));
			paymentBtn.setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/paymentLabel.jpg").getFile()))));
			logoutBtn.setMargin(new Insets(0, 0, 0, 0));
			logoutBtn.setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/logoutLabel.jpg").getFile()))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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

		menuManageBtn.addMouseListener(amfc);
		memberManageBtn.addMouseListener(amfc);
		requestManageBtn.addMouseListener(amfc);
		paymentBtn.addMouseListener(amfc);
		logoutBtn.addMouseListener(amfc);
	}
}
