package kitri.foodCourt.management.regit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;
	
	JFrame jfA = new JFrame("관리자등록");
	JDialog jfAD = new JDialog(jfA);
	JFrame jfM = new JFrame("회원등록");
	JDialog jfMD = new JDialog(jfM);
	JFrame jfMo = new JFrame("수정");
	JDialog jfMoD = new JDialog(jfMo);
	JFrame jfD = new JFrame("삭제");
	JDialog jfDD = new JDialog(jfD);
	
	
	AdminRegister ar;
	MemberRegister mr;
	ModifyRegit mR;
	RemoveMember rm;
	
	
	public AdminRegisterService(AdminRegisterControl arc) {
		this.arc = arc;
		ami = this.arc.ami;
		
		ar = new AdminRegister();
		mr = new MemberRegister();
		mR = new ModifyRegit();
		rm = new RemoveMember();
		
	}

	public void showadminRegister() {
		jfAD.getContentPane().add(ar);
		jfAD.setSize(600,500);
		jfAD.setModal(true);
		jfAD.setVisible(true);
	}

	public void showmemberRegister() {
		jfMD.getContentPane().add(mr);
		jfMD.setSize(600,500);
		jfMD.setModal(true);
		jfMD.setVisible(true);
	}

	public void showmodify() {
		jfMoD.getContentPane().add(mR);
		jfMoD.setSize(600,500);
		jfMoD.setModal(true);
		jfMoD.setVisible(true);
	}

	public void showdelete() {
		jfDD.getContentPane().add(rm);
		jfDD.setSize(450,220);
		jfDD.setModal(true);
		jfDD.setVisible(true);
	}
	
	
	
}
