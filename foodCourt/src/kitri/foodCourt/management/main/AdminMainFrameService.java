package kitri.foodCourt.management.main;

import kitri.foodCourt.management.regit.AdminMemberInfo;

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
}
