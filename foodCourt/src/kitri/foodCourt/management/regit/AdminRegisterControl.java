package kitri.foodCourt.management.regit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegisterControl implements ActionListener{

	AdminMemberInfo ami;
	AdminRegisterService ars;
	
	public AdminRegisterControl(AdminMemberInfo ami) {
		this.ami = ami;
		ars = new AdminRegisterService(this);
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
		
	}
	
}
