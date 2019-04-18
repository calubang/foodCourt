package kitri.foodCourt.management.regit;

import java.awt.CardLayout;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.AdminRegitDto;
import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.swing.SwingFactory;

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
	public AdminTable at;
	public MemberTable mt;
	DefaultTableModel dtm;

	// 멤버부분 추가
	public AdminUserDao dao;

	public AdminRegisterService(AdminRegisterControl arc) {
		connectionMaker = DbFactory.connectionMaker("oracle");

		checkid = 0;
		pwcheck = 0;

		this.arc = arc;
		ami = this.arc.ami;
		ar = ami.ar;

		// 멤버 관련
		mr = ami.mr;
		mR = ami.mR;
		rm = ami.rm;
		mt = ami.mt;

		maR = ami.maR;
		dtm = ami.at.dtm;

		dao = new AdminUserDao();
	}

	// 관리자등록
	public void showadminRegister() {
		ami.ar.idtf.setText("");
		ami.ar.nametf.setText("");
		ami.ar.midnumber.setText("");
		ami.ar.lastnumber.setText("");
		ami.ar.passwordtf.setText("");
		ami.ar.pwtf.setText("");
		ami.ar.addresstf.setText("");
		ami.ar.email.setText("");
		ami.ar.emaildomain.setText("");
		ami.ar.etclabel.setText("6\uC790\uB9AC\uC774\uC0C1 \uBB38\uC790,\uC22B\uC790\uC870\uD569");

		ami.jfAD.getContentPane().add(ami.ar);
		ami.jfAD.setSize(600, 740);
		ami.jfAD.setModal(true);
		ami.jfAD.setVisible(true);

	}

	// 회원등록
	public void showmemberRegister() {
		ami.mr.clear();

		ami.jfMD.getContentPane().add(ami.mr);
		ami.jfMD.setBounds(ami.getX() + 100, ami.getY() + 100, 575, 760);
		ami.jfMD.setModal(true);
		ami.jfMD.setVisible(true);
		ami.jfM.setResizable(false);
		ami.jfMD.setResizable(false);

	}

	// 관리자/회원수정
	public void showmodify() {
		if (ami.check == false) {
			// 관리자
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
			// 회원
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

	}

	// 관리자/회원삭제
	public void showdelete() {

		int resultQuery = 0;
		int result = JOptionPane.showOptionDialog(ami.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		if(result != 0) {
			return;
		}
		// 관리자
		if (ami.currentCard.equals("AdminTable")) {
			int selectRow = ami.at.adt.getSelectedRow();

			String quary = ("delete from fook_manager " + "where manager_id = (?)");

			if (result == JOptionPane.OK_OPTION) {
				if (selectRow >= 0) {
					selectRow = ami.at.adt.convertRowIndexToModel(selectRow);
					Object ob = ami.at.adt.getModel().getValueAt(selectRow, 0);

					try {
						conn = connectionMaker.makeConnection();
						pstm = conn.prepareStatement(quary);

						pstm.setString(1, (String) ob);

						resultQuery = pstm.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							connectionMaker.closeConnection(conn, pstm, rs);
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
					dtm.removeRow(selectRow);
				}
			} else {
				return;
			}
			if (resultQuery == 0) {
				JOptionPane.showMessageDialog(ami.deleteBtn, "선택 되지 않았습니다.");
			}
		}else if(ami.currentCard.equals("MemberTable")){
			//유저 삭제
			
			int selectRow = ami.mt.table.convertRowIndexToModel(ami.mt.table.getSelectedRow());
			String userId = String.valueOf(ami.mt.tableModel.getValueAt(selectRow, 0));
			
			if(dao.delete(userId) != 1) {
				//DB에러
				SwingFactory.getOptionPane("errorMessage", ami.deleteBtn, "시스템 에러", "시스템 에러, 유저 삭제를 실패하였습니다.");
			}else {
				ami.mt.tableModel.removeRow(selectRow);
			}
		}
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

		if (jobid == "관리자") {
			jobid = "Admin";
		} else if (jobid == "점원") {
			jobid = "Clerk";
		} else {
			jobid = "NewBie";
		}

		String quary = "insert into fook_manager(MANAGER_ID, NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, JOB_ID,hire_date,ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN) values(?,?,?,?,?,?,?,sysdate,?,?,?,?)";

		if (id.isEmpty() || pw.isEmpty() || pwtf.isEmpty() || name.isEmpty() || nummid.isEmpty() || numlast.isEmpty()
				|| address.isEmpty() || email.isEmpty() || domain.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "빈 공간을 입력해 주세요.");
			return;
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

			pstm.setString(8, "12345");
			pstm.setString(9, address);
			pstm.setString(10, email);
			pstm.setString(11, domain);

			pstm.executeUpdate();

//			pstm.close();
//			pstm = conn.prepareStatement("SELECT \n" + 
//					"    MANAGER_ID\n" + 
//					"    ,NAME\n" + 
//					"    ,PASSWORD\n" + 
//					"    ,PHONE_FIRST||PHONE_MIDDLE||PHONE_LAST as pn\n" + 
//					"    ,fj.job_name as job_name\n" + 
//					"    ,HIRE_DATE\n" + 
//					"    ,ADDRESS_ZIP\n" + 
//					"    ,ADDRESS\n" + 
//					"    ,EMAIL\n" + 
//					"    ,EMAIL_DOMAIN \n" + 
//					"FROM \n" + 
//					"    FOOK_MANAGER fm \n" + 
//					"    , fook_job fj \n" + 
//					"where fm.job_id = fj.job_id(+)");
//			rs = pstm.executeQuery();
//			if((result != 0) ) {
//				Date date = new Date();
//				rowData[0] = id;
//				rowData[1] = name;
//				rowData[2] = pw;
//				rowData[3] = numfirst+nummid+numlast;
//				rowData[4] = jobid;
//				rowData[5] = Date date = new Date());
//				rowData[6] = "3211";
//				rowData[7] = address;
//				rowData[8] = email;
//				rowData[9] = domain;
//			}
//			ami.at.dtm.addRow(rowData);
			JOptionPane.showMessageDialog(ami.ar, "등록되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connectionMaker.closeConnection(conn, pstm, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		ami.jfAD.setVisible(false);
	}

	// 관리자 id중복확인
	public void arId() {
		String quary = "select manager_id from fook_manager";
		checkidjoin = ami.ar.idtf.getText();
		if (checkidjoin.isEmpty()) {
			JOptionPane.showMessageDialog(ami.ar, "ID를 입력하세요");
			return;
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
	// abo
	public void mrRegister() {
		if (mr.check == false) {
			SwingFactory.getOptionPane("errorMessage", mr, "아이디 중복체크 여부", "아이디 중복체크를 확인해주세요.");
			return;
		}

		UserDto userDto = mr.makeUserDto();
		if (userDto == null) {
			return;
		}

		if (dao.insert(userDto) == 1) {

			// 정상등록
			SwingFactory.getOptionPane("message", mr, "회원정보 등록완료", "유저가 등록되었습니다.");
			// 테이블에 적용
			mr.clear();
			mt.initData();
			ami.jfMD.setVisible(false);

		} else {
			SwingFactory.getOptionPane("errorMessage", mr, "유저 등록", "시스템 오류, 유저등록 실패하였습니다.");
			return;
		}

	}

	// 회원창 - 중복확인
	public void mrId() {

		String userId = ami.mr.idtf.getText();

		if (userId.isEmpty()) {
			JOptionPane.showMessageDialog(ami.mr, "ID를 입력하세요");
			return;
		}

		if (dao.select(userId)) {
			SwingFactory.getOptionPane("errorMessage", mr, "아이디 중복확인", "중복된 아이디가 있습니다.");
			return;
		} else {
			mr.check = true;
			SwingFactory.getOptionPane("message", mr, "아이디 중복확인", "사용가능한 아이디입니다.");
		}

	}

	public void maRRegister() {

//		int SelectRow = ami.at.adt.convertRowIndexToModel(ami.at.adt.getSelectedRow());

		String quary = ("update fook_manager "
				+ "set password = (?), name = (?), phone_first = (?), phone_middle = (?), phone_last = (?),job_id = (?), address = (?), email = (?), email_domain = (?)"
				+ "where manager_id = (?)");
		String admin_id = maR.getidlabel.getText();
		String admin_pw = maR.passwordtf.getText();
		if (admin_pw.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "비밀번호를 입력하세요");
			return;
		}
		String admin_name = maR.nametf.getText();
		if (admin_name.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "이름을 입력하세요");
		}
		String admin_phonefirst = (String) maR.fristnumber.getSelectedItem();
		String admin_phonemid = maR.midnumber.getText();
		if (admin_phonemid.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "번호를입력하세요");
		}
		String admin_phonelast = maR.lastnumber.getText();
		if (admin_phonelast.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "번호를입력하세요");
		}
		String admin_jobid = (String) maR.jobname.getSelectedItem();
		String admin_address = maR.addresstf.getText();
		if (admin_address.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "주소를입력하세요");
		}
		String admin_email = maR.email.getText();
		if (admin_email.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "이메일을입력하세요");
		}
		String admin_domain = maR.emaildomain.getText();
		if (admin_domain.isEmpty()) {
			JOptionPane.showMessageDialog(maR.registerbtn, "도메인을 입력하세요");
		}
		if (admin_jobid == "관리자") {
			admin_jobid = "Admin";
		} else if (admin_jobid == "점원") {
			admin_jobid = "Clerk";
		} else {
			admin_jobid = "NewBie";
		}
		try {
			conn = connectionMaker.makeConnection();
			pstm = conn.prepareStatement(quary);

			pstm.setString(1, admin_pw);
			pstm.setString(2, admin_name);
			pstm.setString(3, admin_phonefirst);
			pstm.setString(4, admin_phonemid);
			pstm.setString(5, admin_phonelast);
			pstm.setString(6, admin_jobid);
			pstm.setString(7, admin_address);
			pstm.setString(8, admin_email);
			pstm.setString(9, admin_domain);
			pstm.setString(10, admin_id);

			pstm.executeUpdate();

//			pstm.close();
//			
//			pstm = conn.prepareStatement("SELECT \n" + 
//					"    MANAGER_ID\n" + 
//					"    ,NAME\n" + 
//					"    ,PASSWORD\n" + 
//					"    ,PHONE_FIRST||PHONE_MIDDLE||PHONE_LAST as pn\n" + 
//					"    ,fj.job_name as job_name\n" + 
//					"    ,HIRE_DATE\n" + 
//					"    ,ADDRESS_ZIP\n" + 
//					"    ,ADDRESS\n" + 
//					"    ,EMAIL\n" + 
//					"    ,EMAIL_DOMAIN \n" + 
//					"FROM \n" + 
//					"    FOOK_MANAGER fm \n" + 
//					"    , fook_job fj \n" + 
//					"where fm.job_id = fj.job_id(+)");
//			rs = pstm.executeQuery();
//			if((result != 0)) {
//				rowData[0] = admin_id;
//				rowData[1] = admin_name;
//				rowData[2] = admin_pw;
//				rowData[3] = "pn";
//				rowData[4] = admin_jobid;
//				rowData[5] = "hire_date";
//				rowData[6] = "4321";
//				rowData[7] = admin_address;
//				rowData[8] = admin_email;
//				rowData[9] = admin_domain;
//				
//			
//				int columNum = ami.at.dtm.getColumnCount();
//				for (int i = 0; i < columNum; i++) {
//					ami.at.dtm.setValueAt(rowData[i], SelectRow, i);
//				}
//			}
			ami.at.adt.setRowSelectionInterval(ami.at.adt.getSelectedRow(), ami.at.adt.getSelectedRow());
			JOptionPane.showMessageDialog(ami.maR, "수정 되었습니다.");
			ami.jfMo.setVisible(false);
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

	// 유저 정보수정
	// abo
	public void mRRegister() {
		UserDto userDto = mR.makeUserDto();
		if (userDto == null) {
			return;
		}

		int result = dao.modify(userDto);
		if (result == 1) {
			SwingFactory.getOptionPane("message", mR, "회원정보 수정완료", "회원정보가 수정되었습니다.");
			// 테이블에 적용
			mt.initData();
			mR.clear();
			ami.jfMo.setVisible(false);
		} else {
			SwingFactory.getOptionPane("errorMessage", mR, "회원정보 수정실패", "회원정보 수정이 실패하였습니다.");
		}
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
