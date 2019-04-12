package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.border.*;

public class FPanel extends JPanel implements MouseListener {

	private Shape shape;
	private Border basic;
	private Border entered;
	private MouseListener controller;

	public FPanel() {
		super();
		addListener();
		defaultSetting();
	}

	public FPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		addListener();
		defaultSetting();
	}

	public FPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		addListener();
		defaultSetting();
	}

	public FPanel(LayoutManager layout) {
		super(layout);
		addListener();
		defaultSetting();
	}

	public void setController(MouseListener controller) {
		this.controller = controller;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Border getBasic() {
		return basic;
	}

	public void setBasic(Border basic) {
		this.basic = basic;
	}

	public Border getEntered() {
		return entered;
	}

	public void setEntered(Border entered) {
		this.entered = entered;
	}

	public void addListener() {
		addMouseListener(this);
	}
	
	public void defaultSetting() {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
//	protected void paintComponent(Graphics g) {
//		//g.setColor(getBackground());
//		//g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//		Graphics2D graphics2d = (Graphics2D)g;
//		graphics2d.setColor(getBackground());
//		graphics2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
//		graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, 0));
//		super.paintComponent(g);
//	}
//
//	protected void paintBorder(Graphics g) {
//		g.setColor(getForeground());
//		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//		super.paintBorder(g);
//	}
//
//	public boolean contains(int x, int y) {
//		if (shape == null || !shape.getBounds().equals(getBounds())) {
//			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//		}
//		return shape.contains(x, y);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		controller.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		basic = this.getBorder();
		if (entered != null) {
			setBorder(entered);
		} else {
			setBorder(new LineBorder(Color.BLACK, 2, true));
			//setBorder(new FlayoutTest(Color.BLACK, 2, true));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (basic != null) {
			setBorder(basic);
		} else {
			setBorder(new LineBorder(Color.BLACK, 0, true));
			//setBorder(new FlayoutTest(Color.BLACK, 0, true));
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
