package kitri.foodCourt.user.basket;

import java.awt.Button;
import java.awt.TrayIcon.MessageType;
import java.awt.event.*;

import javax.swing.JOptionPane;

import kitri.foodCourt.user.swing.FButton;
import kitri.foodCourt.user.swing.FOptionPane;

public class BasketController implements ActionListener, MouseListener{

	public BasketMain basketMain;
	public BasketService service;
	
	String[] options = {"예", "아니오"};
	
	public BasketController(BasketMain basketMain) {
		this.basketMain = basketMain;
		service = new BasketService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FButton button = (FButton)e.getSource();
		String name = button.getName();
		switch(name) {
		case "allCancel":
			service.allCancel();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
