package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class FoodMain extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	JPanel panel = new JPanel();
	JPanel panel_5 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_2 = new JPanel();
	UserMenuView userMenuList = new UserMenuView();
	UserMenuDetailView menuDetailView = new UserMenuDetailView();
	FoodMainView foodMainView = new FoodMainView();
	
	JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
	JPanel panel_6 = new JPanel();
	JPanel changePanel = new JPanel();
	CardLayout card = new CardLayout();
	
	JButton mainMenu = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainbutton.jpg")));
	JButton hansicMenu = new JButton("\uD55C\uC2DD");
	JButton joongsicMenu = new JButton("\uC911\uC2DD");
	JButton ilsicMenu = new JButton("\uC77C\uC2DD");
	JButton yangsicMenu = new JButton("\uC591\uC2DD");
	JButton search = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/search.PNG")));
	JPanel panel_1 = new JPanel();
	JLabel menu = new JLabel(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/menu.PNG")));
	JButton userInfo = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mypage.PNG")));
	JLabel name = new JLabel("\uAD8C\uC601\uCC2C\uB2D8");
	JButton orderList = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/basket.png")));
	JLabel basket = new JLabel("\uC8FC\uBB38\uBAA9\uB85D");
	JPanel panel_7 = new JPanel();
	Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMain frame = new FoodMain();
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
	public FoodMain() {
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setVerticalTextPosition(0);
		hansicMenu.setToolTipText("\uD55C\uC2DD");
		hansicMenu.setName("1");
		joongsicMenu.setToolTipText("\uC911\uC2DD");
		joongsicMenu.setName("2");
		ilsicMenu.setToolTipText("\uC77C\uC2DD");
		ilsicMenu.setName("3");
		yangsicMenu.setToolTipText("\uC591\uC2DD");
		yangsicMenu.setName("4");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBorder(null);
		
		mainMenu.setCursor(handCursor);
		userInfo.setToolTipText("\uD68C\uC6D0\uC815\uBCF4");
		userInfo.setCursor(handCursor);
		orderList.setToolTipText("\uC8FC\uBB38\uBAA9\uB85D");
		orderList.setCursor(handCursor);
		name.setCursor(handCursor);
		basket.setCursor(handCursor);
		
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel_5.setBackground(Color.DARK_GRAY);
		
		
		panel_5.setBounds(12, 10, 1160, 6);
		panel.add(panel_5);
		panel_3.setBackground(Color.DARK_GRAY);
		
		
		panel_3.setBounds(12, 102, 1160, 6);
		panel.add(panel_3);
		
		
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(22, 21, 107, 75);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		mainMenu.setToolTipText("\uBA54\uC778\uBA54\uB274");
		mainMenu.setBorder(null);
		mainMenu.setPreferredSize(new Dimension(107, 75));
		
		mainMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		mainMenu.setBorderPainted(false);
		panel_2.add(mainMenu);
		mainMenu.setBackground(Color.WHITE);
		
		userMenuList.setBounds(160, 118, 1012, 634);
		hansicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		joongsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		ilsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		yangsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
	
//		--------------------변하는 패널 부분 카드레이아웃 설정
		changePanel.setLayout(card);
		changePanel.add(userMenuList, "menuList");
		changePanel.add(menuDetailView, "menuDetail");
		changePanel.add(foodMainView, "mainMenu");
		changePanel.setBounds(160, 118, 1012, 634);
		panel.add(changePanel);
		card.show(changePanel, "mainMenu");
//		---------------------
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(171, 26, 69, 66);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(2, 2, 4, 4, (Color) Color.LIGHT_GRAY));
		textField.setBounds(252, 48, 553, 38);
		panel.add(textField);
		textField.setColumns(10);
		panel_6.setBackground(Color.DARK_GRAY);
		
		
		panel_6.setBounds(145, 118, 4, 633);
		panel.add(panel_6);
		hansicMenu.setBounds(22, 210, 103, 90);
		
		panel.add(hansicMenu);
		joongsicMenu.setBounds(22, 321, 103, 90);
		
		panel.add(joongsicMenu);
		ilsicMenu.setBounds(22, 432, 103, 90);
		
		panel.add(ilsicMenu);
		yangsicMenu.setBounds(22, 543, 103, 90);
		
		panel.add(yangsicMenu);
		search.setBorder(null);
		search.setBounds(828, 46, 40, 38);
		
		panel.add(search);
		panel_1.setBounds(145, 26, 4, 66);
		panel.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		menu.setToolTipText("\uBA54\uB274");
		menu.setOpaque(true);
		menu.setBackground(Color.WHITE);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBounds(12, 118, 123, 82);
		
		panel.add(menu);
		userInfo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		userInfo.setBounds(965, 26, 79, 54);
		
		panel.add(userInfo);
		name.setBounds(965, 77, 79, 22);
		
		panel.add(name);
		orderList.setBorder(new LineBorder(Color.GRAY, 2, true));
		orderList.setBounds(1074, 26, 79, 54);
		
		panel.add(orderList);
		basket.setVerticalTextPosition(SwingConstants.CENTER);
		basket.setHorizontalAlignment(SwingConstants.CENTER);
		basket.setBounds(1074, 77, 79, 22);
		
		panel.add(basket);
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(932, 26, 4, 66);
		
		panel.add(panel_7);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
//		--------------------------이벤트 등록부
		FoodMainController mainController = new FoodMainController(this);
		mainMenu.addActionListener(mainController);
		search.addActionListener(mainController);
		hansicMenu.addActionListener(mainController);
		joongsicMenu.addActionListener(mainController);
		ilsicMenu.addActionListener(mainController);
		yangsicMenu.addActionListener(mainController);
	}
	// 한식 메뉴를 클릭했을때 한식 메뉴 패널에 메뉴 리스트를 세팅하고 setView메소드를 호출해서 메인화면에 add해준다
	// 메뉴 패널을 메인에 add하지 않고 setvisible을 하게되면 메인 화면을 움직였을때 
//	public void setView(Component component) {
//		component.setLocation(160, 118);
//		FoodMain.add(component);
//	}
//	public void removeView(Component component) {
//		FoodMain.remove(component);
//	}
}
