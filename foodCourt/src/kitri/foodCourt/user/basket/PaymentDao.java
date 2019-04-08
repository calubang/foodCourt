package kitri.foodCourt.user.basket;

import java.sql.*;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;

public class PaymentDao {
	
	private PaymentService service;
	private ConnectionMaker connectionMaker;
	
	public PaymentDao(PaymentService service) {
		this.service = service;
		connectionMaker = DbFactory.connectionMaker("oracle");
	}

	public int payment() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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

	
}
