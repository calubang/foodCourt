package kitri.foodCourt.management.regit;

import java.awt.CardLayout;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.AdminRegitDto;
import kitri.foodCourt.management.regit.DBConnection;

public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;


	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	RemoveMember rm;
	ModifyRegit mR;

	List<AdminRegitDto> list = new ArrayList<AdminRegitDto>();
	AdminRegitDto AdminRegitDto;
	String[] option = { "예", "아니요" };

	CardLayout card;
	private ConnectionMaker connectionMaker;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	int checkid;
	int pwcheck;
	String checkidjoin;
	
	
	public AdminRegisterService(AdminRegisterControl arc) {
		connectionMaker = DbFactory.connectionMaker("oracle");
		
		checkid = 0;
		pwcheck = 0;
		
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
		String id = ami.ar.idtf.getText();
		String pw = ami.ar.passwordtf.getText();
		String pwtf = ami.ar.pwtf.getText();
		String name = ami.ar.nametf.getText();
		String numfirst = ami.ar.fristnumber.getSelectedItem().toString();
		String nummid = ami.ar.idtf.getText();
		String numlast = ami.ar.idtf.getText();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
		String str = dayTime.format(new Date());
		String jobid = ami.ar.jobname.getSelectedItem().toString();
		int r = 0;
		
		String quary = "insert into fook_manager(MANAGER_ID, NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, JOB_ID,ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		
		if ( id.isEmpty() || pw.isEmpty() || pwtf.isEmpty()
				|| name.isEmpty() || nummid.isEmpty() || numlast.isEmpty()) { // == 는 주소값 비교.
				JOptionPane.showMessageDialog(ami.ar, "빈 공간을 입력해 주세요.");
			}else if(checkid == 0 || checkid == 1) {
				JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
			}else if (!(checkidjoin.equals(id))) {
				JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
			}else if ( pwcheck == 0) {
				JOptionPane.showMessageDialog(ami.ar, "비밀번호를 확인해 주세요.");
			}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			
			
			pstm.setString(1, id);
			pstm.setString(2, name); 
			pstm.setString(3, pw);
			pstm.setString(4, numfirst);
			pstm.setString(5, nummid);
			pstm.setString(6, numlast);
			pstm.setString(7, jobid);
//			pstm.setString(8, question);
//			pstm.setString(9, answer);
//			pstm.setString(10, "N");
			
			r = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void arId() {
//		int result = JOptionPane.showOptionDialog(ar, "사용하시겠습니까", "중복 확인", JOptionPane.YES_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		String quary = "select manager_id from fook_manager";
		checkidjoin = ami.ar.idtf.getText();
		if(checkidjoin.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "ID를 입력하세요");
		}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			String DBuser_id;
			
			int check = 0;
			
			while(rs.next()){
				
				DBuser_id = rs.getString("manager_id");
				
				if (checkidjoin.equals(DBuser_id)) {
					
					javax.swing.JOptionPane.showMessageDialog(ami.ar, "중복된 아이디가 있습니다.");
					ami.ar.idtf.setText("");
					
					check = 1;
					pwcheck = 1;
				}
			}
			if( check == 0 ) {
				javax.swing.JOptionPane.showMessageDialog(ami.ar, "사용 가능한 아이디 입니다.");
				pwcheck = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void Close(JDialog jd) {

		jd.dispose();

	}

	public void mrRegister() {

	}

	public void mrId() {
//		int result = JOptionPane.showOptionDialog(ar, "사용하시겠습니까", "중복확인", JOptionPane.YES_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		String quary = "select user_id from fook_user";
		checkidjoin = ami.ar.idtf.getText();
		if(checkidjoin.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "ID를 입력하세요");
		}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			String DBuser_id;
			
			int check = 0;
			
			while(rs.next()){
				
				DBuser_id = rs.getString("user_id");
				
				if (checkidjoin.equals(DBuser_id)) {
					
					javax.swing.JOptionPane.showMessageDialog(ami.ar, "중복된 아이디가 있습니다.");
					ami.ar.idtf.setText("");
					
					check = 1;
					pwcheck = 1;
				}
			}
			if( check == 0 ) {
				javax.swing.JOptionPane.showMessageDialog(ami.ar, "사용 가능한 아이디 입니다.");
				pwcheck = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void maRRegister() {

	}

	public void mRRegister() {

	}
	public void checkid() {
		
		
	}
}
