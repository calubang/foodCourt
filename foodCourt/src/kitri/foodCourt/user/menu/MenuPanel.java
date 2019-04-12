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
	public int thickness;
	public int arc;
	/**
	 * Create the panel.
	 */

	public MenuPanel(ImageIcon roperImg, String foodName) {
		setBackground(Color.WHITE);
		
		btnImg = new MenuButton(roperImg);
		labName = new JLabel(foodName);
		labName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		labName.setHorizontalAlignment(SwingConstants.CENTER);
		btnImg.setCursor(cursor);
		setMaximumSize(ds);
		setPreferredSize(ds);
		setLayout(null);
		btnImg.setFocusPainted(false);
		btnImg.setContentAreaFilled(false);
		btnImg.setBorderPainted(false);
		btnImg.setBounds(10, 10, 165, 130);
		labName.setBounds(10, 140, 165, 40);
		add(btnImg, "Center");
		add(labName, "South");
		
		setVisible(true);
		btnImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		thickness = 3;
		arc = 40;
		// ¿Ã∫•∆Æ µÓ∑œ∫Œ
		
//		MenuClickController
//		label.addMouseListener(l);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(getBackground());
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
	}
	
	@Override
	protected void paintChildren(Graphics g) {

		super.paintChildren(g);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(getForeground());
		graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		graphics2d.setStroke(new BasicStroke(thickness));
	}
	
}
