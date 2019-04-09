package kitri.foodCourt.user.basket;


import java.awt.event.*;
import kitri.foodCourt.user.swing.FButton;

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
		service.goFoodDetail();
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
