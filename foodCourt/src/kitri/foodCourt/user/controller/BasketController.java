package kitri.foodCourt.user.controller;


import java.awt.event.*;

import javax.swing.JPanel;

import kitri.foodCourt.user.service.BasketService;
import kitri.foodCourt.user.swing.FButton;
import kitri.foodCourt.user.swing.FPanel;
import kitri.foodCourt.user.view.BasketMain;

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
			char meaning = name.charAt(0);
			int index = name.charAt(1) - 48;
			if(meaning == 'u') {
				//수량증가
				service.countUp(index);
			}else if(meaning == 'd') {
				//수량감소
				service.countDown(index);
			}else if(meaning == 'x') {
				service.delete(index);
			}
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
