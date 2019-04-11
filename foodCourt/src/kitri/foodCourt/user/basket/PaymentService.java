package kitri.foodCourt.user.basket;

import javax.swing.JTextField;
import javax.xml.crypto.Data;

import kitri.foodCourt.dto.PaymentDto;
import kitri.foodCourt.user.User;

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
		receipt.setBounds(payment.getX()+100, payment.getY()+100, receipt.getWidth(), receipt.getHeight());
		payment.receipt.setVisible(true);
		payment.setEnabled(false);
		
	}

	public void receiptOK() {
		payment.setEnabled(true);
		Receipt receipt = payment.receipt;
		receipt.setVisible(false);
	}

	public void payment() {
		//실제 결제부분
		//정상적으로 가격이 적어졌는지 부터 확인
		//장바구니 -> 결제 클래스로 변경
		//paymentDao.payment();
		int cash = 0 , card = 0, point = 0;
		int total = 0;
		if(payment.tfCash.getText().isEmpty()) {
			cash = 0;
		} else {
			cash = Integer.parseInt(payment.tfCash.getText());
		}
		if(payment.tfCard.getText().isEmpty()) {
			card = 0;
		} else {
			card = Integer.parseInt(payment.tfCard.getText());
		}
		if(payment.tfPoint.getText().isEmpty()) {
			point = 0;
		} else {
			point = Integer.parseInt(payment.tfPoint.getText());
		}
		total = card+cash+point;
		if( total < user.getBasket().getTotalPrice()) {
			SwingFactory.getOptionPane("warning", payment, "결제오류", "입력금액 총합이 적습니다.");
			return;
		} else if(  total > user.getBasket().getTotalPrice() ) {
			SwingFactory.getOptionPane("warning", payment, "결제오류", "입력금액 총합이 많습니다.");
			return;
		}
		
		//장바구니 초기화
		payment.basketMain.user.getBasket().removeAll();
		//네트워크 통신
		
		//모든 절차후
		int result = SwingFactory.getOptionPane("message", payment, "결제확인", payment.requestNumber + "번으로 결제완료 되었습니다.");
		if(result == 0) {
			payment.requestNumber++;
			payment.basketMain.foodMain.card.show(payment.basketMain.foodMain.panChangePanel, "foodMainView");
		}
		
		
		
	}

	public void isCorrectValue() {
		
	}

	public void cancel() {
		//결제 취소
		int select = SwingFactory.getOptionPane("warning", payment, "결제취소", "장바구니 화면으로 돌아가시겠습니까?");
		if(select == 0) {
			//예
			payment.basketMain.dataSetting();
			payment.basketMain.card.show(payment.basketMain.pChangePanel, "basket");
		}
	}
	
	//입력받은 숫자확인
	public void checkValue(JTextField tp, char input) {
		if(input > '9' || input < '0') {
			if(tp.getText().isEmpty()) {
				return;
			}
			tp.setText(tp.getText().substring(0, tp.getText().length()-1));
			//SwingFactory.getOptionPane("warning", payment, "잘못된 입력", "숫자를 입력해주세요");
			return;
		}
		
		//포인트의 경우는 입력 후 가용포인트와 비교하는 작업
		if(tp.getName().equals("point")) {
			int point = 0;
			if(payment.tfPoint.getText().isEmpty()) {
				point = 0;
				return;
			} else {
				point = Integer.parseInt(payment.tfPoint.getText());
			}
			if(point > payment.basketMain.user.getUserPoint()) {
				tp.setText(tp.getText().substring(0, tp.getText().length()-1));
				SwingFactory.getOptionPane("warning", payment, "잘못된 입력", "사용가용한 포인트를 넘었습니다.");
				return;
			}
		}
		
	}
	
}
