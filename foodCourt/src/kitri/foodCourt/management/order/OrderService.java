package kitri.foodCourt.management.order;

import java.awt.Color;
import java.util.*;

import javax.swing.border.LineBorder;

public class OrderService {
	StringTokenizer st;
	OrderController orderController;
	OrderListFrame main;

	public OrderService() {
	}

	public OrderService(OrderController orderController) {
		this.orderController = orderController;
		main = orderController.orderListFrame;
	}

	// order리스트의 갱신을 담당
	public boolean addOrderList(String requestNumber, String orderFood) {
		int size = main.tmap.size();
		OrderList order = new OrderList();
		order.setRequestNumber(requestNumber);
		st = new StringTokenizer(orderFood, "|");
		while (st.hasMoreTokens()) {
			order.addMenuName(st.nextToken());
			order.addMenuCount(st.nextToken());
		}
		main.tmap.put(requestNumber, order);
		// 패널 버튼 목록을 지우고
		main.panel.removeAll();
		// 재생성
		main.addOrder();
		if(!main.isVisible())
			main.setVisible(true);
		if(size+1 == main.tmap.size())
			return true;
		else {
			return false;
		}
	}

	// 주문정보 프레임 띄우기
	public void visibleOrder() {
		main.setVisible(true);
	}

	// 주문버튼 완료 처리 (버튼의 색을 바꿔준다)
	public void completeOrder() {
		main.tmap.get(main.selectedRequestNumber).setComplete();
		main.tmap.get(main.selectedRequestNumber).getButton().setBackground(Color.GREEN);
	}

	// 완료된 버튼 지우기 (완료 처리 된 버튼을 클릭했을때만 보여진다)
	public void removeOrder() {
		
	}

	// 어떤버튼을 클릭했는지 전역변수에 담기
	// 버튼을 누를때 check를 판단해서 제거버튼을 활성/ 비활성 시켜야함
	public void setGlobalOrderButton(Object object) {
		OrderListButton orderListButton = (OrderListButton) object;
		if (main.tmap.get(orderListButton.getName()).isComplete())
			main.btnRemove.setVisible(true);
		else
			main.btnRemove.setVisible(false);
		if (main.selectedRequestNumber != "") { 
			if (!orderListButton.getName().equals(main.selectedRequestNumber)) { // orderlist안에 버튼 넣어서 주소값 가져오기 성공
				setClick(orderListButton);
			} 
		} else { //아무것도 선택되어있지 않을때
			setClick(orderListButton);
		}
	}
	private void setClick(OrderListButton button) {
		main.tmap.get(main.selectedRequestNumber).getButton().setBorder(null);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		main.selectedRequestNumber = button.getName();
	}
}
