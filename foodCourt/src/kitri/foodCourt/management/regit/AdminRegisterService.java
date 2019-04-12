package kitri.foodCourt.management.regit;

import java.awt.CardLayout;
import java.awt.Component;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.dto.AdminRegitDto;


public class AdminRegisterService {

	AdminRegisterControl arc;
	AdminMemberInfo ami;
	ManagermentDao managermentDao =new DbFactory().managermentDao();
	AdminRegister ar;
	MemberRegister mr;
	ModifyAdminRegit maR;
	RemoveMember rm;
	ModifyRegit mR;
	List<AdminRegitDto> list = new ArrayList<AdminRegitDto>();

	String[] option = { "예", "아니요" };
	

	


	DefaultTableModel dtm;
	CardLayout card;
	 Connection c = null;
	 PreparedStatement ps = null;
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
//	private void closeOracleConnection(Connection c, PreparedStatement ps, ResultSet rs) {
//		if(rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				rs = null;
//			}
//		}
//		
//		if(ps != null) {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				ps = null;
//			}
//		}
//		
//		if(c != null) {
//			try {
//				c.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				c = null;
//			}
//		}
//	}
	
//	public void showview() {
//		List<AdminRegitDto> list = new ArrayList<AdminRegitDto>();
//		ListIterator<AdminRegitDto> iterator;
//		AdminRegitDto adminRegitDto = null;
//		
//		Object[] rowData = new Object[12];
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dam", "dam");
//			
//			ps = c.prepareStatement("select *" 
//								  + "from FOOK_MANAGER");
//			
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				adminRegitDto = new AdminRegitDto(rs.getString("MANAGER_ID"), rs.getString("NAME"),rs.getString("PASSWORD"), rs.getString("PHONE_FIRST"), rs.getString("PHONE_MIDDLE"),rs.getString("PHONE_LAST"), rs.getString("JOB_ID"), rs.getDate("HIRE_DATE"), rs.getString("ADDRESS_ZIP"),rs.getString("ADDRESS"), rs.getString("EMAIL"), rs.getString("EMAIL_DOMAIN"));
//
//				AdminRegitDto.setPoint(rs.getInt("food_point"));
//				AdminRegitDto.setDescription(rs.getString("food_description"));
//				AdminRegitDto.setManagerId(rs.getString("manager_id"));
//				AdminRegitDto.setCreateDate(rs.getDate("create_date"));
//				AdminRegitDto.setEnable(rs.getString("food_enable").charAt(0));
//				
//				list.add(adminRegitDto);
//			}
//
//			iterator = list.listIterator();
//			
//			while(iterator.hasNext()) {
//				adminRegitDto = iterator.next();
//				
//				rowData[0] = adminRegitDto.getManagerId();
//				rowData[1] = adminRegitDto.getName();
//				rowData[2] = adminRegitDto.getPassword();
//				rowData[3] = adminRegitDto.getPhoneFirst();
//				rowData[4] = adminRegitDto.getPhoneMiddle();
//				rowData[5] = adminRegitDto.getPhoneLast();
//				rowData[6] = adminRegitDto.getJobId();
//				rowData[7] = adminRegitDto.getHireDate();
//				rowData[8] = adminRegitDto.getAdressZip();
//				rowData[9] = adminRegitDto.getAdress();
//				rowData[10] = adminRegitDto.getEmail();
//				rowData[11] = adminRegitDto.getEmailDomain();
//				
//				dtm.addRow(rowData);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeOracleConnection(c, ps, rs);
//		}
//	}
//
//	
//	private void warningMessage(Component component, Object msg, String title) {
//		JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
//	}
	
	public void showadminRegister() {
		
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
	
		
		if(ami.check == false) {
			ami.card.show(ami.jpaMo, "adminModi");
			
		}else {
			ami.card.show(ami.jpaMo, "memberModi");
			
		}
		ami.jfMo.setSize(600, 650);
		ami.jfMo.setVisible(true);

	
		}

	

	public void showdelete() {
		int result = JOptionPane.showOptionDialog(ami.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}

	public void arRegister() {
//		System.out.println("start");
//		int currentSelectedrow = ami.commonTable.convertRowIndexToModel(ami.commonTable.getSelectedRow());
//		int result = 0;	
//		System.out.println("1");
//		
//		Object[] rowData = new Object[12];
//		System.out.println("11");
//		String managerid = ar.idtf.getText();
//		System.out.println(ar.idtf.getText());
//		if (managerid.isEmpty()) {
//			warningMessage(ar.adminRegister, "아이디가 적합하지않습니다", "아이디 오류");
//			return;
//		}
//		System.out.println("3");
//		String managername = ar.nametf.getText();
//		System.out.println("4");
//		if (managername.isEmpty()) {
//			warningMessage(ar.adminRegister, "이름이 적합하지않습니다", "이름 오류");
//			return;
//		}
//		System.out.println("5");
//		String managerpass = ar.passwordtf.getText();
//		System.out.println("6");
//		if (managerpass.isEmpty()) {
//			warningMessage(ar.adminRegister, "비밀번호가 적합하지않습니다", "비밀번호 오류");
//			return;
//		}		
//		System.out.println("7");
//		String managerpw = ar.pwtf.getText();
//		if (managerpw.isEmpty()) {
//			warningMessage(ar.adminRegister, "비밀번호가 일치하지않습니다.", "비밀번호 오류");
//			return;
//		}
//		String managerphone1 = (String) ar.fristnumber.getItemAt(0);
//		if (managerphone1.isEmpty()) {
//			warningMessage(ar.adminRegister, "앞자리를 선택해야 합니다", "번호 오류");
//			return;
//		}
//		String managerphone2 = ar.midnumber.getText();
//		if (managerphone2.isEmpty()) {
//			warningMessage(ar.adminRegister, "가운데자리를 선택해야 합니다", "번호 오류");
//			return;
//		}
//		String managerphone3 = ar.lastnumber.getText();
//		if (managerphone3.isEmpty()) {
//			warningMessage(ar.adminRegister, "뒷자리를 선택해야 합니다", "번호 오류");
//			return;
//		}
//		String jobid = ar;	
//		int price = Integer.parseInt(priceStr);
//		
//		int point = arm.pointTextField.getText().isEmpty() ? (price / 100) : Integer.parseInt(arm.pointTextField.getText());
//		int category = arm.categoryComboBox.getSelectedIndex() + 1;
//		if (category < 1) {
//			warningMessage(arm.confirmBtn, "카테고리를 선택하세요.", "메뉴 등록 오류");
//			return;
//		}
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dam", "dam");
//			
//			ps = c.prepareStatement("insert into FOOK_MANAGER (MANAGER_ID, NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, JOB_ID, HIRE_DATE, ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN) "
//												 + "values ((?), (?), (?), (?), (?), (?), (?), sysdate, (?), (?), (?), (?)");
//			
//			ps.setString(1, managerid);
//			ps.setString(2, managername);
//			ps.setString(3, managerpass);
//			ps.setString(4, managerpw);
//			ps.setString(5, managerphone1);
//			ps.setString(6, managerphone2);
//			ps.setString(7, managerphone3);
////			ps.setString(8, );
////			ps.setString(9, food_enable);
////			ps.setString(10, food_enable);
////			ps.setString(11, food_enable);
////			ps.setString(12, food_enable);
//			
//			result = ps.executeUpdate();
//
//			ps.close();
//			
//			ps = c.prepareStatement("select managerid, managername, managerpass,managerpw ,managerphone1,managerphone2,managerphone3"
//								  + "from FOOK_MANAGER " );
//			
//			rs = ps.executeQuery();
//			
//			if ((result != 0) && rs.next()) {
//				rowData[0] = rs.getString("managerid");
//				rowData[1] = rs.getString("managername");
//				rowData[2] = rs.getString("managerpass");
//				rowData[3] = rs.getString("managerid");
//				rowData[4] = rs.getString("managerid");
////				rowData[5] = manager_id;
////				rowData[6] = rs.getDate("create_date");
////				rowData[7] = food_enable;
//			}
//			
//			dtm.addRow(rowData);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeOracleConnection(c, ps, rs);
//		}
//		
//		Close(ami.jfAD);
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
