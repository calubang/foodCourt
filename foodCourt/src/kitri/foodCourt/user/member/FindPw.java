package kitri.foodCourt.user.member;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPw extends JPanel {
	public JTextField idTF;
	public JButton nextbtn;
	public JButton cancelbtn;
	public JButton idfindbtn;
	
	FindPwMain findPwMain;

	public FindPw(FindPwMain findPwMain) {
		
		this.findPwMain = findPwMain;

		setBounds(0, 0, 650, 400);
		setLayout(null);

		JLabel label = new JLabel("1.아이디 입력");
		label.setOpaque(true);
		label.setHorizontalAlignment(0);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(0, 153, 255));
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
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(469, 62, 119, 28);
		add(label_2);

		this.idTF = new JTextField();
		this.idTF.setColumns(10);
		this.idTF.setBounds(147, 156, 307, 37);
		add(this.idTF);

		JLabel label_5 = new JLabel("아이디");
		label_5.setHorizontalAlignment(2);
		label_5.setFont(new Font("굴림", 0, 17));
		label_5.setBounds(60, 156, 75, 37);
		add(label_5);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(38, 92, 550, 3);
		add(panel);

		JLabel label_6 = new JLabel("비밀번호 찾기");
		label_6.setFont(new Font("굴림", 1, 18));
		label_6.setBounds(38, 45, 206, 45);
		add(label_6);

		JLabel label_7 = new JLabel("아이디가 기억나지 않는다면?");
		label_7.setFont(new Font("굴림", 0, 14));
		label_7.setBounds(48, 335, 196, 23);
		add(label_7);

		this.idfindbtn = new JButton("아이디찾기");
		this.idfindbtn.setBounds(242, 336, 105, 23);
		add(this.idfindbtn);

		this.nextbtn = new JButton("다음");
		this.nextbtn.setBackground(new Color(0, 153, 255));
		this.nextbtn.setBounds(391, 281, 85, 30);
		add(this.nextbtn);

		this.cancelbtn = new JButton("취소");
		this.cancelbtn.setBackground(new Color(0, 153, 255));
		this.cancelbtn.setBounds(488, 281, 85, 30);
		add(this.cancelbtn);
	}
}
