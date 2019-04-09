package kitri.foodCourt.management.regit;

import javax.swing.JDialog;


public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;

	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	RemoveMember rm;
	ModifyRegit mR;
	
	public AdminRegisterService(AdminRegisterControl arc) {
		this.arc = arc;
		ami = this.arc.ami;
		ar = ami.ar;
		mr = ami.mr;
		maR = ami.maR;
		mR = ami.mR;
		rm = ami.rm;
		
	}

	public void showadminRegister() {
		ami.jfAD.getContentPane().add(ami.ar);
//		ami.jfAD.add(ar);
		ami.jfAD.setSize(600,650);
		ami.jfAD.setModal(true);
		ami.jfAD.setVisible(true);
	}

	public void showmemberRegister() {
		ami.jfMD.getContentPane().add(ami.mr);
		ami.jfMD.setSize(600,650);
		ami.jfMD.setModal(true);
		ami.jfMD.setVisible(true);
	}

	public void showmodify() {
		
		ami.jfMoD.getContentPane().add(ami.maR);
		ami.jfMoD.setSize(600,650);
		ami.jfMoD.setModal(true);
		ami.jfMoD.setVisible(true);
		
			
		
	}

	public void showdelete() {
		ami.jfDD.getContentPane().add(ami.rm);
		ami.jfDD.setSize(450,220);
		ami.jfDD.setModal(true);
		ami.jfDD.setVisible(true);
	}

	public void arRegister() {
		
	}

	public void arId() {
		
	}

	public void Close(JDialog ja) {
		ja.dispose();
	}

	public void mrRegister() {
		
	}

	public void mrId() {
		
	}

	public void maRRegister() {
		
	}

	public void mRRegister() {
		
	}

	

	

	
	
	
	
}
