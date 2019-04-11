package kitri.foodCourt.user.main;

//
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
import java.awt.Dimension;
import javax.swing.border.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.BasketDetail;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.basket.BasketMain;
import kitri.foodCourt.user.menu.*;

public class FoodMain extends JFrame{

	public JPanel contentPane;
	public JTextField searchField;
	public JPanel panel = new JPanel();
	public JPanel panel_5 = new JPanel();
	public JPanel panel_3 = new JPanel();
	public JPanel panel_2 = new JPanel();
	public UserMenuView userMenuView = new UserMenuView();
	public UserMenuDetailView UserMenuDetailView = new UserMenuDetailView();
	public FoodMainView foodMainView = new FoodMainView();
	public NoSearchMenuImg noSearchMenuImg = new NoSearchMenuImg();
	
	public JLabel labSearch = new JLabel("\uAC80\uC0C9");
	public JPanel panel_6 = new JPanel();
	public JPanel panChangePanel = new JPanel();
	public CardLayout card = new CardLayout();
	
	public JButton btnMainMenu = new MainButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/mainbutton.jpg")));
	public JButton btnHansicMenu = new MainButton("\uD55C\uC2DD");
	public JButton btnJoongsicMenu = new MainButton("\uC911\uC2DD");
	public JButton btnIlsicMenu = new MainButton("\uC77C\uC2DD");
	public JButton btnYangsicMenu = new MainButton("\uC591\uC2DD");
	
	public JButton btnSearch = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/search.PNG")));
	public JPanel panMainButton = new JPanel();
	public JLabel labMenu = new JLabel(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/menu.PNG")));
	public JButton btnUserInfo = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/mypage.PNG")));
	public JLabel labName = new JLabel("\uAD8C\uC601\uCC2C\uB2D8");
	public JButton btnOrderList = new JButton(new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/basket.png")));
	public JLabel labBasket = new JLabel("\uC8FC\uBB38\uBAA9\uB85D");
	public JPanel panBarVerRight = new JPanel();
	public Cursor csorHandCursor = new Cursor(Cursor.HAND_CURSOR);
	boolean check = false;
	//장바구니, 결제부분 결합
	public User user;
	public BasketMain basketMain;
	
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
	public void test() {
		FoodDto food1 = new FoodDto("1", "된장찌개", 1, "한식", 5000, "/kitri/foodCourt/user/basket/image/제육1.jpg");
		FoodDto food2 = new FoodDto("2", "스테이크", 2, "양식", 8000, "/kitri/foodCourt/user/basket/image/제육1.jpg");
		FoodDto food3 = new FoodDto("3", "자장면", 3, "중식", 7000, "/kitri/foodCourt/user/basket/image/제육1.jpg");
		FoodDto food4 = new FoodDto("4", "나가사키짬뽕", 4, "일식", 6000, "/kitri/foodCourt/user/basket/image/제육1.jpg");
		FoodDto food5 = new FoodDto("5", "나가사키짬뽕", 4, "일식", 6000, "/kitri/foodCourt/user/basket/image/제육1.jpg");
		BasketDetail detail1 = new BasketDetail(food1, 1);
		BasketDetail detail2 = new BasketDetail(food2, 2);
		BasketDetail detail3 = new BasketDetail(food3, 3);
		BasketDetail detail4 = new BasketDetail(food4, 4);
		BasketDetail detail5 = new BasketDetail(food5, 5);
		
		user.getBasket().add(detail1);
		user.getBasket().add(detail2);
		user.getBasket().add(detail3);
		user.getBasket().add(detail4);
		user.getBasket().add(detail5);
		
	}
	
	public FoodMain() {
		//테스트용
		user = new User("calubang", "안병욱", 5000);
		test();
		basketMain = new BasketMain(this); //이시점에서 유저를 넣어준다
		
		btnHansicMenu.setName("1");
		btnJoongsicMenu.setName("2");
		btnIlsicMenu.setName("3");
		btnYangsicMenu.setName("4");
		
		labName.setHorizontalAlignment(SwingConstants.CENTER);
		labName.setVerticalTextPosition(0);
		btnHansicMenu.setToolTipText("\uD55C\uC2DD");
		btnHansicMenu.setName("1");
		btnJoongsicMenu.setToolTipText("\uC911\uC2DD");
		btnJoongsicMenu.setName("2");
		btnIlsicMenu.setToolTipText("\uC77C\uC2DD");
		btnIlsicMenu.setName("3");
		btnYangsicMenu.setToolTipText("\uC591\uC2DD");
		btnYangsicMenu.setName("4");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBorder(null);
		btnSearch.setToolTipText("\uAC80\uC0C9");
		// 커서 모양지정
		btnSearch.setCursor(csorHandCursor);
		btnMainMenu.setCursor(csorHandCursor);
		btnUserInfo.setToolTipText("\uD68C\uC6D0\uC815\uBCF4");
		btnUserInfo.setCursor(csorHandCursor);
		btnOrderList.setToolTipText("\uC8FC\uBB38\uBAA9\uB85D");
		btnOrderList.setCursor(csorHandCursor);
		labName.setCursor(csorHandCursor);
		labBasket.setCursor(csorHandCursor);
		
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
		btnMainMenu.setToolTipText("\uBA54\uC778");
		btnMainMenu.setBorder(null);
		btnMainMenu.setPreferredSize(new Dimension(107, 75));
		
		btnMainMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMainMenu.setBorderPainted(false);
		panel_2.add(btnMainMenu);
		btnMainMenu.setBackground(Color.WHITE);
		
		
		btnHansicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnJoongsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnIlsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnYangsicMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		panChangePanel.setBackground(Color.WHITE);
	
//		--------------------변하는 패널 부분 카드레이아웃 설정
		panChangePanel.setLayout(card);
		panChangePanel.add(UserMenuDetailView, "UserMenuDetailView");
		panChangePanel.add(userMenuView, "userMenuView");
		panChangePanel.add(foodMainView, "foodMainView");
		panChangePanel.add(noSearchMenuImg, "noSearchMenuImg");
		panChangePanel.add(basketMain, "basketMain");
		panChangePanel.setBounds(160, 118, 1012, 634);
		panel.add(panChangePanel);
		card.show(panChangePanel, "foodMainView");
		
		searchField = new JTextField();
		searchField.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		searchField.setBorder(new MatteBorder(2, 2, 4, 4, (Color) Color.LIGHT_GRAY));
		searchField.setBounds(240, 42, 553, 38);
		panel.add(searchField);
		searchField.setColumns(10);
		panel_6.setBackground(Color.DARK_GRAY);
		
		
		panel_6.setBounds(145, 118, 4, 633);
		panel.add(panel_6);
		btnHansicMenu.setBounds(22, 210, 103, 90);
		
		panel.add(btnHansicMenu);
		btnJoongsicMenu.setBounds(22, 321, 103, 90);
		
		panel.add(btnJoongsicMenu);
		btnIlsicMenu.setBounds(22, 432, 103, 90);
		
		panel.add(btnIlsicMenu);
		btnYangsicMenu.setBounds(22, 543, 103, 90);
		
		panel.add(btnYangsicMenu);
		btnSearch.setBorder(null);
		btnSearch.setBounds(826, 42, 40, 38);
		
		panel.add(btnSearch);
		panMainButton.setBounds(145, 26, 4, 66);
		panel.add(panMainButton);
		panMainButton.setBackground(Color.DARK_GRAY);
		labMenu.setToolTipText("\uBA54\uB274");
		labMenu.setOpaque(true);
		labMenu.setBackground(Color.WHITE);
		labMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labMenu.setBounds(12, 118, 123, 82);
		
		panel.add(labMenu);
		btnUserInfo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		btnUserInfo.setBounds(965, 26, 79, 54);
		
		panel.add(btnUserInfo);
		labName.setBounds(965, 77, 79, 22);
		
		panel.add(labName);
		btnOrderList.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnOrderList.setBounds(1074, 26, 79, 54);
		
		panel.add(btnOrderList);
		labBasket.setVerticalTextPosition(SwingConstants.CENTER);
		labBasket.setHorizontalAlignment(SwingConstants.CENTER);
		labBasket.setBounds(1074, 77, 79, 22);
		
		panel.add(labBasket);
		panBarVerRight.setBackground(Color.DARK_GRAY);
		panBarVerRight.setBounds(916, 26, 4, 66);
		
		panel.add(panBarVerRight);
				labSearch.setBounds(170, 26, 60, 66);
				panel.add(labSearch);
		//		---------------------
				labSearch.setFont(new Font("굴림", Font.PLAIN, 30));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
//		--------------------------이벤트 등록부
		FoodMainController foodMainController = new FoodMainController(this);
		btnMainMenu.addActionListener(foodMainController);
		btnSearch.addActionListener(foodMainController);
		btnHansicMenu.addActionListener(foodMainController);
		btnJoongsicMenu.addActionListener(foodMainController);
		btnIlsicMenu.addActionListener(foodMainController);
		btnYangsicMenu.addActionListener(foodMainController);
		btnUserInfo.addActionListener(foodMainController);
		btnOrderList.addActionListener(foodMainController);
		searchField.addActionListener(foodMainController);
		
		foodMainView.labHansic.addActionListener(foodMainController);
		foodMainView.labJoongsic.addActionListener(foodMainController);
		foodMainView.labIlsic.addActionListener(foodMainController);
		foodMainView.labYangsic.addActionListener(foodMainController);
		
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