package kitri.foodCourt.management.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AdminMainFrameControl implements ActionListener, MouseListener {

	AdminMainFrame amf;
	AdminMainFrameService amfs;


	public AdminMainFrameControl(AdminMainFrame amf) {
		this.amf = amf;
		
		amfs = new AdminMainFrameService(this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		
		if (ob == amf.menuManageBtn) {
			amfs.showPanel("AdminMenuManagement");
		} else if (ob == amf.memberManageBtn) {
			amfs.showPanel("AdminMemberInfo");
		} else if (ob == amf.requestManageBtn) {
			amfs.showPanel("AdminRequest");
		} else if (ob == amf.paymentBtn) {
			amfs.showPanel("AdminPayment");
		} 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		amfs.showButtonText(e.getSource());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		amfs.showButtonIcon(e.getSource());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == amf.logoutBtn) {
			amfs.logout();
		}
	}
}