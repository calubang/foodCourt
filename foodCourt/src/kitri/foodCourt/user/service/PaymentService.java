package kitri.foodCourt.user.service;

import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.xml.crypto.Data;

import kitri.foodCourt.dto.PaymentDto;
import kitri.foodCourt.management.order.OrderConatance;
import kitri.foodCourt.user.BasketDetail;
import kitri.foodCourt.user.User;
import kitri.foodCourt.user.controller.PaymentController;
import kitri.foodCourt.user.dao.PaymentDao;
import kitri.foodCourt.user.swing.SwingFactory;
import kitri.foodCourt.user.view.Payment;
import kitri.foodCourt.user.view.Receipt;

public class PaymentService {

	public PaymentController controller;
	public Payment payment;
	public PaymentDao paymentDao;
	public User user;

	public PaymentService(PaymentController paymentController) {
		this.controller = paymentController;
		this.payment = controller.payment;
		this.paymentDao = new PaymentDao(this);
		this.user = payment.basketMain.user;
	}

	public void receiptConfirm() {
		Receipt receipt = payment.receipt;
		receipt.setBounds(payment.getX() + 100, payment.getY() + 100, receipt.getWidth(), receipt.getHeight());
		receipt.dataSetting();
		payment.receipt.setVisible(true);
		payment.setEnabled(false);

	}

	public void receiptOK() {
		payment.setEnabled(true);
		payment.receipt.setVisible(false);
	}

	public void payment() {
		// 실제 결제부분
		// 정상적으로 가격이 적어졌는지 부터 확인
		// 장바구니 -> 결제 클래스로 변경
		// paymentDao.payment();
		int cash = 0, card = 0, point = 0;
		int total = 0;
		int savePoint = 0;
		int usedPoint = 0;

		if (payment.tfCash.getText().isEmpty()) {
			cash = 0;
		} else {
			cash = Integer.parseInt(payment.tfCash.getText());
		}
		if (payment.tfCard.getText().isEmpty()) {
			card = 0;
		} else {
			card = Integer.parseInt(payment.tfCard.getText());
		}
		if (payment.tfPoint.getText().isEmpty()) {
			point = 0;
		} else {
			point = Integer.parseInt(payment.tfPoint.getText());
		}
		total = card + cash + point;
		if (total < user.getBasket().getTotalPrice()) {
			SwingFactory.getOptionPane("message", payment, "결제오류", "입력금액 총합이 적습니다.");
			return;
		} else if (total > user.getBasket().getTotalPrice()) {
			SwingFactory.getOptionPane("message", payment, "결제오류", "입력금액 총합이 많습니다.");
			return;
		}

		// 네트워크 통신
		// ---------------------------------------------------
		Socket socket = null;
		BufferedReader in = null;
		OutputStream out = null;
		String orderStr = "";
		boolean flag = true;
		String orderNumber=""; // 서버에서 생성해준 request 번호
		try {
			socket = new Socket(OrderConatance.IP, OrderConatance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			List<BasketDetail> list = user.getBasket().getDetailList();
			for (BasketDetail basketDetail : list) {
				orderStr += basketDetail.getFood().getFoodName() + "^" + basketDetail.getCount() + "^";
			}
//			100|음식이름^수량~|
			sendMassage(OrderConatance.CS_ORDER + "|" + orderStr, out);

			while (flag) {
				String msg = in.readLine();
				System.out.println("서버가 보낸 메세지 : " + msg);
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case OrderConatance.SC_ORDER_RESULT: {
//					200|true or false
					orderNumber = st.nextToken();
					System.out.println("주문 번호"+orderNumber);
					flag = false;
				}
				}
			}
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(controller.payment.basketMain.foodMain, "주문 오류가 발생했습니다 \n 직원에게 문의해주세요", "결제 오류", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(controller.payment.basketMain.foodMain, "주문 오류가 발생했습니다 \n 직원에게 문의해주세요", "결제 오류", JOptionPane.ERROR_MESSAGE);
			return;
		} finally {
			if (out != null) 		{try {out.close();} 	catch (IOException e) {e.printStackTrace();}}
			if (in != null) 		{try {in.close();} 		catch (IOException e) {e.printStackTrace();}}
			if (socket != null) 	{try {socket.close();} 	catch (IOException e) {e.printStackTrace();}}

		}
		// ---------------------------------------------------
		
		// DB연동
		user.getBasket().setRequestNumber(Integer.valueOf(orderNumber));
		int dbResult = paymentDao.insertPayment(user, card, cash, point);
		if (dbResult == -1) {
			// 비정상
			System.out.println("비정상종료");
			SwingFactory.getOptionPane("errorMessage", payment, "결제오류", "결제오류, 관리자를 호출해주세요.");
			return;
		}
		
		// 포인트 조절
		savePoint = user.getBasket().getSavePoint();
		usedPoint = point;
		user.setUserPoint(user.getUserPoint() - usedPoint + savePoint);
		
		// 모든 절차후
		int result = SwingFactory.getOptionPane("message", payment, "결제확인", orderNumber + "번으로 결제완료 되었습니다.");
		if (result == 0) {
			//payment.requestNumber++;
			payment.basketMain.foodMain.card.show(payment.basketMain.foodMain.panChangePanel, "foodMainView");
			// 장바구니 초기화
			payment.basketMain.user.getBasket().removeAll();
		}
	}

	public void cancel() {
		// 결제 취소
		int select = SwingFactory.getOptionPane("warning", payment, "결제취소", "장바구니 화면으로 돌아가시겠습니까?");
		if (select == 0) {
			// 예
			payment.basketMain.dataSetting();
			payment.basketMain.card.show(payment.basketMain.pChangePanel, "basket");
		}
	}

	// 입력받은 숫자확인
	public void checkValue(JTextField tp, char input) {
		if(input == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		if( input < 32 || input > 126 ) {
			return;
		}
		if (input > '9' || input < '0') {
			if (tp.getText().isEmpty()) {
				return;
			}
			tp.setText(tp.getText().substring(0, tp.getText().length() - 1));
			// SwingFactory.getOptionPane("warning", payment, "잘못된 입력", "숫자를 입력해주세요");
			return;
		}

		// 포인트의 경우는 입력 후 가용포인트와 비교하는 작업
		if (tp.getName().equals("point")) {
			int point = 0;
			if (payment.tfPoint.getText().isEmpty()) {
				point = 0;
				return;
			} else {
				point = Integer.parseInt(payment.tfPoint.getText());
			}
			if (point > payment.basketMain.user.getUserPoint()) {
				tp.setText(tp.getText().substring(0, tp.getText().length() - 1));
				SwingFactory.getOptionPane("warning", payment, "잘못된 입력", "사용가용한 포인트를 넘었습니다.");
				return;
			}
		}

	}

	private void sendMassage(String msg, OutputStream out) {
		try {
			out.write((msg + "|\n").getBytes()); // BufferedReader는 enter key 기준
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
