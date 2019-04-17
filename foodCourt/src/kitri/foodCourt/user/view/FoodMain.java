package kitri.foodCourt.user.view;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import javax.swing.*;
import javax.swing.border.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.BasketDetail;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.controller.FoodMainController;
import kitri.foodCourt.user.login.LoginMain;
import kitri.foodCourt.user.swing.*;
import kitri.foodCourt.util.Constance;

public class FoodMain extends JFrame {
	public String currentPanelName;
	public JPanel contentPane;
	public JTextField searchField;
	public JPanel panel = new JPanel();
	
	//구분자 패널
	public JPanel pSeparator1 = SwingFactory.getJPanel("separator");
	public JPanel pSeparator2 = SwingFactory.getJPanel("separator");
	public JPanel pSeparator3 = SwingFactory.getJPanel("separator");
	public JPanel pSeparator4 = SwingFactory.getJPanel("separator");
	public JPanel pSeparator5 =SwingFactory.getJPanel("separator");
	
	public JPanel pHomeButton = new JPanel();
	
	public UserMenuView userMenuView = new UserMenuView();
	public UserMenuDetailView UserMenuDetailView = new UserMenuDetailView();
	public FoodMainView foodMainView = new FoodMainView();
	public NoSearchMenuImg noSearchMenuImg = new NoSearchMenuImg();

	public FLabel labSearch = new FLabel("\uAC80\uC0C9");
	
	public JPanel panChangePanel = new JPanel();
	public CardLayout card = new CardLayout();
	public JButton btnMainMenu = new JButton();
	public JButton btnSearch = new JButton(new ImageIcon(FoodMain.class.getResource("/img/user/search.PNG")));
	public JButton btnUserInfo = new JButton();
	public JLabel labName = new JLabel();
	public JButton btnOrderList = new JButton(new ImageIcon(FoodMain.class.getResource("/img/user/basket.png")));
	public JLabel labBasket = new JLabel("\uC8FC\uBB38\uBAA9\uB85D");
	public Cursor csorHandCursor = new Cursor(Cursor.HAND_CURSOR);
	boolean check = false;
	public MainButton btnLogout;
	public RoundPanel pLogout;
	
	// 장바구니, 결제부분 결합
	public User user;
	public BasketMain basketMain;
	public FLabel lbOrderCircle = new FLabel();
	public FLabel lbOrderCount = new FLabel(Font.BOLD, 20);
	public FoodMainController foodMainController;
	
	//유저정보 결합
	public UserInfo userInfo;
	public JPasswordField pfPassword;
	public JPanel pPassword;
	public FOptionPane fOptionPane;
	public JDialog dgPassword;

	public JLabel labHansic = new JLabel("\uD55C  \uC2DD");
	public JLabel labJoongsic = new JLabel("\uC911  \uC2DD");
	public JLabel labIlsic = new JLabel("\uC77C  \uC2DD");
	public JLabel labYangsic = new JLabel("\uC591  \uC2DD");
	public MainButton btnHansic = new MainButton(new ImageIcon(FoodMain.class.getResource("/img/user/koreanFoodImageSmall.png")));
	public JButton btnJoongsic = new MainButton(new ImageIcon(FoodMain.class.getResource("/img/user/chineseFoodImageSmall.png")));
	public JButton btnIlsic = new MainButton(new ImageIcon(FoodMain.class.getResource("/img/user/JapaneseFoodImageSmall.png")));
	public JButton btnYangsic = new MainButton(new ImageIcon(FoodMain.class.getResource("/img/user/americanFoodImageSmall.png")));
	
	//로그인 부분 결합
	public LoginMain loginMain;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMain frame = new FoodMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setPanelName(String panelName) {
		this.currentPanelName = panelName;
	}
	public String getPanelName() {
		return this.currentPanelName;
	}

	public FoodMain() {
		this.user = User.getInstance();

		loginMain = new LoginMain(this);
		loginMain.setVisible(true);
		basketMain = new BasketMain(this);
		userInfo = new UserInfo(this);
		this.setVisible(false);
		initView();
		
	}
	
	public void initView() {
		//본코드
		setTitle("풉키에 오신 것을 환영합니다.");
		
		this.setVisible(false);
		
		
		labName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labName.setHorizontalAlignment(SwingConstants.CENTER);
		labName.setVerticalTextPosition(0);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBorder(null);
		btnSearch.setBackground(new Color(255, 240, 245));
		btnSearch.setToolTipText("\uAC80\uC0C9");
		
		//패스워드 확인용 패널
		fOptionPane = new FOptionPane();
		dgPassword = fOptionPane.createDialog(this, "비민번호 확인");
		dgPassword.setBounds(600, 400, dgPassword.getWidth(), dgPassword.getHeight());
		pPassword = new JPanel();
		pPassword.setLayout(new BorderLayout());
		FLabel label = new FLabel(Font.PLAIN, 15);
		pfPassword = new JPasswordField();
		label.setText("비밀번호를 입력하세요.");
		pPassword.add(label, BorderLayout.NORTH);
		pPassword.add(pfPassword, BorderLayout.CENTER);
		
		// 커서 모양지정
		btnSearch.setCursor(csorHandCursor);
		btnMainMenu.setIcon(null);
		btnMainMenu.setBounds(0, 0, 120, 75);
		btnMainMenu.setCursor(csorHandCursor);
		btnUserInfo.setIcon(new ImageIcon(FoodMain.class.getResource("/img/user/myInfo.png")));
		btnUserInfo.setBackground(Color.WHITE);
		btnUserInfo.setToolTipText("\uD68C\uC6D0\uC815\uBCF4");
		btnUserInfo.setCursor(csorHandCursor);
		//btnUserInfo
		lbOrderCount.setHorizontalAlignment(SwingConstants.CENTER);
		lbOrderCount.setBackground(Color.WHITE);
		lbOrderCount.setCursor(csorHandCursor);
		
		btnOrderList.setFocusPainted(false);
		btnOrderList.setContentAreaFilled(false);
		btnOrderList.setToolTipText("\uC8FC\uBB38\uBAA9\uB85D");
		btnOrderList.setCursor(csorHandCursor);
		labName.setCursor(csorHandCursor);
		labBasket.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labBasket.setCursor(csorHandCursor);

		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		pSeparator1.setBounds(12, 10, 1160, 6);
		panel.add(pSeparator1);

		pSeparator2.setBounds(12, 102, 1160, 6);
		panel.add(pSeparator2);
		pSeparator3.setBounds(145, 26, 4, 66);
		panel.add(pSeparator3);

		pSeparator4.setBounds(916, 26, 4, 66);
		
		panel.add(pSeparator4);
		pSeparator5.setBounds(145, 118, 4, 633);
		panel.add(pSeparator5);
		pHomeButton.setBackground(Color.WHITE);
		pHomeButton.setBounds(16, 21, 120, 75);
		panel.add(pHomeButton);
		pHomeButton.setLayout(null);
		btnMainMenu.setToolTipText("\uBA54\uC778");
		btnMainMenu.setPreferredSize(new Dimension(115, 75));
		btnMainMenu.setIcon(new ImageIcon(FoodMain.class.getResource("/img/user/home2.png")));
		btnMainMenu.setBorderPainted(false);
		pHomeButton.add(btnMainMenu);
		btnMainMenu.setBackground(Color.WHITE);
		panChangePanel.setBackground(Color.WHITE);
		
		//koreanFood
		RoundPanel pKoreanMenu = new RoundPanel(2, 40);
		pKoreanMenu.setName("1");
		pKoreanMenu.setBackground(Color.WHITE);
		pKoreanMenu.setBounds(16, 120, 115, 100);
		panel.add(pKoreanMenu);
		pKoreanMenu.setLayout(null);
		
		labHansic.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labHansic.setBounds(10, 70, 95, 20);
		labHansic.setOpaque(true);
		labHansic.setBackground(Color.WHITE);
		labHansic.setHorizontalAlignment(SwingConstants.CENTER);
		pKoreanMenu.add(labHansic);		
		btnHansic.setBounds(10, 10, 95, 70);
		btnHansic.setCursor(csorHandCursor);
		pKoreanMenu.add(btnHansic);
		btnHansic.setName("1");
		btnHansic.setFocusable(false);
		btnHansic.setContentAreaFilled(false);
		btnHansic.setBorderPainted(false);
	
		//chineseMenu
		RoundPanel pChineseMenu = new RoundPanel(2, 40);
		pChineseMenu.setName("2");
		pChineseMenu.setBackground(Color.WHITE);
		pChineseMenu.setBounds(16, 230, 115, 100);
		panel.add(pChineseMenu);
		pChineseMenu.setLayout(null);
		
		labJoongsic.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labJoongsic.setSize(95, 20);
		labJoongsic.setLocation(10, 70);
		labJoongsic.setBackground(Color.WHITE);
		labJoongsic.setOpaque(true);
		labJoongsic.setHorizontalAlignment(SwingConstants.CENTER);
		pChineseMenu.add(labJoongsic, BorderLayout.SOUTH);
		btnJoongsic.setSize(95, 60);
		btnJoongsic.setLocation(10, 10);
		btnJoongsic.setCursor(csorHandCursor);
		pChineseMenu.add(btnJoongsic);
		btnJoongsic.setName("2");
		btnJoongsic.setFocusable(false);
		btnJoongsic.setContentAreaFilled(false);
		btnJoongsic.setBorderPainted(false);
		
		//japaneseFood
		RoundPanel pJapaneseMenu = new RoundPanel(2, 40);
		pJapaneseMenu.setName("3");
		pJapaneseMenu.setBackground(Color.WHITE);
		pJapaneseMenu.setBounds(16, 340, 115, 100);
		panel.add(pJapaneseMenu);
		pJapaneseMenu.setLayout(null);
		
		labIlsic.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labIlsic.setBounds(10, 70, 95, 20);
		
		labIlsic.setBackground(Color.WHITE);
		labIlsic.setOpaque(true);
		labIlsic.setHorizontalAlignment(SwingConstants.CENTER);
		pJapaneseMenu.add(labIlsic);
		btnIlsic.setBounds(10, 10, 95, 60);
		btnIlsic.setCursor(csorHandCursor);
		pJapaneseMenu.add(btnIlsic);
		btnIlsic.setName("3");
		btnIlsic.setFocusable(false);
		btnIlsic.setContentAreaFilled(false);
		btnIlsic.setBorderPainted(false);
		
		//americanFood
		RoundPanel pAmericanMenu = new RoundPanel(2, 40);
		pAmericanMenu.setName("4");
		pAmericanMenu.setBackground(Color.WHITE);
		pAmericanMenu.setBounds(16, 450, 115, 100);
		panel.add(pAmericanMenu);
		pAmericanMenu.setLayout(null);
		labYangsic.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labYangsic.setBounds(10, 70, 95, 20);
		labYangsic.setBackground(Color.WHITE);
		labYangsic.setOpaque(true);
		labYangsic.setHorizontalAlignment(SwingConstants.CENTER);
		pAmericanMenu.add(labYangsic);
		btnYangsic.setBounds(10, 10, 95, 60);
		btnYangsic.setCursor(csorHandCursor);
		pAmericanMenu.add(btnYangsic);
		btnYangsic.setName("4");
		
		btnYangsic.setFocusable(false);
		btnYangsic.setContentAreaFilled(false);
		btnYangsic.setBorderPainted(false);
		
		pLogout = new RoundPanel(2, 40);
		pLogout.setLayout(null);
		pLogout.setName("0");
		pLogout.setBackground(Color.WHITE);
		pLogout.setBounds(16, 651, 115, 100);
		panel.add(pLogout);
		
		JLabel label_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(10, 70, 95, 20);
		pLogout.add(label_1);
		
		btnLogout = new MainButton((Icon) null);
		btnLogout.setIcon(new ImageIcon(FoodMain.class.getResource("/img/user/logout.png")));
		btnLogout.setName("4");
		btnLogout.setFocusable(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(10, 10, 95, 60);
		pLogout.add(btnLogout);
		

//				--------------------변하는 패널 부분 카드레이아웃 설정
		panChangePanel.setLayout(card);
		UserMenuDetailView.setBackground(Color.WHITE);
		panChangePanel.add(UserMenuDetailView, "UserMenuDetailView");
		panChangePanel.add(userMenuView, "userMenuView");
		panChangePanel.add(foodMainView, "foodMainView");
		panChangePanel.add(noSearchMenuImg, "noSearchMenuImg");
		panChangePanel.add(basketMain, "basketMain");
		panChangePanel.add(userInfo, "userInfo");
		panChangePanel.setBounds(160, 118, 1012, 634);
		panel.add(panChangePanel);
		currentPanelName = "foodMainView";
		card.show(panChangePanel, currentPanelName);

		searchField = new JTextField();
		searchField.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		searchField.setBorder(new MatteBorder(2, 2, 4, 4, (Color) SystemColor.activeCaption));
		searchField.setBounds(240, 42, 553, 38);
		panel.add(searchField);
		searchField.setColumns(10);
		btnSearch.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		btnSearch.setBounds(826, 42, 40, 38);

		panel.add(btnSearch);
		btnUserInfo.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		btnUserInfo.setBounds(965, 26, 79, 54);

		panel.add(btnUserInfo);
		labName.setBounds(965, 77, 79, 22);

		panel.add(labName);

		// 주문 개수 표시
		lbOrderCount.setBounds(1129, 15, 35, 35);
		panel.add(lbOrderCount);
		user.getBasket().setOrderCount(lbOrderCount);

		lbOrderCircle.setBounds(1129, 15, 35, 35);
		lbOrderCircle.setIcon(new ImageIcon(FoodMain.class.getResource("/img/user/red_circle.png")));
		panel.add(lbOrderCircle);

		btnOrderList.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		btnOrderList.setBounds(1074, 26, 79, 54);

		panel.add(btnOrderList);
		labBasket.setVerticalTextPosition(SwingConstants.CENTER);
		labBasket.setHorizontalAlignment(SwingConstants.CENTER);
		labBasket.setBounds(1074, 77, 79, 22);

		panel.add(labBasket);
		labSearch.setBounds(170, 26, 60, 66);
		panel.add(labSearch);
		// ---------------------
		labSearch.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
//		--------------------------이벤트 등록부
		foodMainController = new FoodMainController(this);
		btnMainMenu.addActionListener(foodMainController);
		btnSearch.addActionListener(foodMainController);
		btnUserInfo.addActionListener(foodMainController);
		btnOrderList.addActionListener(foodMainController);
		searchField.addActionListener(foodMainController);
		
		//패스워드 확인용 텍스트필드
		pfPassword.addActionListener(foodMainController);
		
		//좌측 이벤트
		btnHansic.addActionListener(foodMainController);
		pKoreanMenu.addMouseListener(foodMainController);
		btnJoongsic.addActionListener(foodMainController);
		pChineseMenu.addMouseListener(foodMainController);
		btnYangsic.addActionListener(foodMainController);
		pAmericanMenu.addMouseListener(foodMainController);
		btnIlsic.addActionListener(foodMainController);
		pJapaneseMenu.addMouseListener(foodMainController);
		btnLogout.addActionListener(foodMainController);
		pLogout.addMouseListener(foodMainController);
		
		foodMainView.labHansic.addActionListener(foodMainController);
		foodMainView.labJoongsic.addActionListener(foodMainController);
		foodMainView.labIlsic.addActionListener(foodMainController);
		foodMainView.labYangsic.addActionListener(foodMainController);
		
		
		
	}
	
	public void dataSetting() {
		labName.setText(user.getName() + "님");
	}
}