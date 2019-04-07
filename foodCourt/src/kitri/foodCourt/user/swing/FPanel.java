package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.*;

public class FPanel extends JPanel implements MouseListener{
	
	Border basic;
	Border entered;
	
	public FPanel() {
		super();
		addListener();
	}

	public FPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		addListener();
	}

	public FPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		addListener();
	}

	public FPanel(LayoutManager layout) {
		super(layout);
		addListener();
	}

	public void addListener() {
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		basic = this.getBorder();
		if(entered != null) {
			setBorder(entered);
		}else {
			setBorder(new LineBorder(Color.BLACK, 2, true));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(basic != null) {
			setBorder(basic);
		}else {
			setBorder(new LineBorder(Color.BLACK, 0, true));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
}
