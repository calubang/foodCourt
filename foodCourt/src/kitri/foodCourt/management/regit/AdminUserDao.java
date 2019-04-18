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
	
	public boolean select(String userId) {
		UserDto userDto = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"select user_id\r\n" + 
				"from fook_user\r\n" + 
				"where user_id = ?";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			return rs.next();
			
			
//			userDto = new UserDto();
//			userDto.setUserId(rs.getString("user_id"));
//			userDto.setPassword(rs.getString("password"));
//			userDto.setName(rs.getString("name"));
//			userDto.setPhoneNumberFirst(rs.getString("phone_first"));
//			userDto.setPhoneNumberMiddle(rs.getString("phone_middle"));
//			userDto.setPhoneNumberlast(rs.getString("phone_last"));
//			userDto.setUserPoint(Integer.parseInt(rs.getString("user_point")));
//			userDto.setPasswordQuiz(rs.getString("password_quiz"));
//			userDto.setPasswordAnswer(rs.getString("password_answer"));
//			userDto.setJoinDate(rs.getString("join_date"));
//			userDto.setSecessionDate(rs.getString("secession_date"));
//			userDto.setEnable(rs.getString("enable").charAt(0));
				
			//return userDto;
			
		} catch (SQLException sqle) {
			System.out.println("id select 문에서 예외 발생");
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
		return false;
	}
	
	public int modify(UserDto userDto) {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"update fook_user\r\n" + 
				"set \r\n" + 
				"    password = ?\r\n" + 
				"    , name = ?\r\n" + 
				"    , phone_first = ?\r\n" + 
				"    , phone_middle = ?\r\n" + 
				"    , phone_last = ?\r\n" + 
				"    , user_point = ?\r\n" + 
				"    , password_quiz = ?\r\n" + 
				"    , password_answer = ?\r\n" + 
				"    , join_date = nvl(to_date(?, 'yyyy-mm-dd'), join_date)\r\n" + 
				"    , secession_date = nvl(to_date(?, 'yyyy-mm-dd'), secession_date)\r\n" + 
				"    , enable = lower(?)\r\n" + 
				"where user_id = ?";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDto.getPassword());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getPhoneNumberFirst());
			ps.setString(4, userDto.getPhoneNumberMiddle());
			ps.setString(5, userDto.getPhoneNumberlast());
			ps.setInt(6, userDto.getUserPoint());
			ps.setString(7, userDto.getPasswordQuiz());
			ps.setString(8, userDto.getPasswordAnswer());
			ps.setString(9, userDto.getJoinDate());
			ps.setString(10, userDto.getSecessionDate());
			ps.setString(11, String.valueOf(userDto.getEnable()));
			ps.setString(12, userDto.getUserId());
			
			result = ps.executeUpdate();
			
			return result;
			
		} catch (SQLException sqle) {
			System.out.println("modify 문에서 예외 발생");
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
	
	public int delete(String userId) {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"delete from fook_user\n" + 
				"where user_id = ?";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			
			result = ps.executeUpdate();
			
			return result;
			
		} catch (SQLException sqle) {
			System.out.println("delete문에서 예외 발생");
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
	
	public int insert(UserDto user) {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = 
				"insert into fook_user(\n" + 
				"    user_id\n" + 
				"    , password\n" + 
				"    , name\n" + 
				"    , phone_first\n" + 
				"    , phone_middle\n" + 
				"    , phone_last\n" + 
				"    , user_point\n" + 
				"    , password_quiz\n" + 
				"    , password_answer\n" + 
				"    , join_date\n" + 
				"    , secession_date\n" + 
				"    , enable\n" + 
				")values(\n" + 
				"    ?\n" + 
				"    , ?\n" + 
				"    , ?\n" + 
				"    , ?\n" + 
				"    , ?\n" + 
				"    , ?\n" + 
				"    , nvl(?, 0)\n" + 
				"    , ?\n" + 
				"    , ?\n" + 
				"    , nvl(to_date(?, 'yyyy-mm-dd'), sysdate)\n" + 
				"    , nvl(to_date(?, 'yyyy-mm-dd'), '')\n" + 
				"    , lower(?)\n" + 
				")";
		
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getPhoneNumberFirst());
			ps.setString(5, user.getPhoneNumberMiddle());
			ps.setString(6, user.getPhoneNumberlast());
			ps.setInt(7, user.getUserPoint());
			ps.setString(8, user.getPasswordQuiz());
			ps.setString(9, user.getPasswordAnswer());
			ps.setString(10, user.getJoinDate());
			ps.setString(11, user.getSecessionDate());
			ps.setString(12, user.getEnable()+"");

			result = ps.executeUpdate();
			
			return result;
			
		} catch (SQLException sqle) {
			System.out.println("insert문에서 예외 발생");
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
