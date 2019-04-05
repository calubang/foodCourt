package kitri.foodCourt.user.basket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import kitri.foodCourt.user.swing.FLabel;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import kitri.foodCourt.user.swing.FButton;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
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
		JButton btnNewButton = new JButton("∏ﬁ¿Œ∏ﬁ¥∫", new ImageIcon("C:\\Users\\Administrator\\Desktop\\home.png"));
		btnNewButton.setBounds(12, 10, 120, 59);
		btnNewButton.setBorderPainted(false);
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778\uBA54\uB274");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 71, 120, 20);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.PLAIN, 30));
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(160, 118, 1012, 634);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(main.class.getResource("/kitri/foodCourt/user/basket/image/Basket1.png")));
		lblNewLabel_2.setBounds(12, 10, 120, 100);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(12, 120, 988, 6);
		panel_4.add(panel_1);
		
		FLabel label = new FLabel();
		label.setFont(new Font("±º∏≤", Font.BOLD, 40));
		label.setText("\uC7A5\uBC14\uAD6C\uB2C8");
		label.setBounds(144, 10, 178, 100);
		panel_4.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaptionBorder);
		panel_7.setBounds(12, 132, 988, 64);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		FButton btnAllCancel = new FButton();
		btnAllCancel.setSelectedIcon(null);
		btnAllCancel.setContentAreaFilled(false);
		btnAllCancel.setBorderPainted(false);
		btnAllCancel.setFocusPainted(false);
		//btnAllCancel.setIcon(new ImageIcon(main.class.getResource("/kitri/foodCourt/user/basket/image/x_button.png")));
		ImageIcon btnAllCancelBasic = new ImageIcon(main.class.getResource("/kitri/foodCourt/user/basket/image/x_button.png"));
		ImageIcon btnAllCancelEntered = new ImageIcon(main.class.getResource("/kitri/foodCourt/user/basket/image/x_button2.png"));
		btnAllCancel.setBasic(btnAllCancelBasic);
		btnAllCancel.setEntered(btnAllCancelEntered);
		btnAllCancel.setBounds(29, 10, 45, 45);
		panel_7.add(btnAllCancel);
		
		FLabel label_1 = new FLabel();
		label_1.setFont(new Font("±º∏≤", Font.BOLD, 30));
		label_1.setText("\uC0C1\uD488\uC815\uBCF4");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(213, 10, 134, 45);
		panel_7.add(label_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 206, 988, 130);
		panel_4.add(panel_8);
		
		ImageIcon main = new ImageIcon("C:\\Users\\Administrator\\Desktop\\restaurant-895428__340.png");
	}
}
