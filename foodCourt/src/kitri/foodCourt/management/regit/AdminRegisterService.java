package kitri.foodCourt.management.regit;

import java.awt.CardLayout;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.*;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.AdminRegitDto;

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
	AdminTable at;

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

	// 관리자등록
	public void showadminRegister() {
		ami.ar.idtf.setText("");
		ami.ar.nametf.setText("");
		ami.ar.midnumber.setText("");
		ami.ar.lastnumber.setText("");
		ami.ar.passwordtf.setText("");
		ami.ar.pwtf.setText("");
		ami.ar.etclabel.setText("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");

		ami.jfAD.getContentPane().add(ami.ar);
		ami.jfAD.setSize(600, 740);
		ami.jfAD.setModal(true);
		ami.jfAD.setVisible(true);

	}

	// 회원등록
	public void showmemberRegister() {
		ami.mr.idtf.setText("");
		ami.mr.nametf.setText("");
		ami.mr.midnumber.setText("");
		ami.mr.lastnumber.setText("");
		ami.mr.passwordtf.setText("");
		ami.mr.pwtf.setText("");
		ami.mr.etclabel.setText("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");

		ami.jfMD.getContentPane().add(ami.mr);
		ami.jfMD.setSize(600, 650);
		ami.jfMD.setModal(true);
		ami.jfMD.setVisible(true);
	}

	// 관리자/회원수정
	public void showmodify() {
		if (ami.check == false) {
			//관리자
			int SelectRow = ami.at.adt.getSelectedRow();

			if (SelectRow == -1) {
				JOptionPane.showMessageDialog(ami.maR, "선택 되지 않았습니다.");
				Close(ami.jfMoD);
				return;
			}
			ami.card.show(ami.jpaMo, "adminModi");
			ami.jfMo.setSize(600, 740);
			ami.maR.etclabel.setText("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
			ami.maR.dataSetting();
			ami.jfMo.setVisible(true);
			return;
		} else {
			//회원
			int SelectRow = ami.mt.table.getSelectedRow();

			if (SelectRow == -1) {
				JOptionPane.showMessageDialog(ami.mR, "선택 되지 않았습니다.");
				Close(ami.jfMoD);
				return;
			}
			
			ami.card.show(ami.jpaMo, "memberModi");
			ami.mR.dataSetting();
			ami.mR.etclabel.setText("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");
			ami.jfMo.setSize(600, 740);
			ami.jfMo.setVisible(true);
			return;
		}
//		ami.jfMo.setVisible(true);
//		int SelectRow = at.adt.getSelectedRow();
//		if (SelectRow == -1) {
//			JOptionPane.showMessageDialog(ami.maR, "선택 되지 않았습니다.");
//			Close(ami.jfMoD);
//			return;
//		}

		

		
	}

	// 관리자/회원삭제
	public void showdelete() {
		int resultQuery = 0;

		int result = JOptionPane.showOptionDialog(ami.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);

	}

	// 관리자창 - 등록버튼
	public void arRegister() {
		String id = ami.ar.idtf.getText();
		String pw = ami.ar.passwordtf.getText();
		String pwtf = ami.ar.pwtf.getText();
		String name = ami.ar.nametf.getText();
		String numfirst = ami.ar.fristnumber.getSelectedItem().toString();
		String nummid = ami.ar.midnumber.getText();
		String numlast = ami.ar.lastnumber.getText();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
		String str = dayTime.format(new Date());
		String jobid = ami.ar.jobname.getSelectedItem().toString();
		String email = ami.ar.email.getText();
		String domain = ami.ar.emaildomain.getText();
		String address = ami.ar.addresstf.getText();
		int r = 0;

		String quary = "insert into fook_manager(MANAGER_ID, NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, JOB_ID,ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN) values(?,?,?,?,?,?,?,?,?,?,?)";

		if (id.isEmpty() || pw.isEmpty() || pwtf.isEmpty() || name.isEmpty() || nummid.isEmpty() || numlast.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "빈 공간을 입력해 주세요.");
		} else if (checkid == 0 || checkid == 1) {
			JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
		} else if (!(checkidjoin.equals(id))) {
			JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
		} else if (pwcheck == 0) {
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
			pstm.setString(8, null);
			pstm.setString(9, address);
			pstm.setString(10, email);
			pstm.setString(11, domain);

			r = pstm.executeUpdate();
			JOptionPane.showMessageDialog(ami.ar, "등록되었습니다");

			ami.jfAD.setVisible(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// 관리자 id중복확인
	public void arId() {
		String quary = "select manager_id from fook_manager";
		checkidjoin = ami.ar.idtf.getText();
		if (checkidjoin.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "ID를 입력하세요");
		}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			String DBuser_id;

			int check = 0;

			while (rs.next()) {

				DBuser_id = rs.getString("manager_id");

				if (checkidjoin.equals(DBuser_id)) {

					javax.swing.JOptionPane.showMessageDialog(ami.ar, "중복된 아이디가 있습니다.");
					ami.ar.idtf.setText("");

					check = 1;
					pwcheck = 1;
				}
			}
			if (check == 0) {
				javax.swing.JOptionPane.showMessageDialog(ami.ar, "사용 가능한 아이디 입니다.");
				pwcheck = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// dialog창끄기
	public void Close(JDialog jd) {

		jd.dispose();

	}

	// 회원등록창
	public void mrRegister() {
		String id = ami.mr.idtf.getText();
		String pw = ami.mr.passwordtf.getText();
		String pwtf = ami.mr.pwtf.getText();
		String name = ami.mr.nametf.getText();
		String numfirst = ami.mr.fristnumber.getSelectedItem().toString();
		String nummid = ami.mr.midnumber.getText();
		String numlast = ami.mr.lastnumber.getText();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
		String str = dayTime.format(new Date());

		int r = 0;

		String quary = "insert into fook_manager(user_id, PASSWORD,NAME, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, user_point,password_quiz, password_answer, enable) values(?,?,?,?,?,?,?,?,?,?)";

		if (id.isEmpty() || pw.isEmpty() || pwtf.isEmpty() || name.isEmpty() || nummid.isEmpty() || numlast.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "빈 공간을 입력해 주세요.");
		} else if (checkid == 0 || checkid == 1) {
			JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
		} else if (!(checkidjoin.equals(id))) {
			JOptionPane.showMessageDialog(ami.ar, "중복 확인을 눌러주세요.");
		} else if (pwcheck == 0) {
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
//			pstm.setint(7, 0);
//			pstm.setString(8, null);
//			pstm.setString(9, address);
//			pstm.setString(10,email);
//			pstm.setString(11,domain);

			r = pstm.executeUpdate();
			JOptionPane.showMessageDialog(ami.ar, "등록되었습니다");

			ami.jfAD.setVisible(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// 회원창 - 중복확인
	public void mrId() {
//		int result = JOptionPane.showOptionDialog(ar, "사용하시겠습니까", "중복확인", JOptionPane.YES_OPTION,
//				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		String quary = "select user_id from fook_user";
		checkidjoin = ami.ar.idtf.getText();
		if (checkidjoin.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "ID를 입력하세요");
		}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			String DBuser_id;

			int check = 0;

			while (rs.next()) {

				DBuser_id = rs.getString("user_id");

				if (checkidjoin.equals(DBuser_id)) {

					javax.swing.JOptionPane.showMessageDialog(ami.ar, "중복된 아이디가 있습니다.");
					ami.ar.idtf.setText("");

					check = 1;
					pwcheck = 1;
				}
			}
			if (check == 0) {
				javax.swing.JOptionPane.showMessageDialog(ami.ar, "사용 가능한 아이디 입니다.");
				pwcheck = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void maRRegister() {

		int SelectRow = at.adt.getSelectedRow();
		if (SelectRow < 0) {
			JOptionPane.showMessageDialog(ami.maR, "선택 되지 않았습니다.");
			Close(ami.jfMoD);
			return;
		}

		String quary = "select NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, fj.job_name,ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN"
				+ "from fook_manager fm, fook_job fj" + "where fm.job_id=fj.job_id,fm.name =(?)";

		try {
			System.out.println("오나");
			SelectRow = at.adt.convertRowIndexToModel(SelectRow);
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);
			pstm.setString(1, (String) at.dtm.getValueAt(SelectRow, 0));
			rs = pstm.executeQuery();
			if (rs.next()) {
				maR.nametf.setText(rs.getString("name"));
				maR.passwordtf.setText(rs.getString("password"));
				maR.fristnumber.setSelectedItem(rs.getString("phone_first"));
				maR.midnumber.setText(rs.getString("phone_middle"));
				maR.lastnumber.setText(rs.getString("phone_last"));
				maR.jobname.setSelectedItem(rs.getString("job_name"));
				maR.addresstf.setText(rs.getString("address"));
				maR.email.setText(rs.getString("email"));
				maR.emaildomain.setText(rs.getString("email_domain"));
			}

			JOptionPane.showMessageDialog(ami.ar, "수정되었습니다");

			ami.jfAD.setVisible(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void mRRegister() {

	}

	// password 일치확인
	public void pwCompare() {
		String arpw = new String(ami.ar.passwordtf.getPassword());
		String archeckpw = new String(ami.ar.pwtf.getPassword());
		String mrpw = new String(ami.mr.passwordtf.getPassword());
		String mrcheckpw = new String(ami.mr.pwtf.getPassword());
		String maRpw = new String(ami.maR.passwordtf.getPassword());
		String maRcheckpw = new String(ami.maR.pwtf.getPassword());
		String mRpw = new String(ami.mR.passwordtf.getPassword());
		String mRcheckpw = new String(ami.mR.pwtf.getPassword());

		if (!((arpw.equals(archeckpw)) || arpw.isEmpty() || archeckpw.isEmpty())
				&& ((mrpw.equals(archeckpw)) || mrpw.isEmpty() || mrcheckpw.isEmpty())
				&& ((maRpw.equals(archeckpw)) || maRpw.isEmpty() || maRcheckpw.isEmpty())
				&& ((mRpw.equals(archeckpw)) || mRpw.isEmpty() || mRcheckpw.isEmpty())) {
			ami.ar.etclabel.setForeground(Color.RED);
			ami.ar.etclabel.setText("비밀번호가 일치하지 않습니다.");
			ami.mr.etclabel.setForeground(Color.RED);
			ami.mr.etclabel.setText("비밀번호가 일치하지 않습니다.");
			ami.maR.etclabel.setForeground(Color.RED);
			ami.maR.etclabel.setText("비밀번호가 일치하지 않습니다.");
			ami.mR.etclabel.setForeground(Color.RED);
			ami.mR.etclabel.setText("비밀번호가 일치하지 않습니다.");
			pwcheck = 0;
		} else if ((arpw.length() < 6 || archeckpw.length() < 6) && (mrpw.length() < 6 || mrcheckpw.length() < 6)
				&& (maRpw.length() < 6 || maRcheckpw.length() < 6) && (mRpw.length() < 6 || mRcheckpw.length() < 6)) {
			ami.ar.etclabel.setForeground(Color.RED);
			ami.ar.etclabel.setText("비밀번호를 6자리 이상 입력해 주세요.");
			ami.mr.etclabel.setForeground(Color.RED);
			ami.mr.etclabel.setText("비밀번호를 6자리 이상 입력해 주세요.");
			ami.maR.etclabel.setForeground(Color.RED);
			ami.maR.etclabel.setText("비밀번호를 6자리 이상 입력해 주세요.");
			ami.mR.etclabel.setForeground(Color.RED);
			ami.mR.etclabel.setText("비밀번호를 6자리 이상 입력해 주세요.");
			pwcheck = 0;
		} else if (arpw.equals(archeckpw) && mrpw.equals(mrcheckpw) && maRpw.equals(maRcheckpw)
				&& mRpw.equals(mRcheckpw)) {
			ami.ar.etclabel.setForeground(Color.GREEN);
			ami.ar.etclabel.setText("비밀번호가 일치합니다.");
			ami.mr.etclabel.setForeground(Color.GREEN);
			ami.mr.etclabel.setText("비밀번호가 일치합니다.");
			ami.maR.etclabel.setForeground(Color.GREEN);
			ami.maR.etclabel.setText("비밀번호가 일치합니다.");
			ami.mR.etclabel.setForeground(Color.GREEN);
			ami.mR.etclabel.setText("비밀번호가 일치합니다.");
			pwcheck = 1;

		}
	}

	
}
