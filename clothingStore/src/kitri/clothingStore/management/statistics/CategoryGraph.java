package kitri.clothingStore.management.statistics;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class CategoryGraph extends JPanel {

	JPanel legendPanel = new JPanel();
	
	JLabel colorShortTLabel = new JLabel("\uBC18\uD314\uC0C9");
	JLabel shortTLabel = new JLabel("\uBC18\uD314");
	JLabel colorLongTLabel = new JLabel("\uAE34\uD314\uC0C9");
	JLabel longTLabel = new JLabel("\uAE34\uD314");
	JLabel colorShortPLabel = new JLabel("\uBC18\uBC14\uC9C0\uC0C9");
	JLabel shortPLabel = new JLabel("\uBC18\uBC14\uC9C0");
	JLabel colorLongPLabel = new JLabel("\uAE34\uBC14\uC9C0\uC0C9");
	JLabel longPLabel = new JLabel("\uAE34\uBC14\uC9C0");
	JLabel colorHatLabel = new JLabel("\uBAA8\uC790\uC0C9");
	JLabel hatLabel = new JLabel("\uBAA8\uC790");
	JLabel colorOuterLabel = new JLabel("\uC544\uC6B0\uD130\uC0C9");
	JLabel outerLabel = new JLabel("\uC544\uC6B0\uD130");
	
	
	/**
	 * Create the panel.
	 */
	public CategoryGraph() {
		setSize(new Dimension(744, 632));
		setLayout(null);
		
		legendPanel.setBorder(new TitledBorder(null, "\uBC94\uB840", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		legendPanel.setBounds(12, 30, 142, 200);
		legendPanel.setLayout(new GridLayout(6, 2, 0, 0));
		add(legendPanel);
		
		colorShortTLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorShortTLabel);
		
		shortTLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(shortTLabel);
		
		colorLongTLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorLongTLabel);
		
		longTLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(longTLabel);
		
		colorShortPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorShortPLabel);
		
		shortPLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(shortPLabel);
		
		colorLongPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorLongPLabel);
		
		longPLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(longPLabel);
		
		colorHatLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorHatLabel);
		
		hatLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(hatLabel);
		
		colorOuterLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		legendPanel.add(colorOuterLabel);
		
		outerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		legendPanel.add(outerLabel);
	}

}
