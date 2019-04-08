package kitri.foodCourt.user.menu;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FoodMainView extends JPanel {
	public FoodMainView() {
		setBounds(160, 118, 1012, 634);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(107, 23, 330, 288);
		add(panel);
		panel.setLayout(null);
		
		JLabel hansic = new JLabel(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/hansic.jpg")));
		hansic.setToolTipText("\uD55C\uC2DD");
		hansic.setBounds(0, 0, 330, 251);
		panel.add(hansic);
		
		JLabel lblNewLabel_1 = new JLabel("\uD55C\uC2DD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 250, 330, 38);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(107, 321, 330, 288);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel ilsic = new JLabel(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/ilsic.jpg")));
		ilsic.setToolTipText("\uC77C\uC2DD");
		ilsic.setBounds(0, 0, 330, 251);
		panel_1.add(ilsic);
		
		JLabel label_4 = new JLabel("\uC77C\uC2DD");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 250, 330, 38);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(575, 23, 330, 288);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel joongsic = new JLabel(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/joongsic.jpg")));
		joongsic.setToolTipText("\uC911\uC2DD");
		joongsic.setBounds(0, 0, 330, 251);
		panel_2.add(joongsic);
		
		JLabel label_3 = new JLabel("\uC911\uC2DD");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 250, 330, 38);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(575, 321, 330, 288);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel yangsic = new JLabel(new ImageIcon(FoodMainView.class.getResource("/kitri/foodCourt/user/menu/mainImage/yangsic.jpeg")));
		yangsic.setToolTipText("\uC591\uC2DD");
		yangsic.setBounds(0, 0, 330, 251);
		panel_3.add(yangsic);
		
		JLabel label_5 = new JLabel("\uC591\uC2DD");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 250, 330, 38);
		panel_3.add(label_5);
		setVisible(true);
	}
}
