package kitri.foodCourt.management.order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class OrderListServer implements Runnable {
	// 유저를 담을 벡터 생성
	OrderService service = new OrderService();
	// 서버소켓 생성
	ServerSocket ss;

	public OrderListServer() {
		try {
			ss = new ServerSocket(OrderConatance.PORT); // 포트 열었다
			System.out.println("클라이언트 접속 대기중............");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // 접속 처리
		while (true) { // 실행 되는 순간 부터 클라이언트 접속을 기다린다
			try {
				Socket socket = ss.accept(); // socket에 클라이언트 정보 저장
				System.out.println("클라이언트 접속 성공 : " + socket);
				BufferedReader in;
				OutputStream out;
				String requestNumber;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				String msg = in.readLine();
				System.out.println("클라이언트가 보낸 메세지 : " + msg); // protocol|메세지형식
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case OrderConatance.CS_ORDER: {
//						100|requestNumber|음식이름|갯수|음식이름|갯수 ~~
					requestNumber = st.nextToken();
					if (service.addOrderList(requestNumber, st.nextToken())) {
						unicast(OrderConatance.SC_ORDER_RESULT + "|" + "true", out);
					} else {
						unicast(OrderConatance.SC_ORDER_RESULT + "|" + "false", out);
					}
					break;
				}
				}
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