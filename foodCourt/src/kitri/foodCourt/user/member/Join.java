package kitri.foodCourt.user.member;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Join extends JPanel
{
   public JTextField idTextFD;
   public JTextField pwTextFD;
   public JTextField pwCheckFD;
   public JTextField nameFD;
   public JTextField phLastFD;
   public JTextField phMiddleFD;
   public JButton cancelbtn;
   public JButton sinupbtn;
   public JButton doublechekbtn;
   public JComboBox comboBox;
  
   public LoginMain loginMain;
   
   public Join(LoginMain loginMain)
   {
     this.loginMain = loginMain;
     
     setLayout(null);
     setBounds(0, 0, 1200, 800);
     
     JLabel label = new JLabel("아이디");
     label.setOpaque(true);
     label.setHorizontalAlignment(0);
     label.setForeground(Color.WHITE);
     label.setFont(new Font("굴림", 0, 14));
     label.setBackground(new Color(0, 153, 255));
     label.setBounds(258, 266, 121, 30);
     add(label);
     
     JLabel label_1 = new JLabel("회원가입");
     label_1.setHorizontalAlignment(0);
     label_1.setFont(new Font("돋움", 1, 20));
     label_1.setBounds(134, 77, 121, 45);
     add(label_1);
     
     this.idTextFD = new JTextField();
     this.idTextFD.setColumns(10);
     this.idTextFD.setBounds(408, 267, 319, 30);
     add(this.idTextFD);
     
     JLabel label_2 = new JLabel("비밀번호");
     label_2.setOpaque(true);
     label_2.setHorizontalAlignment(0);
     label_2.setForeground(Color.WHITE);
     label_2.setFont(new Font("굴림", 0, 14));
     label_2.setBackground(new Color(0, 153, 255));
     label_2.setBounds(258, 365, 121, 30);
     add(label_2);
     
     this.pwTextFD = new JTextField();
     this.pwTextFD.setColumns(10);
     this.pwTextFD.setBounds(408, 366, 319, 30);
     add(this.pwTextFD);
     
     JLabel label_3 = new JLabel("비밀번호 확인");
     label_3.setOpaque(true);
     label_3.setHorizontalAlignment(0);
     label_3.setForeground(Color.WHITE);
     label_3.setFont(new Font("굴림", 0, 14));
     label_3.setBackground(new Color(0, 153, 255));
     label_3.setBounds(258, 420, 121, 30);
     add(label_3);
     
     this.pwCheckFD = new JTextField();
     this.pwCheckFD.setColumns(10);
     this.pwCheckFD.setBounds(408, 421, 319, 30);
     add(this.pwCheckFD);
     
     JLabel label_4 = new JLabel("이름");
     label_4.setOpaque(true);
     label_4.setHorizontalAlignment(0);
     label_4.setForeground(Color.WHITE);
     label_4.setFont(new Font("굴림", 0, 14));
     label_4.setBackground(new Color(0, 153, 255));
     label_4.setBounds(258, 469, 121, 30);
     add(label_4);
     
     this.nameFD = new JTextField();
     this.nameFD.setColumns(10);
     this.nameFD.setBounds(408, 470, 319, 30);
     add(this.nameFD);
     
     JLabel label_5 = new JLabel("휴대전화");
     label_5.setOpaque(true);
     label_5.setHorizontalAlignment(0);
     label_5.setForeground(Color.WHITE);
     label_5.setFont(new Font("굴림", 0, 14));
     label_5.setBackground(new Color(0, 153, 255));
     label_5.setBounds(258, 522, 121, 30);
     add(label_5);
     
     this.phLastFD = new JTextField();
     this.phLastFD.setColumns(10);
     this.phLastFD.setBounds(625, 523, 102, 30);
     add(this.phLastFD);
     
     this.phMiddleFD = new JTextField();
     this.phMiddleFD.setColumns(10);
     this.phMiddleFD.setBounds(511, 524, 102, 30);
     add(this.phMiddleFD);
     
     this.doublechekbtn = new JButton("중복확인");
     this.doublechekbtn.setBounds(728, 266, 97, 31);
     add(this.doublechekbtn);
     
     JLabel label_6 = new JLabel("6자리이상 문자, 숫자 조합");
     label_6.setHorizontalAlignment(2);
     label_6.setFont(new Font("굴림", 0, 11));
     label_6.setBounds(408, 348, 137, 15);
     add(label_6);
     
     JLabel label_7 = new JLabel("비밀번호가 올바르지 않습니다.");
     label_7.setHorizontalAlignment(2);
     label_7.setBounds(728, 373, 176, 15);
     add(label_7);
     
     JLabel label_8 = new JLabel("비밀번호가 다릅니다.");
     label_8.setHorizontalAlignment(2);
     label_8.setBounds(728, 428, 155, 15);
     add(label_8);
     
     this.comboBox = new JComboBox();
     this.comboBox.setBounds(408, 523, 89, 30);
     add(comboBox);
     comboBox.addItem("010");
     comboBox.addItem("011");
     comboBox.addItem("017");
     comboBox.addItem("019");
     
     this.sinupbtn = new JButton("회원가입");
     this.sinupbtn.setFont(new Font("굴림", 0, 14));
     this.sinupbtn.setBounds(418, 668, 121, 30);
     add(this.sinupbtn);
     
     this.cancelbtn = new JButton("취소");
     this.cancelbtn.setFont(new Font("굴림", 0, 14));
     this.cancelbtn.setBounds(551, 668, 121, 30);
     add(this.cancelbtn);
     
     JPanel panel = new JPanel();
     panel.setBackground(Color.LIGHT_GRAY);
     panel.setBounds(145, 120, 1027, 2);
     add(panel);
     
     JLabel lblNewLabel = new JLabel("");
     lblNewLabel.setBackground(Color.WHITE);
     lblNewLabel.setIcon(new ImageIcon(Join.class.getResource("/kitri/foodCourt/user/member/duck.png")));
     lblNewLabel.setBounds(861, 453, 327, 308);
     add(lblNewLabel);
   }
}

