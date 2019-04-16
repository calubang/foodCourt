package kitri.foodCourt.management.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginControl implements ActionListener {

	LoginMain lm;
	LoginService ls;
	
	
	public LoginControl(LoginMain lm) {
		this.lm = lm;
		
		ls = new LoginService(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == lm.panLogin.loginbtn) {
			ls.loginAdmin();
		}
	}
}
