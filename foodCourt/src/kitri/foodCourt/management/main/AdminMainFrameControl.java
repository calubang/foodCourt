package kitri.foodCourt.management.main;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;

import kitri.foodCourt.management.login.LoginMain;
import kitri.foodCourt.management.order.*;

public class AdminMainFrameControl extends WindowAdapter implements MouseListener {

	AdminMainFrame amf;
	AdminMainFrameService amfs;

	public AdminMainFrameControl(AdminMainFrame amf) {
		this.amf = amf;

		amfs = new AdminMainFrameService(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();

		if (ob == amf.menuManageBtn) {
			amfs.showPanel("AdminMenuManagement");
		} else if (ob == amf.memberManageBtn) {
			amfs.showPanel("AdminMemberInfo");
		} else if (ob == amf.requestManageBtn) {
			// amfs.showPanel("AdminRequest");
			// 요청한 주문 목록 프레임
			if (LoginMain.orderListFrame.isVisible()) {
				if (!LoginMain.orderListFrame.isVisible())
					LoginMain.orderListFrame.setVisible(true);
				if (LoginMain.orderListFrame.getState() == JFrame.ICONIFIED)
					LoginMain.orderListFrame.setState(JFrame.NORMAL);
				LoginMain.orderListFrame.toFront(); // 맨 앞의 창으로 가져오기
			} else {
				LoginMain.orderListFrame.setVisible(true);
				LoginMain.orderListFrame.toFront();
			}
		} else if (ob == amf.paymentBtn) {
			amfs.showPanel("AdminPayment");
		} else if (ob == amf.logoutBtn) {
			amfs.logout();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		amfs.showButtonText(e.getSource());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		amfs.showButtonIcon(e.getSource());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
		@Override
		public void windowClosing(WindowEvent e) {
			

		}
}
