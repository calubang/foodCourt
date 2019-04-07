package kitri.foodCourt.user.swing;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FPanel extends JPanel implements MouseListener{
	
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
		setBorder(new LineBorder(Color.BLACK, 2));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(new LineBorder(Color.BLACK, 0));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
}
