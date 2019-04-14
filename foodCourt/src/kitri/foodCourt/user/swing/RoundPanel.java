package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import oracle.core.lmx.CoreException;

public class RoundPanel extends JPanel implements MouseListener{

	int thickness;
	int arc;
	Graphics2D graphics2D;
	private MouseListener controller;
	
	public RoundPanel() {
		super();
		thickness = 3;
		arc = 50;
		defaultSetting();
	}

	public RoundPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		defaultSetting();
	}

	public RoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		defaultSetting();
	}

	public RoundPanel(LayoutManager layout) {
		super(layout);
		defaultSetting();
	}
	
	public RoundPanel(int thickness, int arc) {
		this.thickness = thickness;
		this.arc = arc;
		defaultSetting();
		//setMouseListener();
	}
	
	public void defaultSetting() {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void setMouseListener() {
		this.addMouseListener(this);
	}
	
	public void setController(MouseListener controller) {
		this.controller = controller;
	} 
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(getBackground());
		graphics2d.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		//hexToRgb("#FFF8DC")
		//graphics2d.setStroke(new BasicStroke(thickness));
		//graphics2d.setColor(getForeground());
		//graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		//Graphics2D graphics2d = (Graphics2D) g;
		//graphics2d.setBackground(new Color(255, 255, 240));
		//graphics2d.setColor(new Color(255, 255, 240));
		//graphics2d.fillRoundRect(1, 1, getWidth()-3, getHeight()-3, 50, 50);
		super.paintChildren(g);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(getForeground());
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		//super.paintBorder(g);
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
		e.getComponent().setBackground(hexToRgb("#FFF8DC"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setBackground(Color.WHITE);
	}

	public static Color hexToRgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	} 
	
}
