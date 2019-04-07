package kitri.foodCourt.management.payment;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AdminPaymentService {

	AdminPaymentControl apc;
	AdminPayment ap;
	
	AdminViewReceipt avr;
	
	JFrame jfR = new JFrame("영수증");
	
	String[] option = {"예", "아니오"};
	
	
	public AdminPaymentService(AdminPaymentControl apc) {
		this.apc = apc;
		ap = this.apc.ap;
		
		avr = new AdminViewReceipt();
	}
	
	
	public void showReceiptWindow() {
		jfR.getContentPane().add(avr);
		jfR.setSize(395, 720);
		jfR.setVisible(true);
	}
	
	public void showDeleteWindow() {
		JOptionPane.showOptionDialog(ap.deleteBtn, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}
}
