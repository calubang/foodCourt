package kitri.foodCourt.user.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FButton extends JButton implements MouseListener{
	
	private ImageIcon basic = null;
	private ImageIcon entered = null;
	
	//생성자
	public FButton() {
		super();
		this.addMouseListener(this);
	}

	public FButton(Action arg0) {
		super(arg0);
	}

	public FButton(Icon arg0) {
		super(arg0);
	}

	public FButton(String arg0, Icon arg1) {
		super(arg0, arg1);
	}

	public FButton(String arg0) {
		super(arg0);
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

	//마우스이벤트등록
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		FButton button = (FButton)e.getSource();
		if(this.entered != null) {
			button.setIcon(entered);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		FButton button = (FButton)e.getSource();
		if(this.entered != null) {
			button.setIcon(basic);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
