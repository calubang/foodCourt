package kitri.foodCourt.user.basket;

import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.*;
import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.menu.UserMenuView;
import kitri.foodCourt.user.swing.*;
import oracle.net.aso.a;

import javax.swing.border.*;


public class BasketMain extends JPanel{

	private BasketController controller;
	
	public JPanel pBasketMain;
	public Payment payment;
	public JPanel pChangePanel;
	public JPanel pMiddle;
	public CardLayout card;
	public GridBagLayout gbl_pMiddle;
	public JScrollPane scrollPane;
	
	public FButton btnAllCancel;
	public FButton btnPayment;
	
	//라벨
	public FLabel lblTotalPrice;
	public FLabel lblTotalPoint;
	
	public FoodMain foodMain;
	
	//스크롤바위치
	int position;
	
	//테스트
	public User user ;

	public BasketMain(FoodMain foodMain) {
		//기본 UI 구성
		this.foodMain = foodMain;
		this.user = foodMain.user;
		payment = new Payment(this);
		controller = new BasketController(this);
		initView();
		
		//이벤트
		btnAllCancel.addActionListener(controller);
		btnPayment.addActionListener(controller);
		
	}
	
	public void initView() {
		//시작
		this.setLayout(new BorderLayout());
		this.setBounds(160, 118, 1012, 634);
		
		pChangePanel = new JPanel();
		pChangePanel.setBounds(163, 118, 1021, 643);
		add(pChangePanel, BorderLayout.CENTER);
		card = new CardLayout();
		pChangePanel.setLayout(card);
		
		pBasketMain = new JPanel();
		pBasketMain.setBackground(Color.WHITE);
		pBasketMain.setBounds(160, 118, 1012, 634);
		pBasketMain.setLayout(null);
		
		btnAllCancel = SwingFactory.getInstance().getButton("x");
		btnAllCancel.setToolTipText("\uC804\uCCB4\uC0AD\uC81C");
		btnAllCancel.setName("allCancel");
		btnAllCancel.setBounds(29, 2, 44, 44);
		
		JPanel pTop = new JPanel();
		pTop.setBackground(Color.WHITE);
		pTop.setBounds(0, 0, 1012, 141);
		pBasketMain.add(pTop);
		pTop.setLayout(null);
		
		JLabel lblBasketImage = new JLabel("");
		lblBasketImage.setBounds(0, 0, 120, 60);
		pTop.add(lblBasketImage);
		lblBasketImage.setIcon(new ImageIcon(this.getClass().getResource("/img/user/Basket1.png")));
		
		FLabel lblBasket = new FLabel(Font.BOLD, 40);
		lblBasket.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblBasket.setBounds(130, 0, 178, 60);
		pTop.add(lblBasket);
		lblBasket.setText("\uC7A5\uBC14\uAD6C\uB2C8");
		
		JPanel pSeparator = new JPanel();
		pSeparator.setBounds(0, 70, 1012, 6);
		pTop.add(pSeparator);
		pSeparator.setBackground(SystemColor.activeCaption);
		
		JPanel pBasketMenu = new JPanel();
		pBasketMenu.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pBasketMenu.setBounds(0, 85, 1012, 50);
		pTop.add(pBasketMenu);
		pBasketMenu.setBackground(SystemColor.inactiveCaptionBorder);
		pBasketMenu.setLayout(null);
		pBasketMenu.add(btnAllCancel);
		
		FLabel label_1 = new FLabel(Font.PLAIN, 20);
		label_1.setText("\uC0C1\uD488\uC815\uBCF4");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(160, 0, 134, 50);
		pBasketMenu.add(label_1);
		
		FLabel label_3 = new FLabel(Font.PLAIN, 20);
		label_3.setText("\uD3EC\uC778\uD2B8");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(420, 0, 100, 50);
		pBasketMenu.add(label_3);
		
		FLabel label_4 = new FLabel(Font.PLAIN, 20);
		label_4.setText("\uAC1C\uB2F9\uAC00\uACA9");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(720, 0, 100, 50);
		pBasketMenu.add(label_4);
		
		FLabel label_5 = new FLabel(Font.PLAIN, 20);
		label_5.setText("\uC218\uB7C9");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(560, 0, 100, 50);
		pBasketMenu.add(label_5);
		
		FLabel label = new FLabel(0, 20);
		label.setText("\uCD1D\uAC00\uACA9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(876, 0, 100, 50);
		pBasketMenu.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.inactiveCaptionBorder, 1, true));
		panel_1.setBounds(0, 143, 1012, 330);
		pBasketMain.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		pMiddle = new JPanel();
		pMiddle.setBackground(Color.WHITE);
		scrollPane.setViewportView(pMiddle);
		gbl_pMiddle = new GridBagLayout();
		gbl_pMiddle.columnWidths = new int[]{0};
		gbl_pMiddle.rowHeights = new int[]{0, 0, 0};
		gbl_pMiddle.columnWeights = new double[]{0.0};
		gbl_pMiddle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMiddle.setLayout(gbl_pMiddle);
		
		JPanel pBottom = new JPanel();
		pBottom.setBackground(Color.WHITE);
		pBottom.setBounds(0, 479, 1012, 155);
		pBasketMain.add(pBottom);
		pBottom.setLayout(null);
		
		//토탈부분
		JPanel pTotal = new JPanel();
		pTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pTotal.setBounds(0, 0, 1012, 85);
		pBottom.add(pTotal);
		pTotal.setBackground(SystemColor.inactiveCaptionBorder);
		pTotal.setLayout(null);
		
		FLabel lblPrice = new FLabel(Font.BOLD, 30);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setText("\uCD1D \uACB0\uC81C\uAE08\uC561");
		lblPrice.setBounds(578, 0, 179, 50);
		pTotal.add(lblPrice);
		
		lblTotalPrice = new FLabel(Font.BOLD, 30);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setBounds(765, 0, 196, 50);
		pTotal.add(lblTotalPrice);
		
		lblTotalPoint = new FLabel(Font.BOLD, 20);
		lblTotalPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTotalPoint.setBounds(837, 50, 124, 35);
		pTotal.add(lblTotalPoint);
		
		FLabel lblPoint = new FLabel(Font.BOLD, 20);
		lblPoint.setText("\uC801\uB9BD \uD3EC\uC778\uD2B8");
		lblPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoint.setBounds(710, 50, 115, 35);
		pTotal.add(lblPoint);
		
		btnPayment = SwingFactory.getButton("");
		btnPayment.setBackground(SystemColor.inactiveCaptionBorder);
		btnPayment.setToolTipText("\uACB0\uC81C");
		btnPayment.setName("payment");
		btnPayment.setBounds(831, 95, 169, 47);
		pBottom.add(btnPayment);
		btnPayment.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnPayment.setText("\uACB0\uC81C");
		
		//카드부분
		pChangePanel.add(pBasketMain, "basket");
		pChangePanel.add(payment, "payment");
		card.show(pChangePanel, "basket");
		
	}
	
	public void dataSetting() {
		//토탈가격
		lblTotalPrice.setText(String.valueOf(user.getBasket().getTotalPrice()));
		lblTotalPoint.setText(String.valueOf(user.getBasket().getSavePoint()));
		
		pMiddle.removeAll();
		
		scrollPane.setViewportView(pMiddle);
		gbl_pMiddle = new GridBagLayout();
		gbl_pMiddle.columnWidths = new int[]{0};
		gbl_pMiddle.rowHeights = new int[]{0, 0, 0};
		gbl_pMiddle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pMiddle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMiddle.setLayout(gbl_pMiddle);
		
		//바스켓에 있는 음식정보 뿌리기
		int size = user.getBasket().getDetailList().size();
		for(int i = 0; i<size ; i++) {
			JPanel temp = addFood(i);
			GridBagConstraints gbcFood = new GridBagConstraints();
			gbcFood.insets = new Insets(0, 0, 0, 0);
			gbcFood.fill = GridBagConstraints.HORIZONTAL;
			gbcFood.gridx = 0;
			gbcFood.gridy = i;
			
			pMiddle.add(temp, gbcFood);
		}
		
	}
	
	public JPanel addFood(int index) {
		BasketDetail detail = user.getBasket().getDetailList().get(index);
		int count = detail.getCount();
		JPanel pFood = new JPanel();
		pFood.setLayout(null);
		pFood.setMaximumSize(new Dimension(1010, 110));
		pFood.setPreferredSize(new Dimension(1010, 110));
		pFood.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pFood.setBackground(SystemColor.inactiveCaptionBorder);
		//x버튼
		FButton btnX = SwingFactory.getInstance().getButton("x");
		btnX.setName(index+"cancel");
		btnX.setBounds(26, 33, 44, 44);
		pFood.add(btnX);
		btnX.setName("x"+index);
		btnX.setToolTipText("삭제");
		
		//음식설명용 패널 - 차후 클릭하면 효과있음
		FPanel pFoodInfo = SwingFactory.getInstance().getPanel("basketFood");
		pFoodInfo.setBounds(93, 0, 350, 109);
		pFoodInfo.setName(detail.getFood().getFoodId());
		pFoodInfo.setBackground(SystemColor.inactiveCaptionBorder);
		pFood.add(pFoodInfo);
		
		//음식사진
		FButton btnFoodImage = SwingFactory.getInstance().getButton("image");
		URL url = BasketMain.class.getResource(detail.getFood().getImageAddress());
		btnFoodImage.setBounds(12, 15, 120, 80);
		if(url != null) {			
			try {
				BufferedImage bImage = ImageIO.read(url);
				ImageIcon icon = new ImageIcon(bImage.getScaledInstance(btnFoodImage.getWidth(), btnFoodImage.getHeight(), Image.SCALE_FAST));
				btnFoodImage.setIcon(icon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		btnFoodImage.setName(detail.getFood().getFoodId());
		pFoodInfo.add(btnFoodImage);
		
		//음식이름
		FLabel lFoodName = SwingFactory.getInstance().getLabel("basketFood");
		lFoodName.setText(detail.getFood().getFoodName());
		lFoodName.setHorizontalAlignment(SwingConstants.LEFT);
		lFoodName.setBounds(144, 20, 190, 70);
		lFoodName.setName(detail.getFood().getFoodId());
		pFoodInfo.add(lFoodName);
		
		//포인트
		FLabel lPoint = SwingFactory.getInstance().getLabel("basketFood");
		lPoint.setText(String.valueOf(detail.getFood().getPoint()));
		lPoint.setBounds(420, 33, 100, 44);
		pFood.add(lPoint);
		
		//수량
		FLabel lCount = SwingFactory.getInstance().getLabel("basketFood");
		lCount.setText(String.valueOf(detail.getCount()));
		lCount.setBounds(560, 33, 100, 45);
		pFood.add(lCount);
		
		//개당가격
		FLabel lPrice = SwingFactory.getInstance().getLabel("basketFood");
		lPrice.setText(String.valueOf(detail.getFood().getPrice()));
		lPrice.setBounds(720, 33, 100, 45);
		pFood.add(lPrice);
		
		//총가격
		FLabel lPriceSum = SwingFactory.getInstance().getLabel("basketFood");
		lPriceSum.setText(String.valueOf(detail.getFood().getPrice()*count));
		lPriceSum.setBounds(870, 33, 100, 45);
		pFood.add(lPriceSum);
		
		//이벤트
		btnX.addActionListener(controller);
		pFoodInfo.setController(controller);
		btnFoodImage.addMouseListener(controller);
		lFoodName.addMouseListener(controller);
		
		return pFood;
	}
}
