package kitri.foodCourt.user.swing;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class FLabel extends JLabel {

	public FLabel() {
		super();
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
	}

	public FLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public FLabel(Icon image) {
		super(image);
	}

	public FLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	public FLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public FLabel(String text) {
		super(text);
	}
	
	public FLabel(int style, int size) {
		super();
		setFont(new Font("¸¼Àº °íµñ", style, size));
	}
	
	
}
