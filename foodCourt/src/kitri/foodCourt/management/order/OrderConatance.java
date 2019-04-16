package kitri.foodCourt.management.order;

public interface OrderConatance {
	public static final int PORT = 9876;
//	Protocol 정의
	
//	client >> server (client는 오로지 서버하고만 통신한다)
//	접속 및 주문정보 전송				100|요청번호|음식정보
	public static final int CS_ORDER = 100;
	
//	server >> client(여러명이 될 수 있다)
//	주문정보 수신 여부 전송				200|성공여부
	public static final int SC_ORDER = 200;
	
}
