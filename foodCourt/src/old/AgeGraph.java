package old;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class AgeGraph extends JPanel {

	JPanel legendPanel = new JPanel();
	
	JLabel colorTenLabel = new JLabel("10\uB300\uC0C9");
	JLabel tenLabel = new JLabel("10\uB300");
	JLabel colorTwentyLabel = new JLabel("20\uB300\uC0C9");
	JLabel twentyLabel = new JLabel("20\uB300");
	JLabel colorThirtyLabel = new JLabel("30\uB300\uC0C9");
	JLabel thirtyLabel = new JLabel("30\uB300");
	JLabel colorFourtyLabel = new JLabel("40\uB300\uC0C9");
	JLabel fourtyLabel = new JLabel("40\uB300");
	JLabel colorOverFiftyLabel = new JLabel("50\uB300\uC774\uC0C1\uC0C9");
	JLabel overFiftyLabel = new JLabel("50\uB300");
	
	
	/**
	 * Create the panel.
	 */
	public AgeGraph() {
		setSize(new Dimension(744, 632));
		setLayout(null);
		
		legendPanel.setBorder(new TitledBorder(null, "\uBC94\uB840", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		legendPanel.setBounds(12, 30, 142, 174);
		legendPanel.setLayout(new GridLayout(5, 2, 0, 0));
		add(legendPanel);
		
		colorTenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorTenLabel);
		
		tenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(tenLabel);
		
		colorTwentyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorTwentyLabel);
		
		twentyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(twentyLabel);
		
		colorThirtyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorThirtyLabel);
		
		thirtyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(thirtyLabel);
		
		colorFourtyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorFourtyLabel);
		
		fourtyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(fourtyLabel);
		
		colorOverFiftyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorOverFiftyLabel);
		
		overFiftyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(overFiftyLabel);
	}

}
