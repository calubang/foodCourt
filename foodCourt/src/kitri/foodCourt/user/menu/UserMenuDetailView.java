package kitri.foodCourt.user.menu;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UserMenuDetailView extends JPanel {
	private JTextField textField;
	private FoodDto foodDto = null ;
	/**
	 * Create the panel.
	 */
	public UserMenuDetailView() {
		setLayout(null);
		
		JButton menuImage = new JButton("\uC74C\uC2DD\uC774\uBBF8\uC9C0");
		menuImage.setBounds(23, 24, 443, 390);
		add(menuImage);
		
		JLabel lblNewLabel = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(504, 24, 443, 86);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC00\uACA9");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(542, 143, 173, 50);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC81C\uC870\uC6D0");
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setBounds(737, 143, 173, 50);
		add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\uBA54\uB274 \uC124\uBA85");
		lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(542, 216, 368, 135);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uB7C9");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.CYAN);
		lblNewLabel_3.setBounds(542, 372, 90, 42);
		add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(644, 372, 4, 42);
		add(panel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("\uC218\uB7C9\uC744\uC785\uB825\uD574\uC8FC\uC138\uC694");
		textField.setBounds(659, 372, 251, 42);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uC774\uC804\uC73C\uB85C");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		btnNewButton_1.setBounds(313, 458, 153, 62);
		add(btnNewButton_1);
		
		JButton button = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 \uB2F4\uAE30");
		button.setBackground(Color.DARK_GRAY);
		
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		button.setBounds(520, 458, 153, 62);
		add(button);
		setVisible(true);
	}
}
