package kitri.foodCourt.user.service;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

import kitri.foodCourt.user.BasketDetail;
import kitri.foodCourt.user.controller.BasketController;
import kitri.foodCourt.user.swing.*;
import kitri.foodCourt.user.view.BasketMain;

public class BasketService {

	public BasketController controller;
	public BasketMain basketMain;
	
	public BasketService(BasketController basketController) {
		this.controller = basketController;
		basketMain = controller.basketMain;
	}

	public void allDelete() {
		if(basketMain.user.getBasket().getDetailList().size() == 0) {
			return;
		}
		int result = SwingFactory.getOptionPane("warning",basketMain, "장바구니 비우기", "장바구니의 모든 항목을 삭제하시겠습니까?");
		if(result == 0) {
			basketMain.user.getBasket().removeAll();
			basketMain.dataSetting();
		}
		
	}
	public void payment() {
		if(basketMain.user.getBasket().getDetailList().size() == 0) {
			SwingFactory.getOptionPane("warning", basketMain, "결제실패", "장바구니가 비었습니다.");
			return;
		}
		basketMain.payment.dataSetting();
		basketMain.card.show(basketMain.pChangePanel, "payment");
	}

	public void delete(int index) {
		basketMain.user.getBasket().remove(index);
		basketMain.dataSetting();
	}

	public void goFoodDetail(String foodId) {
		//food상세 정보로 이동
		int result = SwingFactory.getOptionPane("messageChoice", basketMain, "상세정보", "음식 상세정보로 이동하시겠습니까?");
		if(result == 0) {
			basketMain.foodMain.foodMainController.foodMainService.searchMenuDetail(foodId);
		}
	}
	
	//수량증가
	public void countUp(int index) {
		Component components[] = basketMain.pMiddle.getComponents();
		
		//장바구니 안에서 데이터변경
		int price = basketMain.user.getBasket().upCount(index);
		
		//해당 라벨위치로 접근해서 값변경
		FLabel temp = (FLabel)components[index].getComponentAt(570, 50);
		int count = Integer.parseInt(temp.getText()) + 1;
		temp.setText(count+"");
		
		//음식총가격 변경
		temp = (FLabel)components[index].getComponentAt(880, 50);
		temp.setText(price+"");
		
		//결제 총금액 변경
		basketMain.lblTotalPrice.setText(basketMain.user.getBasket().getTotalPrice()+"");
		basketMain.lblTotalPoint.setText(basketMain.user.getBasket().getSavePoint()+"");

	}
	
	//수량감소
	public void countDown(int index) {
		Component components[] = basketMain.pMiddle.getComponents();
		FLabel temp = (FLabel)components[index].getComponentAt(570, 50);
		int count = Integer.parseInt(temp.getText());
		
		if(count == 1) {
			SwingFactory.getOptionPane("message", basketMain, "갯수 오류", "최소 1개는 주문해야합니다.");
			return;
		}
		
		//장바구니 안에서 데이터변경
		int price = basketMain.user.getBasket().downCount(index);
		
		//해당 라벨위치로 접근해서 값변경
		count--;
		temp.setText(count+"");
		
		temp = (FLabel)components[index].getComponentAt(880, 50);
		temp.setText(price+"");
		
		//결제 총금액 변경
		basketMain.lblTotalPrice.setText(basketMain.user.getBasket().getTotalPrice()+"");
		basketMain.lblTotalPoint.setText(basketMain.user.getBasket().getSavePoint()+"");
	}

}
