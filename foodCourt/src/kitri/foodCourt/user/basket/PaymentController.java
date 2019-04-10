package kitri.foodCourt.user.basket;

import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import kitri.foodCourt.user.swing.FButton;

public class PaymentController implements ActionListener, InputMethodListener, KeyListener{
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
	public void inputMethodTextChanged(InputMethodEvent e) {
		JTextPane jTextPane = (JTextPane)e.getSource();
		System.out.println(e);
		String name = jTextPane.getName();
		switch(name) {
		case "cash":
			System.out.println(e);
			break;
		case "card":
			break;
		case "point":
			service.isCorrectValue();
			break;
		}
	}

	@Override
	public void caretPositionChanged(InputMethodEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e);
		JTextField temp = (JTextField)e.getComponent();
		char input = e.getKeyChar();
		if(input > '9' || input < '0') {
			temp.setText(temp.getText().substring(0, temp.getText().length()-1));
			SwingFactory.getOptionPane("warning", payment, "잘못된 입력", "숫자를 입력해주세요");
			return;
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
