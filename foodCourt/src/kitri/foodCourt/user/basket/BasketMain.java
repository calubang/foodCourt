package kitri.foodCourt.user.basket;

import java.awt.event.*;
import java.net.URL;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.*;
import kitri.foodCourt.user.menu.MenuButton;
import kitri.foodCourt.user.swing.*;
import javax.swing.border.*;


public class BasketMain extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private BasketController controller;
	public static User user = new User("calubang", "안병욱", 5000);
	public JPanel pBasketMain;
	
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
		BasketDetail detail5 = new BasketDetail(food4, 5);
		
		user.getBasket().add(detail1);
		user.getBasket().add(detail2);
		user.getBasket().add(detail3);
		user.getBasket().add(detail4);
		user.getBasket().add(detail5);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasketMain frame = new BasketMain();
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
	public BasketMain() {
		test();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setToolTipText("\uC804\uCCB4\uC120\uD0DD");
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 10, 1172, 6);
		panel.add(panel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 102, 1172, 6);
		panel.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 10, 133, 101);
		panel.add(panel_2);
		panel_2.setLayout(null);
		JButton btnNewButton = new JButton("메인메뉴", new ImageIcon("C:\\Users\\Administrator\\Desktop\\home.png"));
		btnNewButton.setBounds(12, 10, 120, 59);
		btnNewButton.setBorderPainted(false);
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778\uBA54\uB274");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 71, 120, 20);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(160, 26, 69, 66);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		textField.setBounds(241, 47, 667, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(145, 137, 6, 457);
		panel.add(panel_6);
		
		pBasketMain = new JPanel();
		pBasketMain.setBounds(160, 118, 1012, 634);
		panel.add(pBasketMain);
		pBasketMain.setLayout(null);
		
		FButton btnAllCancel = SwingFactory.getInstance().getButton("x");
		btnAllCancel.setName("allCancel");
		//64/2 32 44 22
		btnAllCancel.setBounds(29, 2, 44, 44);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 1000, 155);
		pBasketMain.add(pTop);
		pTop.setLayout(null);
		
		JLabel lblBasketImage = new JLabel("");
		lblBasketImage.setBounds(12, 10, 120, 70);
		pTop.add(lblBasketImage);
		//lblNewLabel_2.setIcon(new ImageIcon(main.class.getResource("/kitri/foodCourt/user/basket/image/Basket1.png")));
		lblBasketImage.setIcon(new ImageIcon(this.getClass().getResource("/kitri/foodCourt/user/basket/image/Basket1.png")));
		
		FLabel lblBasket = new FLabel();
		lblBasket.setBounds(144, 10, 178, 70);
		pTop.add(lblBasket);
		lblBasket.setFont(new Font("휴먼모음T", Font.BOLD, 40));
		lblBasket.setText("\uC7A5\uBC14\uAD6C\uB2C8");
		
		JPanel pSeparator = new JPanel();
		pSeparator.setBounds(12, 90, 988, 6);
		pTop.add(pSeparator);
		pSeparator.setBackground(SystemColor.activeCaption);
		
		JPanel pBasketMenu = new JPanel();
		pBasketMenu.setBounds(12, 106, 988, 50);
		pTop.add(pBasketMenu);
		pBasketMenu.setBackground(SystemColor.inactiveCaptionBorder);
		pBasketMenu.setLayout(null);
		pBasketMenu.add(btnAllCancel);
		
		FLabel label_1 = new FLabel();
		label_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		label_1.setText("\uC0C1\uD488\uC815\uBCF4");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(210, 0, 134, 50);
		pBasketMenu.add(label_1);
		
		FLabel label_3 = new FLabel();
		label_3.setText("\uD3EC\uC778\uD2B8");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		label_3.setBounds(520, 0, 100, 50);
		pBasketMenu.add(label_3);
		
		FLabel label_4 = new FLabel();
		label_4.setText("\uAC00\uACA9");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		label_4.setBounds(850, 0, 100, 50);
		pBasketMenu.add(label_4);
		
		FLabel label_5 = new FLabel();
		label_5.setText("\uC218\uB7C9");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		label_5.setBounds(695, 0, 100, 50);
		pBasketMenu.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 165, 988, 304);
		pBasketMain.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		JPanel pMiddle = new JPanel();
		scrollPane.setViewportView(pMiddle);
		GridBagLayout gbl_pMiddle = new GridBagLayout();
		gbl_pMiddle.rowHeights = new int[] {110};
		gbl_pMiddle.columnWidths = new int[] {988};
		gbl_pMiddle.columnWeights = new double[]{};
		gbl_pMiddle.rowWeights = new double[]{};
		pMiddle.setLayout(gbl_pMiddle);
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(0, 479, 1010, 155);
		pBasketMain.add(pBottom);
		pBottom.setLayout(null);
		
		JPanel pTotal = new JPanel();
		pTotal.setBounds(12, 0, 988, 85);
		pBottom.add(pTotal);
		pTotal.setBackground(SystemColor.inactiveCaptionBorder);
		pTotal.setLayout(null);
		
		FLabel lblPrice = new FLabel();
		lblPrice.setFont(new Font("휴먼모음T", Font.BOLD, 30));
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setText("\uCD1D \uACB0\uC81C\uAE08\uC561");
		lblPrice.setBounds(578, 0, 179, 50);
		pTotal.add(lblPrice);
		
		FLabel lblTotalPrice = new FLabel();
		lblTotalPrice.setText("20000\uC6D0");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("휴먼모음T", Font.BOLD, 30));
		lblTotalPrice.setBounds(765, 0, 196, 50);
		pTotal.add(lblTotalPrice);
		
		FLabel lblTotalPoint = new FLabel();
		lblTotalPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPoint.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		lblTotalPoint.setText("2000P");
		lblTotalPoint.setBounds(837, 50, 124, 35);
		pTotal.add(lblTotalPoint);
		
		FLabel lblPoint = new FLabel();
		lblPoint.setText("\uC801\uB9BD \uD3EC\uC778\uD2B8");
		lblPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoint.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		lblPoint.setBounds(710, 50, 115, 35);
		pTotal.add(lblPoint);
		
		FButton button = SwingFactory.getButton("");
		button.setBounds(831, 95, 169, 47);
		pBottom.add(button);
		button.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		button.setText("\uACB0\uC81C");
		
		//System.out.println(user);
		//pBasketMain.add(addFood(0));
		Basket basket = user.getBasket();
		
		int size = basket.getDetailList().size();
		if(size > 3) {
			pMiddle.setLayout(new GridLayout(size, 1, 0, 0));
		}
		
		
		for(int i = 0; i<size ; i++) {
			JPanel temp = addFood(i);
			GridBagConstraints gbcFood = new GridBagConstraints();
			gbcFood.insets = new Insets(10, 10, 10, 10);
			gbcFood.fill = GridBagConstraints.CENTER;
			gbcFood.gridx = 0;
			gbcFood.gridy = i;
			
			pMiddle.add(temp, gbcFood);
		}
		
		//이벤트
		controller = new BasketController(this);
		btnAllCancel.addActionListener(controller);
		
	}
	/*
	public void setMenu(int count, List<FoodDto> foodList) { // 임시 테스트용 count
		int gridx = 0;
		int gridy = 0;
		for(int i = 0; i < count; i++) {
			JButton menuButton = new MenuButton("한식" + (i+1)); // 이 텍스트에는 list.getIndex(i).getFoodName(); 이 올것이다
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 9, 9);
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.gridx = gridx;
			gbc_btnNewButton.gridy = gridy;
			panel.add(menuButton, gbc_btnNewButton);
			gridx++;
			if(gridx > 4) {
				gridx = 0;
				gridy++;
			}
			
		}
		
		setLayout(null);
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setBorder(null);
		panel.setLayout(gbl_panel);
		scrollPane.setBorder(null);
	}
	*/
	
	
	
	public JPanel addFood(int index) {
		//panel_8.setBounds(12, 206, 988, 130);
		int height = 110;
		BasketDetail detail = user.getBasket().getDetailList().get(index);
		JPanel pFood = new JPanel();
		pFood.setLayout(null);
		pFood.setMaximumSize(new Dimension(988, 100));
		pFood.setPreferredSize(new Dimension(988, 100));
		//pFood.setBounds(0, 0, 988, 100);
		//pFood.setBackground(SystemColor.inactiveCaptionBorder);
		//x버튼
		FButton btnX = SwingFactory.getInstance().getButton("x");
		btnX.setName(index+"cancel");
		btnX.setBounds(29, 28, 44, 44);
		pFood.add(btnX);
		
		//음식설명용 패널 - 차후 클릭하면 효과있음
		JPanel pFoodInfo = SwingFactory.getInstance().getPanel("basketFood");
		pFoodInfo.setBounds(93, 0, 350, 100);
		pFood.add(pFoodInfo);
		
		//음식사진
		FButton btnFoodImage = SwingFactory.getInstance().getButton("image");
		URL url = BasketMain.class.getResource(detail.getFood().getImageAddress());
		if(url != null) {
			btnFoodImage.setIcon(new ImageIcon(url));
		}
		btnFoodImage.setBounds(12, 15, 120, 70);
		pFoodInfo.add(btnFoodImage);
		
		//음식이름
		FLabel lFoodName = SwingFactory.getInstance().getLabel("basketFood");
		lFoodName.setText(detail.getFood().getFoodName());
		lFoodName.setHorizontalAlignment(SwingConstants.LEFT);
		lFoodName.setBounds(144, 15, 190, 70);
		pFoodInfo.add(lFoodName);
		
		//포인트
		FLabel lPoint = SwingFactory.getInstance().getLabel("basketFood");
		lPoint.setText(String.valueOf(detail.getFood().getPoint()));
		lPoint.setBounds(520, 28, 100, 44);
		pFood.add(lPoint);
		
		//수량
		FLabel lCount = SwingFactory.getInstance().getLabel("basketFood");
		lCount.setText(String.valueOf(detail.getCount()));
		lCount.setBounds(695, 28, 100, 45);
		pFood.add(lCount);
		
		//가격
		FLabel lPrice = SwingFactory.getInstance().getLabel("basketFood");
		lPrice.setText(String.valueOf(detail.getFood().getPrice()));
		lPrice.setBounds(850, 28, 100, 45);
		pFood.add(lPrice);
		
		//btn
		btnX.addActionListener(controller);
		pFoodInfo.addMouseListener(controller);
		
		return pFood;
	}
}
