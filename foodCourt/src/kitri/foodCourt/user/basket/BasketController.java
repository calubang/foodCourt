package kitri.foodCourt.user.basket;


import java.awt.event.*;

import javax.swing.JPanel;

import kitri.foodCourt.user.swing.FButton;
import kitri.foodCourt.user.swing.FPanel;

public class BasketController implements ActionListener, MouseListener{

	public BasketMain basketMain;
	public BasketService service;
	
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
			service.allDelete();
			break;
		case "ok":
			//service.receiptOK();
			break;
		case "payment":
			service.payment();
			break;
		default:
			int index = name.charAt(1) - 48;
			service.delete(index);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		service.goFoodDetail(e.getComponent().getName());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		FPanel temp = (FPanel)e.getComponent().getParent();
		temp.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		FPanel temp = (FPanel)e.getComponent().getParent();
		temp.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
