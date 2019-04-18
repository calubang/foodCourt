package kitri.foodCourt.user.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
public class FindIdMain extends JFrame{
	public FindId findId = new FindId(this);
	public FindIdCheck findIdCheck = new FindIdCheck(this);
   
	public LoginMain loginMain;
   
	public JPanel contentPane;
	public JPanel panMain = new JPanel();
	public CardLayout card = new CardLayout();
   
	public FindIdMain(LoginMain loginMain){
	     this.loginMain = loginMain;
	     
	     setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	     setBounds(100, 100, 450, 300);
	     this.contentPane = new JPanel();
	     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	     this.contentPane.setLayout(new BorderLayout(0, 0));
	     this.contentPane.add(this.panMain);
	     setContentPane(this.contentPane);
	     
	     this.panMain.setLayout(this.card);
	     setBounds(200, 200, 630, 430);
	     this.panMain.add(this.findId, "findId");
	     this.findId.setLayout(null);
	     this.panMain.add(this.findIdCheck, "findIdCheck");
	     this.panMain.setBounds(0, 0, 600, 400);
	     this.card.show(this.panMain, "findId");
	     setVisible(false);
     
	}
}
