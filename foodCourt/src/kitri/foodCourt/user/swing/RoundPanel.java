package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class RoundPanel extends JPanel implements MouseListener{

	int thickness;
	int arc;
	Graphics2D graphics2D;
	
	public RoundPanel() {
		super();
		thickness = 3;
		arc = 50;
		// TODO Auto-generated constructor stub
	}

	public RoundPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
		
	}

	public RoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public RoundPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	public RoundPanel(int thickness, int arc) {
		this.thickness = thickness;
		this.arc = arc;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		this.graphics2D = graphics2d;
		graphics2d.setColor(getBackground());
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
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
		graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		graphics2d.setStroke(new BasicStroke(thickness));
		//super.paintBorder(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
//		thickness = 5;
//		Graphics2D g = (Graphics2D)this.getGraphics();
//		g.setStroke(new BasicStroke(thickness));
//		paintBorder(g);
		//setBackground(Color.RED);
		//setForeground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		thickness = 3;
//		Graphics2D g = (Graphics2D)this.getGraphics();
//		g.setStroke(new BasicStroke(thickness));
//		paintBorder(g);
	}

//	public boolean contains(int x, int y) {
//		if (shape == null || !shape.getBounds().equals(getBounds())) {
//			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//		}
//		return shape.contains(x, y);
//	}
	
}
