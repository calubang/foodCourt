package kitri.foodCourt.management.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AdminMenuControl implements ActionListener, ListSelectionListener, KeyListener {

	AdminMenuManagement amm;
	AdminMenuService ams;
	AdminRegisterMenu arm;
	AdminModifyMenu am;
	
	
	public AdminMenuControl(AdminMenuManagement amm) {
		this.amm = amm;
		ams = new AdminMenuService(this);
		arm = amm.arm;
		am = amm.am;
		
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
		} else if (ob == arm.registerImageBtn) {
			ams.findImage(ob);
		} else if (ob == arm.confirmBtn) {
			
		} else if (ob == arm.cancelBtn) {
			ams.closeWindow(amm.jdR);
		} else if (ob == am.changeImageBtn) {
			ams.findImage(ob);
		} else if (ob == am.confirmBtn) {
			//ams.modifyMenu();
		} else if (ob == am.cancelBtn) {
			ams.closeWindow(amm.jdM);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		ams.showImageDescription();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER) {
			ams.searchFood();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
}