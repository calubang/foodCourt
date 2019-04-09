package kitri.foodCourt.user.menu;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel {
	private JLabel labImg;
	private JLabel labName;
	private Dimension ds = new Dimension(190, 190);
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	/**
	 * Create the panel.
	 */

	public MenuPanel(ImageIcon roperImg) {
		setBackground(Color.WHITE);
		
		labImg = new JLabel(roperImg);
		labName = new JLabel("test");
		labName.setFont(new Font("굴림", Font.PLAIN, 16));
		labName.setHorizontalAlignment(SwingConstants.CENTER);
		labImg.setCursor(cursor);
		labName.setCursor(cursor);
		setMaximumSize(ds);
		setPreferredSize(ds);
		setLayout(new BorderLayout());
		add(labImg, "Center");
		add(labName, "South");
		setVisible(true);
		
		// 이벤트 등록부
		
//		MenuClickController
//		label.addMouseListener(l);
	}
}
