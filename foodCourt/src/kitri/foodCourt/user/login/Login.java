package kitri.foodCourt.user.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kitri.foodCourt.util.Constance;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Login extends JPanel {
	
	public JPasswordField pwtextfd;
	public JTextField idtextField;
	public JLabel label_2;
	public JLabel idlabel;
	public JLabel pwlabel;
	
	public JButton joinbtn;
	public JButton findidbtn;
	public JButton findpwbtn;
	public JButton loginbtn;

	public LoginControl loginControl;
	public LoginMain loginMain;

	public Login(LoginMain loginMain){
     this.loginMain = loginMain;
     this.loginControl = loginMain.loginControl;
     
     setBackground(Color.WHITE);
     setLayout(null);
     setBounds(0, 0, 1200, 800);
     
     this.pwlabel = new JLabel("PW");
     pwlabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     this.pwlabel.setOpaque(true);
     this.pwlabel.setHorizontalAlignment(0);
     this.pwlabel.setForeground(new Color(0, 0, 0));
     this.pwlabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
     this.pwlabel.setBounds(new Rectangle(340, 465, 81, 39));
     this.pwlabel.setBackground(SystemColor.inactiveCaptionBorder);
     this.pwlabel.setBounds(319, 459, 81, 39);
     add(this.pwlabel);
     
     this.loginbtn = new JButton("로그인");
     loginbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     this.loginbtn.setBackground(SystemColor.inactiveCaptionBorder);
     this.loginbtn.setBounds(319, 510, 532, 33);
     add(this.loginbtn);
     
     this.joinbtn = new JButton("회원가입");
     joinbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     this.joinbtn.setBackground(SystemColor.inactiveCaptionBorder);
     this.joinbtn.setBounds(319, 553, 157, 33);
     add(this.joinbtn);
     
     this.pwtextfd = new JPasswordField();
     pwtextfd.setBorder(new LineBorder(Color.BLACK, 1, true));
     this.pwtextfd.setEchoChar('*');
     this.pwtextfd.setColumns(10);
     this.pwtextfd.setBounds(412, 459, 439, 39);
     add(this.pwtextfd);
     
     this.findidbtn = new JButton("아이디 찾기");
     findidbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     this.findidbtn.setBackground(SystemColor.inactiveCaptionBorder);
     this.findidbtn.setBounds(514, 553, 157, 33);
     add(this.findidbtn);
     
     this.findpwbtn = new JButton("비밀번호 찾기");
     findpwbtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     
 
 
     this.findpwbtn.setBackground(SystemColor.inactiveCaptionBorder);
     this.findpwbtn.setBounds(694, 553, 157, 33);
     add(this.findpwbtn);
     
     this.idtextField = new JTextField();
     idtextField.setBorder(new LineBorder(Color.BLACK, 1, true));
     this.idtextField.setColumns(10);
     this.idtextField.setBounds(412, 410, 439, 39);
     add(this.idtextField);
     
     this.idlabel = new JLabel("ID");
     idlabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
     this.idlabel.setOpaque(true);
     this.idlabel.setHorizontalAlignment(0);
     this.idlabel.setForeground(new Color(0, 0, 0));
     this.idlabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
     this.idlabel.setBounds(new Rectangle(340, 465, 81, 39));
     this.idlabel.setBackground(SystemColor.inactiveCaptionBorder);
     this.idlabel.setBounds(319, 410, 81, 39);
     add(this.idlabel);
     
     this.label_2 = new JLabel();
     this.label_2.setIcon(new ImageIcon(Login.class.getResource(Constance.USER_IMAGE_PATH+"mainimage.png")));
     this.label_2.setBounds(412, 84, 365, 274);
     add(this.label_2);
     
//   this.findpwbtn.addActionListener(new Login.1(this));

     
   }
}






