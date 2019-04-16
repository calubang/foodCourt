package kitri.foodCourt.management.order;

import java.util.Vector;

public class OrderList { 
	private OrderListButton button;
	private int  requestNumber;
	private boolean checkComplete = false; // 이 정보를 바탕으로 새로고침 하면서 체크된 주문 목록 표시
	private Vector<String> menuName = new Vector<String>();
	private Vector<String> menucount = new Vector<String>();
	public void addMenuName(String name) {
		System.out.println("");
		menuName.add(name);
	}
	public void addMenuCount(String count) {
		menucount.add(count);
	}
	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}
	public int getRequestNumber() {
		return this.requestNumber;
	}
	
	public String getMenuName(int i) {
		return menuName.get(i);
	}
	
	public String getMenuCount(int i) {
		return menucount.get(i);
	}
	public int getMenuNameSize() {
		return menuName.size();
	}
	
	public int getMenuCountSize() {
		return menucount.size();
	}
	public void setComplete() {
		this.checkComplete = true;
	}
	public boolean isComplete() {
		return this.checkComplete;
	}
	public void setButton(OrderListButton button) {
		this.button = button; 
	}
	public OrderListButton getButton() {
		return this.button;
	}
}
