package kitri.foodCourt.user.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kitri.foodCourt.util.Constance;
 
public class Join extends JPanel
{
   public JTextField idTextFD;
   public JTextField nameFD;
   public JTextField phLastFD;
   public JTextField phMiddleFD;
   public JTextField questionTF;
   public JTextField answerTF;
   public JPasswordField pwTextFD; 
   public JPasswordField pwCheckFD;
   public JButton cancelbtn;
   public JButton signupbtn;
   public JButton doublechekbtn;
   public JComboBox comboBox;
   public JLabel pwCheckL;
  
   public LoginMain loginMain;
   public JLabel label_7;
   public JLabel label_8;
   public JLabel lblNewLabel_1;
   public JLabel label_10;
   public JLabel label_11;
   public JLabel label_12;
   public JLabel label_13;
   public JLabel label_14;
   
   public Join(LoginMain loginMain)
   {
     this.loginMain = loginMain;
     
     setLayout(null);
     setBounds(0, 0, 1200, 800);
     
     JLabel label = new JLabel("¾ÆÀÌµð");
     label.setOpaque(true);
     label.setHorizontalAlignment(0);
     label.setForeground(Color.WHITE);
     label.setFont(new Font("±¼¸²", 0, 14));
     label.setBackground(new Color(0, 153, 255));
     label.setBounds(145, 233, 121, 30);
     add(label);
     
     JLabel label_1 = new JLabel("È¸¿ø°¡ÀÔ");
     label_1.setHorizontalAlignment(0);
     label_1.setFont(new Font("µ¸¿ò", 1, 20));
     label_1.setBounds(134, 77, 121, 45);
     add(label_1);
     
     this.idTextFD = new JTextField();
     this.idTextFD.setColumns(10);
     this.idTextFD.setBounds(295, 234, 319, 30);
     add(this.idTextFD);
     
     JLabel label_2 = new JLabel("ºñ¹Ð¹øÈ£");
     label_2.setOpaque(true);
     label_2.setHorizontalAlignment(0);
     label_2.setForeground(Color.WHITE);
     label_2.setFont(new Font("±¼¸²", 0, 14));
     label_2.setBackground(new Color(0, 153, 255));
     label_2.setBounds(145, 332, 121, 30);
     add(label_2);
     
     
     this.pwTextFD = new JPasswordField();
     this.pwTextFD.setEchoChar('*');
     this.pwTextFD.setColumns(10);
     this.pwTextFD.setBounds(295, 333, 319, 30);
     add(this.pwTextFD);
     
     JLabel label_3 = new JLabel("ºñ¹Ð¹øÈ£ È®ÀÎ");
     label_3.setOpaque(true);
     label_3.setHorizontalAlignment(0);
     label_3.setForeground(Color.WHITE);
     label_3.setFont(new Font("±¼¸²", 0, 14));
     label_3.setBackground(new Color(0, 153, 255));
     label_3.setBounds(145, 387, 121, 30);
     add(label_3);;
     
     this.pwCheckFD = new JPasswordField();
     this.pwCheckFD.setEchoChar('*');
     this.pwCheckFD.setColumns(10);
     this.pwCheckFD.setBounds(295, 388, 319, 30);
     add(this.pwCheckFD);
     
     JLabel label_4 = new JLabel("ÀÌ¸§");
     label_4.setOpaque(true);
     label_4.setHorizontalAlignment(0);
     label_4.setForeground(Color.WHITE);
     label_4.setFont(new Font("±¼¸²", 0, 14));
     label_4.setBackground(new Color(0, 153, 255));
     label_4.setBounds(145, 436, 121, 30);
     add(label_4);
     
     this.nameFD = new JTextField();
     this.nameFD.setColumns(10);
     this.nameFD.setBounds(295, 437, 319, 30);
     add(this.nameFD);
     
     JLabel label_5 = new JLabel("ÈÞ´ëÀüÈ­");
     label_5.setOpaque(true);
     label_5.setHorizontalAlignment(0);
     label_5.setForeground(Color.WHITE);
     label_5.setFont(new Font("±¼¸²", 0, 14));
     label_5.setBackground(new Color(0, 153, 255));
     label_5.setBounds(145, 489, 121, 30);
     add(label_5);
     
     this.phLastFD = new JTextField();
     this.phLastFD.setColumns(10);
     this.phLastFD.setBounds(512, 490, 102, 30);
     add(this.phLastFD);
     
     this.phMiddleFD = new JTextField();
     this.phMiddleFD.setColumns(10);
     this.phMiddleFD.setBounds(398, 491, 102, 30);
     add(this.phMiddleFD);
     
     this.doublechekbtn = new JButton("Áßº¹È®ÀÎ");
     this.doublechekbtn.setBounds(615, 233, 97, 31);
     add(this.doublechekbtn);
     
     JLabel label_6 = new JLabel("6\uC790\uB9AC\uC774\uC0C1 \uC785\uB825\uD574 \uC8FC\uC138\uC694.");
     label_6.setHorizontalAlignment(2);
     label_6.setFont(new Font("±¼¸²", 0, 11));
     label_6.setBounds(295, 315, 137, 15);
     add(label_6);
     
     pwCheckL = new JLabel("");
     pwCheckL.setFont(new Font("±¼¸²", Font.PLAIN, 11));
     pwCheckL.setHorizontalAlignment(2);
     pwCheckL.setBounds(295, 373, 193, 15);
     add(pwCheckL);
     
     this.comboBox = new JComboBox();
     this.comboBox.setBounds(295, 490, 89, 30);
     add(comboBox);
     comboBox.addItem("010");
     comboBox.addItem("011");
     comboBox.addItem("017");
     comboBox.addItem("019");
     
     this.signupbtn = new JButton("È¸¿ø°¡ÀÔ");
     this.signupbtn.setFont(new Font("±¼¸²", 0, 14));
     this.signupbtn.setBounds(512, 664, 121, 30);
     add(this.signupbtn);
     
     this.cancelbtn = new JButton("Ãë¼Ò");
     this.cancelbtn.setFont(new Font("±¼¸²", 0, 14));
     this.cancelbtn.setBounds(645, 664, 121, 30);
     add(this.cancelbtn);
     
     JPanel panel = new JPanel();
     panel.setBackground(Color.LIGHT_GRAY);
     panel.setBounds(145, 120, 1027, 2);
     add(panel);
     
     JLabel lblNewLabel = new JLabel("");
     lblNewLabel.setBackground(Color.WHITE);
     lblNewLabel.setIcon(new ImageIcon(Join.class.getResource(Constance.USER_IMAGE_PATH + "duck.png")));
     lblNewLabel.setBounds(861, 453, 327, 308);
     add(lblNewLabel);
     
     label_7 = new JLabel("\uC9C8\uBB38");
     label_7.setOpaque(true);
     label_7.setHorizontalAlignment(SwingConstants.CENTER);
     label_7.setForeground(Color.WHITE);
     label_7.setFont(new Font("±¼¸²", Font.PLAIN, 14));
     label_7.setBackground(new Color(0, 153, 255));
     label_7.setBounds(651, 331, 121, 30);
     add(label_7);
     
     questionTF = new JTextField();
     questionTF.setColumns(10);
     questionTF.setBounds(801, 332, 319, 30);
     add(questionTF);
     
     label_8 = new JLabel("\uB2F5\uBCC0");
     label_8.setOpaque(true);
     label_8.setHorizontalAlignment(SwingConstants.CENTER);
     label_8.setForeground(Color.WHITE);
     label_8.setFont(new Font("±¼¸²", Font.PLAIN, 14));
     label_8.setBackground(new Color(0, 153, 255));
     label_8.setBounds(651, 386, 121, 30);
     add(label_8);
     
     answerTF = new JTextField();
     answerTF.setColumns(10);
     answerTF.setBounds(801, 387, 319, 30);
     add(answerTF);
     
     JLabel label_9 = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC744\uB54C\uC758 \uC9C8\uBB38\uC744 \uC785\uB825\uD574 \uC8FC\uC138\uC694.");
     label_9.setHorizontalAlignment(SwingConstants.LEFT);
     label_9.setFont(new Font("±¼¸²", Font.PLAIN, 11));
     label_9.setBounds(801, 314, 230, 15);
     add(label_9);
     
     lblNewLabel_1 = new JLabel("* \uD544\uC218 \uC785\uB825\uBC14\uB78D\uB2C8\uB2E4.");
     lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
     lblNewLabel_1.setForeground(Color.RED);
     lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
     lblNewLabel_1.setBounds(145, 208, 121, 15);
     add(lblNewLabel_1);
     
     label_10 = new JLabel("*");
     label_10.setFont(new Font("±¼¸²", Font.BOLD, 16));
     label_10.setHorizontalAlignment(SwingConstants.LEFT);
     label_10.setForeground(Color.RED);
     label_10.setBounds(134, 332, 13, 15);
     add(label_10);
     
     label_11 = new JLabel("*");
     label_11.setHorizontalAlignment(SwingConstants.LEFT);
     label_11.setForeground(Color.RED);
     label_11.setFont(new Font("±¼¸²", Font.BOLD, 16));
     label_11.setBounds(134, 233, 13, 15);
     add(label_11);
     
     label_12 = new JLabel("*");
     label_12.setHorizontalAlignment(SwingConstants.LEFT);
     label_12.setForeground(Color.RED);
     label_12.setFont(new Font("±¼¸²", Font.BOLD, 16));
     label_12.setBounds(134, 387, 13, 15);
     add(label_12);
     
     label_13 = new JLabel("*");
     label_13.setHorizontalAlignment(SwingConstants.LEFT);
     label_13.setForeground(Color.RED);
     label_13.setFont(new Font("±¼¸²", Font.BOLD, 16));
     label_13.setBounds(134, 436, 13, 15);
     add(label_13);
     
     label_14 = new JLabel("*");
     label_14.setHorizontalAlignment(SwingConstants.LEFT);
     label_14.setForeground(Color.RED);
     label_14.setFont(new Font("±¼¸²", Font.BOLD, 16));
     label_14.setBounds(134, 489, 13, 15);
     add(label_14);
   }
}

