package kitri.foodCourt.user.basket;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

import kitri.foodCourt.user.Basket;
import kitri.foodCourt.user.swing.*;

public class Payment extends JPanel {

	private PaymentController controller;
	public Receipt receipt = new Receipt();
	public BasketMain basketMain;
	
	public Payment(BasketMain basketMain) {
		this.basketMain = basketMain;
		this.setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		FPanel pCash = new FPanel();
		pCash.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pCash.setBounds(100, 220, 200, 180);
		add(pCash);
		pCash.setLayout(null);
		
		FLabel lbCash = new FLabel(Font.BOLD, 20);
		lbCash.setHorizontalAlignment(SwingConstants.CENTER);
		lbCash.setText("\uD604  \uAE08");
		lbCash.setBounds(12, 20, 176, 50);
		pCash.add(lbCash);
				
		JTextPane tpCash = new JTextPane();
		tpCash.setName("cash");
		tpCash.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		tpCash.setBounds(12, 120, 176, 35);
		pCash.add(tpCash);
		
		StyledDocument document = tpCash.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		document.setParagraphAttributes(0, document.getLength(), center, false);
		
		FPanel pCard = new FPanel();
		pCard.setLayout(null);
		pCard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pCard.setBounds(400, 220, 200, 180);
		add(pCard);
		
		JTextPane tpCard = new JTextPane();
		tpCard.setName("card");
		tpCard.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		tpCard.setBounds(12, 120, 176, 35);
		
		document = tpCard.getStyledDocument();
		document.setParagraphAttributes(0, document.getLength(), center, false);
		
		pCard.add(tpCard);
		
		FLabel lbCard = new FLabel(Font.BOLD, 20);
		lbCard.setText("\uCE74  \uB4DC");
		lbCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbCard.setBounds(12, 20, 176, 50);
		pCard.add(lbCard);
		
		FPanel pPoint = new FPanel();
		pPoint.setLayout(null);
		pPoint.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pPoint.setBounds(700, 220, 200, 180);
		add(pPoint);
		
		FLabel lbPointText = new FLabel(Font.BOLD, 20);
		lbPointText.setText("\uAC00\uC6A9\uD3EC\uC778\uD2B8");
		lbPointText.setHorizontalAlignment(SwingConstants.CENTER);
		lbPointText.setBounds(12, 10, 176, 35);
		pPoint.add(lbPointText);
		
		FLabel lbPoint = new FLabel(Font.BOLD, 20);
		lbPoint.setText("5000P");
		lbPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint.setBounds(12, 45, 176, 35);
		pPoint.add(lbPoint);
		
		JTextPane tpPoint = new JTextPane();
		tpPoint.setName("point");
		tpPoint.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		tpPoint.setBounds(12, 120, 176, 35);
		pPoint.add(tpPoint);
		
		FButton btnReceiptConfirm = SwingFactory.getButton("");
		btnReceiptConfirm.setName("receiptConfirm");
		btnReceiptConfirm.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnReceiptConfirm.setText("\uC601\uC218\uC99D\uD655\uC778");
		btnReceiptConfirm.setBounds(480, 470, 140, 45);
		add(btnReceiptConfirm);
		
		FButton btnPayment = SwingFactory.getButton("");
		btnPayment.setName("payment");
		btnPayment.setText("\uACB0\uC81C");
		btnPayment.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnPayment.setBounds(650, 470, 140, 45);
		add(btnPayment);
		
		FButton btnCancel = SwingFactory.getButton("");
		btnCancel.setName("cancel");
		btnCancel.setText("\uCDE8\uC18C");
		btnCancel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		btnCancel.setBounds(820, 470, 140, 45);
		add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(12, 90, 988, 6);
		add(panel_1);
		
		FLabel lbPayment = new FLabel(Font.BOLD, 40);
		lbPayment.setText("\uACB0\uC81C");
		lbPayment.setBounds(144, 10, 178, 70);
		add(lbPayment);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaymentMain.class.getResource("/kitri/foodCourt/user/basket/image/payment.png")));
		label.setBounds(12, 10, 120, 70);
		add(label);
		
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
		
		FLabel lbTotalPrice = new FLabel();
		lbTotalPrice.setText("20000\uC6D0");
		lbTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTotalPrice.setFont(new Font("Dialog", Font.BOLD, 30));
		lbTotalPrice.setBounds(765, 0, 196, 50);
		pTotalPrice.add(lbTotalPrice);
		
		FLabel lbTotalPoint = new FLabel();
		lbTotalPoint.setText("2000P");
		lbTotalPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTotalPoint.setFont(new Font("Dialog", Font.BOLD, 20));
		lbTotalPoint.setBounds(837, 50, 124, 35);
		pTotalPrice.add(lbTotalPoint);
		
		FLabel label_4 = new FLabel(Font.BOLD, 20);
		label_4.setText("\uC801\uB9BD \uD3EC\uC778\uD2B8");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(710, 50, 115, 35);
		pTotalPrice.add(label_4);
		
		document = tpPoint.getStyledDocument();
		document.setParagraphAttributes(0, document.getLength(), center, false);
		
		//¿Ã∫•∆Æ
		controller = new PaymentController(this);
		btnReceiptConfirm.addActionListener(controller);
		receipt.btnOK.addActionListener(controller);
		btnPayment.addActionListener(controller);
		tpCard.addInputMethodListener(controller);
		btnCancel.addActionListener(controller);
	}

}
