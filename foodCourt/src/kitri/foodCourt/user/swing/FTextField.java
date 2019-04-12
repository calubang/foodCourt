package kitri.foodCourt.user.swing;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class FTextField extends JTextArea {

	public FTextField() {
		super();
		defaultSetting();
	}

	public FTextField(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		defaultSetting();
	}

	public FTextField(Document doc) {
		super(doc);
		defaultSetting();
	}

	public FTextField(int rows, int columns) {
		super(rows, columns);
		defaultSetting();
	}

	public FTextField(String text, int rows, int columns) {
		super(text, rows, columns);
		defaultSetting();
	}

	public FTextField(String text) {
		super(text);
		defaultSetting();
	}
	
	public void defaultSetting() {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
	}

}
