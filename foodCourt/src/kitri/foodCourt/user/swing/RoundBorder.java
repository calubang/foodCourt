package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.JButton;
import javax.swing.border.Border;

public class RoundBorder implements Border {

    private int radius;
    private int thickness;
    
    public RoundBorder(int radius, int thickness) {
        this.radius = radius;
        this.thickness = thickness;
    }
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	g.setColor(c.getForeground());
    	((Graphics2D)g).setStroke(new BasicStroke(thickness));
        g.drawRoundRect(x+thickness/2, y+thickness/2, width-thickness, height-thickness, radius, radius);
        
    }
    
    public static Color hexToRgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	} 
}