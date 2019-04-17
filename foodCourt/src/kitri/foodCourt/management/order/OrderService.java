package kitri.foodCourt.management.order;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class OrderService {
	StringTokenizer st;
	OrderController orderController;
	OrderListFrame main;
	
	int request;
	public OrderService(OrderController orderController) {
		this.orderController = orderController;
		main = orderController.orderListFrame;
		request = main.selectedRequestNumber;
	}

	// order리스트의 갱신을 담당
	public boolean addOrderList(int requestNumber, String orderFood) {
		System.out.println("addOrderList");
//		System.out.println(main.tmap);
//		int size;
//		if(!(main.tmap.isEmpty())) {
//			size = main.tmap.size();
//		} else {
//			size = 0;
//		}
		OrderList order = new OrderList();
		order.setRequestNumber(requestNumber);
		System.out.println(orderFood);
		st = new StringTokenizer(orderFood, "^");
		while (st.hasMoreTokens()) {
			order.addMenuName(st.nextToken());
			order.addMenuCount(st.nextToken());
		}
		System.out.println("order에 정보 담기 끝");
		for (int i = 0; i < order.getMenuCountSize(); i++) {
			System.out.println("order : " + order.getRequestNumber() + " : " + order.getMenuName(i) + " : "
					+ order.getMenuCount(i));
		}
		main.tmap.put(requestNumber, order);
		// 주문 목록 패널에 재적용
		constructOrderList();
		System.out.println("주문목록 재생성 완료");
		if (!main.isVisible())
			main.setVisible(true);
//		if (size + 1 == main.tmap.size())
//			return true;
//		else {
//			return false;
//		}
		return true;
	}

	// 주문정보 프레임 띄우기
	public void visibleOrder() {
		// 현재 시간 구하기
		if (isRequestNotZero()) {
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd a h시 mm분 ss초");
			String str = dayTime.format(new Date(time));

//		1. 현재 orderlist가져와서 
//		2. main detail jtable에 뿌려주고
//		3. setvisible 시켜주기
			System.out.println("visibleOrder");
			OrderList orderList = getSelectedOrderList();
			int len = orderList.getMenuNameSize();
			Vector<String[]> menuList = new Vector<String[]>();
			String menu[] = new String[2];
			for (int i = 0; i < len; i++) {
				menu[0] = orderList.getMenuName(i);
				menu[1] = orderList.getMenuCount(i);
				menuList.add(menu);
			}
			orderList.setCheckOrder();
			main.orderDetailDialog.labRequestNum.setText("주문요청번호 : " + Integer.toString(request));
			main.orderDetailDialog.labTimeNow.setText(str);
			main.orderDetailDialog.setOrderDetail(len, menuList);
			main.orderDetailDialog.revalidate();
			main.orderDetailDialog.setVisible(true);
			orderList.setCheckOrder();
			if(!orderList.isComplete())
				orderList.getButton().setBackground(Color.WHITE);
			refresh();
		}
	}

	// 주문버튼 완료 처리 (버튼의 색을 바꿔준다)
	public void completeOrder() {
		System.out.println("completeOrder");
		System.out.println(request);
		if (isRequestNotZero() && !getSelectedOrderList().isComplete()) {
			getSelectedOrderList().setComplete();
			getSelectedButton().setBackground(Color.GREEN);
			refresh();
			main.btnRemove.setVisible(true);
		}
	}

	// 완료된 버튼 지우기 (완료 처리 된 버튼을 클릭했을때만 보여진다)
	public void removeOrder() {
		System.out.println("removeOrder");
		System.out.println(request);
		main.tmap.remove(request);
		request = 0;
		constructOrderList();
		main.btnRemove.setVisible(false);
		main.btnOrderview.setVisible(false);
		main.btnComplete.setVisible(false);
	}

	// 어떤버튼을 클릭했는지 전역변수에 담기
	// 버튼을 누를때 check를 판단해서 제거 버튼을 활성/ 비활성 시켜야함
	public void setGlobalOrderButton(Object object) {
		System.out.println("setGlobalOrderButton");
		System.out.println("requestNumber : " + request);
		OrderListButton orderListButton = (OrderListButton) object;
		if (isRequestNotZero()) {
			if (!orderListButton.getName().equals(Integer.toString(request))) { // orderlist안에 버튼 넣어서
																									// 주소값 가져오기 성공
				getSelectedButton().setBorder(main.defualt);
				setClick(orderListButton);
			}
		} else { // 아무것도 선택되어있지 않을때
			setClick(orderListButton);
		}
		main.btnOrderview.setVisible(true);
		if (main.tmap.get(Integer.parseInt(orderListButton.getName())).getCheckOrder())
			main.btnComplete.setVisible(true);
		else
			main.btnComplete.setVisible(false);
		if (main.tmap.get(Integer.parseInt(orderListButton.getName())).isComplete())
			main.btnRemove.setVisible(true);
		else
			main.btnRemove.setVisible(false);
	}

	private void setClick(OrderListButton button) {
		System.out.println("setClick");

		// TODO 지금 여기서 문제 찾아야해 완료되어있는 버튼 눌러도 제거버튼이 활성화안되는 에러발견
		button.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		request = Integer.parseInt(button.getName());
		refresh();
	}

	private void constructOrderList() {
		// 패널 버튼 목록을 지우고
		main.panOrder.removeAll();
		// 재생성
		main.addOrder();
		if (!isRequestNotZero()) {
			main.btnOrderview.setVisible(false);
		}
		if (isRequestNotZero()) {
			if (!getSelectedOrderList().getCheckOrder())
				main.btnComplete.setVisible(false);
			else
				main.btnComplete.setVisible(true);
		}
		if (isRequestNotZero()) {
			if (!getSelectedOrderList().isComplete())
				main.btnRemove.setVisible(false);
			else
				main.btnRemove.setVisible(true);
		}
		// 리프레시
		refresh();
	}

	private void refresh() {
		main.panOrder.revalidate();
		main.panOrder.repaint();
	}

	private OrderListButton getSelectedButton() {
		return main.tmap.get(request).getButton();
	}

	private OrderList getSelectedOrderList() {
		return main.tmap.get(request);
	}
	private boolean isRequestNotZero() {
		if(request != 0)
			return true;
		else 
			return false;
	}

	public void closingOrderDetail() {
		main.orderDetailDialog.setVisible(false);
		main.orderDetailDialog.labRequestNum.setText("");
		main.orderDetailDialog.labTimeNow.setText("");
		main.btnComplete.setVisible(true);
	}
}
