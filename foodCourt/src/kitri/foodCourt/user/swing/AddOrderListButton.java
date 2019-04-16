package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.view.UserMenuDetailView;
import kitri.foodCourt.util.Constance;

public class AddOrderListButton extends JButton implements MouseListener{
	FoodDto foodDto;
	UserMenuDetailView userMenuDetailView;
	//라운드정도와 선의 두께
	public int arc;
	public int thickness;
	public Color enterColor;
	public Color exitColor;
	
	public AddOrderListButton(String text, UserMenuDetailView userMenuDetailView) {
		super(text);
		this.userMenuDetailView = userMenuDetailView;
		defaultSetting();
	}
	public FoodDto getFoodDto() {
		return this.foodDto;
	}
	public void setFoodDto(FoodDto foodDto) {
		this.foodDto = foodDto;
	}
	public int getCount() {
		return userMenuDetailView.getCount();
	}
	
	public AddOrderListButton() {
		super();
		defaultSetting();
	}

	public AddOrderListButton(Action a) {
		super(a);
		defaultSetting();
	}

	public AddOrderListButton(Icon icon) {
		super(icon);
		defaultSetting();
	}

	public AddOrderListButton(String text, Icon icon) {
		super(text, icon);
		defaultSetting();
	}

	public AddOrderListButton(String text) {
		super(text);
		defaultSetting();
	}
	
	public AddOrderListButton(int thickness, int arc) {
		this.arc = arc;
		this.thickness = thickness;
		defaultSetting();
	}
	
	public void defaultSetting() {
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.enterColor = Constance.MAIN_COLOR;
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//배경색 칠하기 button의 경우 이미지가 사용될 수도 있기에 따로 처리.
		if(getIcon() == null) {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		}else {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
			super.paintComponent(g);
		}
		
		//버튼안에 글자 구현부.. 위치는각자 입맛에 맞게 조절할것
		if(!getText().isEmpty()) {
			g.setColor(getForeground());
			g.setFont(getFont());
			int length = getText().length();
			int size = getFont().getSize();
			if(length % 2 == 1) {
				length += 1;
			}
			if(size % 2 == 1) {
				size += 1;
			}
			g.drawString(getText(), getWidth()/2-(length/2*size)+15, getHeight()/2+getFont().getSize()/2);
		}
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
		AddOrderListButton button = (AddOrderListButton)e.getComponent();
		if(enterColor != null) {
			button.setBackground(enterColor);
		}else {
			button.setBackground(SystemColor.inactiveCaptionBorder);
		}
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		AddOrderListButton button = (AddOrderListButton)e.getComponent();
		if(exitColor != null) {
			button.setBackground(exitColor);
		}else {
			button.setBackground(Color.WHITE);
		}
	}
	
}
