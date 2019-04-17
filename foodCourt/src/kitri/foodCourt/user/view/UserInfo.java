package kitri.foodCourt.user.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import kitri.foodCourt.util.Constance;

import javax.swing.border.LineBorder;

import kitri.foodCourt.user.User;
import kitri.foodCourt.user.controller.UserInfoController;
import kitri.foodCourt.user.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfo extends JPanel {

	public JPanel contentPane;
	public JTextField tfId;
	public JTextField tfName;
	public JComboBox<String> cbPhoneFirst;
	public JTextField tfPhoneMiddle;
	public JTextField tfPhoneLast;
	public JPasswordField pfNewPassword;
	public JPasswordField pfRePassword;
	public FoodMain foodMain;
	public UserInfoController controller;
	public User user;
	public FLabel lbPasswordInfo;
	public FButton btnModify;
	public FButton btnCancel;
	public JTextField tfPasswordQuiz;
	public JTextField tfPasswordAnswer;
	public FButton btnSecession;
	
	private boolean Modifiable = false;
	
	//¿¸»≠π¯»£
	public String phoneFirstArray[] = {"010", "011", "016", "017"};

	
	
	public UserInfo(FoodMain foodMain) {		
		this.foodMain = foodMain;
		this.user = User.getInstance();
		initView();
		//¿Ã∫•∆Æ µÓ∑œ∫Œ
		controller = new UserInfoController(this);
		
		
		
		//¿Ã∫•∆Æ µÓ∑œ
		pfNewPassword.addKeyListener(controller);
		pfRePassword.addKeyListener(controller);
		btnCancel.addActionListener(controller);
		btnModify.addActionListener(controller);
		btnSecession.addActionListener(controller);
	}
	
	public void initView() {
		
		//Ω«¡¶ ∆–≥Œ
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1012, 634);

		
		JPanel pTop = new JPanel();
		pTop.setBackground(Color.WHITE);
		pTop.setBounds(0, 0, 1012, 60);
		pTop.setLayout(null);
		this.add(pTop);
		
		JLabel lblBasketImage = new JLabel("");
		lblBasketImage.setIcon(new ImageIcon(UserInfo.class.getResource(Constance.USER_IMAGE_PATH + "userInfo_icon.png")));
		lblBasketImage.setBounds(0, 0, 120, 50);
		pTop.add(lblBasketImage);
		
		FLabel lbUserInfo = new FLabel(Font.BOLD, 40);
		lbUserInfo.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		lbUserInfo.setBounds(130, 0, 178, 50);
		pTop.add(lbUserInfo);
		lbUserInfo.setText("\uC720\uC800\uC815\uBCF4");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 60, 1012, 513);
		this.add(panel);
		panel.setLayout(null);
		
		FLabel label = new FLabel(Font.BOLD, 20);
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setOpaque(true);
		label.setBackground(SystemColor.inactiveCaptionBorder);
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label.setBounds(12, 10, 100, 35);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("\uC544\uC774\uB514");
		
		FLabel label_1 = new FLabel(1, 20);
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_1.setOpaque(true);
		label_1.setBackground(SystemColor.inactiveCaptionBorder);
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_1.setBounds(12, 55, 100, 35);
		panel.add(label_1);
		label_1.setText("\uC774\uB984");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		FLabel label_2 = new FLabel(1, 20);
		label_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_2.setOpaque(true);
		label_2.setBackground(SystemColor.inactiveCaptionBorder);
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_2.setBounds(12, 100, 100, 35);
		panel.add(label_2);
		label_2.setText("\uD734\uB300\uC804\uD654");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		FLabel label_3 = new FLabel(1, 20);
		label_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_3.setOpaque(true);
		label_3.setBackground(SystemColor.inactiveCaptionBorder);
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_3.setBounds(12, 150, 100, 35);
		panel.add(label_3);
		label_3.setText("\uBE44\uBC00\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfId = new JTextField();
		tfId.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tfId.setEditable(false);
		tfId.setBackground(Color.WHITE);
		tfId.setForeground(Color.BLACK);
		tfId.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		tfId.setEnabled(false);
		tfId.setBounds(124, 14, 342, 35);
		panel.add(tfId);
		tfId.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfName.setToolTipText("\uC774\uB984");
		tfName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		tfName.setBounds(124, 59, 342, 35);
		panel.add(tfName);
		tfName.setColumns(10);
		
		cbPhoneFirst = new JComboBox(phoneFirstArray);
		cbPhoneFirst.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		cbPhoneFirst.setBackground(Color.WHITE);
//		popupMenu = new PopupMenu();
//		int size = phoneFirstArray.length;
//		for(int i=0 ; i< size ; i++) {
//			popupMenu.add(phoneFirstArray[i]);
//		}
//		cbPhoneFirst.add(popupMenu);
		cbPhoneFirst.setBounds(124, 104, 96, 35);
		panel.add(cbPhoneFirst);
		
		tfPhoneMiddle = new JTextField();
		tfPhoneMiddle.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfPhoneMiddle.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		tfPhoneMiddle.setBounds(232, 104, 110, 35);
		panel.add(tfPhoneMiddle);
		tfPhoneMiddle.setColumns(10);
		
		tfPhoneLast = new JTextField();
		tfPhoneLast.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfPhoneLast.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		tfPhoneLast.setBounds(356, 104, 110, 35);
		panel.add(tfPhoneLast);
		tfPhoneLast.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(124, 150, 342, 162);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		FLabel label_4 = new FLabel(1, 20);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_4.setText("\uBE44\uBC00\uBC88\uD638\uB294 6\uC790 \uC774\uC0C1 \uBB38\uC790or\uC22B\uC790\uB85C \uAD6C\uC131\uD558\uC138\uC694.");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(10, 10, 320, 20);
		panel_1.add(label_4);
		
		FLabel label_6 = new FLabel(1, 20);
		label_6.setText("\uC2E0\uADDC \uBE44\uBC00\uBC88\uD638");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_6.setBounds(10, 40, 100, 30);
		panel_1.add(label_6);
		
		FLabel label_7 = new FLabel(1, 20);
		label_7.setText("\uB2E4\uC2DC\uC785\uB825");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_7.setBounds(10, 80, 100, 30);
		panel_1.add(label_7);
		
		lbPasswordInfo = new FLabel(1, 20);
		lbPasswordInfo.setForeground(Color.RED);
		lbPasswordInfo.setText("\uBE44\uBC00\uBC88\uD638\uAC00 \uB2E4\uB985\uB2C8\uB2E4.");
		lbPasswordInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lbPasswordInfo.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		lbPasswordInfo.setBounds(122, 120, 208, 20);
		panel_1.add(lbPasswordInfo);
		
		pfNewPassword = new JPasswordField();
		pfNewPassword.setBorder(new LineBorder(Color.BLACK, 1, true));
		pfNewPassword.setName("new");
		pfNewPassword.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		pfNewPassword.setBounds(123, 40, 207, 30);
		panel_1.add(pfNewPassword);
		
		pfRePassword = new JPasswordField();
		pfRePassword.setBorder(new LineBorder(Color.BLACK, 1, true));
		pfRePassword.setName("re");
		pfRePassword.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		pfRePassword.setBounds(123, 80, 207, 30);
		panel_1.add(pfRePassword);
		
		btnModify = SwingFactory.getButton("");
		btnModify.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnModify.setBackground(SystemColor.inactiveCaptionBorder);
		btnModify.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		btnModify.setText("\uC218\uC815");
		btnModify.setBounds(420, 463, 97, 35);
		panel.add(btnModify);
		
		btnCancel = SwingFactory.getButton("");
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCancel.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		btnCancel.setText("\uCDE8\uC18C");
		btnCancel.setBounds(529, 463, 97, 35);
		panel.add(btnCancel);
		
		FLabel label_5 = new FLabel(1, 20);
		label_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_5.setOpaque(true);
		label_5.setBackground(SystemColor.inactiveCaptionBorder);
		label_5.setText("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_5.setBounds(12, 322, 100, 35);
		panel.add(label_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(124, 322, 502, 131);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		FLabel label_8 = new FLabel(1, 20);
		label_8.setText("\uC9C8\uBB38");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_8.setBounds(12, 40, 100, 30);
		panel_2.add(label_8);
		
		tfPasswordQuiz = new JTextField();
		tfPasswordQuiz.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfPasswordQuiz.setForeground(Color.BLACK);
		tfPasswordQuiz.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		tfPasswordQuiz.setColumns(10);
		tfPasswordQuiz.setBackground(Color.WHITE);
		tfPasswordQuiz.setBounds(124, 40, 366, 35);
		panel_2.add(tfPasswordQuiz);
		
		FLabel label_10 = new FLabel(1, 20);
		label_10.setText("\uB2F5\uBCC0");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_10.setBounds(12, 80, 100, 30);
		panel_2.add(label_10);
		
		tfPasswordAnswer = new JTextField();
		tfPasswordAnswer.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfPasswordAnswer.setForeground(Color.BLACK);
		tfPasswordAnswer.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		tfPasswordAnswer.setColumns(10);
		tfPasswordAnswer.setBackground(Color.WHITE);
		tfPasswordAnswer.setBounds(124, 80, 366, 35);
		panel_2.add(tfPasswordAnswer);
		
		FLabel label_11 = new FLabel(1, 20);
		label_11.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC744 \uB54C \uC0AC\uC6A9\uB429\uB2C8\uB2E4. \uAC04\uB2E8\uD55C \uC9C8\uBB38\uC73C\uB85C \uC124\uC815\uD558\uC138\uC694.");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_11.setBounds(12, 10, 478, 20);
		panel_2.add(label_11);
		
		FLabel label_9 = new FLabel();
		label_9.setBounds(638, 212, 241, 286);
		panel.add(label_9);
		label_9.setIcon(new ImageIcon(UserInfo.class.getResource(Constance.USER_IMAGE_PATH + "duck.png")));
		
		btnSecession = SwingFactory.getButton("");
		btnSecession.setBounds(877, 463, 97, 35);
		panel.add(btnSecession);
		btnSecession.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSecession.setText("\uD68C\uC6D0\uD0C8\uD1F4");
		btnSecession.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		btnSecession.setBackground(SystemColor.inactiveCaptionBorder);
	}
	
	public void dataSetting() {
		
		tfId.setText(user.getUserId() + " (ºˆ¡§∫“∞°)");
		tfName.setText(user.getName());
		cbPhoneFirst.setSelectedItem(user.getPhoneNumberFirst());		
		tfPhoneMiddle.setText(user.getPhoneNumberMiddle());
		tfPhoneLast.setText(user.getPhoneNumberlast());
		
		pfNewPassword.setText("");
		pfRePassword.setText("");
		lbPasswordInfo.setText("");
		
		tfPasswordQuiz.setText(user.getPasswordQuiz());
		tfPasswordQuiz.setText(user.getPasswordAnswer());
		
		Modifiable = true;
		btnModify.setEnabled(true);
		
	}

	public boolean getModifiable() {
		return Modifiable;
	}
	public void setModifiable(boolean modifiable) {
		Modifiable = modifiable;
	}
}
