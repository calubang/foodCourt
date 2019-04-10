package kitri.foodCourt.user.basket;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

import kitri.foodCourt.user.Basket;
import kitri.foodCourt.user.swing.*;

public class Payment extends JPanel {

	public static int requestNumber = 0;
	private PaymentController controller;
	public Receipt receipt = new Receipt();
	public BasketMain basketMain;
	//«œ¥‹ πˆ∆∞3∞≥
	public FButton btnReceiptConfirm;
	public FButton btnPayment;
	public FButton btnCancel;
	
	//≈ÿΩ∫∆Æ« µÂ
	public JTextField tpCard;
	public JTextField tpCash;
	public JTextField tpPoint;
	
	//ªÛ¥‹ √—∞°∞› 
	public FLabel lbTotalPrice;
	public FLabel lbTotalPoint;
	//¿Ø¿˙¿« ∞°øÎ∆˜¿Œ∆Æ
	public FLabel lbUserPoint;
	
	public Payment(BasketMain basketMain) {
		this.basketMain = basketMain;
		receipt.user = basketMain.user;
		//±‚∫ªUI
		initView();
		//dataSetting();
		
		//¿Ã∫•∆Æ
		controller = new PaymentController(this);
		btnReceiptConfirm.addActionListener(controller);
		receipt.btnOK.addActionListener(controller);
		btnPayment.addActionListener(controller);
		btnCancel.addActionListener(controller);
		tpCard.addKeyListener(controller);
		tpCash.addKeyListener(controller);
		tpPoint.addKeyListener(controller);
	}
	
	public void dataSetting() {
		Basket basket = basketMain.user.getBasket();
		
		lbTotalPrice.setText(String.valueOf(basket.getTotalPrice()));
		lbTotalPoint.setText(String.valueOf(basket.getSavePoint()) + "P");
		lbUserPoint.setText(String.valueOf(basketMain.user.getUserPoint()) + "P");
		
		//øµºˆ¡ıµµ ∞∞¿Ã dataSetting
		receipt.dataSetting();
	}
	
	public void initView(){
		this.setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		JPanel pSeperator = new JPanel();
		pSeperator.setBackground(SystemColor.activeCaption);
		pSeperator.setBounds(12, 90, 988, 6);
		add(pSeperator);
		
		JLabel lbPageImage = new JLabel("");
		lbPageImage.setIcon(new ImageIcon(Payment.class.getResource("/kitri/foodCourt/user/basket/image/payment.png")));
		lbPageImage.setBounds(12, 10, 120, 70);
		add(lbPageImage);
		
		FLabel lbPageName = new FLabel(Font.BOLD, 40);
		lbPageName.setText("\uACB0\uC81C");
		lbPageName.setBounds(144, 10, 178, 70);
		add(lbPageName);
		
		JPanel pTotalPrice = new JPanel();
		pTotalPrice.setLayout(null);
		pTotalPrice.setBackground(SystemColor.inactiveCaptionBorder);
		pTotalPrice.setBounds(12, 106, 988, 85);
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
		//pCash.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pCash.setBounds(100, 220, 200, 180);
		add(pCash);
		pCash.setLayout(null);
		
		FLabel lbCash = new FLabel(Font.BOLD, 20);
		lbCash.setHorizontalAlignment(SwingConstants.CENTER);
		lbCash.setText("\uD604  \uAE08");
		lbCash.setBounds(12, 20, 176, 50);
		pCash.add(lbCash);
				
		tpCash = new JTextField();
		tpCash.setHorizontalAlignment(JTextField.CENTER);
		tpCash.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tpCash.setBounds(12, 120, 176, 35);
		tpCash.setName("cash");
		tpCash.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		pCash.add(tpCash);
	
		RoundPanel pCard = new RoundPanel();
		pCard.setBackground(new Color(255, 255, 240));
		pCard.setLayout(null);
		pCard.setBounds(400, 220, 200, 180);
		add(pCard);
		
		tpCard = new JTextField();
		tpCard.setHorizontalAlignment(JTextField.CENTER);
		tpCard.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tpCard.setName("card");
		tpCard.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		tpCard.setBounds(12, 120, 176, 35);
		pCard.add(tpCard);
		
		FLabel lbCard = new FLabel(Font.BOLD, 20);
		lbCard.setText("\uCE74  \uB4DC");
		lbCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbCard.setBounds(12, 20, 176, 50);
		pCard.add(lbCard);
		
		RoundPanel pPoint = new RoundPanel();
		pPoint.setBackground(new Color(255, 255, 240));
		pPoint.setLayout(null);
		pPoint.setBounds(700, 220, 200, 180);
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
		
		tpPoint = new JTextField();
		tpPoint.setHorizontalAlignment(JTextField.CENTER);
		tpPoint.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tpPoint.setName("point");
		tpPoint.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		tpPoint.setBounds(12, 120, 176, 35);
		pPoint.add(tpPoint);
		
		btnReceiptConfirm = SwingFactory.getButton("");
		btnReceiptConfirm.setName("receiptConfirm");
		btnReceiptConfirm.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnReceiptConfirm.setText("\uC601\uC218\uC99D\uD655\uC778");
		btnReceiptConfirm.setBounds(480, 470, 140, 45);
		add(btnReceiptConfirm);
		
		btnPayment = SwingFactory.getButton("");
		btnPayment.setName("payment");
		btnPayment.setText("\uACB0\uC81C");
		btnPayment.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnPayment.setBounds(650, 470, 140, 45);
		add(btnPayment);
		
		btnCancel = SwingFactory.getButton("");
		btnCancel.setName("cancel");
		btnCancel.setText("\uCDE8\uC18C");
		btnCancel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnCancel.setBounds(820, 470, 140, 45);
		add(btnCancel);
	
	}

}
