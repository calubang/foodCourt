package kitri.foodCourt.user.menu.jdbc;

import kitri.foodCourt.user.menu.MenuDao;

public class DaoFactory {
	public ConnectionMaker connectionMaker() { 
		return new OracleConnectionMaker(); // 학원에서 디비 연결할때
//		return new HomeOracleConnectionMaker(); 집에서 디비 테스트 할때
	}
	public MenuDao menuDao() {
		ConnectionMaker connectionMaker = connectionMaker();
		MenuDao userDao = new MenuDao(connectionMaker);
		return userDao;
	}
}