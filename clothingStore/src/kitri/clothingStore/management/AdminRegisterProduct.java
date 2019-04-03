package kitri.clothingStore.management;

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


public class AdminRegisterProduct extends JPanel {

	JPanel picturePanel = new JPanel();

	JComboBox categoryComboBox = new JComboBox(new String[] {"반팔", "긴팔", "반바지", "긴바지", "모자", "아우터"});
	JComboBox sizeComboBox = new JComboBox(new Object[]{"S", "M", "L", "XL", "XXL"});
	JComboBox productNationComboBox = new JComboBox(new Object[]{"한국", "중국", "일본", "러시아", "영국", "독일", "스페인"});
	
	JLabel pictureLabel = new JLabel("\uC0AC\uC9C4");
	JLabel productCodeLabel = new JLabel("\uC0C1\uD488\uCF54\uB4DC");
	JLabel productNameLabel = new JLabel("\uC0C1\uD488\uBA85");
	JLabel productCostLabel = new JLabel("\uD310\uB9E4\uAC00\uACA9");
	JLabel quantityLabel = new JLabel("\uC218\uB7C9");
	JLabel colorCodeLabel = new JLabel("\uC0C9\uC0C1\uCF54\uB4DC");
	JLabel sizeLabel = new JLabel("\uCE58\uC218 / \uD06C\uAE30");
	JLabel cautionLabel = new JLabel("\uC8FC\uC758\uC0AC\uD56D");
	JLabel productNationLabel = new JLabel("\uC81C\uC870\uAD6D\uAC00");

	JButton isDuplicateCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
	JButton registerImageBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
	JButton confirmBtn = new JButton("\uB4F1\uB85D");
	JButton cancelBtn = new JButton("\uCDE8\uC18C");
	
	JTextField productCodeTextField = new JTextField();
	JTextField productNameTextField = new JTextField();
	JTextField productCostTextField = new JTextField();
	JTextField quantityTextField = new JTextField();
	JTextField colorCodeTextField = new JTextField();
	JTextField cautionTextField = new JTextField();
	
	
	/**
	 * Create the panel.
	 */
	public AdminRegisterProduct() {
		setSize(new Dimension(750, 650));
		setLayout(null);
		
		productCodeTextField.setText("\uCE74\uD14C\uACE0\uB9AC - 6\uC790\uB9AC \uB09C\uC218 - \uCE58\uC218/\uD06C\uAE30 - \uC81C\uC870\uAD6D\uAC00");
		productCodeTextField.setEditable(false);
		
		productCodeTextField.setBounds(300, 40, 290, 40);
		productCodeTextField.setColumns(10);
		add(productCodeTextField);
		
		picturePanel.setBounds(40, 40, 130, 155);
		picturePanel.setLayout(new BorderLayout(0, 0));
		add(picturePanel);
		
		pictureLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picturePanel.add(pictureLabel, BorderLayout.CENTER);
		
		registerImageBtn.setBounds(40, 215, 130, 40);
		add(registerImageBtn);
		
		categoryComboBox.setBorder(new LineBorder(Color.BLACK));
		categoryComboBox.setBounds(40, 300, 130, 34);
		add(categoryComboBox);
		
		productCodeLabel.setBounds(213, 40, 80, 40);
		add(productCodeLabel);
		
		isDuplicateCheckBtn.setBounds(620, 40, 100, 40);
		add(isDuplicateCheckBtn);
		
		productNameLabel.setBounds(213, 110, 80, 40);
		productNameTextField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		add(productNameLabel);
		
		productNameTextField.setColumns(10);
		productNameTextField.setBounds(300, 110, 290, 40);
		add(productNameTextField);
		
		productCostLabel.setBounds(213, 180, 80, 40);
		productCostTextField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		add(productCostLabel);

		productCostTextField.setColumns(10);
		productCostTextField.setBounds(300, 180, 290, 40);
		add(productCostTextField);
		
		quantityLabel.setBounds(213, 250, 80, 40);
		quantityTextField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		add(quantityLabel);
		
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(300, 250, 290, 40);
		add(quantityTextField);
		
		colorCodeLabel.setBounds(213, 320, 80, 40);
		colorCodeTextField.setText("#FFFFFF");
		add(colorCodeLabel);
		
		colorCodeTextField.setColumns(10);
		colorCodeTextField.setBounds(300, 320, 290, 40);
		add(colorCodeTextField);
		
		cautionLabel.setBounds(213, 460, 80, 40);
		cautionTextField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		add(cautionLabel);
		
		cautionTextField.setColumns(10);
		cautionTextField.setBounds(300, 460, 290, 40);
		add(cautionTextField);
		
		sizeLabel.setBounds(213, 390, 80, 40);
		add(sizeLabel);
		
		sizeComboBox.setBorder(new LineBorder(Color.BLACK));
		sizeComboBox.setBounds(300, 390, 90, 40);
		add(sizeComboBox);
		
		productNationLabel.setBounds(433, 390, 65, 40);
		add(productNationLabel);
		
		productNationComboBox.setBorder(new LineBorder(Color.BLACK));
		productNationComboBox.setBounds(500, 390, 90, 40);
		add(productNationComboBox);
		
		confirmBtn.setBounds(240, 550, 120, 50);
		add(confirmBtn);
		
		cancelBtn.setBounds(420, 550, 120, 50);
		add(cancelBtn);
	}
}
