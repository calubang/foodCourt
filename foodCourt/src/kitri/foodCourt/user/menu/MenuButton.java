package kitri.foodCourt.user.menu;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuButton extends JButton {
	private String food_id; // 버튼이 갖고 있을 만한 정보\
	
	public MenuButton(String name) {
		setText(name);
		setMaximumSize(new Dimension(190, 190));
		setPreferredSize(new Dimension(190, 190));
		setVerticalAlignment(SwingConstants.BOTTOM);
	}
}
