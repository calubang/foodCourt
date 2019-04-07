package kitri.foodCourt.management.regit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AdminRegister extends JPanel {
	private JTextField idtf;
	private JTextField passwordtf;
	private JTextField pwtf;
	private JTextField nametf;
	private JTextField lastnumber;
	private JTextField midnumber;

	JPanel mainpanel = new JPanel();
	JPanel idpanel = new JPanel();
	JPanel passwordpanel = new JPanel();
	JPanel pwpanel = new JPanel();
	JPanel namepanel = new JPanel();
	JPanel phonepanel = new JPanel();
	JPanel selectpanel = new JPanel();
	JPanel etcpanel = new JPanel();

	JLabel adminRegister = new JLabel("\uAD00\uB9AC\uC790 \uB4F1\uB85D");
	JLabel idlabel = new JLabel("\uC544\uC774\uB514");
	JLabel etclabel = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
	JLabel passwordlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
	JLabel namelabel = new JLabel("\uC774\uB984");
	JLabel phonelabel = new JLabel("\uD734\uB300\uC804\uD654");

	JComboBox fristnumber = new JComboBox();

	JButton idbtn = new JButton("\uC544\uC774\uB514\uC911\uBCF5\uD655\uC778");
	JButton registerbtn = new JButton("\uB4F1\uB85D");
	JButton cancelbtn = new JButton("\uCDE8\uC18C");
	
	

	/**
	 * Create the panel.
	 */
	public AdminRegister() {
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
		mainpanel.setBounds(43, 64, 518, 360);
		mainpanel.setLayout(new GridLayout(6, 1, 0, 10));
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

		passwordtf = new JTextField();
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

		pwtf = new JTextField();
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

		selectpanel.setBackground(Color.DARK_GRAY);
		selectpanel.setBounds(272, 434, 245, 44);
		selectpanel.setLayout(null);
		selectpanel.add(registerbtn);
		selectpanel.add(cancelbtn);

		registerbtn.setBounds(12, 5, 110, 39);
		cancelbtn.setBounds(134, 5, 110, 39);
		


	}

}
