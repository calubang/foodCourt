package kitri.foodCourt.user.menu.jdbc;

import java.sql.*;

public class OracleConnectionMaker implements ConnectionMaker{

	public Connection makeConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.14.89:1521:orcl", "kitri", "kitri");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
