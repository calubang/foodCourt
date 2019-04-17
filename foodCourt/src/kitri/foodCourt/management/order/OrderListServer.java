package kitri.foodCourt.management.order;

import java.io.*;
import java.net.*;
import java.util.*;

public class OrderListServer implements Runnable {
	// 유저를 담을 벡터 생성
	public OrderService orderService;
	// 서버소켓 생성
	public ServerSocket serverSocket = null;
	public Socket socket = null;
	public BufferedReader in = null;
	public OutputStream out = null;
	public boolean flag = true;
	public OrderListServer(OrderService orderService) {
		this.orderService = orderService;
		try {
			serverSocket = new ServerSocket(OrderConatance.PORT); // 포트 열었다
			System.out.println("클라이언트 접속 대기중............");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // 접속 처리
		while (flag) { // 실행 되는 순간 부터 클라이언트 접속을 기다린다
			try {
				socket = serverSocket.accept(); // socket에 클라이언트 정보 저장
				System.out.println("클라이언트 접속 성공 : " + socket);
				String requestNumber;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				String msg = in.readLine();
				System.out.println("클라이언트가 보낸 메세지 : " + msg); // protocol|메세지형식
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case OrderConatance.CS_ORDER: {
//					100|requestNumber|음식이름^갯수^음식이름^갯수| ~~
					requestNumber = st.nextToken();
					orderService.addOrderList(Integer.parseInt(requestNumber), st.nextToken());
						System.out.println("주문이 완료되었습니다");
						unicast(Integer.toString(OrderConatance.SC_ORDER_RESULT), out);
					break;
				}
				}
			} catch (SocketException e) {
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void unicast(String msg, OutputStream out) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}