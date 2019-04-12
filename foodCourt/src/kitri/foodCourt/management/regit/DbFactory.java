package kitri.foodCourt.management.regit;

import kitri.foodCourt.management.regit.ManagermentDao;;


public class DbFactory {
	public ConnectionMaker connectionMaker() { 
		return new OracleConnectionMaker(); // 학원에서 디비 연결할때

	}

	public ManagermentDao managermentDao() {
		ConnectionMaker connectionMaker = connectionMaker();
		ManagermentDao managermentDao = new ManagermentDao(connectionMaker);
		return managermentDao;
	}
}