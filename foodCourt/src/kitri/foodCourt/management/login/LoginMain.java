package kitri.foodCourt.management.login;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kitri.foodCourt.user.User;
import kitri.foodCourt.user.view.FoodMain;


@SuppressWarnings("serial")
public class LoginMain extends JFrame {
	
	JPanel contentPane;
	Login panLogin = new Login(this);

	JPanel panMain = new JPanel();
	CardLayout card = new CardLayout();
	
	public FoodMain foodMain;
	public User user;

	LoginControl lc;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginMain() {
		//시작부
		setTitle("풉키에 오신것을 환영합니다.");
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new java.awt.BorderLayout(0, 0));
		this.contentPane.add(this.panMain);
		setDefaultCloseOperation(3);
		setContentPane(this.contentPane);

		this.panMain.setLayout(this.card);
		setBounds(100, 100, 1200, 800);
		this.panMain.add(this.panLogin, "panLogin");
		this.panLogin.setLayout(null);
		this.panMain.setBounds(0, 0, 1200, 800);
		this.card.show(this.panMain, "panLogin");
		setVisible(true);
		
		//로그인 페이지
		lc = new LoginControl(this);
		
		panLogin.loginbtn.addActionListener(lc);
	}
}
