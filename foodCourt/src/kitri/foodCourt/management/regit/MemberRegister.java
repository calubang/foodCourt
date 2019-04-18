package kitri.foodCourt.management.regit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.print.attribute.standard.Fidelity;
import javax.swing.*;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.swing.SwingFactory;

public class MemberRegister extends JPanel implements ItemListener{
	public JTextField idtf;
	public JPasswordField passwordtf;
	public JPasswordField pwtf;
	public JTextField nametf;
	public JTextField lastnumber;
	public JTextField midnumber;

	JPanel mainpanel = new JPanel();
	JPanel passwordpanel = new JPanel();
	JPanel pwpanel = new JPanel();
	JPanel namepanel = new JPanel();
	JPanel phonepanel = new JPanel();
	JPanel selectpanel = new JPanel();
	JPanel idpanel = new JPanel();

	JLabel idlabel = new JLabel("\uC544\uC774\uB514");
	JLabel memberRegister = new JLabel("\uD68C\uC6D0 \uB4F1\uB85D");
	JLabel etclabel = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
	JLabel passwordlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
	JLabel namelabel = new JLabel("\uC774\uB984");
	public JLabel phonelabel = new JLabel("\uD734\uB300\uC804\uD654");

	public JComboBox fristnumber = new JComboBox();
	public JButton idbtn = new JButton("\uC911\uBCF5\uD655\uC778");
	public JButton registerbtn = new JButton("\uB4F1\uB85D");
	public JButton cancelbtn = new JButton("\uCDE8\uC18C");
	public JPanel pUserPoint = new JPanel();
	public JLabel label = new JLabel("\uD3EC\uC778\uD2B8");
	public JTextField tfUserPoint = new JTextField();
	public JPanel pJoinDate = new JPanel();
	public JLabel label_1 = new JLabel("\uAC00\uC785\uC77C");
	public JYearChooser yearJoin = new JYearChooser();
	public JSpinField dayJoin = new JSpinField();
	public JPanel pSecession = new JPanel();
	public JLabel label_2 = new JLabel("\uD0C8\uD1F4\uC77C");
	public JYearChooser yearSecession = new JYearChooser();
	public JSpinField daySecession = new JSpinField();
	public JPanel pPasswordQuiz = new JPanel();
	public JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD034\uC988");
	public JTextField tfPasswordQuiz = new JTextField();
	public JPanel pPasswordAnswer = new JPanel();
	public JLabel label_4 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uB2F5\uBCC0");
	public JTextField tfPasswordAnswer = new JTextField();
	public JPanel pEnable = new JPanel();
	public JLabel label_5 = new JLabel("\uD65C\uC131\uD654");
	public JComboBox cbEnable = new JComboBox();
	public JMonthChooser monthSecession;
	public JMonthChooser monthJoin;

	public boolean check;
	
	public MemberRegister(MemberTable mt) {
		initView();
		check = false;
		
		//이벤트 등록
		cbEnable.addItemListener(this);
	}
	
	public void initView() {
		this.setSize(571, 726);
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		memberRegister.setFont(new Font("돋움", Font.BOLD, 16));
		memberRegister.setBackground(new Color(128, 0, 0));
		memberRegister.setForeground(Color.WHITE);
		memberRegister.setOpaque(true);
		memberRegister.setHorizontalAlignment(SwingConstants.CENTER);
		memberRegister.setBounds(0, 0, 571, 31);
		add(memberRegister);
		add(selectpanel);
		add(mainpanel);

		
		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setBounds(10, 41, 548, 609);
		mainpanel.setLayout(new GridLayout(11, 1, 0, 10));
		mainpanel.add(idpanel);

		idpanel.setOpaque(false);
		idpanel.setForeground(Color.DARK_GRAY);
		idpanel.setBackground(Color.DARK_GRAY);
		idpanel.setLayout(null);
		idpanel.add(idlabel);
		idbtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idpanel.add(idbtn);

		idtf = new JTextField();
		idtf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idpanel.add(idtf);
		idtf.setBounds(107, 0, 283, 51);
		idtf.setColumns(10);

		idlabel.setFont(new Font("굴림", Font.BOLD, 14));
		idlabel.setForeground(Color.WHITE);
		idlabel.setBackground(Color.DARK_GRAY);
		idlabel.setOpaque(true);
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(0, 0, 107, 51);

		idbtn.setBounds(402, 0, 116, 51);
		mainpanel.add(passwordpanel);
		mainpanel.add(pwpanel);

		passwordpanel.setBackground(Color.DARK_GRAY);
		passwordpanel.setLayout(null);
		passwordpanel.add(passwordlabel);

		passwordtf = new JPasswordField();
		passwordtf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		passwordpanel.add(passwordtf);
		passwordtf.setBounds(107, 0, 283, 51);
		passwordtf.setColumns(10);

		passwordlabel.setForeground(Color.WHITE);
		passwordlabel.setFont(new Font("돋움", Font.BOLD, 16));
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlabel.setBounds(0, 0, 107, 51);
		etclabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		etclabel.setForeground(Color.WHITE);
		etclabel.setBounds(398, 1, 150, 51);
		passwordpanel.add(etclabel);

		pwpanel.setBackground(Color.DARK_GRAY);
		pwpanel.setLayout(null);
		pwpanel.add(pwlabel);

		pwtf = new JPasswordField();
		pwtf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwpanel.add(pwtf);
		pwtf.setBounds(107, 0, 283, 51);
		pwtf.setColumns(10);

		pwlabel.setForeground(Color.WHITE);
		pwlabel.setFont(new Font("돋움", Font.BOLD, 16));
		pwlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwlabel.setBounds(0, 0, 107, 51);

		namepanel.setBackground(Color.DARK_GRAY);
		namepanel.setLayout(null);
		namepanel.add(namelabel);

		mainpanel.add(namepanel);
		mainpanel.add(phonepanel);

		nametf = new JTextField();
		nametf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		namepanel.add(nametf);
		nametf.setBounds(108, 0, 283, 51);
		nametf.setColumns(10);

		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("돋움", Font.BOLD, 16));
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setBounds(0, 0, 107, 51);

		midnumber = new JTextField();
		midnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		midnumber.setColumns(10);
		midnumber.setBounds(183, 0, 104, 51);
		
		lastnumber = new JTextField();
		lastnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lastnumber.setBounds(291, 0, 99, 51);
		lastnumber.setColumns(10);
		
		phonepanel.setBackground(Color.DARK_GRAY);
		phonepanel.setLayout(null);
		phonepanel.add(phonelabel);
		fristnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		phonepanel.add(fristnumber);
		phonepanel.add(midnumber);
		phonepanel.add(lastnumber);

		fristnumber.setBounds(107, 0, 72, 51);
		fristnumber.addItem("010");
		fristnumber.addItem("011");
		fristnumber.addItem("017");


		phonelabel.setFont(new Font("굴림", Font.BOLD, 16));
		phonelabel.setForeground(Color.WHITE);
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setBounds(0, 0, 107, 51);
		pUserPoint.setLayout(null);
		pUserPoint.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pUserPoint);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(0, 0, 107, 47);
		
		pUserPoint.add(label);
		tfUserPoint.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfUserPoint.setColumns(10);
		tfUserPoint.setBounds(108, 0, 283, 47);
		
		pUserPoint.add(tfUserPoint);
		pJoinDate.setLayout(null);
		pJoinDate.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pJoinDate);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_1.setBounds(0, 0, 107, 47);
		
		pJoinDate.add(label_1);
		yearJoin.getSpinner().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		yearJoin.setBounds(108, 0, 90, 47);
		
		pJoinDate.add(yearJoin);
		
		monthJoin = new JMonthChooser();
		monthJoin.getSpinner().setBounds(0, 0, 90, 46);
		monthJoin.setBounds(210, 0, 90, 46);
		pJoinDate.add(monthJoin);
		monthJoin.setLayout(null);
		dayJoin.getSpinner().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dayJoin.setMinimum(1);
		dayJoin.setMaximum(31);
		dayJoin.setBounds(312, 0, 78, 47);
		
		pJoinDate.add(dayJoin);
		pSecession.setLayout(null);
		pSecession.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pSecession);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_2.setBounds(0, 0, 107, 47);
		
		pSecession.add(label_2);
		yearSecession.getSpinner().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		yearSecession.setBounds(108, 0, 90, 47);
		
		pSecession.add(yearSecession);
		
		monthSecession = new JMonthChooser();
		monthSecession.getSpinner().setBounds(0, 0, 90, 47);
		monthSecession.setBounds(210, 0, 90, 47);
		pSecession.add(monthSecession);
		monthSecession.setLayout(null);
		daySecession.getSpinner().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		daySecession.setMinimum(1);
		daySecession.setMaximum(31);
		daySecession.setBounds(312, 0, 78, 47);
		
		pSecession.add(daySecession);
		pPasswordQuiz.setLayout(null);
		pPasswordQuiz.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pPasswordQuiz);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_3.setBounds(0, 0, 107, 47);
		
		pPasswordQuiz.add(label_3);
		tfPasswordQuiz.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfPasswordQuiz.setColumns(10);
		tfPasswordQuiz.setBounds(108, 0, 398, 47);
		
		pPasswordQuiz.add(tfPasswordQuiz);
		pPasswordAnswer.setLayout(null);
		pPasswordAnswer.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pPasswordAnswer);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_4.setBounds(0, 0, 107, 47);
		
		pPasswordAnswer.add(label_4);
		tfPasswordAnswer.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfPasswordAnswer.setColumns(10);
		tfPasswordAnswer.setBounds(108, 0, 398, 47);
		
		pPasswordAnswer.add(tfPasswordAnswer);
		pEnable.setLayout(null);
		pEnable.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pEnable);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_5.setBounds(0, 0, 107, 47);
		
		pEnable.add(label_5);
		cbEnable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cbEnable.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		cbEnable.setBounds(107, 0, 83, 47);
		
		pEnable.add(cbEnable);

		selectpanel.setBackground(Color.DARK_GRAY);
		selectpanel.setBounds(313, 660, 245, 44);
		selectpanel.setLayout(null);
		selectpanel.add(registerbtn);
		selectpanel.add(cancelbtn);

		registerbtn.setBounds(12, 5, 110, 39);
		cancelbtn.setBounds(134, 5, 110, 39);
	}
	
	public void clear() {
		
		//id
		idtf.setText("");
		
		//비밀번호
		passwordtf.setText("");
		pwtf.setText("");
		
		//이름
		nametf.setText("");
		
		//전화번호
		fristnumber.setSelectedItem("010");
		midnumber.setText("");
		lastnumber.setText("");
		
		//유저포인트
		tfUserPoint.setText("");
		
		//가입일
		yearJoin.setYear(new GregorianCalendar().get(Calendar.YEAR));
		monthJoin.setMonth(new GregorianCalendar().get(Calendar.MONTH));
		dayJoin.setValue(new GregorianCalendar().get(Calendar.DAY_OF_MONTH));
		
		//탈퇴일
		yearSecession.setEnabled(false);
		monthSecession.setEnabled(false);
		daySecession.setEnabled(false);
		daySecession.setValue(new GregorianCalendar().get(Calendar.DAY_OF_MONTH));
		
		//퀴즈
		tfPasswordQuiz.setText("");
		tfPasswordAnswer.setText("");
		
		//활성화
		cbEnable.setSelectedItem("Y");
		
		//중복확인여부
		check = false;
	}
	
	public UserDto makeUserDto() {
		UserDto userDto = new UserDto();
		
		//비밀번호 확인체크
		String password = new String(passwordtf.getPassword());
		String passwordRe = new String(pwtf.getPassword());
		
		if(password.length() < 6) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "비민번호는 6글자 이상으로 해주세요");
			return null;
		}
		
		if( !isCorrectPassword(password) ) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "비민번호는 숫자 혹은 문자의 조합만 가능합니다.");
			return null;
		}
		
		if( !password.equals(passwordRe)) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "비밀번호가 다릅니다.");
			return null;
		}
		
		//유저포인트 숫자체크
		String userPointStr = tfUserPoint.getText();
		for(int i=0 ; i<userPointStr.length() ; i++) {
			if(userPointStr.charAt(i) < '0' || userPointStr.charAt(i) > '9' ) {
				SwingFactory.getOptionPane("errorMessage", this, "입력오류", "풉키포인트에 문자가 섞였습니다.");
				return null;
			}
		}
		
		//전화번호 숫자체크
		String phoneNumberMiddle = midnumber.getText();
		String phoneNumberLast = lastnumber.getText();
		if( phoneNumberMiddle.length() > 4 || (!isNumber(phoneNumberMiddle)) ) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "중간 전화번호가 잘못되었습니다.");
			return null;
		}
		
		if(phoneNumberLast.length() > 4 || (!isNumber(phoneNumberLast)) ) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "마지막 전화번호가 잘못되었습니다.");
			return null;
		}
		//추가
		//이름
		String name = nametf.getText().trim();
		if(name.isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "이름을 입력해주세요.");
			return null;
		}
		//전화번호 입력안함
		if(phoneNumberMiddle.isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "중간 전화번호를 입력하지 않았습니다.");
			return null;
		}
		//전화번호 입력안함
		if(phoneNumberLast.isEmpty()) {
			SwingFactory.getOptionPane("errorMessage", this, "입력오류", "마지막 전화번호를 입력하지 않았습니다.");
			return null;
		}
		
		userDto.setUserId(idtf.getText().trim());
		userDto.setPassword(new String(pwtf.getPassword()));
		userDto.setName(nametf.getText().trim());
		userDto.setPhoneNumberFirst(String.valueOf(fristnumber.getSelectedItem()));
		userDto.setPhoneNumberMiddle(midnumber.getText().trim());
		userDto.setPhoneNumberlast(lastnumber.getText().trim());
		userDto.setUserPoint(Integer.parseInt(tfUserPoint.getText()));
		userDto.setPasswordQuiz(tfPasswordQuiz.getText().trim());
		userDto.setPasswordAnswer(tfPasswordAnswer.getText().trim());
		
		String joinDate = "" + yearJoin.getYear() + "-" + intTOString(monthJoin.getMonth()+1) + "-" + intTOString(dayJoin.getValue());
		userDto.setJoinDate(joinDate);
		
		if(String.valueOf(cbEnable.getSelectedItem()).equals("Y")) {
			userDto.setSecessionDate("");
		}else {
			String secessionDate = "" + yearSecession.getYear() + "-" + intTOString(monthSecession.getMonth()+1) + "-" + intTOString(daySecession.getValue());
			userDto.setJoinDate(secessionDate);
		}
		
		userDto.setEnable(String.valueOf(cbEnable.getSelectedItem()).charAt(0));
		
		return userDto;
	}
	
	public String intTOString(int value) {
		String str = "";
		if(value < 10) {
			return "0" + value;
		}else {
			return ""+value;
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String enable = String.valueOf(e.getItem());
		if(enable.equals("N")) {
			yearSecession.setEnabled(true);
			monthSecession.setEnabled(true);
			daySecession.setEnabled(true);
		}else {
			yearSecession.setEnabled(false);
			monthSecession.setEnabled(false);
			daySecession.setEnabled(false);
		}
	}
	
	public boolean isNumber(String value) {
		int length = value.length();
		for(int i=0 ; i<length ; i++) {
			if(value.charAt(i) < '0' || value.charAt(i) > '9' ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isCorrectPassword(String password) {
		int length = password.length();
		if(length < 6) {
			return false;
		}
		
		for(int i=0 ; i<length ; i++) {
			char temp = password.charAt(i);
			if( !((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z') || (temp >= '0' && temp <= '9')) ) {
				return false;
			}
		}
		return true;
	}
}
