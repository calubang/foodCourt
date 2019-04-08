package kitri.foodCourt.user.basket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import kitri.foodCourt.user.swing.FLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Dimension;
import kitri.foodCourt.user.swing.FButton;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;

public class Receipt extends JFrame{

	private JPanel contentPane;
	private String columnNames[] = {"ºÐ·ù", "À½½Ä¸í", "Ç±Å°Æ÷ÀÎÆ®", "¼ö·®", "°¡°Ý"};
	private Object data[][] = {{"ÇÑ½Ä", "µÈÀåÂî°³", 100, 2, 5000}, {"¾ç½Ä", "½ºÅ×ÀÌÅ©", 100, 2, 5000}, {"Áß½Ä", "ÀÚÀå¸é", 100, 2, 5000}, {"ÀÏ½Ä", "ÃÊ¹ä", 100, 2, 5000}};
	private JTable tabFood;
	private Payment payment;
	private int columnHeight = 30;
	
	//¹öÆ°
	FButton btnOK;
	
	//Å×½ºÆ®¿ë
	BasketMain basket = new BasketMain();


	public Receipt() {
		//this.payment = payment;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 434, 114);
		panel.add(pTop);
		pTop.setLayout(null);
		
		FLabel label = new FLabel();
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("\uC601\uC218\uC99D");
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(0, 0, 434, 40);
		pTop.add(label);
		
		FLabel label_1 = new FLabel();
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_1.setText("\uC8FC\uBB38\uBC88\uD638 : ");
		label_1.setBounds(0, 50, 75, 30);
		pTop.add(label_1);
		
		FLabel lbPaymentNumber = new FLabel();
		lbPaymentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbPaymentNumber.setText("217");
		lbPaymentNumber.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbPaymentNumber.setBounds(75, 50, 73, 30);
		pTop.add(lbPaymentNumber);
		
		FLabel label_3 = new FLabel();
		label_3.setText("\uACB0\uC81C\uC77C\uC2DC : ");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_3.setBounds(210, 50, 75, 30);
		pTop.add(label_3);
		
		FLabel lbPaymentDate = new FLabel();
		lbPaymentDate.setText("19-04-08 12:05:23");
		lbPaymentDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbPaymentDate.setBounds(289, 50, 135, 30);
		pTop.add(lbPaymentDate);
		
		FLabel label2 = new FLabel();
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setText("\uD68C\uC6D0ID : ");
		label2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label2.setBounds(237, 84, 75, 30);
		pTop.add(label2);
		
		FLabel lbId = new FLabel();
		lbId.setText("calubang");
		lbId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbId.setBounds(324, 84, 100, 30);
		pTop.add(lbId);
		
		JScrollPane spFood = new JScrollPane();
		spFood.setBorder(new LineBorder(Color.BLACK, 2, true));
		spFood.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spFood.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		spFood.setBounds(0, 124, 434, 63);
		panel.add(spFood);
		
		DefaultTableModel foodTableMode = new DefaultTableModel(columnNames, 0);
		tabFood = new JTable(foodTableMode);
		tabFood.setEnabled(false);
		tabFood.setRowHeight(columnHeight);
		tabFood.setMinimumSize(new Dimension(75, 30));
		tabFood.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		
		//³»¿ë °¡¿îµ¥ Á¤·Ä
		TableColumnModel tcm = tabFood.getColumnModel();
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		int size = columnNames.length;
		for(int i = 0 ; i< size ; i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		//Çì´õ Å©±âÁ¶Àý
		JTableHeader th = tabFood.getTableHeader();
		th.setPreferredSize(new Dimension(0, columnHeight));
		th.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		
		spFood.setViewportView(tabFood);
		
		JPanel pPayment = new JPanel();
		pPayment.setBounds(0, 192, 434, 76);
		panel.add(pPayment);
		pPayment.setLayout(new GridLayout(2, 3, 0, 0));
		
		FLabel label_8 = new FLabel();
		label_8.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 0, 0)));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label_8.setText("\uD604\uAE08");
		pPayment.add(label_8);
		
		FLabel label_9 = new FLabel();
		label_9.setText("\uCE74\uB4DC");
		label_9.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pPayment.add(label_9);
		
		FLabel label_10 = new FLabel();
		label_10.setText("\uD489\uD0A4\uD3EC\uC778\uD2B8");
		label_10.setBorder(new MatteBorder(2, 1, 1, 2, (Color) new Color(0, 0, 0)));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pPayment.add(label_10);
		
		FLabel lbCash = new FLabel();
		lbCash.setBorder(new MatteBorder(1, 2, 2, 1, (Color) new Color(0, 0, 0)));
		lbCash.setHorizontalAlignment(SwingConstants.CENTER);
		lbCash.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pPayment.add(lbCash);
		
		FLabel lbCard = new FLabel();
		lbCard.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		lbCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbCard.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pPayment.add(lbCard);
		
		FLabel lbPoint = new FLabel();
		lbPoint.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 0, 0)));
		lbPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pPayment.add(lbPoint);
		
		JPanel pTotal = new JPanel();
		pTotal.setBounds(0, 278, 434, 80);
		panel.add(pTotal);
		pTotal.setLayout(new GridLayout(2, 2, 0, 0));
		
		FLabel label_5 = new FLabel();
		label_5.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.LIGHT_GRAY);
		label_5.setOpaque(true);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setText("\uCD1D\uAE08\uC561");
		pTotal.add(label_5);
		
		FLabel lbTotalPrice = new FLabel();
		lbTotalPrice.setBorder(new MatteBorder(2, 1, 1, 2, (Color) new Color(0, 0, 0)));
		lbTotalPrice.setOpaque(true);
		lbTotalPrice.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotalPrice.setText("20000");
		pTotal.add(lbTotalPrice);
		
		FLabel label_7 = new FLabel();
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setBorder(new MatteBorder(1, 2, 2, 1, (Color) new Color(0, 0, 0)));
		label_7.setOpaque(true);
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setText("\uD68D\uB4DD\uD3EC\uC778\uD2B8");
		pTotal.add(label_7);
		
		FLabel lbTotalPoint = new FLabel();
		lbTotalPoint.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 0, 0)));
		lbTotalPoint.setOpaque(true);
		lbTotalPoint.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbTotalPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotalPoint.setText("2000P");
		pTotal.add(lbTotalPoint);
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(0, 368, 434, 62);
		panel.add(pBottom);
		pBottom.setLayout(null);
		
		btnOK = new FButton();
		btnOK.setName("receiptOK");
		btnOK.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnOK.setText("\uD655\uC778");
		btnOK.setBounds(157, 10, 127, 45);
		pBottom.add(btnOK);
		
		//Å×ÀÌºí¿¡ µ¥ÀÌÅÍ ³Ö±â
		size = data.length;
		for (int i = 0; i < size; i++) {
			foodTableMode.addRow(data[i]);
		}
		//µ¥ÀÌÅÍ°¡ µé¾î°£ ¸¸Å­ »çÀÌÁî Á¶Àý
		int changeSize = columnHeight * (size-1);
		this.setSize(this.getWidth(), this.getHeight()+changeSize);
		spFood.setBounds(spFood.getX(), spFood.getY(), spFood.getWidth(), spFood.getHeight()+changeSize);
		pPayment.setBounds(pPayment.getX(), pPayment.getY()+changeSize, pPayment.getWidth(), pPayment.getHeight());
		pTotal.setBounds(pTotal.getX(), pTotal.getY()+changeSize, pTotal.getWidth(), pTotal.getHeight());
		pBottom.setBounds(pBottom.getX(), pBottom.getY()+changeSize, pBottom.getWidth(), pBottom.getHeight());
		
		
		//ÀÌº¥Æ®´Â paymentMain ¿¡¼­ Ã³¸®
		//x¹öÆ°¿¡ ´ëÇÑ Ã³¸®¸¸ ¿©±â¼­ ¼öÇà
//		WindowListener windowListener = new WindowAdapter() {
//			@Override
//			public void windowClosed(WindowEvent e) {
//				paymentMain.setEnabled(true);
//				Receipt receipt = paymentMain.receipt;
//				receipt.setVisible(false);
//			}
//		};
//		
//		this.addWindowListener(windowListener);
	}
}
