package kitri.foodCourt.management.menu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AdminMenuService {

	AdminMenuControl amc;
	AdminMenuManagement amm;
	
	AdminRegisterMenu arp;
	AdminModifyMenu amp;
	
	JFrame jfR = new JFrame("메뉴등록");
	JFrame jfM = new JFrame("메뉴수정");
	
	String[] option = {"예", "아니오"};
	
	
	public AdminMenuService(AdminMenuControl amc) {
		this.amc = amc;
		amm = this.amc.amm;
		
		arp = new AdminRegisterMenu();
		amp = new AdminModifyMenu();
	}
	
	
	public void showRegisterWindow() {
		jfM.setVisible(false);
		
		jfR.getContentPane().add(arp);
		jfR.setSize(750, 650);
		jfR.setVisible(true);
	}
	
	public void showModifyWindow() {
		jfR.setVisible(false);
		
		jfM.getContentPane().add(amp);
		jfM.setSize(750, 650);
		jfM.setVisible(true);
	}
	
	public void showDeleteWindow() {
		JOptionPane.showOptionDialog(amm.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}
}
