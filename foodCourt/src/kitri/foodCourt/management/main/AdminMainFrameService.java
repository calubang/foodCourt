package kitri.foodCourt.management.main;


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
		
	}
}
