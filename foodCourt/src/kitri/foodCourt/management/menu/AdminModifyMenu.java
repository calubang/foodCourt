package kitri.foodCourt.management.menu;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class AdminModifyMenu extends JPanel {

	JPanel picturePanel = new JPanel();

	JComboBox<String> categoryComboBox = new JComboBox<String>(new String[] {"한식", "중식", "일식", "양식"});
	
	JLabel pictureLabel = new JLabel("\uC0AC\uC9C4");
	JLabel menuNameLabel = new JLabel("\uBA54\uB274\uBA85");
	JLabel priceLabel = new JLabel("\uD310\uB9E4\uAC00\uACA9");
	JLabel pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	JLabel descriptionLabel = new JLabel("\uC124\uBA85");
	JLabel menuCodeLabel = new JLabel("\uBA54\uB274\uCF54\uB4DC");
	JLabel enableLabel = new JLabel("\uD310\uB9E4 \uC5EC\uBD80");
	
	JButton changeImageBtn = new JButton("\uC0AC\uC9C4\uBCC0\uACBD");
	JButton confirmBtn = new JButton("\uC218\uC815");
	JButton cancelBtn = new JButton("\uCDE8\uC18C");
	
	JTextField menuNameTextField = new JTextField();
	JTextField priceTextField = new JTextField();
	JTextField pointTextField = new JTextField();
	JTextField menuCodeTextField = new JTextField();
	
	JTextArea descriptionTextArea = new JTextArea();
	
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox checkBox1 = new Checkbox("판매 가능", cg, true);
	Checkbox checkBox2 = new Checkbox("판매 불가능", cg, false);
	
	
	/**
	 * Create the panel.
	 */
	public AdminModifyMenu() {
		setSize(new Dimension(750, 650));
		setLayout(null);
		
		menuNameTextField.setText("내용을 입력해주세요.");
		menuNameTextField.setBounds(384, 110, 290, 40);
		menuNameTextField.setColumns(10);
		add(menuNameTextField);
		
		pictureLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);

		picturePanel.setBounds(40, 40, 205, 213);
		picturePanel.setLayout(new BorderLayout(0, 0));
		picturePanel.add(pictureLabel, BorderLayout.CENTER);
		add(picturePanel);
		
		changeImageBtn.setBounds(40, 289, 205, 40);
		add(changeImageBtn);
		
		categoryComboBox.setBorder(new LineBorder(Color.BLACK));
		categoryComboBox.setBounds(40, 375, 205, 34);
		add(categoryComboBox);
		
		menuNameLabel.setBounds(297, 110, 80, 40);
		add(menuNameLabel);
		
		priceLabel.setBounds(297, 180, 80, 40);
		priceTextField.setText("내용을 입력해주세요.");
		add(priceLabel);

		priceTextField.setColumns(10);
		priceTextField.setBounds(384, 180, 290, 40);
		add(priceTextField);
		
		pointLabel.setBounds(297, 250, 80, 40);
		pointTextField.setText("기본값이 있지만 따로 더 주고 싶을 때");
		add(pointLabel);
		
		pointTextField.setColumns(10);
		pointTextField.setBounds(384, 250, 290, 40);
		add(pointTextField);
		
		confirmBtn.setBounds(240, 550, 120, 50);
		add(confirmBtn);
		
		cancelBtn.setBounds(420, 550, 120, 50);
		add(cancelBtn);
		
		descriptionLabel.setBounds(297, 390, 80, 40);
		add(descriptionLabel);
		
		descriptionTextArea.setText("해당 음식에 대한 가벼운 설명");
		descriptionTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		descriptionTextArea.setBounds(384, 390, 290, 100);
		add(descriptionTextArea);
		
		menuCodeLabel.setBounds(297, 40, 80, 40);
		add(menuCodeLabel);
		
		menuCodeTextField.setEditable(false);
		menuCodeTextField.setText("수정불가");
		menuCodeTextField.setColumns(10);
		menuCodeTextField.setBounds(384, 40, 290, 40);
		add(menuCodeTextField);
		
		enableLabel.setBounds(297, 320, 80, 40);
		add(enableLabel);
		checkBox1.setLocation(384, 320);
		checkBox1.setSize(80, 40);
		
		add(checkBox1);
		checkBox2.setSize(80, 40);
		checkBox2.setLocation(485, 320);
		add(checkBox2);
	}
}
