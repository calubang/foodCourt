package kitri.foodCourt.management.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AdminMenuControl implements ActionListener, ListSelectionListener {

	AdminMenuManagement amm;
	AdminMenuService ams;
	
	
	public AdminMenuControl(AdminMenuManagement amm) {
		this.amm = amm;
		ams = new AdminMenuService(this);
		
		ams.showMenu();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == amm.registerBtn) {
			ams.showRegisterWindow();
		} else if (ob == amm.modifyBtn) {
			ams.showModifyWindow();
		} else if (ob == amm.deleteBtn) {
			ams.showDeleteWindow();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		ams.showImageDescription();
	}
}