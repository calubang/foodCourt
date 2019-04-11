package kitri.foodCourt.management.payment;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminPaymentService {

	AdminPaymentControl apc;
	AdminPayment ap;
	
	AdminViewReceipt avr;
	
	JFrame jfR = new JFrame();
	JDialog jdR = new JDialog(jfR, "영수중");
	
	String[] option = {"예", "아니오"};
	String[] column = {"카테고리", "메뉴명", "수량", "가격", "포인트"};
	
	DefaultTableModel dtm;
	
	
	public AdminPaymentService(AdminPaymentControl apc) {
		this.apc = apc;
		ap = this.apc.ap;
		
		avr = new AdminViewReceipt();
		dtm = avr.dtm;
		
		// Set Table column
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
	}
	
	
	public void showReceiptWindow() {
		jdR.getContentPane().add(avr);
		jdR.setSize(395, 720);
		jdR.setModal(true);
		jdR.setVisible(true);
	}
	
	public void showDeleteWindow() {
		int result = JOptionPane.showOptionDialog(ap.deleteBtn, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		
		if (result == JOptionPane.OK_OPTION) {
			
		} else {
			return;
		}
	}

	public void closeReceiptWindow() {
		jdR.dispose();
	}
}
