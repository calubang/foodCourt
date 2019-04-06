package kitri.foodCourt.management.request;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminRequestControl implements ActionListener {

	AdminRequest ar;
	AdminRequestService ars;

	
	public AdminRequestControl(AdminRequest ar) {
		this.ar = ar;
		ars = new AdminRequestService(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == ar.checkOrderBtn) {
			ars.showOrderWindow();
		} else if (ob == ar.processOrderBtn) {
			ars.processOrderWindow();
		}
	}
}