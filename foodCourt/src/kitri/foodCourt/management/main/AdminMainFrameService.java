package kitri.foodCourt.management.main;


public class AdminMainFrameService {

	AdminMainFrameControl amfc;
	AdminMainFrame amf;
	
	
	public AdminMainFrameService(AdminMainFrameControl amfs) {
		this.amfc = amfs;
		amf = amfc.amf;
	}
	
	
	public void showPanel(String str) {
		amf.cl.show(amf.ampPanel, str);
	}
	
	public void logout() {
		
	}
}
