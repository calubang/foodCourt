package kitri.foodCourt.management.request;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;


@SuppressWarnings("serial")
public class AdminRequest extends JPanel {

	JPanel requestPanel = new JPanel();
	JPanel panel = new JPanel();
	
	JScrollPane scrollPane = new JScrollPane(requestPanel);
	
	JButton requestBtn1 = new JButton("\uC694\uCCAD1");
	JButton requestBtn2 = new JButton("\uC694\uCCAD2");
	JButton requestBtn3 = new JButton("\uC694\uCCAD3");
	JButton requestBtn4 = new JButton("\uC694\uCCAD4");
	JButton requestBtn5 = new JButton("\uC694\uCCAD5");
	JButton requestBtn6 = new JButton("\uC694\uCCAD6");
	JButton requestBtn7 = new JButton("\uC694\uCCAD7");
	JButton requestBtn8 = new JButton("\uC694\uCCAD8");
	JButton requestBtn9 = new JButton("\uC694\uCCAD9");
	JButton processOrderBtn = new JButton("\uCC98\uB9AC");
	JButton checkOrderBtn = new JButton("\uC8FC\uBB38\uBAA9\uB85D \uD655\uC778");

	AdminRequestControl arc;
	
	
	/**
	 * Create the panel.
	 */
	public AdminRequest() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		scrollPane.setBounds(0, 0, 785, 722);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(requestPanel);

		FlowLayout flowLayout = (FlowLayout)requestPanel.getLayout();
		flowLayout.setVgap(60);
		flowLayout.setHgap(60);
		flowLayout.setAlignment(FlowLayout.LEFT);
		requestPanel.setPreferredSize(new Dimension(785, 50));
		requestPanel.setBorder(new EmptyBorder(0, 50, 0, 0));

		requestBtn1.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn1);
		
		requestBtn2.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn2);
		
		requestBtn3.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn3);
		
		requestBtn4.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn4);
		
		requestBtn5.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn5);
		
		requestBtn6.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn6);
		
		requestBtn7.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn7);
		
		requestBtn8.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn8);
		
		requestBtn9.setPreferredSize(new Dimension(100, 100));
		requestPanel.add(requestBtn9);
		
		add(scrollPane);
		
		panel.setLayout(new GridLayout(2, 1, 0, 60));
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		panel.setBounds(792, 427, 216, 295);
		
		panel.add(checkOrderBtn);
		panel.add(processOrderBtn);

		add(panel);
		
		
		// Add Listener
		arc = new AdminRequestControl(this);
		
		checkOrderBtn.addActionListener(arc);
		processOrderBtn.addActionListener(arc);
	}
}
