package kitri.foodCourt.user.menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class MenuPanel extends JPanel {
	JButton btnImg;
	JLabel labName;
	Dimension ds = new Dimension(185, 190);
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	/**
	 * Create the panel.
	 */

	public MenuPanel(ImageIcon roperImg, String foodName) {
		setBackground(Color.WHITE);
		
		btnImg = new MenuButton(roperImg);
		labName = new JLabel(foodName);
		labName.setFont(new Font("굴림", Font.PLAIN, 16));
		labName.setHorizontalAlignment(SwingConstants.CENTER);
		btnImg.setCursor(cursor);
		setMaximumSize(ds);
		setPreferredSize(ds);
		setLayout(new BorderLayout());
		add(btnImg, "Center");
		add(labName, "South");
		
		setVisible(true);
		btnImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// 이벤트 등록부
		
//		MenuClickController
//		label.addMouseListener(l);
	}
}
