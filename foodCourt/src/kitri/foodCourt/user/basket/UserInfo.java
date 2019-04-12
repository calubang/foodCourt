package kitri.foodCourt.user.basket;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import kitri.foodCourt.user.swing.FLabel;
import javax.swing.border.LineBorder;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//실제 패널
		JPanel userInfo = new JPanel();
		userInfo.setLayout(null);
		userInfo.setBounds(160, 118, 1012, 634);
		contentPane.add(userInfo);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 1012, 105);
		pTop.setLayout(null);
		userInfo.add(pTop);
		
		JLabel lblBasketImage = new JLabel("");
		lblBasketImage.setBounds(12, 10, 120, 70);
		
		try {
			URL url = UserInfo.class.getResource("/kitri/foodCourt/user/basket/image/userInfo_icon.png");
			BufferedImage img = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(img.getScaledInstance(lblBasketImage.getWidth(), lblBasketImage.getHeight()+30, Image.SCALE_FAST));
			lblBasketImage.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pTop.add(lblBasketImage);
		
		FLabel lbUserInfo = new FLabel(Font.BOLD, 40);
		lbUserInfo.setBounds(144, 10, 178, 70);
		pTop.add(lbUserInfo);
		lbUserInfo.setText("\uC720\uC800\uC815\uBCF4");
		
		JPanel pSeparator = new JPanel();
		pSeparator.setBounds(0, 90, 1012, 6);
		pTop.add(pSeparator);
		pSeparator.setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(54, 133, 547, 444);
		userInfo.add(panel);
		panel.setLayout(null);
		
		FLabel label = new FLabel(Font.BOLD, 20);
		label.setBounds(12, 10, 100, 35);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("\uC544\uC774\uB514");
		
		FLabel label_1 = new FLabel(1, 20);
		label_1.setBounds(12, 55, 100, 35);
		panel.add(label_1);
		label_1.setText("\uC774\uB984");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		FLabel label_2 = new FLabel(1, 20);
		label_2.setBounds(12, 100, 100, 35);
		panel.add(label_2);
		label_2.setText("\uD734\uB300\uC804\uD654");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		FLabel label_3 = new FLabel(1, 20);
		label_3.setBounds(12, 145, 100, 35);
		panel.add(label_3);
		label_3.setText("\uBE44\uBC00\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfId = new JTextField();
		tfId.setBounds(124, 14, 262, 35);
		panel.add(tfId);
		tfId.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(124, 59, 262, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 104, 80, 35);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 104, 79, 35);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(307, 104, 79, 35);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		
	}
}
