package kitri.foodCourt.management.member;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class RemoveMember extends JPanel {

	/**
	 * Create the panel.
	 */
	public RemoveMember() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 27, 430, 90);
		add(panel);
		
		JLabel label = new JLabel("\uC0AD\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 430, 90);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(12, 127, 430, 90);
		add(panel_1);
		
		JButton button = new JButton("Cancel");
		button.setActionCommand("Cancel");
		button.setBounds(225, 10, 170, 50);
		panel_1.add(button);
		
		JButton button_1 = new JButton("OK");
		button_1.setActionCommand("OK");
		button_1.setBounds(40, 10, 170, 50);
		panel_1.add(button_1);

	}

}
