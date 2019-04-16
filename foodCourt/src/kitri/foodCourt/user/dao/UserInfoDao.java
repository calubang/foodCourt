package kitri.foodCourt.user.dao;

import java.sql.*;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.service.UserInfoService;

public class UserInfoDao {	

	private UserInfoService service;
	private ConnectionMaker connectionMaker;
	
	public UserInfoDao(UserInfoService userInfoService) {
		this.service = userInfoService;
		connectionMaker = DbFactory.connectionMaker("oracle");
	}

	public int modify(UserDto modifyUser) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = 
				"update fook_user\r\n" + 
				"set \r\n" + 
				"    password = ?\r\n" + 
				"    , name = ?\r\n" + 
				"    , phone_first = ?\r\n" + 
				"    , phone_middle = ?\r\n" + 
				"    , phone_last = ?\r\n" + 
				"    , password_quiz = ?\r\n" + 
				"    , password_answer = ?\r\n" + 
				"where user_id = ?\r\n";
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modifyUser.getPassword());
			ps.setString(2, modifyUser.getName());
			ps.setString(3, modifyUser.getPhoneNumberFirst());
			ps.setString(4, modifyUser.getPhoneNumberMiddle());
			ps.setString(5, modifyUser.getPhoneNumberlast());
			ps.setString(6, modifyUser.getUserId());
			ps.setString(7, modifyUser.getPasswordQuiz());
			ps.setString(8, modifyUser.getPasswordAnswer());
			
			int result = ps.executeUpdate();
			
			System.out.println("DB : User Modify ->" + modifyUser);
			return result;
			
		} catch (SQLException e) {
			System.out.println("DB failed : UserModify");
			e.printStackTrace();
		} finally {
			try {
				closeConnection(con, ps, null, sql);
			} catch(SQLException e) {
				System.out.println("DB failed : UserModify");
				e.printStackTrace();
			}
		}
		return -1;
	}

	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs, String sql) throws SQLException{
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(con != null) {
			con.close();
		}
	}

	public int secession(String userId) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = 
				"delete from fook_user\r\n" + 
				"where user_id = ?";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("DB failed : User Secession");
			e.printStackTrace();
		} finally {
			try {
				closeConnection(con, ps, null, sql);
			} catch(SQLException e) {
				System.out.println("DB close failed : User Secession");
				e.printStackTrace();
			}
		}
		return -1;
	}
}
