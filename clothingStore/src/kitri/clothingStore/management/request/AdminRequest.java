package kitri.clothingStore.management.request;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


public class AdminRequest extends JPanel {

	JPanel requestPanel = new JPanel();
	
	JScrollPane scrollPane = new JScrollPane(requestPanel);
	
	JButton requestBtn1 = new JButton("\uC694\uCCAD1");
	private final JButton requestBtn2 = new JButton("\uC694\uCCAD2");
	private final JButton requestBtn3 = new JButton("\uC694\uCCAD3");
	private final JButton requestBtn4 = new JButton("\uC694\uCCAD4");
	private final JButton requestBtn5 = new JButton("\uC694\uCCAD5");
	private final JButton requestBtn6 = new JButton("\uC694\uCCAD6");
	private final JButton requestBtn7 = new JButton("\uC694\uCCAD7");
	private final JButton requestBtn8 = new JButton("\uC694\uCCAD8");
	private final JButton requestBtn9 = new JButton("\uC694\uCCAD9");
	private final JButton requestBtn10 = new JButton("\uC694\uCCAD10");

	
	/**
	 * Create the panel.
	 */
	public AdminRequest() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 1008, 722);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(requestPanel);

		FlowLayout flowLayout = (FlowLayout)requestPanel.getLayout();
		flowLayout.setVgap(60);
		flowLayout.setHgap(60);
		flowLayout.setAlignment(FlowLayout.LEFT);
		requestPanel.setPreferredSize(new Dimension(1008, 10));
		requestPanel.setBorder(new EmptyBorder(0, 50, 0, 0));

		requestBtn1.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn1);
		
		requestBtn2.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn2);
		
		requestBtn3.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn3);
		
		requestBtn4.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn4);
		
		requestBtn5.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn5);
		
		requestBtn6.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn6);
		
		requestBtn7.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn7);
		
		requestBtn8.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn8);
		
		requestBtn9.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn9);
		
		requestBtn10.setPreferredSize(new Dimension(150, 150));
		requestPanel.add(requestBtn10);
		
		add(scrollPane);
	}
}
