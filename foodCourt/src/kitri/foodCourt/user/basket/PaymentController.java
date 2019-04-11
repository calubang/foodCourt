package kitri.foodCourt.user.basket;

import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import kitri.foodCourt.user.swing.FButton;

public class PaymentController implements ActionListener, KeyListener{
	public Payment payment;
	private PaymentService service;
	
	public PaymentController(Payment payment){
		this.payment = payment;
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
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//3개 텍스트필드
		service.checkValue((JTextField)e.getComponent(), e.getKeyChar());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
