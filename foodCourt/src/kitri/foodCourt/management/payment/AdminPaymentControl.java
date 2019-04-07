package kitri.foodCourt.management.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminPaymentControl implements ActionListener {

	AdminPayment ap;
	AdminPaymentService aps;
	
	
	public AdminPaymentControl(AdminPayment ap) {
		this.ap = ap;
		aps = new AdminPaymentService(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == ap.checkReceiptBtn) {
			aps.showReceiptWindow();
		} else if (ob == ap.deleteBtn) {
			aps.showDeleteWindow();
		}
	}
}