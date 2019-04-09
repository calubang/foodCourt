package kitri.foodCourt.db;

public class DbFactory {
	public static ConnectionMaker connectionMaker(String name) { 
		switch(name) {
		case "oracle":
			return new OracleConnectionMaker();
		}
		return null;
	}
}