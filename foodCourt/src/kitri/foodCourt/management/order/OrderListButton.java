package kitri.foodCourt.management.order;

import java.awt.*;
import javax.swing.*;

public class OrderListButton extends JButton{
	private int requestNumber;
//	private boolean visible = false; //??왜만들었었지
	public OrderListButton(int requestNumber) {
		super(Integer.toString(requestNumber));
		this.requestNumber = requestNumber;
	}
	public Dimension ds;
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	/**
	 * Create the panel.
	 */

	public OrderListButton() {
		ds = new Dimension(100, 100);
		setBackground(Color.WHITE);
		setOpaque(true);
		setMaximumSize(ds);
		setPreferredSize(ds);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setVisible(true);
	}
//	public boolean isVisible() {
//		return this.visible;
//	}
	public int getRequestNumber() {
		return this.requestNumber;
	}}