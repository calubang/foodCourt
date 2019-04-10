package kitri.foodCourt.user.menu;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class NoSearchMenuImg extends JPanel {

	/**
	 * Create the panel.
	 */
	public NoSearchMenuImg() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메뉴가 없습니다.");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 141, 745, 323);
		add(lblNewLabel);

	}
}
