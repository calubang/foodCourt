package kitri.foodCourt.management.regit;

import java.sql.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;

	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	RemoveMember rm;
	ModifyRegit mR;

	String[] option = { "��", "�ƴϿ�" };
	String[] column = { "�̸�", "��й�ȣ", "�ڵ�����ȣ", "�����ڵ�", "�Ի���", "�����ȣ", "�ּ�", "�̸���", "�̸��ϵ�����" };

	DefaultTableModel dtm;

	public AdminRegisterService(AdminRegisterControl arc) {
		this.arc = arc;
		ami = this.arc.ami;
		ar = ami.ar;
		mr = ami.mr;
		maR = ami.maR;
		mR = ami.mR;
		rm = ami.rm;

		dtm = ami.dtm;
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}

	}

	public void showadminRegister() {

//		Connection c = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		AdminRegitDto adminDto = null;

		ami.jfAD.getContentPane().add(ami.ar);
		ami.jfAD.setSize(600, 650);
		ami.jfAD.setModal(true);
		ami.jfAD.setVisible(true);
	}

	public void showmemberRegister() {
		ami.jfMD.getContentPane().add(ami.mr);
		ami.jfMD.setSize(600, 650);
		ami.jfMD.setModal(true);
		ami.jfMD.setVisible(true);
	}

	public void showmodify() {
		if(ami.check) {
			// 회원
			ami.jfMoD.getContentPane().add(ami.mR);
			ami.jfMoD.setSize(600, 650);
			ami.jfMoD.setModal(true);
			ami.jfMoD.setVisible(true);
		} else {
			// 관리자
			ami.jfMoD.getContentPane().add(ami.maR);
			ami.jfMoD.setSize(600, 650);
			ami.jfMoD.setModal(true);
			ami.jfMoD.setVisible(true);
		}
	}

	public void showdelete() {
		int result = JOptionPane.showOptionDialog(ami.deleteBtn, "���� �����Ͻðڽ��ϱ�?\n(�����ϸ� �ٽ� �ǵ��� �� �����ϴ�.)",
				"���� Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void arRegister() {

	}

	public void arId() {
		int result = JOptionPane.showOptionDialog(ar, "����ϽǼ� �ֽ��ϴ�.", "�ߺ�Ȯ��", JOptionPane.YES_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void Close(JDialog ja) {
		ja.dispose();
	}

	public void mrRegister() {

	}

	public void mrId() {
		int result = JOptionPane.showOptionDialog(ar, "����ϽǼ� �ֽ��ϴ�.", "�ߺ�Ȯ��", JOptionPane.YES_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void maRRegister() {

	}

	public void mRRegister() {

	}

}
