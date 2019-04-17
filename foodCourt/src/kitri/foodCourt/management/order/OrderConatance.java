package kitri.foodCourt.management.order;

public interface OrderConatance {
	public static final int PORT = 9876;
	public static final String IP = "192.168.14.89";
//	Protocol 정의
	
//	client >> server (client는 오로지 서버하고만 통신한다)
//	접속 및 주문정보 전송				100|요청번호|음식이름|수량|음식이름|수량|음식이름|수량 - 반복
	public static final int CS_ORDER = 100;
	
//	server >> client(여러명이 될 수 있다)
//	주문정보 수신 여부 전송				200|
	public static final int SC_ORDER_RESULT = 200;
	
}
