package kitri.foodCourt.management.request;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AdminRequestService {

	AdminRequestControl arc;
	AdminRequest ar;
	
	AdminViewOrder avo;
	
	JFrame jfV = new JFrame("주문 목록 확인");
	
	String[] option = {"예", "아니오"};
	
	
	public AdminRequestService(AdminRequestControl arc) {
		this.arc = arc;
		ar = this.arc.ar;
		
		avo = new AdminViewOrder();
	}
	
	
	public void showOrderWindow() {
		jfV.getContentPane().add(avo);
		jfV.setSize(395, 580);
		jfV.setVisible(true);
	}
	
	public void processOrderWindow() {
		JOptionPane.showOptionDialog(ar.processOrderBtn, "처리하시겠습니까?", "처리 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}
}
