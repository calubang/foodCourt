package kitri.foodCourt.user.menu;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class FoodMainView extends JPanel {
	public Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	public JButton labHansic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/hansic.jpg")));
	public JLabel labHansicName = new JLabel("\uD55C\uC2DD");
	public JButton labIlsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/ilsic.jpg")));
	public JButton labJoongsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/joongsic.jpg")));
	public JButton labYangsic = new MainButton(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/yangsic.jpeg")));
	public FoodMainView() {
		
		labHansic.setName("1");
		labJoongsic.setName("2");
		labIlsic.setName("3");
		labYangsic.setName("4");
		
		setBackground(Color.WHITE);
		setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(107, 23, 330, 288);
		add(panel);
		panel.setLayout(null);
		
		
		labHansic.setToolTipText("\uD55C\uC2DD");
		labHansic.setBounds(0, 0, 330, 251);
		labHansic.setCursor(hand);
		panel.add(labHansic);
		labHansicName.setFont(new Font("±º∏≤", Font.BOLD, 20));
		
		
		labHansicName.setOpaque(true);
		labHansicName.setBackground(Color.WHITE);
		labHansicName.setHorizontalAlignment(SwingConstants.CENTER);
		labHansicName.setBounds(0, 250, 330, 38);

		panel.add(labHansicName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(107, 321, 330, 288);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		labIlsic.setToolTipText("\uC77C\uC2DD");
		labIlsic.setBounds(0, 0, 330, 251);
		labIlsic.setCursor(hand);
		panel_1.add(labIlsic);
		
		JLabel label_4 = new JLabel("\uC77C\uC2DD");
		label_4.setFont(new Font("±º∏≤", Font.BOLD, 20));
		label_4.setOpaque(true);
		label_4.setBackground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 250, 330, 38);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(575, 23, 330, 288);
		add(panel_2);
		panel_2.setLayout(null);
		
		
		labJoongsic.setToolTipText("\uC911\uC2DD");
		labJoongsic.setBounds(0, 0, 330, 251);
		labJoongsic.setCursor(hand);
		panel_2.add(labJoongsic);
		
		JLabel label_3 = new JLabel("\uC911\uC2DD");
		label_3.setFont(new Font("±º∏≤", Font.BOLD, 20));
		label_3.setOpaque(true);
		label_3.setBackground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 250, 330, 38);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(575, 321, 330, 288);
		add(panel_3);
		panel_3.setLayout(null);
		
		
		labYangsic.setToolTipText("\uC591\uC2DD");
		labYangsic.setBounds(0, 0, 330, 251);
		labYangsic.setCursor(hand);
		panel_3.add(labYangsic);
		
		JLabel label_5 = new JLabel("\uC591\uC2DD");
		label_5.setFont(new Font("±º∏≤", Font.BOLD, 20));
		label_5.setOpaque(true);
		label_5.setBackground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 250, 330, 38);
		panel_3.add(label_5);
		setVisible(true);
		
		//¿Ã∫•∆Æ µÓ∑œ
	}
}
