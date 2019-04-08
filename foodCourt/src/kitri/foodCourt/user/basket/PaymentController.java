package kitri.foodCourt.user.basket;

import java.awt.event.*;

import javax.swing.JTextPane;

import kitri.foodCourt.user.swing.FButton;

public class PaymentController implements ActionListener, InputMethodListener{
	public PaymentMain paymentMain;
	private PaymentService service;
	
	public PaymentController(PaymentMain paymentMain){
		this.paymentMain = paymentMain;
		this.service = new PaymentService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = ((FButton)e.getSource()).getName();
		
		switch(name) {
		case "receiptConfirm":
			service.receiptConfirm();
			break;
		case "receiptOK":
			service.receiptOK();
			break;
		case "payment":
			service.payment();
			break;
		case "cancel":
			service.cancel();
			break;
		}
	}

	@Override
	public void inputMethodTextChanged(InputMethodEvent e) {
		JTextPane jTextPane = (JTextPane)e.getSource();
		String name = jTextPane.getName();
		switch(name) {
		case "cash":
		case "card":
		case "point":
			service.isCorrectValue();
			break;
		}
	}

	@Override
	public void caretPositionChanged(InputMethodEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
