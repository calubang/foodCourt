package test;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodMainView extends JPanel {

	/**
	 * Create the panel.
	 */
	JButton hansicBigMenu = new JButton(new ImageIcon());
	JButton joongsicBigMenu = new JButton(new ImageIcon());
	JButton ilsicBigMenu = new JButton(new ImageIcon());
	JButton yangsicBigMenu = new JButton(new ImageIcon());
	public FoodMainView() {
		setLayout(new GridLayout(2, 2, 50, 50));
		
		
		add(hansicBigMenu);
		
		
		add(joongsicBigMenu);
		
		
		add(ilsicBigMenu);
		
		
		add(yangsicBigMenu);
		setBounds(160, 118, 1012, 634);
		setVisible(true);
	}

}
