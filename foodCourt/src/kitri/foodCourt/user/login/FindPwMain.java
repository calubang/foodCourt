 package kitri.foodCourt.user.login;
 
	import java.awt.BorderLayout;
	import java.awt.CardLayout;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	 
	 public class FindPwMain extends JFrame
	 {
	   FindPw findPw = new FindPw(this);
	   FindPwCheck findPwCheck = new FindPwCheck(this);
	   FindRPw findRPw = new FindRPw(this);
	   
	   LoginMain loginMain;
	   
	   public JPanel contentPane;
	   JPanel panMain = new JPanel();
	   CardLayout card = new CardLayout();
	   
	   public FindPwMain(LoginMain loginMain)
	   {
	     this.loginMain = loginMain;
	     
	     setDefaultCloseOperation(3);
	     setBounds(100, 100, 450, 300);
	     this.contentPane = new JPanel();
	     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	     this.contentPane.setLayout(new BorderLayout(0, 0));
	     this.contentPane.add(this.panMain);
	     setContentPane(this.contentPane);
	     
	     this.panMain.setLayout(this.card);
	     setBounds(200, 200, 630, 430);
	     this.panMain.add(this.findPw, "findPw");
	     this.findPw.setLayout(null);
	     this.panMain.add(this.findPwCheck, "findPwCheck");
	     this.panMain.add(this.findRPw, "findRPw");
	     this.panMain.setBounds(0, 0, 600, 400);
	     this.card.show(this.panMain, "findPw");
	     setVisible(false);
	  }
}
