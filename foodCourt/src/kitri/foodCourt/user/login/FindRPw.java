package kitri.foodCourt.user.login;
 
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FindRPw extends JPanel
{
   public JTextField pwTF;
   public JTextField againPwTF;
   public JButton cancelbtn;
   public JButton confirmbtn;
   public JLabel checkL;
   
   FindPwMain findPwMain;

   public FindRPw(FindPwMain findPwMain)
   {
     this.findPwMain = findPwMain;
     
     setBounds(0, 0, 650, 400);
     setLayout(null);
     
     this.cancelbtn = new JButton("취소");
     this.cancelbtn.setBackground(new Color(0, 153, 255));
     this.cancelbtn.setBounds(488, 281, 85, 30);
     add(this.cancelbtn);
     
     this.confirmbtn = new JButton("확인");
     confirmbtn.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     	}
     });
     this.confirmbtn.setBackground(new Color(0, 153, 255));
     this.confirmbtn.setBounds(391, 281, 85, 30);
     add(this.confirmbtn);
     
     JLabel label = new JLabel("1.아이디 입력");
     label.setOpaque(true);
     label.setHorizontalAlignment(0);
     label.setForeground(Color.WHITE);
     label.setBackground(Color.GRAY);
     label.setBounds(273, 62, 98, 28);
     add(label);
     
     JLabel label_1 = new JLabel("2.본인확인");
     label_1.setOpaque(true);
     label_1.setHorizontalAlignment(0);
     label_1.setForeground(Color.WHITE);
     label_1.setBackground(Color.GRAY);
     label_1.setBounds(373, 62, 94, 28);
     add(label_1);
     
     JLabel label_2 = new JLabel("3.비밀번호 재설정");
     label_2.setOpaque(true);
     label_2.setHorizontalAlignment(0);
     label_2.setForeground(Color.WHITE);
     label_2.setBackground(new Color(0, 153, 255));
     label_2.setBounds(469, 62, 119, 28);
     add(label_2);
     
     JPanel panel = new JPanel();
     panel.setBackground(Color.LIGHT_GRAY);
     panel.setBounds(38, 92, 550, 3);
     add(panel);
     
     JLabel label_3 = new JLabel("비밀번호 찾기");
     label_3.setFont(new Font("굴림", 1, 18));
     label_3.setBounds(38, 45, 206, 45);
     add(label_3);
     
     JLabel label_4 = new JLabel("비밀번호");
     label_4.setFont(new Font("굴림", 0, 17));
     label_4.setBounds(60, 156, 75, 37);
     add(label_4);
     
     this.pwTF = new JTextField();
     this.pwTF.setColumns(10);
     this.pwTF.setBounds(147, 156, 307, 37);
     add(this.pwTF);
    
     checkL = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574 \uC8FC\uC138\uC694.");
     checkL.setFont(new Font("굴림", 0, 12));
     checkL.setBounds(147, 260, 168, 23);
     add(checkL);
     
     this.againPwTF = new JTextField();
     this.againPwTF.setColumns(10);
     this.againPwTF.setBounds(147, 213, 307, 37);
     add(this.againPwTF);
     
     JLabel label_6 = new JLabel("재입력");
     label_6.setHorizontalAlignment(2);
     label_6.setFont(new Font("굴림", 0, 17));
     label_6.setBounds(60, 213, 75, 37);
     add(label_6);
   }
}