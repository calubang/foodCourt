package kitri.foodCourt.management.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFrameControl implements ActionListener {

	AdminMainFrame amf;
	AdminMainFrameService amfs;
	
	
	public AdminMainFrameControl(AdminMainFrame amf) {
		this.amf = amf;
		amfs = new AdminMainFrameService(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == amf.menuManageBtn) {
			amfs.showPanel("AdminMenuManagement");
		} else if (ob == amf.memberManageBtn) {
			amfs.showPanel("AdminMemberInfo");
		} else if (ob == amf.requestManageBtn) {
			amfs.showPanel("AdminRequest");
		} else if (ob == amf.paymentBtn) {
			amfs.showPanel("AdminPayment");
		} else if (ob == amf.logoutBtn) {
			amfs.logout();
		}
	}
}