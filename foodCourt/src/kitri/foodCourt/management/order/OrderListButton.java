package kitri.foodCourt.management.order;

import java.awt.*;
import javax.swing.*;

public class OrderListButton extends JButton{
	private String requestNumber;
	private boolean visible = false;
	public OrderListButton(String requestNumber) {
		super(requestNumber);
		this.requestNumber = requestNumber;
	}
	Dimension ds = new Dimension(70, 70);
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	/**
	 * Create the panel.
	 */

	public OrderListButton() {
		setBackground(Color.WHITE);
		setMaximumSize(ds);
		setPreferredSize(ds);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public boolean isVisible() {
		return this.visible;
	}
	public String getRequestNumber() {
		return this.requestNumber;
	}}