package kitri.foodCourt.management.statistics;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProfitGraph extends JPanel {

	JPanel panel = new JPanel();
	
	JLabel profitLabel = new JLabel("\uB9E4\uCD9C\uC561");
	JLabel durationLabel = new JLabel("\uAE30\uAC04");

	/**
	 * Create the panel.
	 */
	public ProfitGraph() {
		setSize(new Dimension(744, 632));
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(145, 49, 523, 495);
		add(panel);
		
		profitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		profitLabel.setBounds(47, 10, 99, 37);
		add(profitLabel);
		
		durationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		durationLabel.setBounds(680, 523, 50, 37);
		add(durationLabel);
	}

}
