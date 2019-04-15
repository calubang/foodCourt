package kitri.foodCourt.management.regit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.Component;

public class AdminRegister extends JPanel {
	
	JTextField idtf;
	JPasswordField passwordtf = new JPasswordField();
	JPasswordField pwtf = new JPasswordField();
	JTextField nametf = new JTextField();
	JTextField lastnumber = new JTextField();
	JTextField midnumber = new JTextField();

	JPanel mainpanel = new JPanel();
	JPanel idpanel = new JPanel();
	JPanel passwordpanel = new JPanel();
	JPanel pwpanel = new JPanel();
	JPanel namepanel = new JPanel();
	JPanel phonepanel = new JPanel();
	JPanel selectpanel = new JPanel();
	JPanel etcpanel = new JPanel();
	JComboBox jobname = new JComboBox();
	JLabel adminRegister = new JLabel("\uAD00\uB9AC\uC790 \uB4F1\uB85D");
	JLabel idlabel = new JLabel("\uC544\uC774\uB514");
	JLabel etclabel = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
	JLabel passwordlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
	JLabel namelabel = new JLabel("\uC774\uB984");
	JLabel phonelabel = new JLabel("\uD734\uB300\uC804\uD654");

	JComboBox fristnumber = new JComboBox();

	JButton idbtn = new JButton("\uC911\uBCF5\uD655\uC778");
	JButton registerbtn = new JButton("\uB4F1\uB85D");
	JButton cancelbtn = new JButton("\uCDE8\uC18C");
	private final JPanel jobpanel = new JPanel();
	private final JPanel emailpanel = new JPanel();
	private final JLabel emaillabel = new JLabel("\uC774\uBA54\uC77C");
	JTextField addresstf;
	JTextField email;
	JTextField emaildomain;
	
	

	/**
	 * Create the panel.
	 */
	public AdminRegister() {
		idtf = new JTextField();
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		adminRegister.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		adminRegister.setBackground(new Color(128, 0, 0));
		adminRegister.setForeground(Color.WHITE);
		adminRegister.setOpaque(true);
		adminRegister.setHorizontalAlignment(SwingConstants.CENTER);
		adminRegister.setBounds(0, 0, 600, 31);

		add(adminRegister);
		add(mainpanel);
		add(selectpanel);

		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setBounds(43, 64, 518, 572);
		mainpanel.setLayout(new GridLayout(9, 1, 0, 10));
		mainpanel.add(idpanel);
		mainpanel.add(etcpanel);
		mainpanel.add(passwordpanel);

		idpanel.setOpaque(false);
		idpanel.setForeground(Color.DARK_GRAY);
		idpanel.setBackground(Color.DARK_GRAY);
		idpanel.setLayout(null);
		idpanel.add(idlabel);
		idpanel.add(idbtn);

		idtf = new JTextField();
		idpanel.add(idtf);
		idtf.setBounds(107, 0, 283, 51);
		idtf.setColumns(10);

		idlabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		idlabel.setForeground(Color.WHITE);
		idlabel.setBackground(Color.DARK_GRAY);
		idlabel.setOpaque(true);
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(0, 0, 107, 51);

		idbtn.setBounds(402, 0, 116, 51);

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
		fristnumber.addItem("019");

		phonelabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		phonelabel.setForeground(Color.WHITE);
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setBounds(0, 0, 107, 51);
		jobpanel.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(jobpanel);
		jobpanel.setLayout(null);
		
		JLabel joblabel = new JLabel("\uC9C1\uAE09");
		joblabel.setForeground(Color.WHITE);
		joblabel.setOpaque(true);
		joblabel.setBackground(Color.DARK_GRAY);
		joblabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		joblabel.setHorizontalAlignment(SwingConstants.CENTER);
		joblabel.setBounds(0, 0, 105, 51);
		jobpanel.add(joblabel);
		
		
		jobname.setBounds(105, 0, 105, 51);
		jobpanel.add(jobname);
		jobname.addItem("°ü¸®ÀÚ");
		jobname.addItem("Á¡¿ø");
		jobname.addItem("½ÅÀÔ");
		
		JPanel addresspanel = new JPanel();
		addresspanel.setLayout(null);
		addresspanel.setBackground(Color.DARK_GRAY);
		mainpanel.add(addresspanel);
		
		JLabel addresslabel = new JLabel("\uC8FC\uC18C");
		addresslabel.setOpaque(true);
		addresslabel.setHorizontalAlignment(SwingConstants.CENTER);
		addresslabel.setForeground(Color.WHITE);
		addresslabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		addresslabel.setBackground(Color.DARK_GRAY);
		addresslabel.setBounds(0, 0, 105, 51);
		addresspanel.add(addresslabel);
		
		addresstf = new JTextField();
		addresstf.setColumns(10);
		addresstf.setBounds(104, 0, 315, 51);
		addresspanel.add(addresstf);
		emailpanel.setLayout(null);
		emailpanel.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(emailpanel);
		emaillabel.setOpaque(true);
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		emaillabel.setForeground(Color.WHITE);
		emaillabel.setFont(new Font("µ¸¿ò", Font.BOLD, 16));
		emaillabel.setBackground(Color.DARK_GRAY);
		emaillabel.setBounds(0, 0, 105, 51);
		
		emailpanel.add(emaillabel);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(103, 0, 142, 51);
		emailpanel.add(email);
		
		emaildomain = new JTextField();
		emaildomain.setColumns(10);
		emaildomain.setBounds(257, 0, 162, 51);
		emailpanel.add(emaildomain);
		
		selectpanel.setBackground(Color.DARK_GRAY);
		selectpanel.setBounds(314, 646, 247, 44);
		selectpanel.setLayout(null);
		selectpanel.add(registerbtn);
		selectpanel.add(cancelbtn);

		registerbtn.setBounds(12, 5, 110, 39);
		cancelbtn.setBounds(134, 5, 110, 39);
		


	}
}
