package kitri.foodCourt.management.regit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegisterControl implements ActionListener{

	AdminMemberInfo ami;
	AdminRegisterService ars;
	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	ModifyRegit mR;
	RemoveMember rm;
	
	
	public AdminRegisterControl(AdminMemberInfo ami) {
		this.ami = ami;
		ars = new AdminRegisterService(this);
		ar = ami.ar;
		mr = ami.mr;
		maR= ami.maR;
		mR = ami.mR;
		rm = ami.rm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == ami.adminMemberRegisterBtn) {
			ars.showadminRegister();
		}else if(ob == ami.memberRegisterBtn) {
			ars.showmemberRegister();
		}else if(ob == ami.modifyBtn) {
			ars.showmodify();
		}else if(ob == ami.deleteBtn) {
			ars.showdelete();
		}
		else if(ob == ami.ar.registerbtn) {
			ars.arRegister();
		}else if(ob == ami.ar.idbtn) {
			ars.arId();
		}
		else if(ob == ami.ar.cancelbtn) {
			ars.Close(ami.jfAD);
			
		}else if(ob == ami.mr.registerbtn) {
			ars.mrRegister();
		}else if (ob == ami.mr.idbtn) {
			ars.mrId();
		}else if(ob == ami.mr.cancelbtn) {
			ars.Close(ami.jfMD);
			
		}else if(ob == ami.maR.registerbtn) {
			ars.maRRegister();
		}else if(ob == ami.maR.cancelbtn) {
			ars.Close(ami.jfMoD);
			
		}
//		else if(ob == ami.mR.registerbtn) {
//			ars.mRRegister();
//		}else if(ob == ami.mR.cancelbtn) {
//			ars.Close(ami.jfMoD);
//		}
		
	}
	
}
