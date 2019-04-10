package kitri.foodCourt.management.menu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class AdminRegisterMenu extends JPanel {

	JPanel picturePanel = new JPanel();

	JComboBox<String> categoryComboBox = new JComboBox<String>(new String[] {"한식", "중식", "일식", "양식"});
	
	JLabel pictureLabel = new JLabel("\uC0AC\uC9C4");
	JLabel menuNameLabel = new JLabel("\uBA54\uB274\uBA85");
	JLabel priceLabel = new JLabel("\uD310\uB9E4\uAC00\uACA9");
	JLabel pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	JLabel descriptionLabel = new JLabel("\uC124\uBA85");
	
	JButton registerImageBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
	JButton confirmBtn = new JButton("\uB4F1\uB85D");
	JButton cancelBtn = new JButton("\uCDE8\uC18C");
	
	JTextField menuNameTextField = new JTextField();
	JTextField priceTextField = new JTextField();
	JTextField pointTextField = new JTextField();
	
	JTextArea descriptionTextArea = new JTextArea();
	
	
	/**
	 * Create the panel.
	 */
	public AdminRegisterMenu() {
		setSize(new Dimension(750, 650));
		setLayout(null);
		
		menuNameTextField.setText("");
		menuNameTextField.setBounds(384, 40, 290, 40);
		menuNameTextField.setColumns(10);
		add(menuNameTextField);
		
		pictureLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);

		picturePanel.setBounds(40, 40, 205, 213);
		picturePanel.setLayout(new BorderLayout(0, 0));
		picturePanel.add(pictureLabel, BorderLayout.CENTER);
		add(picturePanel);
		
		registerImageBtn.setBounds(40, 289, 205, 40);
		add(registerImageBtn);
		
		categoryComboBox.setBorder(new LineBorder(Color.BLACK));
		categoryComboBox.setBounds(40, 375, 205, 34);
		add(categoryComboBox);
		
		menuNameLabel.setBounds(297, 40, 80, 40);
		add(menuNameLabel);
		
		priceLabel.setBounds(297, 110, 80, 40);
		priceTextField.setText("");
		add(priceLabel);

		priceTextField.setColumns(10);
		priceTextField.setBounds(384, 110, 290, 40);
		add(priceTextField);
		
		pointLabel.setBounds(297, 180, 80, 40);
		pointTextField.setText("");
		add(pointLabel);
		
		pointTextField.setColumns(10);
		pointTextField.setBounds(384, 180, 290, 40);
		add(pointTextField);
		
		confirmBtn.setBounds(240, 550, 120, 50);
		add(confirmBtn);
		
		cancelBtn.setBounds(420, 550, 120, 50);
		add(cancelBtn);
		
		descriptionLabel.setBounds(297, 250, 80, 40);
		add(descriptionLabel);
		
		descriptionTextArea.setText("");
		descriptionTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		descriptionTextArea.setBounds(384, 250, 290, 240);
		descriptionTextArea.setLineWrap(true);
		add(descriptionTextArea);
	}
}
