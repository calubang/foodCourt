package kitri.foodCourt.user.basket;

import java.awt.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.LineBorder;

import kitri.foodCourt.user.swing.*;

public class SwingFactory {
	private static SwingFactory swingFactory = new SwingFactory();
	
	private SwingFactory() {}
	
	public static SwingFactory getInstance() {
		return swingFactory;
	}
	
	public static FButton getButton(String name) {
		FButton button = null;
		switch(name) {
		case "x":
			ImageIcon basic = new ImageIcon(SwingFactory.class.getResource("/kitri/foodCourt/user/basket/image/x_button.png"));
			ImageIcon entered = new ImageIcon(SwingFactory.class.getResource("/kitri/foodCourt/user/basket/image/x_button2.png"));
			button = new FButton(basic, entered);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.addMouseListener(button);
			return button;
		case "image":
			button = new FButton();
			button.setIcon(new ImageIcon(SwingFactory.class.getResource("/kitri/foodCourt/user/basket/image/notFoundImage.png")));
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.addMouseListener(button);
			return button;
		default:
			button = new FButton();
			button.setBackground(SystemColor.inactiveCaptionBorder);
			button.setBorder(new LineBorder(Color.BLACK, 1));
			button.addMouseListener(button);
			return button;
			
		}
	}
	
	public static FLabel getLabel(String name) {
		FLabel label = null;
		
		switch(name) {
		case "basketFood":
			label = new FLabel();
			label.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.PLAIN, 20));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			return label;
		}
		return label;
	}
	
	public static FPanel getPanel(String name) {
		FPanel panel = null;
		
		switch(name) {
		case "basketFood":
			panel = new FPanel();
			panel.setLayout(null);
			return panel;
		}
		return panel;
	}
	
	public static int getOptionPane(String name, Container parentComponent, String title, String message) {
		FOptionPane fOptionPane = null;
		switch(name) {
		case "warning":
			//ImageIcon icon = new ImageIcon(BasketMain.class.getResource("/kitri/foodCourt/user/basket/image/warning.png"));
			fOptionPane = new FOptionPane();
			String options[] = {"¿¹", "¾Æ´Ï¿ä"};
			UIManager.put("OptionPane.messageFont", new Font("", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			return fOptionPane.showOptionDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		case "message":
			fOptionPane = new FOptionPane();
			UIManager.put("OptionPane.messageFont", new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			fOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE);
			return 0;
		default:
			return 0;
		}
	}
}
