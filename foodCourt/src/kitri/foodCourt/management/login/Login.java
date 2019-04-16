package kitri.foodCourt.management.login;

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

@SuppressWarnings("serial")
public class Login extends JPanel {
	
	public JPasswordField pwtextfd;
	public JTextField idtextField;
	public JLabel label_2;
	public JLabel idlabel;
	public JLabel pwlabel;
	public JButton loginbtn;

	public LoginMain loginMain;

	public Login(LoginMain loginMain){
     this.loginMain = loginMain;
     
     setBackground(Color.WHITE);
     setLayout(null);
     setBounds(0, 0, 1200, 800);
     
     this.pwlabel = new JLabel("PW");
     this.pwlabel.setOpaque(true);
     this.pwlabel.setHorizontalAlignment(0);
     this.pwlabel.setForeground(Color.WHITE);
     this.pwlabel.setFont(new Font("±¼¸²", 0, 14));
     this.pwlabel.setBounds(new Rectangle(340, 465, 81, 39));
     this.pwlabel.setBackground(new Color(0, 153, 255));
     this.pwlabel.setBounds(319, 522, 81, 39);
     add(this.pwlabel);
     
     this.loginbtn = new JButton("·Î±×ÀÎ");
     this.loginbtn.setBackground(new Color(0, 153, 255));
     this.loginbtn.setBounds(319, 573, 532, 33);
     add(this.loginbtn);
     
     this.pwtextfd = new JPasswordField();
     this.pwtextfd.setEchoChar('*');
     this.pwtextfd.setColumns(10);
     this.pwtextfd.setBounds(412, 528, 439, 28);
     add(this.pwtextfd);
     
     this.idtextField = new JTextField();
     this.idtextField.setColumns(10);
     this.idtextField.setBounds(412, 479, 439, 28);
     add(this.idtextField);
     
     this.idlabel = new JLabel("ID");
     this.idlabel.setOpaque(true);
     this.idlabel.setHorizontalAlignment(0);
     this.idlabel.setForeground(Color.WHITE);
     this.idlabel.setFont(new Font("±¼¸²", 0, 14));
     this.idlabel.setBounds(new Rectangle(340, 465, 81, 39));
     this.idlabel.setBackground(new Color(0, 153, 255));
     this.idlabel.setBounds(319, 473, 81, 39);
     add(this.idlabel);
     
     this.label_2 = new JLabel();
     this.label_2.setIcon(new ImageIcon(Login.class.getResource(Constance.USER_IMAGE_PATH+"mainimage.png")));
     this.label_2.setBounds(412, 84, 365, 274);
     add(this.label_2);
   }
}






