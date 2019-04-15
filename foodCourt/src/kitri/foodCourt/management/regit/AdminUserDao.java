package kitri.foodCourt.management.regit;

import java.sql.*;
import java.util.Vector;

import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.UserDto;

public class AdminUserDao {
	
	private kitri.foodCourt.db.ConnectionMaker connectionMaker;
	
	public AdminUserDao() {
		this.connectionMaker = DbFactory.connectionMaker("oracle");
	}
	
	public Vector<UserDto> allSelect() {
		Vector<UserDto> vector = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"select \r\n" + 
				"    user_id\r\n" + 
				"    , password\r\n" + 
				"    , name\r\n" + 
				"    , phone_first\r\n" + 
				"    , phone_middle\r\n" + 
				"    , phone_last\r\n" + 
				"    , user_point\r\n" + 
				"    , password_quiz\r\n" + 
				"    , password_answer\r\n" + 
				"    , to_char(join_date, 'yyyy-mm-dd hh24:mi:ss') as join_date\r\n" + 
				"    , nvl(to_char(secession_date, 'yyyy-mm-dd hh24:mi:ss'), '') as secession_date\r\n" + 
				"    , enable\r\n" + 
				"from fook_user";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			vector = new Vector<UserDto>();
			
			while (rs.next()) {
				
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getString("user_id"));
				userDto.setPassword(rs.getString("password"));
				userDto.setName(rs.getString("name"));
				userDto.setPhoneNumberFirst(rs.getString("phone_first"));
				userDto.setPhoneNumberMiddle(rs.getString("phone_middle"));
				userDto.setPhoneNumberlast(rs.getString("phone_last"));
				userDto.setUserPoint(Integer.parseInt(rs.getString("user_point")));
				userDto.setPasswordQuiz(rs.getString("password_quiz"));
				userDto.setPasswordAnswer(rs.getString("password_answer"));
				userDto.setJoinDate(rs.getString("join_date"));
				userDto.setSecessionDate(rs.getString("secession_date"));
				userDto.setEnable(rs.getString("enable").charAt(0));
				
				vector.add(userDto);
				
			}
			
			return vector;
			
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다.
			try {
				connectionMaker.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				System.out.println("DB연결 종료중 문제생김 : " + sql);
				e.printStackTrace();
			}
			
		}
		return vector;
	}
	
	public UserDto select(String userId) {
		UserDto userDto = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"select \r\n" + 
				"    user_id\r\n" + 
				"    , password\r\n" + 
				"    , name\r\n" + 
				"    , phone_first\r\n" + 
				"    , phone_middle\r\n" + 
				"    , phone_last\r\n" + 
				"    , user_point\r\n" + 
				"    , password_quiz\r\n" + 
				"    , password_answer\r\n" + 
				"    , to_char(join_date, 'yyyy-mm-dd hh24:mi:ss') as join_date\r\n" + 
				"    , nvl(to_char(secession_date, 'yyyy-mm-dd hh24:mi:ss'), '') as secession_date\r\n" + 
				"    , enable\r\n" + 
				"from fook_user\r\n" + 
				"where user_id = ? ";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			userDto = new UserDto();
			userDto.setUserId(rs.getString("user_id"));
			userDto.setPassword(rs.getString("password"));
			userDto.setName(rs.getString("name"));
			userDto.setPhoneNumberFirst(rs.getString("phone_first"));
			userDto.setPhoneNumberMiddle(rs.getString("phone_middle"));
			userDto.setPhoneNumberlast(rs.getString("phone_last"));
			userDto.setUserPoint(Integer.parseInt(rs.getString("user_point")));
			userDto.setPasswordQuiz(rs.getString("password_quiz"));
			userDto.setPasswordAnswer(rs.getString("password_answer"));
			userDto.setJoinDate(rs.getString("join_date"));
			userDto.setSecessionDate(rs.getString("secession_date"));
			userDto.setEnable(rs.getString("enable").charAt(0));
				
			return userDto;
			
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다.
			try {
				connectionMaker.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				System.out.println("DB연결 종료중 문제생김 : " + sql);
				e.printStackTrace();
			}
			
		}
		return userDto;
	}
	
	public int modify(UserDto userDto) {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
			
			return result;
			
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다.
			try {
				connectionMaker.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				System.out.println("DB연결 종료중 문제생김 : " + sql);
				e.printStackTrace();
			}
			
		}
		return result;
	}

}
