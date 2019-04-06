package kitri.foodCourt.management.request;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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

	JFrame jfV = new JFrame("주문 목록 확인");
	
	AdminViewOrder avo;
	
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
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		panel.setBounds(808, 427, 200, 295);
		
		add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 60));

		checkOrderBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							avo = new AdminViewOrder();
							
							jfV.getContentPane().add(avo);
							jfV.setSize(395, 580);
							jfV.setVisible(true);
						}
					});
		panel.add(checkOrderBtn);
		
		processOrderBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String[] option = {"예", "아니오"};
								JOptionPane.showOptionDialog(processOrderBtn, "처리하시겠습니까?", "처리 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
							}
						});
		panel.add(processOrderBtn);
	}
}
