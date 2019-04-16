package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

import kitri.foodCourt.util.Constance;

public class MenuButton extends JButton implements MouseListener{
	
	public int arc;
	public int thickness;
	public Color enterColor;
	public Color exitColor;
	public MouseListener controller;

	public MenuButton() {
		super();
		defaultSetting();
	}

	public MenuButton(Action a) {
		super(a);
		defaultSetting();
	}

	public MenuButton(Icon icon) {
		super(icon);
		defaultSetting();
	}

	public MenuButton(String text, Icon icon) {
		super(text, icon);
		defaultSetting();
	}

	public MenuButton(String text) {
		super(text);
		defaultSetting();
	}
	
	public MenuButton(int thickness, int arc) {
		this.arc = arc;
		this.thickness = thickness;
		defaultSetting();
	}
	
	public void defaultSetting() {
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		//this.enterColor = SwingFactory.hexToRgb("#FFF8DC");
		this.enterColor = Constance.MAIN_COLOR;
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//배경색 칠하기
		
		if(getIcon() == null) {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		}else {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
			super.paintComponent(g);
		}
		g.setColor(getForeground());
		g.setFont(getFont());
		//안에 글자 넣기
		int length = getText().length();
		int size = getFont().getSize();
		if(length % 2 == 1) {
			length += 1;
		}
		if(size % 2 == 1) {
			size += 1;
		}
		g.drawString(getText(), getWidth()/2-(length*size)/2, getHeight()/2+getFont().getSize()/2);

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		MenuButton button = (MenuButton)e.getComponent();
		if(enterColor != null) {
			button.setBackground(enterColor);
			button.getParent().setBackground(enterColor);
		}else {
			button.getParent().setBackground(SystemColor.inactiveCaptionBorder);
			button.setBackground(SystemColor.inactiveCaptionBorder);
		}
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		MenuButton button = (MenuButton)e.getComponent();
		if(exitColor != null) {
			button.setBackground(exitColor);
			button.getParent().setBackground(exitColor);
		}else {
			button.getParent().setBackground(Color.WHITE);
			button.setBackground(Color.WHITE);
		}
	}
}
