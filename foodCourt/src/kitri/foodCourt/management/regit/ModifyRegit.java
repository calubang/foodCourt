package kitri.foodCourt.management.regit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.swing.SwingFactory;

public class ModifyRegit extends JPanel implements ItemListener{

	JPanel mainpanel = new JPanel();
	JPanel idpanel = new JPanel();
	JPanel passwordpanel = new JPanel();
	JPanel pwpanel = new JPanel();
	JPanel namepanel = new JPanel();
	JPanel phonepanel = new JPanel();
	JPanel selectpanel = new JPanel();

	JLabel modifylabel = new JLabel("\uC815\uBCF4 \uC218\uC815");
	JLabel idlabel = new JLabel("\uC544\uC774\uB514");
	JLabel etclabel = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790or\uC22B\uC790");
	JLabel passwordlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
	JLabel namelabel = new JLabel("\uC774\uB984");
	JLabel phonelabel = new JLabel("\uD734\uB300\uC804\uD654");

	JButton registerbtn = new JButton("\uC218\uC815");
	JButton cancelbtn = new JButton("\uCDE8\uC18C");
	public JLabel impossibleModify = new JLabel("\uC218\uC815\uBD88\uAC00");

	public EtchedBorder eborder;
	public JPanel enablepanel = new JPanel();
	public JLabel enablelabel = new JLabel("\uD65C\uC131\uD654");
	public JPanel pPasswordQuiz = new JPanel();
	
	public JPanel pPasswordAnswer = new JPanel();
	public JPanel pJoinDate = new JPanel();
	public JPanel pSecessionDate = new JPanel();
	public JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uB2F5\uBCC0");
	public JLabel label_2 = new JLabel("\uAC00\uC785\uC77C");
	public JLabel label_3 = new JLabel("\uD0C8\uD1F4\uC77C");
	
	//데이터 테이블 필드
	public MemberTable memberTable;
	
	//이름
	public JTextField nametf;
	
	//비밀번호 필드
	public JPasswordField passwordtf;
	public JPasswordField pwtf;
	
	//전화번호
	public JComboBox<String> fristnumber;
	public JTextField midnumber;
	public JTextField lastnumber;
	
	//비밀번호 찾기
	public JTextField tfPasswordQuiz;
	public JTextField tfPasswordAnswer;
	
	//가입일, 탈퇴일
	public JYearChooser yearJoin;
	public JMonthChooser monthJoin;
	public JSpinField dayJoin;
	
	public JYearChooser yearSecession;
	public JMonthChooser monthSecession;
	public JSpinField daySecession;
	
	//enable
	public JComboBox<String> cbEnable;
	public JPanel pUserPont = new JPanel();
	public JLabel lbUserPoint = new JLabel("\uD3EC\uC778\uD2B8");
	public JTextField tfUserPoint = new JTextField();

	
	

	/**
	 * Create the panel.
	 */
//	public static void main(String[] args) {
//		JFrame temp = new JFrame();
//		temp.getContentPane().add(null);
//		temp.setVisible(true);
//		temp.setBounds(100, 200, 600, 700);
//	}
	
	public ModifyRegit(MemberTable mt) {
		this.memberTable = mt;
		initView();
		
		//이벤트 등록부
		cbEnable.addItemListener(this);
		

	}
	public void dataSetting() {
		//{ "유저ID", "패스워드", "이름", "핸드폰번호", "사용가능포인트", "비밀번호 찾기용질문", "비밀번호 찾기용답변",  "가입일", "탈퇴일", "활성화여부" };
		
		int row = memberTable.table.convertRowIndexToModel(memberTable.table.getSelectedRow());
		//id
		impossibleModify.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 0)));
		//pw
		passwordtf.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 1)));
		pwtf.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 1)));
		//name
		nametf.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 2)));
		//phone
		fristnumber.setSelectedItem((String.valueOf(memberTable.tableModel.getValueAt(row, 3)).substring(0, 3)));
		midnumber.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 3)).substring(4, 8));
		lastnumber.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 3)).substring(9));
		//userPoint
		tfUserPoint.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 4)));
		
		//가입일
		String dateStr = "";
		StringTokenizer tokenizer;
		if( memberTable.tableModel.getValueAt(row, 7) == null ) {
			GregorianCalendar calendar = new GregorianCalendar();
			yearJoin.setYear(calendar.get(Calendar.YEAR));
			monthJoin.setMonth(calendar.get(Calendar.MONTH));
			dayJoin.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		} else {
			dateStr = String.valueOf(memberTable.tableModel.getValueAt(row, 7)).substring(0, 10);
			tokenizer = new StringTokenizer(dateStr, "-");
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken());
			int date = Integer.parseInt(tokenizer.nextToken());
			
			
			System.out.println(month);
			yearJoin.setYear(year);
			monthJoin.setMonth(month-1);
			dayJoin.setValue(date);
			
		}
		
		//탈퇴일
		if( memberTable.tableModel.getValueAt(row, 8) == null ) {
			GregorianCalendar calendar = new GregorianCalendar();
			yearSecession.setYear(calendar.get(Calendar.YEAR));
			monthSecession.setMonth(calendar.get(Calendar.MONTH));
			daySecession.setValue(calendar.get(Calendar.DAY_OF_MONTH));
			
		} else {
			dateStr = String.valueOf(memberTable.tableModel.getValueAt(row, 8)).substring(0, 10);
			tokenizer = new StringTokenizer(dateStr, "-");
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken());
			int date = Integer.parseInt(tokenizer.nextToken());
			yearSecession.setYear(year);
			monthSecession.setMonth(month-1);
			daySecession.setValue(date);
		}
		
		//비밀번호 퀴즈
		tfPasswordQuiz.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 5)));
		tfPasswordAnswer.setText(String.valueOf(memberTable.tableModel.getValueAt(row, 6)));
		
		//enable
		cbEnable.setSelectedItem(String.valueOf(memberTable.tableModel.getValueAt(row, 9)));
		if(String.valueOf(cbEnable.getSelectedItem()).equals("Y")) {
			yearSecession.setEnabled(false);
			monthSecession.setEnabled(false);
			daySecession.setEnabled(false);
		}
	}
	
	public void initView(){
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		modifylabel.setFont(new Font("돋움", Font.BOLD, 16));
		modifylabel.setBackground(new Color(128, 0, 0));
		modifylabel.setForeground(Color.WHITE);
		modifylabel.setOpaque(true);
		modifylabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifylabel.setBounds(0, 0, 600, 31);

		add(modifylabel);
		add(mainpanel);
		add(selectpanel);

		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setBounds(10, 41, 576, 609);
		mainpanel.setLayout(new GridLayout(11, 1, 0, 10));
		mainpanel.add(idpanel);
		mainpanel.add(passwordpanel);

		idpanel.setOpaque(false);
		idpanel.setForeground(Color.DARK_GRAY);
		idpanel.setBackground(Color.DARK_GRAY);
		idpanel.setLayout(null);
		idpanel.add(idlabel);

		idlabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idlabel.setForeground(Color.WHITE);
		idlabel.setBackground(Color.DARK_GRAY);
		idlabel.setOpaque(true);
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setBounds(0, 0, 107, 47);
		impossibleModify.setEnabled(false);
		impossibleModify.setFont(new Font("돋움", Font.BOLD, 16));
		impossibleModify.setForeground(Color.WHITE);
		impossibleModify.setBackground(Color.DARK_GRAY);
		impossibleModify.setOpaque(true);
		impossibleModify.setBounds(105, 0, 288, 47);
		impossibleModify.setBorder(eborder);
		eborder = new EtchedBorder(EtchedBorder.RAISED);
		idpanel.add(impossibleModify);

		passwordpanel.setBackground(Color.DARK_GRAY);
		passwordpanel.setLayout(null);
		passwordpanel.add(passwordlabel);

		passwordtf = new JPasswordField();
		passwordtf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		passwordpanel.add(passwordtf);
		passwordtf.setBounds(107, 0, 283, 47);
		passwordtf.setColumns(10);

		passwordlabel.setForeground(Color.WHITE);
		passwordlabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlabel.setBounds(0, 0, 107, 47);
		etclabel.setForeground(Color.WHITE);
		etclabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		etclabel.setBounds(395, 0, 181, 47);
		passwordpanel.add(etclabel);

		pwpanel.setBackground(Color.DARK_GRAY);
		pwpanel.setLayout(null);
		pwpanel.add(pwlabel);

		mainpanel.add(pwpanel);
		mainpanel.add(namepanel);
		mainpanel.add(phonepanel);

		pwtf = new JPasswordField();
		pwtf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwpanel.add(pwtf);
		pwtf.setBounds(107, 0, 283, 47);
		pwtf.setColumns(10);

		pwlabel.setForeground(Color.WHITE);
		pwlabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pwlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwlabel.setBounds(0, 0, 107, 47);

		namepanel.setBackground(Color.DARK_GRAY);
		namepanel.setLayout(null);

		nametf = new JTextField();
		nametf.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nametf.setBounds(108, 0, 283, 47);
		nametf.setColumns(10);
		namepanel.add(nametf);

		namelabel.setForeground(Color.WHITE);
		namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setBounds(0, 0, 107, 47);
		namepanel.add(namelabel);

		midnumber = new JTextField();
		midnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		midnumber.setColumns(10);
		midnumber.setBounds(183, 0, 104, 47);

		lastnumber = new JTextField();
		lastnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lastnumber.setBounds(291, 0, 99, 47);
		lastnumber.setColumns(10);

		phonepanel.setBackground(Color.DARK_GRAY);
		fristnumber = new JComboBox<String>();
		fristnumber.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		phonepanel.add(fristnumber);
		phonepanel.add(midnumber);
		phonepanel.add(lastnumber);
		phonepanel.add(phonelabel);
		phonepanel.setLayout(null);

		fristnumber.setBounds(108, 0, 72, 47);
		fristnumber.addItem("010");
		fristnumber.addItem("011");
		fristnumber.addItem("017");

		phonelabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phonelabel.setForeground(Color.WHITE);
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setBounds(0, 0, 107, 47);
		pUserPont.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pUserPont);
		pUserPont.setLayout(null);
		lbUserPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserPoint.setForeground(Color.WHITE);
		lbUserPoint.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbUserPoint.setBounds(0, 0, 107, 47);
		
		pUserPont.add(lbUserPoint);
		tfUserPoint.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfUserPoint.setColumns(10);
		tfUserPoint.setBounds(108, 0, 283, 47);
		
		pUserPont.add(tfUserPoint);
		pJoinDate.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pJoinDate);
		pJoinDate.setLayout(null);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_2.setBounds(0, 0, 107, 47);
		
		pJoinDate.add(label_2);
		
		yearJoin = new JYearChooser();
		yearJoin.setBounds(108, 0, 90, 47);
		pJoinDate.add(yearJoin);
		
		monthJoin = new JMonthChooser();
		monthJoin.getSpinner().setBounds(0, 0, 90, 47);
		monthJoin.setBounds(210, 0, 90, 47);
		pJoinDate.add(monthJoin);
		monthJoin.setLayout(null);
		
		dayJoin = new JSpinField();
		dayJoin.setBounds(312, 0, 78, 47);
		dayJoin.setMaximum(31);
		dayJoin.setMinimum(1);
		pJoinDate.add(dayJoin);
		pSecessionDate.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pSecessionDate);
		pSecessionDate.setLayout(null);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_3.setBounds(0, 0, 107, 47);
		
		pSecessionDate.add(label_3);
		
		yearSecession = new JYearChooser();
		yearSecession.setBounds(108, 0, 90, 47);
		pSecessionDate.add(yearSecession);
		
		monthSecession = new JMonthChooser();
		monthSecession.getSpinner().setBounds(0, 0, 90, 47);
		monthSecession.setBounds(210, 0, 90, 47);
		pSecessionDate.add(monthSecession);
		monthSecession.setLayout(null);
		
		daySecession = new JSpinField();
		daySecession.setBounds(312, 0, 78, 47);
		daySecession.setMaximum(31);
		daySecession.setMinimum(1);
		pSecessionDate.add(daySecession);
		pPasswordQuiz.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pPasswordQuiz);
		pPasswordQuiz.setLayout(null);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD034\uC988");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(0, 0, 107, 47);
		pPasswordQuiz.add(label);
		tfPasswordQuiz = new JTextField();
		tfPasswordQuiz.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfPasswordQuiz.setColumns(10);
		tfPasswordQuiz.setBounds(108, 0, 456, 47);
		
		pPasswordQuiz.add(tfPasswordQuiz);
		pPasswordAnswer.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(pPasswordAnswer);
		pPasswordAnswer.setLayout(null);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_1.setBounds(0, 0, 107, 47);
		
		pPasswordAnswer.add(label_1);
		tfPasswordAnswer = new JTextField();
		tfPasswordAnswer.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfPasswordAnswer.setColumns(10);
		tfPasswordAnswer.setBounds(108, 0, 456, 47);
		
		pPasswordAnswer.add(tfPasswordAnswer);
		enablepanel.setLayout(null);
		enablepanel.setBackground(Color.DARK_GRAY);
		
		mainpanel.add(enablepanel);
		enablelabel.setHorizontalAlignment(SwingConstants.CENTER);
		enablelabel.setForeground(Color.WHITE);
		enablelabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		enablelabel.setBounds(0, 0, 107, 47);
		
		enablepanel.add(enablelabel);
		
		cbEnable = new JComboBox();
		cbEnable.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		cbEnable.setBounds(107, 0, 83, 47);
		enablepanel.add(cbEnable);

		selectpanel.setBackground(Color.DARK_GRAY);
		selectpanel.setBounds(341, 660, 245, 44);
		selectpanel.setLayout(null);
		selectpanel.add(registerbtn);
		selectpanel.add(cancelbtn);

		registerbtn.setBounds(12, 5, 110, 39);
		cancelbtn.setBounds(134, 5, 110, 39);
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
		
		userDto.setUserId(impossibleModify.getText());
		userDto.setPassword(new String(pwtf.getPassword()));
		userDto.setName(nametf.getText());
		
		
		userDto.setPhoneNumberFirst(String.valueOf(fristnumber.getSelectedItem()));
		userDto.setPhoneNumberMiddle(phoneNumberMiddle);
		userDto.setPhoneNumberlast(phoneNumberLast);
		userDto.setPasswordQuiz(tfPasswordQuiz.getText());
		userDto.setPasswordAnswer(tfPasswordAnswer.getText());
		
		
		userDto.setUserPoint(Integer.valueOf(userPointStr));
		
		String joinDate = yearJoin.getYear() + "-" + intTOString(monthJoin.getMonth()+1) + "-" + intTOString(dayJoin.getValue());
		userDto.setJoinDate(joinDate);
		
		String secessionDate = "";
		if(String.valueOf(cbEnable.getSelectedItem()).equals("Y")) {
			secessionDate = "";
		}else {
			secessionDate = yearSecession.getYear() + "-" + intTOString(monthSecession.getMonth()+1) + "-" + intTOString(daySecession.getValue());
		}

		userDto.setSecessionDate(secessionDate);
		userDto.setEnable(String.valueOf(cbEnable.getSelectedItem()).charAt(0));
		
		return userDto;
	}
	
	public void clear() {
		
		
		impossibleModify.setText("");
		
		pwtf.setText("");
		passwordtf.setText("");
		
		nametf.setText("");
		
		tfUserPoint.setText("");
		
		fristnumber.setSelectedItem("010");
		midnumber.setText("");
		lastnumber.setText("");
		
		tfPasswordQuiz.setText("");
		tfPasswordAnswer.setText("");
		
		GregorianCalendar calendar = new GregorianCalendar();
		yearJoin.setYear(calendar.get(Calendar.YEAR));
		monthJoin.setMonth(calendar.get(Calendar.MONTH)+1);
		dayJoin.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		
		yearSecession.setYear(calendar.get(Calendar.YEAR));
		monthSecession.setMonth(calendar.get(Calendar.MONTH)+1);
		daySecession.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		
		cbEnable.setSelectedItem("Y");
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
