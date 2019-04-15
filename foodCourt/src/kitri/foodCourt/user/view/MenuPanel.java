package kitri.foodCourt.user.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import kitri.foodCourt.user.swing.*;

public class MenuPanel extends JPanel implements MouseListener{
	public JButton btnImg;
	public JLabel labName;
	public Dimension ds = new Dimension(185, 190);
	public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	public int thickness;
	public int arc;
	private MouseListener controller;
	private Color enterColor;
	private Color exitColor;
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
		
		this.thickness = 3;
		this.arc = 40;
		this.enterColor = SwingFactory.hexToRgb("#FFF8DC");
		setBorder(new RoundBorder(arc, thickness));
		this.addMouseListener(this);
		// ¿Ã∫•∆Æ µÓ∑œ∫Œ
		
//		MenuClickController
//		label.addMouseListener(l);
	}
	
//	@Override
//	protected void paintComponent(Graphics g) {
//		Graphics2D graphics2d = (Graphics2D) g;
//		graphics2d.setColor(getBackground());
//		graphics2d.setStroke(new BasicStroke(thickness));
//		graphics2d.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
//	}
//	
//	
//	@Override
//	protected void paintBorder(Graphics g) {
//		Graphics2D graphics2d = (Graphics2D) g;
//		graphics2d.setColor(getForeground());
//		graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
//		graphics2d.setStroke(new BasicStroke(thickness));
//	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(getBackground());
		graphics2d.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		Component component[] = getComponents();
		int len = component.length;
		for (int i = 0; i < len; i++) {
			component[i].setBackground(getBackground());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(controller != null) {
			controller.mouseClicked(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		MenuPanel panel = (MenuPanel)e.getComponent();
		if(enterColor != null) {
			panel.setBackground(enterColor);
		}else {
			panel.setBackground(SystemColor.inactiveCaptionBorder);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		MenuPanel panel = (MenuPanel)e.getComponent();
		if(exitColor != null) {
			panel.setBackground(exitColor);
		}else {
			panel.setBackground(Color.WHITE);
		}
	}
}
