package kitri.foodCourt.user.basket;

import java.awt.Font;

import javax.swing.*;

import kitri.foodCourt.user.swing.FOptionPane;

public class BasketService {

	public BasketController controller;
	public BasketMain basketMain;
	String options[] = {"예", "아니요"};
	
	public BasketService(BasketController basketController) {
		this.controller = basketController;
		basketMain = controller.basketMain;
	}

	public void allDelete() {
		int result = SwingFactory.getOptionPane("warning",basketMain, "장바구니 비우기", "장바구니의 모든 항목을 삭제하시겠습니까?");
		if(result == 0) {
			basketMain.user.getBasket().removeAll();
			basketMain.pMiddle.removeAll();
			basketMain.dataSetting();
		}
		
	}
	public void payment() {
		basketMain.payment = new Payment(basketMain);
		basketMain.pChangePanel.add(basketMain.payment, "payment");
		basketMain.card.show(basketMain.pChangePanel, "payment");
		//basketMain.
	}

	public void delete(int index) {
		basketMain.user.getBasket().remove(index);
		//System.out.println(basketMain.user.getBasket());
		basketMain.pMiddle.removeAll();
		basketMain.dataSetting();
	}

}
