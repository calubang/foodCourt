package kitri.foodCourt.management.main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import kitri.foodCourt.management.login.LoginMain;


public class AdminMainFrameService {

	AdminMainFrameControl amfc;
	AdminMainFrame amf;
	
	public AdminMainFrameService(AdminMainFrameControl amfc) {
		this.amfc = amfc;
		amf = this.amfc.amf;
	}
	
	public void showPanel(String str) {
		amf.cl.show(amf.ampPanel, str);
	}
	
	public void logout() {
		amf.adminID = null;
		new LoginMain().setVisible(true);
		amf.dispose();
	}

	public void showButtonText(Object ob) {
		((JButton)ob).setIcon(null);
		
		if (ob == amf.menuManageBtn) {
			((JButton)ob).setText("皋春包府");
		} else if (ob == amf.memberManageBtn) {
			((JButton)ob).setText("雀盔包府");
		} else if (ob == amf.requestManageBtn) {
			((JButton)ob).setText("夸没包府");
		} else if (ob == amf.paymentBtn) {
			((JButton)ob).setText("搬力包府");
		} else if (ob == amf.logoutBtn) {
			((JButton)ob).setText("肺弊酒眶");
		}
	}

	public void showButtonIcon(Object ob) {
		((JButton)ob).setText("");

		try {
			if (ob == amf.menuManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrameService.class.getResource("/img/admin/menuLabel.jpg").getFile()))));
			} else if (ob == amf.memberManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrameService.class.getResource("/img/admin/memberLabel.jpg").getFile()))));
			} else if (ob == amf.requestManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrameService.class.getResource("/img/admin/requestLabel.jpg").getFile()))));
			} else if (ob == amf.paymentBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrameService.class.getResource("/img/admin/paymentLabel.jpg").getFile()))));
			} else if (ob == amf.logoutBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrameService.class.getResource("/img/admin/logoutLabel.jpg").getFile()))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
