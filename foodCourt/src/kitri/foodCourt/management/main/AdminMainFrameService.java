package kitri.foodCourt.management.main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class AdminMainFrameService {

	AdminMainFrameControl amfc;
	AdminMainFrame amf;
//	AdminMemberInfo amif;
	
	public AdminMainFrameService(AdminMainFrameControl amfc) {
		this.amfc = amfc;
		amf = this.amfc.amf;
//		amif = this.amfc.amif;
	}
	
	
	
	public void showPanel(String str) {
		amf.cl.show(amf.ampPanel, str);
	}
	
	public void logout() {
		
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
		}
	}

	public void showButtonIcon(Object ob) {
		((JButton)ob).setText("");

		try {
			if (ob == amf.menuManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/menuLabel.jpg").getFile()))));
			} else if (ob == amf.memberManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/memberLabel.jpg").getFile()))));
			} else if (ob == amf.requestManageBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/requestLabel.jpg").getFile()))));
			} else if (ob == amf.paymentBtn) {
				((JButton)ob).setIcon(new ImageIcon(ImageIO.read(new File(AdminMainFrame.class.getResource("/img/admin/paymentLabel.jpg").getFile()))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
