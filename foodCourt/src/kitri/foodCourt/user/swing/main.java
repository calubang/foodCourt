package kitri.foodCourt.user.swing;

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
		JButton btnNewButton = new JButton("메인메뉴", new ImageIcon("C:\\Users\\Administrator\\Desktop\\home.png"));
		btnNewButton.setBounds(12, 10, 120, 59);
		btnNewButton.setBorderPainted(false);
		panel_2.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778\uBA54\uB274");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 71, 120, 20);
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(160, 118, 1012, 634);
		panel.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
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
		
		ImageIcon main = new ImageIcon("C:\\Users\\Administrator\\Desktop\\restaurant-895428__340.png");
	}
}
