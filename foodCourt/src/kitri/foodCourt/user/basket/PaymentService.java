package kitri.foodCourt.user.basket;

import kitri.foodCourt.dto.PaymentDto;

public class PaymentService {
	
	public PaymentController controller;
	public Payment payment;
	public PaymentDao paymentDao;
	
	public PaymentService(PaymentController paymentController) {
		this.controller = paymentController;
		this.payment = controller.payment;
		this.paymentDao = new PaymentDao(this);
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
		
		SwingFactory.getOptionPane("message", payment, "결제확인", "결제완료 되었습니다.");
	}

	public void isCorrectValue() {
		
	}

	public void cancel() {
		//결제 취소
		int select = SwingFactory.getOptionPane("warning", payment, "결제취소", "장바구니 화면으로 돌아가시겠습니까?");
		if(select == 0) {
			//예
			payment.basketMain.payment = null;
			payment.basketMain.card.show(payment.basketMain.pChangePanel, "basket");
		}
	}
	
}
