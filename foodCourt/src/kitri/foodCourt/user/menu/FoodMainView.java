package kitri.foodCourt.user.menu;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.swing.RoundPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FoodMainView extends JPanel {
	public Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	public JButton labHansic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/hansic.jpg")));
	public JLabel labHansicName = new JLabel("\uD55C  \uC2DD");
	public JButton labIlsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/ilsic.jpg")));
	public JButton labJoongsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/joongsic.jpg")));
	public JButton labYangsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/yangsic.jpeg")));
	public FoodMainView() {
		
		labHansic.setName("1");
		labIlsic.setBorder(null);
		labIlsic.setName("3");
		labYangsic.setName("4");
		
		setBackground(Color.WHITE);
		setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		RoundPanel pKorean = new RoundPanel(4, 50);
		pKorean.setBackground(Color.WHITE);
		pKorean.setBounds(130, 23, 310, 270);
		add(pKorean);
		pKorean.setLayout(null);
		
		
		labHansic.setToolTipText("\uD55C\uC2DD");
		labHansic.setBounds(15, 10, 280, 200);
		labHansic.setCursor(hand);
		pKorean.add(labHansic);
		
		labHansic.setFocusable(false);
		labHansic.setContentAreaFilled(false);
		labHansic.setBorderPainted(false);
		try {
			String btnImageName = "koreanFoodImage.png";
			URL url = FoodMain.class.getResource("/img/user/"+btnImageName);
			BufferedImage bufferedImage = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(labHansic.getWidth()+10, labHansic.getHeight()+10, Image.SCALE_SMOOTH));
			labHansic.setIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		labHansicName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		labHansicName.setOpaque(true);
		labHansicName.setBackground(Color.WHITE);
		labHansicName.setHorizontalAlignment(SwingConstants.CENTER);
		labHansicName.setBounds(15, 210, 280, 50);
		pKorean.add(labHansicName);
		
		labJoongsic.setName("2");
		
		RoundPanel pChinese = new RoundPanel(4, 50);
		pChinese.setBackground(Color.WHITE);
		pChinese.setBounds(545, 23, 310, 270);
		add(pChinese);
		pChinese.setLayout(null);
		
		
		labJoongsic.setToolTipText("\uC911\uC2DD");
		labJoongsic.setBounds(15, 10, 280, 200);
		labJoongsic.setBackground(Color.WHITE);
		labJoongsic.setCursor(hand);
		labJoongsic.setFocusable(false);
		labJoongsic.setContentAreaFilled(false);
		labJoongsic.setBorderPainted(false);
		pChinese.add(labJoongsic);
		try {
			String btnImageName = "chineseFoodImage.png";
			URL url = FoodMain.class.getResource("/img/user/"+btnImageName);
			BufferedImage bufferedImage = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(labJoongsic.getWidth(), labJoongsic.getHeight(), Image.SCALE_SMOOTH));
			labJoongsic.setIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//chineseFoodImage
		
		
		JLabel label_3 = new JLabel("\uC911  \uC2DD");
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		label_3.setOpaque(true);
		label_3.setBackground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(15, 210, 280, 50);
		pChinese.add(label_3);
		
		RoundPanel pJapanese = new RoundPanel(4, 50);
		pJapanese.setBackground(Color.WHITE);
		pJapanese.setBounds(130, 320, 310, 270);
		add(pJapanese);
		pJapanese.setLayout(null);
		
		
		labIlsic.setToolTipText("\uC77C\uC2DD");
		labIlsic.setBackground(Color.WHITE);
		labIlsic.setBounds(15, 10, 280, 200);
		labIlsic.setCursor(hand);
		pJapanese.add(labIlsic);
		labIlsic.setFocusable(false);
		labIlsic.setContentAreaFilled(false);
		labIlsic.setBorderPainted(false);
		try {
			String btnImageName = "japaneseFoodImage.png";
			URL url = FoodMain.class.getResource("/img/user/"+btnImageName);
			BufferedImage bufferedImage = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(labIlsic.getWidth(), labIlsic.getHeight(), Image.SCALE_SMOOTH));
			labIlsic.setIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		JLabel label_4 = new JLabel("\uC77C  \uC2DD");
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		label_4.setOpaque(true);
		label_4.setBackground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(15, 210, 280, 50);
		pJapanese.add(label_4);
		
		RoundPanel pAmerican = new RoundPanel(4, 50);
		pAmerican.setBackground(Color.WHITE);
		pAmerican.setBounds(545, 321, 310, 270);
		add(pAmerican);
		pAmerican.setLayout(null);
		
		
		labYangsic.setToolTipText("\uC591\uC2DD");
		labYangsic.setBounds(15, 10, 280, 200);
		labYangsic.setCursor(hand);
		pAmerican.add(labYangsic);
		labYangsic.setFocusable(false);
		labYangsic.setContentAreaFilled(false);
		labYangsic.setBorderPainted(false);
		try {
			String btnImageName = "americanFoodImage.png";
			URL url = FoodMain.class.getResource("/img/user/"+btnImageName);
			BufferedImage bufferedImage = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(labYangsic.getWidth(), labYangsic.getHeight(), Image.SCALE_SMOOTH));
			labYangsic.setIcon(icon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//americanFoodImage
		
		JLabel label_5 = new JLabel("\uC591  \uC2DD");
		label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		label_5.setOpaque(true);
		label_5.setBackground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(15, 210, 280, 50);
		pAmerican.add(label_5);
		setVisible(true);
		
		//¿Ã∫•∆Æ µÓ∑œ
	}
}
