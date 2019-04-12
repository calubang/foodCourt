package kitri.foodCourt.user.swing;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.JLabel;

public class RoundLabel extends JLabel{
	
	public int thickness;
	public int arc;
	
	public RoundLabel() {
		super();
	}

	public RoundLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public RoundLabel(Icon image) {
		super(image);
	}

	public RoundLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	public RoundLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public RoundLabel(String text) {
		super(text);
	}
	
	public void defaultSetting() {
		thickness = 3;
		arc = 30;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.WHITE);
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.drawRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
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
	
}
