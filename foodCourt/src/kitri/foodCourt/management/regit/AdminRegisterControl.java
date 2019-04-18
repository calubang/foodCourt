package kitri.foodCourt.management.regit;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class AdminRegisterControl implements ActionListener, KeyListener {

	AdminMemberInfo ami;
	AdminRegisterService ars;
	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	ModifyRegit mR;
	RemoveMember rm;
	AdminTable at;

	public AdminRegisterControl(AdminMemberInfo ami) {
		this.ami = ami;
		ars = new AdminRegisterService(this);
		ar = ami.ar;
		mr = ami.mr;
		maR = ami.maR;
		mR = ami.mR;
		rm = ami.rm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == ami.adminMemberRegisterBtn) {
			ars.showadminRegister();
		}else if (ob == ami.memberRegisterBtn) {
			ars.showmemberRegister();
		} else if (ob == ami.modifyBtn) {
			ars.showmodify();
		} else if (ob == ami.deleteBtn) {
			ars.showdelete();
		} else if (ob == ami.ar.registerbtn) {
			ars.arRegister();
			ami.at.dtm.setNumRows(0);
			ami.at.selectAdmin();
		} else if (ob == ami.ar.idbtn) {
			ars.arId();
		} else if (ob == ami.ar.cancelbtn) {	
			ars.Close(ami.jfAD);
		} else if (ob == ami.mr.registerbtn) {
			ars.mrRegister();
		} else if (ob == ami.mr.idbtn) {
			ars.mrId();
		} else if (ob == ami.mr.cancelbtn) {
			ami.mr.clear();
			ars.Close(ami.jfMD);
		} else if (ob == ami.maR.registerbtn) {
			ars.maRRegister();
			ami.at.dtm.setNumRows(0);
			ami.at.selectAdmin();
		} else if (ob == maR.cancelbtn) {
			System.out.println("1");
			ami.jfMo.setVisible(false);
		}else if(ob == ami.mR.registerbtn) {
			ars.mRRegister();
		}else if(ob == ami.mR.cancelbtn) {
			ami.mR.clear();
			ami.jfMo.setVisible(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object ob = e.getSource();
		if(ob == ar.passwordtf) {
			ars.pwCompare();
		}else if(ob == ar.pwtf){
			ars.pwCompare();
		}else if(ob == mr.pwtf) {
			ars.pwCompare();
		}else if(ob == mr.passwordtf) {
			ars.pwCompare();
		}else if(ob == maR.pwtf) {
			ars.pwCompare();
		}else if(ob == maR.passwordtf) {
			ars.pwCompare();
		}else if(ob == mR.pwtf) {
			ars.pwCompare();
		}else if(ob == mR.passwordtf) {
			ars.pwCompare();
		}
	}

	

}
