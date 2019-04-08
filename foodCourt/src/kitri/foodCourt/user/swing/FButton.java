package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class FButton extends JButton implements MouseListener{
	
	private ImageIcon basic = null;
	private ImageIcon entered = null;
	
	//생성자
	public FButton() {
		super();
		basic();
	}

	public FButton(Action arg0) {
		super(arg0);
		basic();
	}

	public FButton(Icon icon) {
		super(icon);
		basic();
	}

	public FButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		basic();
	}

	public FButton(String arg0) {
		super(arg0);
		basic();
	}
	
	public FButton(ImageIcon basic, ImageIcon entered) {
		super();
		basic();
		setBasic(basic);
		setEntered(entered);
	}
	public void basic() {
		this.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public ImageIcon getBasic() {
		return basic;
	}

	public void setBasic(ImageIcon basic) {
		this.basic = basic;
		setIcon(basic);
	}

	public ImageIcon getEntered() {
		return entered;
	}

	public void setEntered(ImageIcon entered) {
		this.entered = entered;
	}
	
	@Override
	public void setIcon(Icon defaultIcon) {
		super.setIcon(defaultIcon);
	}

	//마우스이벤트등록
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		FButton button = (FButton)e.getSource();
		if(this.entered != null) {
			button.setIcon(entered);
		}else {
			button.setBorder(new LineBorder(Color.BLACK, 2));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		FButton button = (FButton)e.getSource();
		if(this.basic != null) {
			button.setIcon(basic);
		}else {
			button.setBorder(new LineBorder(Color.BLACK, 1));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
