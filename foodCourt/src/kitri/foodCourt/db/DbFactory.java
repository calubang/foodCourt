package kitri.foodCourt.db;

public class DbFactory {
	public static ConnectionMaker connectionMaker(String name) { 
		switch(name) {
		case "oracle":
			return new OracleConnectionMaker();
		case "oracleJW":
			return new OracleConnectionMakerJW();
		default:
			return new OracleConnectionMaker();
		}
	}
}