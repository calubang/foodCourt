package kitri.foodCourt.user.basket;

import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import java.awt.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.*;
import kitri.foodCourt.user.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;


public class PaymentMain extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private BasketController controller;
	public static User user = new User("calubang", "¾Èº´¿í", 5000);
	
	public void test() {
		FoodDto food1 = new FoodDto("1", "µÈÀåÂî°³", 1, "ÇÑ½Ä", 5000, "/kitri/foodCourt/user/basket/image/Á¦À°1.jpg");
		FoodDto food2 = new FoodDto("2", "½ºÅ×ÀÌÅ©", 2, "¾ç½Ä", 8000, "/kitri/foodCourt/user/basket/image/Á¦À°1.jpg");
		FoodDto food3 = new FoodDto("3", "ÀÚÀå¸é", 3, "Áß½Ä", 7000, "/kitri/foodCourt/user/basket/image/Á¦À°1.jpg");
		FoodDto food4 = new FoodDto("4", "³ª°¡»çÅ°Â«»Í", 4, "ÀÏ½Ä", 6000, "/kitri/foodCourt/user/basket/image/Á¦À°1.jpg");
		FoodDto food5 = new FoodDto("5", "³ª°¡»çÅ°Â«»Í", 4, "ÀÏ½Ä", 6000, "/kitri/foodCourt/user/basket/image/Á¦À°1.jpg");
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
					PaymentMain frame = new PaymentMain();
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
	public PaymentMain() {
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
		JButton btnNewButton = new JButton("¸ÞÀÎ¸Þ´º", new ImageIcon("C:\\Users\\Administrator\\Desktop\\home.png"));
		btnNewButton.setBounds(12, 10, 120, 59);
		btnNewButton.setBorderPainted(false);
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778\uBA54\uB274");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 71, 120, 20);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 30));
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
		
		JPanel pPaymentMain = new JPanel();
		pPaymentMain.setBounds(160, 118, 1012, 634);
		panel.add(pPaymentMain);
		pPaymentMain.setLayout(null);
		
		FPanel pCash = new FPanel();
		pCash.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, new Color(64, 64, 64), null)));
		pCash.setBounds(100, 150, 200, 180);
		pPaymentMain.add(pCash);
		pCash.setLayout(null);
		
		FLabel lbCash = new FLabel();
		lbCash.setHorizontalAlignment(SwingConstants.CENTER);
		lbCash.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		lbCash.setText("\uD604  \uAE08");
		lbCash.setBounds(12, 20, 176, 50);
		pCash.add(lbCash);
				
		JTextPane tpCash = new JTextPane();
		tpCash.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.PLAIN, 20));
		tpCash.setBounds(12, 120, 176, 35);
		pCash.add(tpCash);
		
		StyledDocument document = tpCash.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		document.setParagraphAttributes(0, document.getLength(), center, false);
		
		FPanel pCard = new FPanel();
		pCard.setLayout(null);
		pCard.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, new Color(64, 64, 64), null)));
		pCard.setBounds(400, 150, 200, 180);
		pPaymentMain.add(pCard);
		
		JTextPane tpCard = new JTextPane();
		tpCard.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.PLAIN, 20));
		tpCard.setBounds(12, 120, 176, 35);
		
		document = tpCard.getStyledDocument();
		document.setParagraphAttributes(0, document.getLength(), center, false);
		
		pCard.add(tpCard);
		
		FLabel lbCard = new FLabel();
		lbCard.setText("\uCE74  \uB4DC");
		lbCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbCard.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		lbCard.setBounds(12, 20, 176, 50);
		pCard.add(lbCard);
		
		FPanel pPoint = new FPanel();
		pPoint.setLayout(null);
		pPoint.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, new Color(64, 64, 64), null)));
		pPoint.setBounds(700, 150, 200, 180);
		pPaymentMain.add(pPoint);
		
		FLabel lbPointText = new FLabel();
		lbPointText.setText("\uAC00\uC6A9\uD3EC\uC778\uD2B8");
		lbPointText.setHorizontalAlignment(SwingConstants.CENTER);
		lbPointText.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		lbPointText.setBounds(12, 10, 176, 35);
		pPoint.add(lbPointText);
		
		FLabel lbPoint = new FLabel();
		lbPoint.setText("5000P");
		lbPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		lbPoint.setBounds(12, 45, 176, 35);
		pPoint.add(lbPoint);
		
		JTextPane tpPoint = new JTextPane();
		tpPoint.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.PLAIN, 20));
		tpPoint.setBounds(12, 120, 176, 35);
		pPoint.add(tpPoint);
		
		FButton button = new FButton();
		button.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		button.setText("\uC601\uC218\uC99D\uD655\uC778");
		button.setBounds(480, 430, 140, 45);
		pPaymentMain.add(button);
		
		FButton button_1 = new FButton();
		button_1.setText("\uACB0\uC81C");
		button_1.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		button_1.setBounds(650, 430, 140, 45);
		pPaymentMain.add(button_1);
		
		FButton button_2 = new FButton();
		button_2.setText("\uCDE8\uC18C");
		button_2.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 20));
		button_2.setBounds(820, 430, 140, 45);
		pPaymentMain.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(12, 90, 988, 6);
		pPaymentMain.add(panel_1);
		
		FLabel lbPayment = new FLabel();
		lbPayment.setText("\uACB0\uC81C");
		lbPayment.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 40));
		lbPayment.setBounds(144, 10, 178, 70);
		pPaymentMain.add(lbPayment);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaymentMain.class.getResource("/kitri/foodCourt/user/basket/image/payment.png")));
		label.setBounds(12, 10, 120, 70);
		pPaymentMain.add(label);
		
		document = tpPoint.getStyledDocument();
		document.setParagraphAttributes(0, document.getLength(), center, false);
		

		
	}
}
