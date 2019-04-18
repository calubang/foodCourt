package kitri.foodCourt.user.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindId extends JPanel {
	
	public JTextField middleTF;
	public JTextField lastTF;
	public JTextField nameTF;
	public JButton nextbtn;
	public JButton cancelbtn;
	public JComboBox comboBox;
	public CardLayout findCard = new CardLayout();
	
	public JLabel label;
	public JLabel label_1;
	public JPanel panel;
	public JLabel label_2;
	
	FindIdMain findIdMain;
	
	public FindId(FindIdMain findIdMain) {
		
		this.findIdMain = findIdMain;
		
		setBounds(0, 0, 650, 400);
		setLayout(null);
		    
		this.nextbtn = new JButton("다음");
		this.nextbtn.setBackground(new Color(0, 153, 255));
		    
		
		this.nextbtn.setBounds(355, 327, 85, 30);
		add(this.nextbtn);
		    
		this.middleTF = new JTextField();
		this.middleTF.setColumns(10);
		this.middleTF.setBounds(220, 226, 104, 37);
		add(this.middleTF);
		    
		this.comboBox = new JComboBox();
		this.comboBox.setBounds(133, 226, 75, 37);
		add(comboBox);
	    comboBox.addItem("010");
	    comboBox.addItem("011");
	    comboBox.addItem("017");
	    comboBox.addItem("019");
		   
		this.lastTF = new JTextField();
		this.lastTF.setColumns(10);
		this.lastTF.setBounds(336, 226, 104, 37);
		add(this.lastTF);
		    
		this.nameTF = new JTextField();
		this.nameTF.setColumns(10);
		this.nameTF.setBounds(133, 168, 307, 37);
		add(this.nameTF);
		
		JLabel label_4 = new JLabel("이름");
		label_4.setFont(new Font("굴림", 0, 17));
		label_4.setBounds(46, 168, 75, 37);
		add(label_4);
		 
		JLabel label_5 = new JLabel("전화번호");
		label_5.setFont(new Font("굴림", 0, 17));
		label_5.setBounds(46, 226, 75, 37);
		add(label_5);
		
		this.cancelbtn = new JButton("취소");
		this.cancelbtn.setBackground(new Color(0, 153, 255));
		     
		
		
		this.cancelbtn.setBounds(456, 327, 85, 30);
		add(this.cancelbtn);
		    
		this.label = new JLabel("1.본인확인");
		this.label.setOpaque(true);
		this.label.setHorizontalAlignment(0);
		this.label.setForeground(Color.WHITE);
		this.label.setBackground(new Color(0, 153, 255));
		this.label.setBounds(412, 65, 75, 28);
		add(this.label);
		     
		this.label_1 = new JLabel("2.아이디 확인");
		this.label_1.setOpaque(true);
		this.label_1.setHorizontalAlignment(0);
		this.label_1.setForeground(Color.WHITE);
		this.label_1.setBackground(Color.GRAY);
		this.label_1.setBounds(489, 65, 96, 28);
		add(this.label_1);
		  
		this.panel = new JPanel();
		this.panel.setBackground(Color.LIGHT_GRAY);
		this.panel.setBounds(24, 94, 564, 3);
		add(this.panel);
		     
		this.label_2 = new JLabel("아이디 찾기");
		this.label_2.setFont(new Font("굴림", 1, 18));
		this.label_2.setBounds(24, 50, 206, 37);
		add(this.label_2);
		


		
		
	}

}
