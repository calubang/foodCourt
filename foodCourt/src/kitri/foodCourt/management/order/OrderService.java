package kitri.foodCourt.management.order;

import java.awt.Color;
import java.awt.Component;
import java.util.*;

import javax.swing.border.Border;
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
		OrderList order = new OrderList();

		order.setRequestNumber(requestNumber);
		st = new StringTokenizer(orderFood, "|");
		while (st.hasMoreTokens()) {
			order.addMenuName(st.nextToken());
			order.addMenuCount(st.nextToken());
		}
		main.list.add(order);
		main.map.put(requestNumber, order);
		main.panel.removeAll();
		main.addOrder();
		// 패널 버튼 목록을 갱신
		return false;
	}

	// 주문정보 프레임 띄우기
	public void visibleOrder() {

	}

	// 주문버튼 완료 처리 (버튼의 색을 바꿔준다)
	public void completeOrder() {
		
	}

	// 완료된 버튼 지우기 (완료 처리 된 버튼을 클릭했을때만 보여진다)
	public void removeOrder() {
		
	}

	// 어떤버튼을 클릭했는지 전역변수에 담기
	// 버튼을 누를때 check를 판단해서 제거버튼을 활성/ 비활성 시켜야함
	public void setGlobalOrderButton(Object object) {
		OrderListButton orderListButton = (OrderListButton) object;
		if (main.map.get(orderListButton.getName()).isCheck())
			main.btnRemove.setVisible(true);
		else
			main.btnRemove.setVisible(false);
		if (main.selectedRequestNumber != "") {
//			if (orderListButton != main.) { //이부분을 처리해야한다 왜냐하면 버튼들은 새로고침할때 새로 생성되기때문
//				orderListButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
//				main.btnOrder.setBorder(null);
//			} else {
//				orderListButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
//			}
		}
	}
}
