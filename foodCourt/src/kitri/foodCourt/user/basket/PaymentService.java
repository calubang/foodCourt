package kitri.foodCourt.user.basket;

import kitri.foodCourt.dto.PaymentDto;

public class PaymentService {
	
	public PaymentController controller;
	public PaymentMain paymentMain;
	public PaymentDao paymentDao;
	
	public PaymentService(PaymentController paymentController) {
		this.controller = paymentController;
		this.paymentMain = controller.paymentMain;
		this.paymentDao = new PaymentDao(this);
	}

	public void receiptConfirm() {
		Receipt receipt = paymentMain.receipt;
		receipt.setBounds(paymentMain.getX()+100, paymentMain.getY()+100, receipt.getWidth(), receipt.getHeight());
		paymentMain.receipt.setVisible(true);
		paymentMain.setEnabled(false);
		
	}

	public void receiptOK() {
		paymentMain.setEnabled(true);
		Receipt receipt = paymentMain.receipt;
		receipt.setVisible(false);
		
	}

	public void payment() {
		//실제 결제부분 
		//정상적으로 가격이 적어졌는지 부터 확인
		//장바구니 -> 결제 클래스로 변경
		//paymentDao.payment();
		
		SwingFactory.getOptionPane("message", paymentMain, "결제확인", "결제완료 되었습니다.");
	}

	public void isCorrectValue() {
		
	}

	public void cancel() {
		//결제 취소
		SwingFactory.getOptionPane("warning", paymentMain, "결제취소", "장바구니 화면으로 돌아가시겠습니까?");
	}
	
}
