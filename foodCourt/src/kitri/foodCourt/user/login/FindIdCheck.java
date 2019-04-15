package kitri.foodCourt.user.login;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FindIdCheck extends JPanel {
	
	FindIdMain findIdMainId;
	
	public JButton Confirm;
	public JLabel nameL;

	public FindIdCheck(FindIdMain findIdMainId)
   {
    
	this.findIdMainId = findIdMainId;
  
    setBounds(0, 0, 650, 400);
    setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(24, 94, 564, 3);
    add(panel);
    
    JLabel label = new JLabel("1.본인확인");
    label.setOpaque(true);
    label.setHorizontalAlignment(0);
    label.setForeground(Color.WHITE);
    label.setBackground(Color.GRAY);
    label.setBounds(412, 65, 75, 28);
    add(label);
    
    JLabel label_1 = new JLabel("2.아이디 확인");
    label_1.setOpaque(true);
    label_1.setHorizontalAlignment(0);
    label_1.setForeground(Color.WHITE);
    label_1.setBackground(new Color(0, 153, 255));
    label_1.setBounds(489, 65, 96, 28);
    add(label_1);
   
    JLabel label_2 = new JLabel("아이디 찾기");
    label_2.setFont(new Font("굴림", 1, 18));
    label_2.setBounds(24, 50, 206, 37);
    add(label_2);
    
    this.nameL = new JLabel("이름");
    this.nameL.setHorizontalAlignment(0);
    this.nameL.setFont(new Font("굴림", 0, 17));
    this.nameL.setBounds(167, 179, 283, 37);
    add(this.nameL);
    
    this.Confirm = new JButton("확인");
    
 

    this.Confirm.setBackground(new Color(0, 153, 255));
    this.Confirm.setBounds(456, 327, 85, 30);
    add(this.Confirm);
    
    
//  this.Confirm.addActionListener(new FindIdCheck.1(this));

    
   }
}

