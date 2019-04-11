package kitri.foodCourt.management.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class AdminPaymentControl implements ActionListener, KeyListener {

	AdminPayment ap;
	AdminPaymentService aps;
	AdminViewReceipt avr;
	
	
	public AdminPaymentControl(AdminPayment ap) {
		this.ap = ap;
		aps = new AdminPaymentService(this);
		this.avr = aps.avr;
		
		aps.showPayment();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == ap.checkReceiptBtn) {
			aps.showReceiptWindow();
		} else if (ob == ap.deleteBtn) {
			aps.showDeleteWindow();
		} else if (ob == avr.confirmBtn) {
			aps.closeReceiptWindow();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER) {
			aps.searchUserID();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
}