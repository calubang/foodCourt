package kitri.foodCourt.management.regit;

import java.awt.CardLayout;

import java.sql.*;
import java.util.*;

import javax.swing.*;
import kitri.foodCourt.dto.AdminRegitDto;
import kitri.foodCourt.management.regit.DBConnection;

public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;
	ManagermentDao managermentDao = new DbFactory().managermentDao();

	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	RemoveMember rm;
	ModifyRegit mR;

	List<AdminRegitDto> list = new ArrayList<AdminRegitDto>();
	AdminRegitDto AdminRegitDto;
	String[] option = { "예", "아니요" };

	CardLayout card;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

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
		ami.ar.idtf.setText("");
		ami.ar.nametf.setText("");
		ami.ar.midnumber.setText("");
		ami.ar.lastnumber.setText("");
		ami.ar.passwordtf.setText("");
		ami.ar.pwtf.setText("");
		ami.jfAD.getContentPane().add(ami.ar);
		ami.jfAD.setSize(600, 650);
		ami.jfAD.setModal(true);
		ami.jfAD.setVisible(true);

	}

	public void showmemberRegister() {
		ami.mr.idtf.setText("");
		ami.mr.nametf.setText("");
		ami.mr.midnumber.setText("");
		ami.mr.lastnumber.setText("");
		ami.mr.passwordtf.setText("");
		ami.mr.pwtf.setText("");

		ami.jfMD.getContentPane().add(ami.mr);
		ami.jfMD.setSize(600, 650);
		ami.jfMD.setModal(true);
		ami.jfMD.setVisible(true);
	}

	public void showmodify() {


		

		ami.maR.nametf.setText("");
		ami.maR.midnumber.setText("");
		ami.maR.lastnumber.setText("");
		ami.maR.passwordtf.setText("");
		ami.maR.pwtf.setText("");
		
		ami.mR.nametf.setText("");
		ami.mR.midnumber.setText("");
		ami.mR.lastnumber.setText("");
		ami.mR.passwordtf.setText("");
		ami.mR.pwtf.setText("");
		
		if (ami.check == false) {
			
			ami.card.show(ami.jpaMo, "adminModi");
			
		} else {
			ami.card.show(ami.jpaMo, "memberModi");
			
		}
		ami.jfMo.setSize(600, 650);
		ami.jfMo.setVisible(true);
	}

	public void showdelete() {
		int result = JOptionPane.showOptionDialog(ami.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void arRegister() {
		managermentDao.register(AdminRegitDto);
	}

	public void arId() {
		int result = JOptionPane.showOptionDialog(ar, "사용하시겠습니까", "중복 확인", JOptionPane.YES_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void Close(JDialog jd) {

		jd.dispose();

	}

	public void mrRegister() {

	}

	public void mrId() {
		int result = JOptionPane.showOptionDialog(ar, "사용하시겠습니까", "중복확인", JOptionPane.YES_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void maRRegister() {

	}

	public void mRRegister() {

	}

}
