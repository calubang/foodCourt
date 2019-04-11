package kitri.foodCourt.user.basket;

import java.sql.*;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.user.*;

public class PaymentDao {
	
	private PaymentService service;
	private ConnectionMaker connectionMaker;
	
	public PaymentDao(PaymentService service) {
		this.service = service;
		connectionMaker = DbFactory.connectionMaker("oracle");
	}

	public int insertPayment(User user, int card, int cash, int point) {
		int result = 0 ;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into fook_payment(\r\n" + 
				"    payment_id\r\n" + 
				"    , user_id\r\n" + 
				"    , payment_date\r\n" + 
				"    , request_number\r\n" + 
				"    , total_price\r\n" + 
				"    , save_point\r\n" + 
				"    , cash\r\n" + 
				"    , card\r\n" + 
				"    , used_point\r\n" + 
				"    , payment_state\r\n" + 
				")VALUES(\r\n" + 
				"    payment_id_seq.nextval\r\n" + 	//결제id 는 seq 를 통해 자동으로 얻어짐
				"    , ?\r\n" + 									//user_id
				"    , sysdate\r\n" + 						//sysdate
				"    , ?\r\n" + 									//요청번호
				"    , ?\r\n" + 									//총가격
				"    , ?\r\n" + 									//총획득포인트
				"    , ?\r\n" + 									//현금
				"    , ?\r\n" + 									//카드
				"    , ?\r\n" + 									//사용포인트
				"    , 0\r\n" + 									//0결제 , 1환불
				")";
		try {
			con = connectionMaker.makeConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserId());   								//유저id
			ps.setInt(2, user.getBasket().getRequestNumber());		//요청번호
			ps.setInt(3, user.getBasket().getTotalPrice());				//총가격
			ps.setInt(4, user.getBasket().getSavePoint());				//총획득포인트
			ps.setInt(5, cash);														//현금
			ps.setInt(6, card);														//카드
			ps.setInt(7, point);														//사용포인트
			result = ps.executeUpdate();
			if( result == 1) {
				//detail 생성
				for(BasketDetail detail : user.getBasket().getDetailList()) {
					result = insertDetail(con, detail);
					if( result != 1) {
						return result;
					}
				}
				// user point 업데이트
				result = updateUserPoint(con, user.getUserId(), user.getUserPoint());
				if(result != 1) {
					return result;
				}
				con.commit();
				return user.getBasket().getDetailList().size();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.rollback();
				
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int insertDetail(Connection con, BasketDetail detail) throws SQLException {
		System.out.println(detail);
		PreparedStatement ps = null;
		String sql = "insert into fook_payment_detail(\r\n" + 
				"    payment_id\r\n" + 
				"    , food_id\r\n" + 
				"    , food_name\r\n" + 
				"    , price\r\n" + 
				"    , count\r\n" + 
				"    , point\r\n" + 
				")values(\r\n" + 
				"     PAYMENT_ID_SEQ.currval\r\n" + 			//현재 seq
				"     , ?\r\n" + 										//food_id
				"     , ?\r\n" + 										//food name
				"     , ?\r\n" + 										//price
				"     , ?\r\n" + 										//count
				"     , ?\r\n" + 										//point
				")";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, detail.getFood().getFoodId());	//id
		ps.setString(2, detail.getFood().getFoodName());	//name
		ps.setInt(3, detail.getFood().getPrice());	//price
		ps.setInt(4, detail.getCount());	//count
		ps.setInt(5, detail.getFood().getPoint());	//point
	
		
		return ps.executeUpdate();
	}
	
	public int updateUserPoint(Connection con, String userId, int newPoint) throws SQLException {
		
		PreparedStatement ps = null;
		String sql = 
				"update fook_user\r\n" + 
				"set\r\n" + 
				"    user_point = ?\r\n" + 
				"where \r\n" + 
				"    user_id = ?";
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, newPoint);	//newPoint
		ps.setString(2, userId);	//id
		
		return ps.executeUpdate();
		
	}
}
