package kitri.foodCourt.management.statistics;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class MenWomenGraph extends JPanel {

	JPanel legendPanel = new JPanel();
	
	JLabel colorMenLabel = new JLabel("\uB0A8\uC790\uC0C9");
	JLabel menLabel = new JLabel("\uB0A8\uC790");
	JLabel colorWomenLabel = new JLabel("\uC5EC\uC790\uC0C9");
	JLabel womenLabel = new JLabel("\uC5EC\uC790");
	
	
	/**
	 * Create the panel.
	 */
	public MenWomenGraph() {
		setSize(new Dimension(744, 632));
		setLayout(null);
		
		legendPanel.setBorder(new TitledBorder(null, "\uBC94\uB840", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		legendPanel.setBounds(12, 30, 142, 84);
		legendPanel.setLayout(new GridLayout(2, 2, 0, 0));
		add(legendPanel);
		
		colorMenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorMenLabel);
		
		menLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(menLabel);
		
		colorWomenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorWomenLabel);
		
		womenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(womenLabel);
	}

}
