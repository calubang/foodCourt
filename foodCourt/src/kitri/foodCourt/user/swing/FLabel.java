package kitri.foodCourt.user.swing;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class FLabel extends JLabel {

	public FLabel() {
		super();
		defaultSetting();
	}

	public FLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		defaultSetting();
	}

	public FLabel(Icon image) {
		super(image);
		defaultSetting();
	}

	public FLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		defaultSetting();
	}

	public FLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		defaultSetting();
	}

	public FLabel(String text) {
		super(text);
		defaultSetting();
	}
	
	public FLabel(int style, int size) {
		super();
		defaultSetting();
		setFont(new Font("¸¼Àº °íµñ", style, size));
	}
	
	public void defaultSetting() {
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	
}
