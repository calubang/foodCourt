package kitri.foodCourt.user.swing;

import java.awt.*;

import javax.swing.JPanel;

public class RoundPanel extends JPanel{

	public RoundPanel() {
		super();
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
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		//graphics2d.setBackground(Color.RED);
		graphics2d.setColor(getBackground());
		graphics2d.setStroke(new BasicStroke(3));
		graphics2d.fillRoundRect(1, 1, getWidth()-3, getHeight()-3, 50, 50);
		//graphics2d.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, 50, 50);
		//super.paintComponent(g);
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
		graphics2d.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, 50, 50);
		graphics2d.setStroke(new BasicStroke(3));
		super.paintBorder(g);
	}

//	public boolean contains(int x, int y) {
//		if (shape == null || !shape.getBounds().equals(getBounds())) {
//			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//		}
//		return shape.contains(x, y);
//	}
	
}
