package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import kitri.foodCourt.user.swing.*;
import kitri.foodCourt.user.view.FoodMain;

public class SwingFactory {
	private static SwingFactory swingFactory = new SwingFactory();
	private static String yesOrno[] = {"øπ", "æ∆¥œø‰"};
	private static String OkOrCancel[] = {"»Æ¿Œ", "√Îº“"};
	
	private SwingFactory() {}
	
	public static SwingFactory getInstance() {
		return swingFactory;
	}
	
	public static FButton getButton(String name) {
		FButton button = null;
		ImageIcon basic = null;
		ImageIcon entered = null;
		switch(name) {
		case "x":
			basic = new ImageIcon(SwingFactory.class.getResource("/img/user/x_button.png"));
			entered = new ImageIcon(SwingFactory.class.getResource("/img/user/x_button2.png"));
			button = new FButton(basic, entered);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.addMouseListener(button);
			return button;
		case "image":
			button = new FButton();
			button.setIcon(new ImageIcon(SwingFactory.class.getResource("/img/user/notFoundImage.png")));
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			return button;
		case "up":
			basic = new ImageIcon(SwingFactory.class.getResource("/img/user/upIconSmall.png"));
			entered = new ImageIcon(SwingFactory.class.getResource("/img/user/upIcon.png"));
			button = new FButton(basic, entered);
			button.setBackground(Color.WHITE);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.addMouseListener(button);
			return button;
		case "down":
			basic = new ImageIcon(SwingFactory.class.getResource("/img/user/downIconSmall.png"));
			entered = new ImageIcon(SwingFactory.class.getResource("/img/user/downIcon.png"));
			button = new FButton(basic, entered);
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
			label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
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
	
	public static int getOptionPane(String name, Container parentComponent, String title, Object message) {
		FOptionPane fOptionPane = null;
		switch(name) {
		case "warning":
			//ImageIcon icon = new ImageIcon(BasketMain.class.getResource("/kitri/foodCourt/user/basket/image/warning.png"));
			fOptionPane = new FOptionPane();
			UIManager.put("OptionPane.messageFont", new Font("", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			return fOptionPane.showOptionDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, yesOrno, yesOrno[0]);
		case "message":
			fOptionPane = new FOptionPane();
			UIManager.put("OptionPane.messageFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			fOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE);
			return 0;
		case "messageChoice":
			fOptionPane = new FOptionPane();
			UIManager.put("OptionPane.messageFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			return fOptionPane.showOptionDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, yesOrno, yesOrno[0]);
		case "errorMessage":
			fOptionPane = new FOptionPane();
			UIManager.put("OptionPane.messageFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			fOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE);
			return 0;
		case "inputPassword":
			fOptionPane = new FOptionPane();
			int option;
			UIManager.put("OptionPane.messageFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			UIManager.put("OptionPane.buttonFont", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
			ImageIcon icon = new ImageIcon(SwingFactory.class.getResource("/img/user/password.png"));
			return fOptionPane.showOptionDialog(parentComponent, message, title, JOptionPane.OK_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE, icon , OkOrCancel, message);

		default:
			return 0;
		}
	}
	
	public static Icon getScaledImage(int width, int height, String fileName, int hints) {
		ImageIcon icon = null;		
		try {
			URL url = SwingFactory.class.getResource(fileName);
			BufferedImage bufferedImage = ImageIO.read(url);
			icon = new ImageIcon(bufferedImage.getScaledInstance(width, height, hints));
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				URL url = SwingFactory.class.getResource("/img/user/notFoundImage.png");
				BufferedImage bufferedImage;
				bufferedImage = ImageIO.read(url);
				icon = new ImageIcon(bufferedImage.getScaledInstance(width, height, hints));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		return icon;
	}
	
	public static Color hexToRgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	} 
}
