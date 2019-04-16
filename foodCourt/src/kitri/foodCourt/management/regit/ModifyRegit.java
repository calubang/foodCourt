package kitri.foodCourt.management.regit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class ModifyRegit extends JPanel {
	JPasswordField passwordtf;
	JPasswordField pwtf;
	JTextField nametf;
	JTextField lastnumber;
	JTextField midnumber;

	JPanel mainpanel = new JPanel();
	JPanel idpanel = new JPanel();
	JPanel passwordpanel = new JPanel();
	JPanel pwpanel = new JPanel();
	JPanel namepanel = new JPanel();
	JPanel phonepanel = new JPanel();
	JPanel selectpanel = new JPanel();
	JPanel etcpanel = new JPanel();

	JLabel modifylabel = new JLabel("\uC815\uBCF4 \uC218\uC815");
	JLabel idlabel = new JLabel("\uC544\uC774\uB514");
	JLabel etclabel = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
	JLabel passwordlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
	JLabel namelabel = new JLabel("\uC774\uB984");
	JLabel phonelabel = new JLabel("\uD734\uB300\uC804\uD654");

	JComboBox fristnumber = new JComboBox();
	JButton registerbtn = new JButton("\uC218\uC815");
	JButton cancelbtn = new JButton("\uCDE8\uC18C");
	private final JLabel impossibleModify = new JLabel("\uC218\uC815\uBD88\uAC00");

	EtchedBorder eborder;
	private final JPanel enablepanel = new JPanel();
	private final JLabel enablelabel = new JLabel("\uD65C\uC131\uD654");

	/**
	 * Create the panel.
	 */
	public ModifyRegit() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		modifylabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		modifylabel.setBackground(new Color(128, 0, 0));
		modifylabel.setForeground(Color.WHITE);
		modifylabel.setOpaque(true);
		modifylabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifylabel.setBounds(0, 0, 600, 31);

		add(modifylabel);
		add(mainpanel);
		add(selectpanel);

		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setBounds(43, 64, 518, 419);
		mainpanel.setLayout(new GridLayout(7, 1, 0, 10));
		mainpanel.add(idpanel);
		mainpanel.add(etcpanel);
		mainpanel.add(passwordpanel);

		idpanel.setOpaque(false);
		idpanel.setForeground(Color.DARK_GRAY);
		idpanel.setBackground(Color.DARK_GRAY);
		idpanel.setLayout(null);
		idpanel.add(idlabel);

		idlabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		idlabel.setForeground(Color.WHITE);
		idlabel.setBackground(Color.DARK_GRAY);
		idlabel.setOpaque(true);
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(0, 0, 107, 51);
		impossibleModify.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		impossibleModify.setForeground(Color.WHITE);
		impossibleModify.setBackground(Color.DARK_GRAY);
		impossibleModify.setOpaque(true);
		impossibleModify.setBounds(105, 0, 288, 51);
		impossibleModify.setBorder(eborder);
		eborder = new EtchedBorder(EtchedBorder.RAISED);
		idpanel.add(impossibleModify);

		etcpanel.setBackground(Color.DARK_GRAY);
		etcpanel.setLayout(null);

		etclabel.setBounds(129, 27, 154, 24);
		etcpanel.add(etclabel);

		passwordpanel.setBackground(Color.DARK_GRAY);
		passwordpanel.setLayout(null);
		passwordpanel.add(passwordlabel);

		passwordtf = new JPasswordField();
		passwordpanel.add(passwordtf);
		passwordtf.setBounds(107, 0, 283, 51);
		passwordtf.setColumns(10);

		passwordlabel.setForeground(Color.WHITE);
		passwordlabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlabel.setBounds(0, 0, 107, 51);

		pwpanel.setBackground(Color.DARK_GRAY);
		pwpanel.setLayout(null);
		pwpanel.add(pwlabel);

		mainpanel.add(pwpanel);
		mainpanel.add(namepanel);
		mainpanel.add(phonepanel);

		pwtf = new JPasswordField();
		pwpanel.add(pwtf);
		pwtf.setBounds(107, 0, 283, 51);
		pwtf.setColumns(10);

		pwlabel.setForeground(Color.WHITE);
		pwlabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		pwlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwlabel.setBounds(0, 0, 107, 51);

		namepanel.setBackground(Color.DARK_GRAY);
		namepanel.setLayout(null);

		nametf = new JTextField();
		nametf.setBounds(108, 0, 283, 51);
		nametf.setColumns(10);
		namepanel.add(nametf);

		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setBounds(0, 0, 107, 51);
		namepanel.add(namelabel);

		midnumber = new JTextField();
		midnumber.setColumns(10);
		midnumber.setBounds(183, 0, 104, 51);

		lastnumber = new JTextField();
		lastnumber.setBounds(291, 0, 99, 51);
		lastnumber.setColumns(10);

		phonepanel.setBackground(Color.DARK_GRAY);
		phonepanel.add(fristnumber);
		phonepanel.add(midnumber);
		phonepanel.add(lastnumber);
		phonepanel.add(phonelabel);
		phonepanel.setLayout(null);

		fristnumber.setBounds(107, 0, 72, 51);
		fristnumber.addItem("010");
		fristnumber.addItem("011");
		fristnumber.addItem("017");

		phonelabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		phonelabel.setForeground(Color.WHITE);
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setBounds(0, 0, 107, 51);
		enablepanel.setLayout(null);
		enablepanel.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(enablepanel);
		enablelabel.setHorizontalAlignment(SwingConstants.CENTER);
		enablelabel.setForeground(Color.WHITE);
		enablelabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		enablelabel.setBounds(0, 0, 107, 51);
		
		enablepanel.add(enablelabel);
		
		JComboBox enablebox = new JComboBox();
		enablebox.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		enablebox.setBounds(107, 10, 83, 31);
		enablepanel.add(enablebox);

		selectpanel.setBackground(Color.DARK_GRAY);
		selectpanel.setBounds(316, 526, 245, 44);
		selectpanel.setLayout(null);
		selectpanel.add(registerbtn);
		selectpanel.add(cancelbtn);

		registerbtn.setBounds(12, 5, 110, 39);
		cancelbtn.setBounds(134, 5, 110, 39);

	}
}
