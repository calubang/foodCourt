package kitri.foodCourt.user.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import kitri.foodCourt.user.Basket;
import kitri.foodCourt.user.controller.PaymentController;
import kitri.foodCourt.user.swing.*;
import kitri.foodCourt.util.Constance;

public class Payment extends JPanel {

	public static int requestNumber = Constance.REQUEST_NUMBER_START;
	private PaymentController controller;
	public Receipt receipt;
	public BasketMain basketMain;
	//ÇÏ´Ü ¹öÆ°3°³
	public FButton btnReceiptConfirm;
	public FButton btnPayment;
	public FButton btnCancel;
	
	//ÅØ½ºÆ®ÇÊµå
	public JTextField tfCard;
	public JTextField tfCash;
	public JTextField tfPoint;
	
	//»ó´Ü ÃÑ°¡°Ý 
	public FLabel lbTotalPrice;
	public FLabel lbTotalPoint;
	//À¯ÀúÀÇ °¡¿ëÆ÷ÀÎÆ®
	public FLabel lbUserPoint;
	
	public Payment(BasketMain basketMain) {
		setBackground(Color.WHITE);
		this.basketMain = basketMain;
	
		//±âº»UI
		initView();
		receipt = new Receipt(this);
		receipt.user = basketMain.user;
		
		//ÀÌº¥Æ®
		controller = new PaymentController(this);
		btnReceiptConfirm.addActionListener(controller);
		receipt.btnOK.addActionListener(controller);
		btnPayment.addActionListener(controller);
		btnCancel.addActionListener(controller);
		tfCard.addKeyListener(controller);
		tfCash.addKeyListener(controller);
		tfPoint.addKeyListener(controller);
	}
	
	public void dataSetting() {
		Basket basket = basketMain.user.getBasket();
		
		lbTotalPrice.setText(String.valueOf(basket.getTotalPrice()));
		lbTotalPoint.setText(String.valueOf(basket.getSavePoint()) + "P");
		lbUserPoint.setText(String.valueOf(basketMain.user.getUserPoint()) + "P");
		
		//tf ¸®¼Â
		tfCard.setText("");
		tfCash.setText("");
		tfPoint.setText("");
		
		//¿µ¼öÁõµµ °°ÀÌ dataSetting
		receipt.dataSetting();
	}
	
	public void initView(){
		this.setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		JPanel pSeperator = new JPanel();
		pSeperator.setBackground(SystemColor.activeCaption);
		pSeperator.setBounds(0, 60, 1012, 6);
		add(pSeperator);
		
		JLabel lbPageImage = new JLabel("");
		lbPageImage.setIcon(new ImageIcon(Payment.class.getResource("/img/user/payment.png")));
		lbPageImage.setBounds(0, 0, 120, 50);
		add(lbPageImage);
		
		FLabel lbPageName = new FLabel(Font.BOLD, 40);
		lbPageName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lbPageName.setText("\uACB0\uC81C");
		lbPageName.setBounds(130, 0, 178, 50);
		add(lbPageName);
		
		JPanel pTotalPrice = new JPanel();
		pTotalPrice.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pTotalPrice.setLayout(null);
		pTotalPrice.setBackground(SystemColor.inactiveCaptionBorder);
		pTotalPrice.setBounds(0, 75, 1012, 85);
		add(pTotalPrice);
		
		FLabel label_1 = new FLabel();
		label_1.setText("\uCD1D \uACB0\uC81C\uAE08\uC561");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 30));
		label_1.setBounds(578, 0, 179, 50);
		pTotalPrice.add(label_1);
		
		FLabel label_4 = new FLabel(Font.BOLD, 20);
		label_4.setText("\uC801\uB9BD \uD3EC\uC778\uD2B8");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(710, 50, 115, 35);
		pTotalPrice.add(label_4);
		
		lbTotalPrice = new FLabel(Font.BOLD, 30);
		lbTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTotalPrice.setBounds(765, 0, 196, 50);
		pTotalPrice.add(lbTotalPrice);
		
		lbTotalPoint = new FLabel(Font.BOLD, 20);
		lbTotalPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTotalPoint.setBounds(837, 50, 124, 35);
		pTotalPrice.add(lbTotalPoint);
		
		RoundPanel pCash = new RoundPanel();
		pCash.setBackground(new Color(255, 255, 240));
		//pCash.addMouseListener(pCash);
		//pCash.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pCash.setBounds(100, 210, 200, 180);
		add(pCash);
		pCash.setLayout(null);
		
		FLabel lbCash = new FLabel(Font.BOLD, 20);
		lbCash.setHorizontalAlignment(SwingConstants.CENTER);
		lbCash.setText("\uD604  \uAE08");
		lbCash.setBounds(12, 20, 176, 50);
		pCash.add(lbCash);
				
		tfCash = new JTextField();
		tfCash.setHorizontalAlignment(JTextField.CENTER);
		tfCash.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tfCash.setBounds(12, 120, 176, 35);
		tfCash.setName("cash");
		tfCash.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		pCash.add(tfCash);
	
		RoundPanel pCard = new RoundPanel();
		pCard.setBackground(new Color(255, 255, 240));
		pCard.setLayout(null);
		pCard.setBounds(400, 210, 200, 180);
		add(pCard);
		
		tfCard = new JTextField();
		tfCard.setHorizontalAlignment(JTextField.CENTER);
		tfCard.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tfCard.setName("card");
		tfCard.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tfCard.setBounds(12, 120, 176, 35);
		pCard.add(tfCard);
		
		FLabel lbCard = new FLabel(Font.BOLD, 20);
		lbCard.setText("\uCE74  \uB4DC");
		lbCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbCard.setBounds(12, 20, 176, 50);
		pCard.add(lbCard);
		
		RoundPanel pPoint = new RoundPanel();
		pPoint.setBackground(new Color(255, 255, 240));
		pPoint.setLayout(null);
		pPoint.setBounds(700, 210, 200, 180);
		add(pPoint);
		
		FLabel lbPointText = new FLabel(Font.BOLD, 20);
		lbPointText.setText("\uAC00\uC6A9\uD3EC\uC778\uD2B8");
		lbPointText.setHorizontalAlignment(SwingConstants.CENTER);
		lbPointText.setBounds(12, 10, 176, 35);
		pPoint.add(lbPointText);
		
		lbUserPoint = new FLabel(Font.BOLD, 20);
		lbUserPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserPoint.setBounds(12, 45, 176, 35);
		pPoint.add(lbUserPoint);
		
		tfPoint = new JTextField();
		tfPoint.setHorizontalAlignment(JTextField.CENTER);
		tfPoint.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tfPoint.setName("point");
		tfPoint.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tfPoint.setBounds(12, 120, 176, 35);
		pPoint.add(tfPoint);
		
		btnReceiptConfirm = SwingFactory.getButton("");
		btnReceiptConfirm.setBackground(SystemColor.inactiveCaptionBorder);
		btnReceiptConfirm.setName("receiptConfirm");
		btnReceiptConfirm.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnReceiptConfirm.setText("\uC601\uC218\uC99D\uD655\uC778");
		btnReceiptConfirm.setBounds(480, 460, 140, 45);
		add(btnReceiptConfirm);
		
		btnPayment = SwingFactory.getButton("");
		btnPayment.setBackground(SystemColor.inactiveCaptionBorder);
		btnPayment.setName("payment");
		btnPayment.setText("\uACB0\uC81C");
		btnPayment.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnPayment.setBounds(650, 460, 140, 45);
		add(btnPayment);
		
		btnCancel = SwingFactory.getButton("");
		btnCancel.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancel.setName("cancel");
		btnCancel.setText("\uCDE8\uC18C");
		btnCancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnCancel.setBounds(820, 460, 140, 45);
		add(btnCancel);
	
	}

}
