package kitri.foodCourt.management.statistics;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminStatistics extends JPanel {

	JPanel datePanel = new JPanel();
	JPanel startPanel = new JPanel();
	JPanel endPanel = new JPanel();
	JPanel statisticsPanel = new JPanel();
	JPanel categoryPanel = new JPanel();

	JLabel startLabel = new JLabel("\uBD80\uD130");
	JLabel endLabel = new JLabel("\uAE4C\uC9C0");

	JButton startYearBtn = new JButton("\uC2DC\uC791\uB144\uB3C4");
	JButton startMonthBtn = new JButton("\uC2DC\uC791\uC6D4");
	JButton endYearBtn = new JButton("\uB05D\uB144\uB3C4");
	JButton endMonthBtn = new JButton("\uB05D\uC6D4");
	JButton profitBtn = new JButton("\uB9E4\uCD9C");
	JButton categoryBtn = new JButton("\uCE74\uD14C\uACE0\uB9AC");
	JButton menwomenBtn = new JButton("\uC131\uBCC4");
	JButton ageBtn = new JButton("\uB098\uC774");
	
	ProfitGraph pg = new ProfitGraph();
	CategoryGraph cg = new CategoryGraph();
	MenWomenGraph mwg = new MenWomenGraph();
	AgeGraph ag = new AgeGraph();
	
	CardLayout cl = new CardLayout(0, 0);
	
	/**
	 * Create the panel.
	 */
	public AdminStatistics() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		datePanel.setLayout(null);
		datePanel.setBorder(new TitledBorder(null, "\uD1B5\uACC4 \uAD6C\uAC04 \uC124\uC815", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		datePanel.setBounds(756, 194, 240, 300);
		add(datePanel);
		
		startPanel.setBounds(12, 45, 216, 45);
		startPanel.setLayout(new GridLayout(1, 2, 0, 0));
		datePanel.add(startPanel);
		
		startPanel.add(startYearBtn);
		startPanel.add(startMonthBtn);
		
		startLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		startLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startLabel.setBounds(12, 90, 109, 33);
		datePanel.add(startLabel);
		
		endPanel.setLayout(new GridLayout(1, 2, 0, 0));
		endPanel.setBounds(12, 178, 216, 45);
		endPanel.add(endYearBtn);
		endPanel.add(endMonthBtn);
		datePanel.add(endPanel);
		
		endLabel.setHorizontalAlignment(SwingConstants.CENTER);
		endLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		endLabel.setBounds(12, 223, 109, 33);
		datePanel.add(endLabel);
		
		categoryPanel.setLayout(new GridLayout(1, 4, 10, 0));
		categoryPanel.setBounds(0, 10, 560, 60);
		profitBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cl.show(statisticsPanel, "ProfitGraph");
						}
					});
		categoryPanel.add(profitBtn);
		categoryBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cl.show(statisticsPanel, "CategoryGraph");
						}
					});
		categoryPanel.add(categoryBtn);
		menwomenBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cl.show(statisticsPanel, "MenWomenGraph");
						}
					});
		categoryPanel.add(menwomenBtn);
		ageBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cl.show(statisticsPanel, "AgeGraph");
					}
				});
		categoryPanel.add(ageBtn);
		add(categoryPanel);
		
		statisticsPanel.setBounds(0, 90, 744, 632);
		statisticsPanel.setLayout(cl);
		statisticsPanel.add("ProfitGraph", pg);
		statisticsPanel.add("CategoryGraph", cg);
		statisticsPanel.add("MenWomenGraph", mwg);
		statisticsPanel.add("AgeGraph", ag);
		cl.show(statisticsPanel, "ProfitGraph");
		
		add(statisticsPanel);
	}
}
