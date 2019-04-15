package kitri.foodCourt.db;

import java.sql.*;

public interface ConnectionMaker {
	public Connection makeConnection();
	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException;
}
