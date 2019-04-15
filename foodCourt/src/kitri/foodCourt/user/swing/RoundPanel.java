package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class RoundPanel extends JPanel implements MouseListener{

	private int thickness;
	private int arc;
	private MouseListener controller;
	private Color enterColor;
	private Color exitColor;
	
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
	}
	
	public void defaultSetting() {
		this.setBorder(new RoundBorder(arc, thickness));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(this);
		this.enterColor = hexToRgb("#FFF8DC");
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
		RoundPanel panel = (RoundPanel)e.getComponent();
		if(enterColor != null) {
			panel.setBackground(enterColor);
		}else {
			panel.setBackground(SystemColor.inactiveCaptionBorder);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		RoundPanel panel = (RoundPanel)e.getComponent();
		if(exitColor != null) {
			panel.setBackground(exitColor);
		}else {
			panel.setBackground(Color.WHITE);
		}
	}

	public static Color hexToRgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	} 
	
}
