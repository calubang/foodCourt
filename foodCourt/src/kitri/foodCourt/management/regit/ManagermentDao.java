package kitri.foodCourt.management.regit;

import kitri.foodCourt.management.regit.ConnectionMaker;
import kitri.foodCourt.dto.AdminRegitDto;

import java.sql.*;



public class ManagermentDao {

	public ConnectionMaker connectionMaker;
	
	public ManagermentDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public int register(AdminRegitDto ard) {
		
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rs = null;
		String sql ="insert into FOOK_MANAGER(MANAGER_ID, NAME, PASSWORD, PHONE_FIRST,PHONE_MIDDLE,PHONE_LAST, JOB_ID, HIRE_DATE, ADDRESS_ZIP, ADDRESS, EMAIL, EMAIL_DOMAIN) values(?,?,?,?,?,?,?,sysdate,?,?,?,?)";
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, ard.getManagerId());
			ps.setString(2, ard.getName());
			ps.setString(3, ard.getPassword());
			ps.setString(4, ard.getPhoneFirst());
			ps.setString(5, ard.getPhoneMiddle());
			ps.setString(6, ard.getPhoneLast());
			ps.setString(7, ard.getJobId());
			ps.setDate(8, ard.getHireDate());
			ps.setString(9, ard.getAdressZip());
			ps.setString(10, ard.getAdress());
			ps.setString(11, ard.getEmail());
			ps.setString(12, ard.getEmailDomain());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return -1;
		
	}
}
